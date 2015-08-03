/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Instituicao;
import br.edu.ifes.sr.dw.modelos.Produto;
import br.edu.ifes.sr.dw.persistencia.DaoFactory;
import br.edu.ifes.sr.dw.persistencia.InstituicaoDao;
import br.edu.ifes.sr.dw.persistencia.ProdutoDao;
import br.edu.ifes.sr.dw.utils.Constants;
import br.edu.ifes.sr.dw.utils.ContextMessage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Renan
 */
@Getter
@Setter
@ManagedBean(name = "produtosInstituicao")
@SessionScoped
public class ListagemProdutosInstituicao {

    private UploadedFile imagem;
    private Produto produto = new Produto();
    private List<Produto> produtos;

    @PostConstruct
    public void preencherListaProduto() {
        ProdutoDao produtoDao = DaoFactory.criarProdutoDao();
        try {
            produtos = produtoDao.listarInstituicao(LoginView.pegarEmailUsuarioLogado());
        } catch (Exception ex) {
            Logger.getLogger(ListagemProdutosInstituicao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String editar() {
        return "editarProduto";
    }

    public String excluir() {
        String resultado = null;
        ProdutoDao produtoDao = DaoFactory.criarProdutoDao();
        try {
            produtoDao.excluir(this.produto);
            ContextMessage.addMessage("Sucesso", "Produto excluído.");
            resultado = "produtoExcluido";
            preencherListaProduto();
            produto = null;

        } catch (Exception ex) {
            Logger.getLogger(ListagemProdutosInstituicao.class.getName()).log(Level.SEVERE, null, ex);
            ContextMessage.addMessage("Falha", "Não foi possível excluir o produto.");
        }
        return resultado;
    }

    public String novo() {
        return "novoProduto";
    }

    public String salvar() {
        carregarImagem();
        String resposta = null;

        InstituicaoDao instituicaoDao = DaoFactory.criarInstituicaoDao();
        ProdutoDao produtoDao = DaoFactory.criarProdutoDao();
        if (produto.getInstituicao() == null) {
            Instituicao instituicao = instituicaoDao.buscar(LoginView.pegarEmailUsuarioLogado());
            produto.setInstituicao(instituicao);
            try {
                produtoDao.salvar(produto);
                ContextMessage.addMessage("Sucesso", "O produto foi criado com sucesso.");
                resposta = "produtoCriado";
                preencherListaProduto();
                produto = null;
            } catch (Exception ex) {
                Logger.getLogger(ListagemProdutosInstituicao.class.getName()).log(Level.SEVERE, null, ex);
                ContextMessage.addMessage("Erro", "Não foi possível salvar o produto.");
            }
        } else {
            try {
                produtoDao.atualizar(produto);
                ContextMessage.addMessage("Sucesso", "O produto foi editado com sucesso.");
                resposta = "produtoCriado";
                preencherListaProduto();
                produto = null;
            } catch (Exception ex) {
                Logger.getLogger(ListagemProdutosInstituicao.class.getName()).log(Level.SEVERE, null, ex);
                ContextMessage.addMessage("Erro", "Não foi possível editar o produto.");
            }
        }
        
        return resposta;
    }

    private void carregarImagem() {
        if (!imagem.getFileName().equals("")) {
            byte[] foto = imagem.getContents();
            String arquivo = Constants.CAMINHO_HOSPEDAGEM_ARQUIVO_PRODUTO + imagem.getFileName();
            produto.setImagem(Constants.CAMINHO_ACESSO_ARQUIVO_PRODUTO + imagem.getFileName());
            criaImagem(foto, arquivo);
        }

    }

    private void criaImagem(byte[] bytes, String arquivo) {
        FileOutputStream fos;

        try {
            fos = new FileOutputStream(arquivo);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
