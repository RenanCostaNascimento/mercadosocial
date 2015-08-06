/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Cliente;
import br.edu.ifes.sr.dw.modelos.Cupom;
import br.edu.ifes.sr.dw.modelos.Instituicao;
import br.edu.ifes.sr.dw.persistencia.ClienteDao;
import br.edu.ifes.sr.dw.persistencia.CupomDao;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import br.edu.ifes.sr.dw.persistencia.InstituicaoDao;
import br.edu.ifes.sr.dw.utils.ContextMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Data;

@Data
@ManagedBean
@RequestScoped
public class GeradorCupom {
    
    private int horasTrabalhadas;
    private String cpfVoluntario;
    private String emailVoluntario;

    public String cadastrar() {
        System.out.println("CADASTRAR!!");
        ContextMessage.addMessage("Gerando o Cupom", "O cupom está sendo gerado. Aguarde Pacientemente.");
        CupomDao cupomDao = DaoFactory.criarCupomDao();
        InstituicaoDao instituicaoDao = DaoFactory.criarInstituicaoDao();
        ClienteDao clienteDao = DaoFactory.criarClienteDao();

        Instituicao instituicao = instituicaoDao.buscar(LoginView.pegarEmailUsuarioLogado());
        if (instituicao == null) {
            ContextMessage.addMessage("Falha ao gerar cupom", "Você precisa se logar como uma instituição beneficente primeiramente.");
            return "login";
        }
        
        Cliente cliente = clienteDao.buscar(cpfVoluntario);
        if (cliente == null) {
            cliente = new Cliente();
            cliente.setCpf(cpfVoluntario);
            cliente.setEmail(emailVoluntario);
            clienteDao.salvar(cliente);
        }

        Cupom cupom = Cupom.gerarCupom(instituicao, cliente, horasTrabalhadas);
        cupomDao.salvar(cupom);
        ContextMessage.addMessage("Cupom Gerado", "Cupom gerado com sucesso.");
        return "cupomCadastrado";
    }

}
