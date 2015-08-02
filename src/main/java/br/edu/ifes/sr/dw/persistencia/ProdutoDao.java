/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.modelos.Produto;
import java.util.List;

/**
 *
 * @author Renan
 */
public interface ProdutoDao {
    public void salvar(Produto produto);
    public void atualizar(Produto produto);
    public void excluir(Produto produto);
    public List<Produto> listarTodos();
    public List<Produto> listarInstituicao(String email);
}
