/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Cliente;
import br.edu.ifes.sr.dw.modelos.Cupom;
import br.edu.ifes.sr.dw.modelos.Instituicao;
import br.edu.ifes.sr.dw.persistencia.CupomDao;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Data;

/**
 *
 * @author Renan
 */
@Data
@ManagedBean
@SessionScoped
public class ListagemCuponsGerados {

    private List<Cupom> cupons;

    @PostConstruct
    public void preencherListaCupom() {
        CupomDao cupomDao = DaoFactory.criarCupomDao();
        String email = LoginView.pegarEmailUsuarioLogado();

        cupons = cupomDao.buscarPorInstituicao(email);
    }

}
