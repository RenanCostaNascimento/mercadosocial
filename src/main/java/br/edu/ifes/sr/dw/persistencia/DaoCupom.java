/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.modelos.Cupom;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCupom extends Dao {

    public void insert(Cupom cupom) throws Exception {

//        open();
//
//        stmt = con.prepareStatement("INSERT INTO cupom (codigo, cpfcliente, moedassociais, resgatado) VALUES (?, ?, ?, ?)");
//        stmt.setString(1, cupom.getCodigo());
//        stmt.setString(2, cupom.getCpfCliente());
//        stmt.setInt(3, cupom.getMoedasSociais());
//        stmt.setBoolean(4, false);
//        stmt.execute();
//
//        close();
    }

    /**
     * Recupera a quantidade de moedas sociais de um cupom.
     *
     * @param cpf o cpf do cliente
     * @param codigoCupom o codigo do cupom
     * @return o cupom encontrado, ou null se não houver cupons válidos cupons
     * válidos
     * @throws SQLException
     */
    public Cupom getCupomValido(String cpf, String codigoCupom) throws Exception {

//        open();
//
//        stmt = con.prepareStatement("SELECT * FROM cupom WHERE codigo = ? AND cpfcliente = ? AND resgatado = false");
//        stmt.setString(1, codigoCupom);
//        stmt.setString(2, cpf);
//
//        stmt.execute();
//
//        ResultSet resultSet = stmt.getResultSet();
//        if (resultSet != null && resultSet.next()) {
//            int id = resultSet.getInt("idcupom");
//            String codigo = resultSet.getString("codigo");
//            String cpfcliente = resultSet.getString("cpfcliente");
//            int moedasSociais = resultSet.getInt("moedassociais");
//            boolean resgatado = resultSet.getBoolean("resgatado");
//
//            close();
//            return new Cupom(id, cpfcliente, cpfcliente, moedasSociais, resgatado);
//        }
//
//        close();
        return null;
    }

    public void cupomResgatado(int idCupom) throws Exception {
        open();

        stmt = con.prepareStatement("UPDATE cupom SET resgatado = true WHERE idCupom = ?");
        stmt.setInt(1, idCupom);        
        stmt.execute();

        close();
    }

}
