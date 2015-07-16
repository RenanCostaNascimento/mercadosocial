/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.beans.HistoricoCupons;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Renan
 */
public class DaoClienteCupom extends Dao {

    public void inserirCupomCliente(int idCliente, int idCupom) throws Exception {

        open();

        stmt = con.prepareStatement("INSERT INTO clientecupom (idcliente, idcupom, datatroca) VALUES (?, ?, ?)");
        stmt.setInt(1, idCliente);
        stmt.setInt(2, idCupom);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        stmt.setString(3, dateFormat.format(Calendar.getInstance().getTime()));
        stmt.execute();

        close();
    }

    public List<HistoricoCupons> getCupons(int idCliente) throws Exception {

        open();

        stmt = con.prepareStatement("SELECT * FROM clientecupom cc \n"
                + "INNER JOIN cupom c ON cc.idcupom = c.idcupom\n"
                + "WHERE cc.idcliente = ?;");
        stmt.setInt(1, idCliente);
        stmt.execute();

        ResultSet resultSet = stmt.getResultSet();
        List<HistoricoCupons> cupons = new ArrayList<>();
        while (resultSet != null && resultSet.next()) {
            String data = resultSet.getString("dataTroca");
            int moedasSociais = resultSet.getInt("moedassociais");

            cupons.add(new HistoricoCupons(moedasSociais, data));

        }

        close();
        return cupons;

    }

}
