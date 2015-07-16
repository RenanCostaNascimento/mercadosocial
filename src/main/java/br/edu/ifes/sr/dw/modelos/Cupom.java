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
    private String cpfCliente;
    private int moedasSociais;
    private boolean resgatado;

    public Cupom(String cnpjInstituicao, String cpfCliente, int horasTrabalhadas) {
        String chave = cnpjInstituicao+cpfCliente+Calendar.getInstance().toString();
        
        this.codigo = String.valueOf(chave.hashCode());
        this.cpfCliente = cpfCliente;
        this.moedasSociais = horasTrabalhadas*5;
        this.resgatado = false;
    } 
    
    public Cupom(int id, String codigo, String cpfCliente, int moedasSociais, boolean resgatado){
        this.id = id;
        this.codigo = codigo;
        this.cpfCliente = cpfCliente;
        this.moedasSociais = moedasSociais;
        this.resgatado = resgatado;
    }
}
