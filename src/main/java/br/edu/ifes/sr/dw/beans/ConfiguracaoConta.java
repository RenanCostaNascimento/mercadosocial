/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.persistencia.DaoCliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Renan
 */
@Getter
@Setter
@ManagedBean(name = "configuracaoConta")
@RequestScoped
public class ConfiguracaoConta {

    private String email;
    private String repeteEmail;
    private String senha;
    private String repeteSenha;

    public void mudarEmail() {
        if (email != null && email.equals(repeteEmail)) {
            DaoCliente daoCliente = new DaoCliente();

            try {
                //TODO: usar o cpf do cliente logado
                daoCliente.updateEmail(email, "123456");
            } catch (Exception ex) {
                Logger.getLogger(ConfiguracaoConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void mudarSenha() {
        if (senha != null && senha.equals(repeteSenha)) {
            DaoCliente daoCliente = new DaoCliente();

            try {
                //TODO: usar o cpf do cliente logado
                daoCliente.updateSenha(senha, "123456");
            } catch (Exception ex) {
                Logger.getLogger(ConfiguracaoConta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
