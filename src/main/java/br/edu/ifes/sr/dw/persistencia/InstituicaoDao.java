/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.modelos.Instituicao;

/**
 *
 * @author Renan
 */
public interface InstituicaoDao {
    public void salvar(Instituicao instituicao);
    public void atualizar(Instituicao instituicao);
    public Instituicao validarLogin(String login, String senha);
    public Instituicao buscar(String email);
}
