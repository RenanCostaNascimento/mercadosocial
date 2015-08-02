/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Renan
 */
@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "preco")
    private double preco;
    
    @Column(name = "quantidade")
    private int quantidade;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "imagem")
    private String imagem;
    
    @OneToMany(mappedBy = "produto")
    private List<Compra> compras;
    
    @ManyToOne
    @JoinColumn(name = "idinstituicao")
    private Instituicao instituicao;

    public Produto() {
    }

    public Produto(String nome, double preco, int quantidade, String descricao, String imagem, Instituicao instituicao) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.imagem = imagem;
        this.instituicao = instituicao;
    }

    public Produto(int id, String nome, double preco, int quantidade, String descricao, String imagem, Instituicao instituicao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.imagem = imagem;
        this.instituicao = instituicao;
    }
}
