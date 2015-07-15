/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.modelos;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Renan
 */
@Getter
@Setter
public class Cliente {
    
    private String nome;
    private String cpf;
    private String email;
    private String moedasSociais;
    private String senha;
    private List<Cupom> cuponsResgatados;
    
}
