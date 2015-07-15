/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.modelos;

import java.util.Calendar;
import lombok.Data;

/**
 *
 * @author Renan
 */
@Data
public class Cupom {
    
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
}
