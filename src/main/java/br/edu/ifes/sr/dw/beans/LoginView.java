/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Cliente;
import br.edu.ifes.sr.dw.modelos.Instituicao;
import br.edu.ifes.sr.dw.modelos.TipoInstituicao;
import br.edu.ifes.sr.dw.persistencia.ClienteDao;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import br.edu.ifes.sr.dw.persistencia.InstituicaoDao;
import br.edu.ifes.sr.dw.utils.ContextMessage;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean(name = "loginView")
@SessionScoped
public class LoginView {

    @ManagedProperty(value = "#{email}")
    private String email;
    private String senha;

    public String login() {
        String resposta = null;
        InstituicaoDao instituicaoDao = DaoFactory.criarInstituicaoDao();
        Instituicao instituicao = instituicaoDao.validarLogin(email, senha);
        if (instituicao != null) {
            if (instituicao.getTipoInstituicao().equals(TipoInstituicao.CONTRIBUIDORA)) {
                resposta = "contribuidora";
            } else {
                resposta = "beneficente";
            }
            ContextMessage.addMessage("Sucesso", "Logado com sucesso!");
            return resposta;
        } else {
            ClienteDao clienteDao = DaoFactory.criarClienteDao();
            Cliente cliente = clienteDao.validarLogin(email, senha);
            if (cliente != null) {
                resposta = "cliente";
                ContextMessage.addMessage("Sucesso", "Logado com sucesso!");
                return resposta;
            }
        }
        ContextMessage.addMessage("Falha", "Email ou senha inválidos.");
        return resposta;
    }

    public String redirecionarLogin() {
        return "login";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "logout";
    }

    public static String pegarEmailUsuarioLogado() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map sessionMap = externalContext.getSessionMap();
        LoginView loginView = (LoginView) sessionMap.get("loginView");
        if(loginView != null){
            return loginView.getEmail();
        }
        return "vazio";
    }
    
    public double pegarMoedasSociais(){
        ClienteDao clienteDao = DaoFactory.criarClienteDao();
        return clienteDao.buscarPorEmail(email).getMoedasSociais();
    }
}
