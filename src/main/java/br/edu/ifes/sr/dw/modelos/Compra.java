/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.modelos;

import java.io.Serializable;
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
 * @author 20121BSI0252
 */
@Getter
@Setter
@Entity
@Table(name = "compra")
public class Compra implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    
    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;
    
    public Compra(Date dataCompra, Produto produto, Cliente cliente){
        this.dataCompra = dataCompra;
        this.produto = produto;
        this.cliente = cliente;
    }

    
}
