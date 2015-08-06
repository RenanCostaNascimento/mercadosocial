/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.modelos.Cliente;

/**
 *
 * @author Renan
 */
public interface ClienteDao {
    public void salvar(Cliente cliente);
    public void atualizar(Cliente cliente);
    public Cliente buscar(String cpf);
    public Cliente buscarPorEmail(String email);
    public Cliente validarLogin(String email, String senha);
}
