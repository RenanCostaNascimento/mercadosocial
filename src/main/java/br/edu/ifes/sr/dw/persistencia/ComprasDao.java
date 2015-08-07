/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.modelos.Compra;
import java.util.List;

/**
 *
 * @author Renan
 */
public interface ComprasDao {
    public void salvar(Compra compra);
    public List<Compra> listarCliente(String email);

}
