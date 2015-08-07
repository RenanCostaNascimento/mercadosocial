/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Cliente;
import br.edu.ifes.sr.dw.modelos.Cupom;
import br.edu.ifes.sr.dw.persistencia.ClienteDao;
import br.edu.ifes.sr.dw.persistencia.CupomDao;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import br.edu.ifes.sr.dw.utils.ContextMessage;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Data;

@Data
@ManagedBean
@RequestScoped
public class GeradorMoeda {
    
    private String codigo;
    private List<Cupom> cupons;

    public void gerarMoedaSocial(){
        CupomDao cupomDao = DaoFactory.criarCupomDao();
        ClienteDao clienteDao = DaoFactory.criarClienteDao();
        
        Cliente cliente = clienteDao.buscarPorEmail(LoginView.pegarEmailUsuarioLogado());
        Cupom cupom = cupomDao.buscarCodigoCpfCliente(codigo, cliente.getCpf());
        if(cupom != null){
            if(cupom.getDataExpiracao().after(Calendar.getInstance().getTime())){
                cliente.setMoedasSociais(cliente.getMoedasSociais() + cupom.getMoedasSociais());
                cupom.setResgatado(true);
                clienteDao.atualizar(cliente);
                cupomDao.atualizar(cupom);
                preencherListaCupom();
                ContextMessage.addMessage("Sucesso", "Moedas sociais geradas com sucesso.");
            }else{
                ContextMessage.addMessage("Erro", "Cupom expirado.");
            }
        }else{
            ContextMessage.addMessage("Erro", "Código do cupom inválido para o usuário de cpf " + cliente.getCpf() + ".");
        }
        
        
    }
    
    @PostConstruct
    public void preencherListaCupom() {
        CupomDao cupomDao = DaoFactory.criarCupomDao();
        String email = LoginView.pegarEmailUsuarioLogado();

        cupons = cupomDao.buscarPorInstituicao(email);
    }

}
