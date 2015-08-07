/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.modelos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Renan
 */
@Getter
@Setter
@Entity
@Table(name = "cupom")
public class Cupom implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "codigo")
    private String codigo;
    
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "idinstituicao")
    private Instituicao instituicao;
    
    @Column(name = "moedassociais")
    private int moedasSociais;
    
    @Column(name = "resgatado")
    private boolean resgatado;
    
    @Temporal(TemporalType.DATE)
    private Date dataExpiracao;
    
    public static Cupom gerarCupom(Instituicao instituicao, Cliente cliente, int horasTrabalhadas){
        return new Cupom(instituicao, cliente, horasTrabalhadas);
    }

    public Cupom() {
        
    }
    
    private Cupom(Instituicao instituicao, Cliente cliente, int horasTrabalhadas) {
        String chave = instituicao.getCnpj()+cliente.getCpf()+Calendar.getInstance().toString();
        
        this.codigo = String.valueOf(chave.hashCode());
        this.instituicao = instituicao;
        this.cliente = cliente;
        this.moedasSociais = horasTrabalhadas*5;
        this.resgatado = false;
        Calendar data = Calendar.getInstance();
        data.add(Calendar.YEAR, 1);
        this.dataExpiracao = data.getTime();
    } 
    
    public Cupom(int id, String codigo, Instituicao instituicao, Cliente cliente, int moedasSociais, boolean resgatado){
        this.id = id;
        this.codigo = codigo;
        this.instituicao = instituicao;
        this.cliente = cliente;
        this.moedasSociais = moedasSociais;
        this.resgatado = resgatado;
    }    
}
