/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.modelos.Instituicao;
import org.hibernate.Query;

/**
 *
 * @author Renan
 */
class InstituicaoDaoHibernate extends DaoHibernate implements InstituicaoDao {

    @Override
    public void salvar(Instituicao instituicao) {
        session.getTransaction().begin();
        session.save(instituicao);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void atualizar(Instituicao instituicao) {
        session.getTransaction().begin();
        session.update(instituicao);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Instituicao validarLogin(String email, String senha) {
        session.getTransaction().begin();
        String hql = "select i from Instituicao i where i.email = :email and i.senha = :senha";
        Query consulta = session.createQuery(hql);
        consulta.setString("email", email);
        consulta.setString("senha", senha);
        Instituicao instituicao = (Instituicao) consulta.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return instituicao;

    }

    @Override
    public Instituicao buscar(String email) {
        session.getTransaction().begin();
        String hql = "select i from Instituicao i where i.email = :email";
        Query consulta = session.createQuery(hql);
        consulta.setString("email", email);
        Instituicao instituicao = (Instituicao) consulta.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return instituicao;
    }
}
