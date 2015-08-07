/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Cliente;
import br.edu.ifes.sr.dw.persistencia.ClienteDao;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import br.edu.ifes.sr.dw.utils.ContextMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@ManagedBean(name = "cadastroCliente")
@RequestScoped
public class CadastroCliente {

    private String nome;
    private String cpf;
    private String email;
    private String senha;

    public String cadastrar() {
        ClienteDao clienteDao = DaoFactory.criarClienteDao();
        
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setMoedasSociais(0.d);

        clienteDao.salvar(cliente);
        ContextMessage.addMessage("Sucesso", "Cliente cadastrado com sucesso. Agora faça login na área apropriada.");
        return "clienteCadastrado";
    }

}
