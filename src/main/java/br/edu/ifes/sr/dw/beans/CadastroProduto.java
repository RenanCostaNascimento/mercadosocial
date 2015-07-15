/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Produto;
import br.edu.ifes.sr.dw.persistencia.DaoProduto;
import br.edu.ifes.sr.dw.utils.ContextMessage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
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
    
    //Caminho em que as imagens ficarão hospedadas no servidor
    private static final String CAMINHO_ARQUIVO = "C:\\Users\\Renan\\Documents\\Git\\mercadosocial\\src\\main\\resources\\imagens\\uploads\\";

    private String nome;
    private double preco;
    private int quantidade;
    private String descricao;
    private String nomeImagem;
    private UploadedFile imagem;

    public void carregarImagem() {
        byte[] foto = imagem.getContents();
        nomeImagem = imagem.getFileName();
        
        String arquivo = CAMINHO_ARQUIVO + nomeImagem;
        criaImagem(foto, arquivo);
    }

    public void criaImagem(byte[] bytes, String arquivo) {
        FileOutputStream fos;

        try {
            fos = new FileOutputStream(arquivo);
            fos.write(bytes);
            fos.flush();
            fos.close();
            System.out.println("Salvo");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar() {

        carregarImagem();
        if (imagem != null) {

            Produto produto = new Produto(nome, preco, quantidade, descricao, nomeImagem);
            DaoProduto daoProduto = new DaoProduto();

            try {
                daoProduto.insert(produto);
                ContextMessage.addMessage("Sucesso", "O produto foi salvo com sucesso.");
            } catch (Exception ex) {
                Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
                ContextMessage.addMessage("Erro", "Não foi possível salvar o produto.");
            }

        }
    }
}
