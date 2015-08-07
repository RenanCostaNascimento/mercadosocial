/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Cliente;
import br.edu.ifes.sr.dw.modelos.Compra;
import br.edu.ifes.sr.dw.modelos.Produto;
import br.edu.ifes.sr.dw.persistencia.ClienteDao;
import br.edu.ifes.sr.dw.persistencia.ComprasDao;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import br.edu.ifes.sr.dw.persistencia.ProdutoDao;
import br.edu.ifes.sr.dw.utils.ContextMessage;
import java.util.Calendar;
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
    public void preencherListaProduto() {
        ProdutoDao produtoDao = DaoFactory.criarProdutoDao();
        try {
            produtos = produtoDao.listarTodos();
        } catch (Exception ex) {
            Logger.getLogger(ListagemProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void comprar() {
        ClienteDao clienteDao = DaoFactory.criarClienteDao();

        Cliente cliente = clienteDao.buscarPorEmail(LoginView.pegarEmailUsuarioLogado());

        if (cliente != null) {
            if (cliente.getMoedasSociais() >= produto.getPreco()) {
                if (produto.getQuantidade() > 0) {
                    cliente.setMoedasSociais(cliente.getMoedasSociais() - produto.getPreco());
                    produto.setQuantidade(produto.getQuantidade() - 1);

                    ProdutoDao produtoDao = DaoFactory.criarProdutoDao();
                    ComprasDao comprasDao = DaoFactory.criarComprasDao();

                    clienteDao.atualizar(cliente);
                    produtoDao.atualizar(produto);
                    comprasDao.salvar(new Compra(Calendar.getInstance().getTime(), produto, cliente));
                    ContextMessage.addMessage("Sucesso", "Compra realizada com sucesso.");
                } else {
                    ContextMessage.addMessage("Erro", "Falta de estoque do produto.");
                }
            } else {
                ContextMessage.addMessage("Erro", "Moedas sociais insuficientes.");
            }
        } else {
            ContextMessage.addMessage("Erro", "É preciso estar logado para realizar uma compra.");
        }
    }
}
