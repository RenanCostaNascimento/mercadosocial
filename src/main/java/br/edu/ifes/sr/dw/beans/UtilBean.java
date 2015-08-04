/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ManagedBean(name = "utilBean")
@SessionScoped
public class UtilBean {

    public String redirecionarCadastro() {
        return "cadastro";
    }

}
