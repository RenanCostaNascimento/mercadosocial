/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.beans;

import br.edu.ifes.sr.dw.modelos.Cupom;
import br.edu.ifes.sr.dw.persistencia.DaoCliente;
import br.edu.ifes.sr.dw.persistencia.DaoClienteCupom;
import br.edu.ifes.sr.dw.persistencia.DaoCupom;
import br.edu.ifes.sr.dw.utils.ContextMessage;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
@ManagedBean(name = "geradorMoeda")
@RequestScoped
public class GeradorMoedaSocial {

    private String codigo;
    private List<HistoricoCupons> cupons;

    public void gerarMoedaSocial() {

        DaoCliente daoCliente = new DaoCliente();
        DaoCupom daoCupom = new DaoCupom();
        DaoClienteCupom daoClienteCupom = new DaoClienteCupom();

        try {
            //TODO: pegar o cpf da sessao do usuario
            Cupom cupom = daoCupom.getCupomValido("123456", codigo);

            if (cupom != null) {
                //TODO: pegar o id da sessao do usuario
                daoClienteCupom.inserirCupomCliente(1, cupom.getId());
                //TODO: pegar o cpf da sessao do usuario
                daoCliente.trocarCupom(1, cupom);
                daoCupom.cupomResgatado(cupom.getId());
                //TODO: adicionar o cupom trocado na lista de cupons do cliente da sessao
                ContextMessage.addMessage("Sucesso", "Operação realizada com sucesso.");
            }else{
                ContextMessage.addMessage("Informação", "Esse código não é válido.");
            }
        } catch (Exception ex) {
            Logger.getLogger(GeradorMoedaSocial.class.getName()).log(Level.SEVERE, null, ex);
            ContextMessage.addMessage("Erro", "A operação falhou.");
        } 

    }
    
    @PostConstruct
    public void preencherHistorico(){
        DaoClienteCupom daoClienteCupom = new DaoClienteCupom();
        try {
            //TODO: passar id do usuario da sessao
            cupons = daoClienteCupom.getCupons(1);
        } catch (Exception ex) {
            Logger.getLogger(GeradorMoedaSocial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
