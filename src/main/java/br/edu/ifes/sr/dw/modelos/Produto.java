/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.modelos;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Renan
 */
@Getter
@Setter
public class Produto extends Modelo {

    private String nome;
    private double preco;
    private int quantidade;
    private String descricao;
    private String imagem;

    public Produto(String nome, double preco, int quantidade, String descricao, String imagem) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public Produto(int id, String nome, double preco, int quantidade, String descricao, String imagem) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.imagem = imagem;
    }
}
