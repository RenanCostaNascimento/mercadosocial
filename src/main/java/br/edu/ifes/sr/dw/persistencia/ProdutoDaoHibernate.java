/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.modelos.Produto;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Renan
 */
public class ProdutoDaoHibernate extends DaoHibernate implements ProdutoDao {

    @Override
    public void salvar(Produto produto) {
        session.getTransaction().begin();
        session.save(produto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void atualizar(Produto produto) {
        session.getTransaction().begin();
        session.update(produto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void excluir(Produto produto) {
        session.getTransaction().begin();
        session.delete(produto);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Produto> listarTodos() {
        session.getTransaction().begin();
        List<Produto> lista = session.createCriteria(Produto.class).list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

    @Override
    public List<Produto> listarInstituicao(String email) {
        session.getTransaction().begin();
        String hql = "select p from Produto p inner join p.instituicao i where i.email = :email";
        Query consulta = session.createQuery(hql);
        consulta.setString("email", email);
        List<Produto> lista = (List<Produto>) consulta.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

}
