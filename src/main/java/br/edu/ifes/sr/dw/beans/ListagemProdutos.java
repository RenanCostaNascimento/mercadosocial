/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Produto;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import br.edu.ifes.sr.dw.persistencia.ProdutoDao;
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
    
    private Produto produto;
    private List<Produto> produtos;
    
    @PostConstruct
    public void preencherListaProduto(){
        ProdutoDao produtoDao =  DaoFactory.criarProdutoDao();
        try {
            produtos = produtoDao.listarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ListagemProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void comprar(){
        
    }
}
