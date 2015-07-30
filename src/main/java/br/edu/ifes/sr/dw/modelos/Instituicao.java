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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "instituicao")
public class Instituicao implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nomefantasia")
    private String nomeFantasia;
    
    @Column(name = "razaosocial")
    private String razaoSocial;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "cnpj")
    private String cnpj;
    
    @Column(name = "senha")
    private String senha;
    
    @Enumerated(EnumType.STRING)
    private TipoInstituicao tipoInstituicao;
    
    @OneToMany(mappedBy = "instituicao")
    private List<Cupom> cuponsGerados;
    
    @OneToMany(mappedBy = "instituicao")
    private List<Produto> produtosCadastrados;
    
}
