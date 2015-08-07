/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.modelos.Cupom;
import java.util.List;

/**
 *
 * @author Renan
 */
public interface CupomDao {
    public void salvar(Cupom cupom);
    public void atualizar(Cupom cupom);
    public List<Cupom> buscarPorInstituicao(String email);
    public Cupom buscarCodigoCpfCliente(String codigo, String cpf);
    public List<Cupom> buscarPorCliente(String email);
}
