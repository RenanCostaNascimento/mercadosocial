/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Instituicao;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import br.edu.ifes.sr.dw.persistencia.InstituicaoDao;
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
public class AdministracaoInstituicaoBeneficente {
    
    public Instituicao instituicao;
    
    @PostConstruct
    public void preencherInstituicao() {
        InstituicaoDao instituicaoDao = DaoFactory.criarInstituicaoDao();
        instituicao = instituicaoDao.buscar(LoginView.pegarEmailUsuarioLogado());
    }

}
