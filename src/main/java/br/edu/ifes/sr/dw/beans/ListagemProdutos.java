/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Produto;
import br.edu.ifes.sr.dw.persistencia.DaoClienteCupom;
import br.edu.ifes.sr.dw.persistencia.DaoProduto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
@ManagedBean(name = "listagemProdutos")
@RequestScoped
public class ListagemProdutos {
    
    private List<Produto> produtos;
    
    @PostConstruct
    public void preencherHistorico(){
        DaoProduto daoProduto = new DaoProduto();
        try {
            produtos = daoProduto.getProdutos();
        } catch (Exception ex) {
            Logger.getLogger(GeradorMoedaSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
