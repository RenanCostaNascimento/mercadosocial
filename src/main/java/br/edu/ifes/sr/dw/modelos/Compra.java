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
 * @author 20121BSI0252
 */
@Getter
@Setter
public class Compra {
    
    private Calendar dataCompra;
    Produto produto;
    
}
