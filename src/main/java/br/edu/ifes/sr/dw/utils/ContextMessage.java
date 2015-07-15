/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Renan
 */
public class ContextMessage {

    public static void addMessage(String title, String content) {
        FacesMessage message = new FacesMessage(title, content);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
