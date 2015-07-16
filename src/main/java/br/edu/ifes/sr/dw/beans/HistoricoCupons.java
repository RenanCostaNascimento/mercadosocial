/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Renan
 */
@Getter
@Setter
public class HistoricoCupons {

    private int moedasSociais;
    private String dataTroca;
    
    public HistoricoCupons(int moedasSociais, String dataTroca) {
        this.moedasSociais = moedasSociais;
        this.dataTroca = dataTroca;
    }
    
}
