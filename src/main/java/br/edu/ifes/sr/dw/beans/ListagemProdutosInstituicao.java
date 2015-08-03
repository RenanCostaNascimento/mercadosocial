/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Produto;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import br.edu.ifes.sr.dw.persistencia.ProdutoDao;
import br.edu.ifes.sr.dw.utils.ContextMessage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Renan
 */
@Getter
@Setter
@ManagedBean(name = "produtosInstituicao")
@ViewScoped
public class ListagemProdutosInstituicao {
    
    private Produto produto;
    private List<Produto> produtos;
    
    @PostConstruct
    public void preencherListaProduto(){
        ProdutoDao produtoDao =  DaoFactory.criarProdutoDao();
        try {
            produtos = produtoDao.listarInstituicao(LoginView.pegarEmailUsuarioLogado());
        } catch (Exception ex) {
            Logger.getLogger(ListagemProdutosInstituicao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editar(){
        
    }
    
    public String excluir(){
        String resultado = null;
        ProdutoDao produtoDao =  DaoFactory.criarProdutoDao();
        try {
            produtoDao.excluir(this.produto);
            ContextMessage.addMessage("Sucesso", "Produto excluído.");
            resultado = "produtoExcluido";
            return resultado;
            
        } catch (Exception ex) {
            Logger.getLogger(ListagemProdutosInstituicao.class.getName()).log(Level.SEVERE, null, ex);
            ContextMessage.addMessage("Falha", "Não foi possível excluir o produto.");
        }
        return resultado;
    }
    
    public String novo(){
        return "novoProduto";
    }
}
