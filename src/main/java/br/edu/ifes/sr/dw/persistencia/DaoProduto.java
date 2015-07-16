/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.beans.HistoricoCupons;
import br.edu.ifes.sr.dw.modelos.Produto;
import br.edu.ifes.sr.dw.utils.Constants;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Produto> getProdutos() throws Exception {
        
         open();

        stmt = con.prepareStatement("SELECT * FROM produto WHERE quantidade > 0");
        stmt.execute();

        ResultSet resultSet = stmt.getResultSet();
        List<Produto> produtos = new ArrayList<>();
        while (resultSet != null && resultSet.next()) {
            int id = resultSet.getInt("idproduto");
            String nome = resultSet.getString("nome");
            double preco = resultSet.getDouble("preco");
            int quantidade = resultSet.getInt("quantidade");
            String descricao = resultSet.getString("descricao");
            String imagem = Constants.CAMINHO_ACESSO_ARQUIVO + resultSet.getString("imagem");

            produtos.add(new Produto(id, nome, preco, quantidade, descricao, imagem));

        }

        close();
        return produtos;
    }
    
}
