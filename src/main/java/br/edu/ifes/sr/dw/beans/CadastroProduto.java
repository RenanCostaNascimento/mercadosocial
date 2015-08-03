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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Renan
 */
@Getter
@Setter
@ManagedBean(name = "cadastroProduto")
@RequestScoped
public class CadastroProduto {

    private String nome;
    private double preco;
    private int quantidade;
    private String descricao;
    private String nomeImagem;
    private UploadedFile imagem;

    public void carregarImagem() {
        byte[] foto = imagem.getContents();
        nomeImagem = imagem.getFileName();

        String arquivo = Constants.CAMINHO_HOSPEDAGEM_ARQUIVO_PRODUTO + nomeImagem;
        criaImagem(foto, arquivo);
    }

    public void criaImagem(byte[] bytes, String arquivo) {
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

    public String salvar() {
        carregarImagem();
        String resposta = null;
        if (imagem != null) {

            InstituicaoDao instituicaoDao = DaoFactory.criarInstituicaoDao();
            Instituicao instituicao = instituicaoDao.buscar(LoginView.pegarEmailUsuarioLogado());

            Produto produto = new Produto(nome, preco, quantidade, descricao, Constants.CAMINHO_ACESSO_ARQUIVO_PRODUTO + nomeImagem, instituicao);
            ProdutoDao produtoDao = DaoFactory.criarProdutoDao();

            try {
                produtoDao.salvar(produto);
                ContextMessage.addMessage("Sucesso", "O produto foi salvo com sucesso.");
                resposta = "produtoCriado";
                return resposta;
            } catch (Exception ex) {
                Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
                ContextMessage.addMessage("Erro", "Não foi possível salvar o produto.");
            }
        }
        return resposta;
    }
}
