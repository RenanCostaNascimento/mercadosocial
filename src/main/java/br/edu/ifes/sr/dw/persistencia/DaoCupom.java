/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.modelos.Cupom;

public class DaoCupom extends Dao {

    public void insert(Cupom cupom) throws Exception {

        open();

        stmt = con.prepareStatement("INSERT INTO cupom (codigo, cpfcliente, moedassociais, resgatado) VALUES (?, ?, ?, ?)");
        stmt.setString(1, cupom.getCodigo());
        stmt.setString(2, cupom.getCpfCliente());
        stmt.setInt(3, cupom.getMoedasSociais());
        stmt.setBoolean(4, false);
        stmt.execute();

        close();
    }
}
