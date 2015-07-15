/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

/**
 *
 * @author Renan
 */
public class DaoCliente extends Dao{
    
    public void updateEmail(String email, String cpf) throws Exception{
        
        open();

        stmt = con.prepareStatement("UPDATE cliente SET email = ? WHERE cpf = ?");
        stmt.setString(1, email);
        stmt.setString(2, cpf);

        stmt.execute();

        close();        
    }
    
    public void updateSenha(String senha, String cpf) throws Exception{
        
        open();

        stmt = con.prepareStatement("UPDATE cliente SET senha = ? WHERE cpf = ?");
        stmt.setString(1, senha);
        stmt.setString(2, cpf);

        stmt.execute();

        close();        
    }
    
}
