/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Cupom;
import br.edu.ifes.sr.dw.persistencia.DaoCupom;
import br.edu.ifes.sr.dw.utils.ContextMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Renan
 */
@Getter
@Setter
@ManagedBean(name = "geradorCupom")
@RequestScoped
public class GeradorCupom {

    private String cpfVoluntario;
    private String emailVoluntario;
    private int horasTrabalhadas;

    public void gerarCupom() {
        //TODO: criar o cupom usando o cnpj da instituição da sessão
        Cupom cupom = new Cupom("12345679", cpfVoluntario, horasTrabalhadas);

        DaoCupom daoCupom = new DaoCupom();

        try {
            daoCupom.insert(cupom);
            ContextMessage.addMessage("Sucesso", "Opera��o realizada com sucesso.");
        } catch (Exception ex) {
            Logger.getLogger(GeradorCupom.class.getName()).log(Level.SEVERE, null, ex);
            ContextMessage.addMessage("Erro", "A opera��o apresentou um erro. Tente novamente.");
        }
    }

}
