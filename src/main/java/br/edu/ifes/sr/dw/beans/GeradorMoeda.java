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

    @PostConstruct
    public void preencherListaCupom() {
        CupomDao cupomDao = DaoFactory.criarCupomDao();
        String email = LoginView.pegarEmailUsuarioLogado();

        cupons = cupomDao.buscarPorCliente(email);
    }

}
