/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.modelos;

import java.util.Calendar;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Renan
 */
@Getter
@Setter
public class Cupom extends Modelo{
    
    private String codigo;
    private Cliente cliente;
    private Instituicao instituicao;
    private int moedasSociais;
    private boolean resgatado;
    
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
