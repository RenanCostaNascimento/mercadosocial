/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Cliente;
import br.edu.ifes.sr.dw.persistencia.ClienteDao;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;

/**
 *
 * @author possatti
 */
@Data
@ManagedBean
@ViewScoped
public class AdministracaoCliente {
        
    public Cliente cliente;
    
    @PostConstruct
    public void iniciarClienteDaSessao() {
        ClienteDao clienteDao = DaoFactory.criarClienteDao();
        String email = LoginView.pegarEmailUsuarioLogado();
        cliente = clienteDao.buscarPorEmail(email);
    }

}
