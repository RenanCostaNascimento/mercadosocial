/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean(name = "barraSuperior")
@RequestScoped
public class BarraSuperior {

    public String listarProdutos() {
        return "listarProdutos";
    }
    
    public String inicio() {
        return "inicio";
    }
    
    public String cadastro() {
        return "cadastro";
    }
    
    public String configuracaoCliente() {
        return "configuracaoCliente";
    }
}
