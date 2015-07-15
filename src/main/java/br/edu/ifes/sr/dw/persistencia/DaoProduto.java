/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.modelos.Produto;

/**
 *
 * @author Renan
 */
public class DaoProduto extends Dao{
    
    public void insert(Produto produto) throws Exception {

        open();

        stmt = con.prepareStatement("INSERT INTO produto (nome, preco, quantidade, descricao, imagem) VALUES (?, ?, ?, ?, ?)");
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.setInt(3, produto.getQuantidade());
        stmt.setString(4, produto.getDescricao());
        stmt.setString(5, produto.getImagem());
        stmt.execute();

        close();
    }
    
}
