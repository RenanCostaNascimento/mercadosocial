/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw;

import br.edu.ifes.sr.dw.conexao.HibernateUtil;

/**
 *
 * @author Renan
 */
public class Main {
    
    public static void main(String args[]){
        
        HibernateUtil.getSessionFactory();
        
    }
    
}
