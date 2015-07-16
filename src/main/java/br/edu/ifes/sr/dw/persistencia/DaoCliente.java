/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.modelos.Cupom;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Renan
 */
public class DaoCliente extends Dao {

    public void updateEmail(String email, String cpf) throws Exception {

        open();

        stmt = con.prepareStatement("UPDATE cliente SET email = ? WHERE cpf = ?");
        stmt.setString(1, email);
        stmt.setString(2, cpf);

        stmt.execute();

        close();
    }

    public void updateSenha(String senha, String cpf) throws Exception {

        open();

        stmt = con.prepareStatement("UPDATE cliente SET senha = ? WHERE cpf = ?");
        stmt.setString(1, senha);
        stmt.setString(2, cpf);

        stmt.execute();

        close();
    }

    public void trocarCupom(int idCliente, Cupom cupom) throws Exception {

        open();
        int moedasSociais = 0;

        stmt = con.prepareStatement("SELECT * FROM cliente WHERE idCliente = ?");
        stmt.setInt(1, idCliente);
        stmt.execute();

        ResultSet resultSet = stmt.getResultSet();
        if (resultSet != null && resultSet.next()) {
            moedasSociais = resultSet.getInt("moedassociais");
        }

        stmt = con.prepareStatement("UPDATE cliente SET moedassociais = ? WHERE idcliente = ?");
        stmt.setInt(1, moedasSociais + cupom.getMoedasSociais());
        stmt.setInt(2, idCliente);
        stmt.execute();

        close();
    }
}
