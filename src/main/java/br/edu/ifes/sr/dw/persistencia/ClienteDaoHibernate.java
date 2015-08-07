/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.conexao.HibernateUtil;
import br.edu.ifes.sr.dw.modelos.Cliente;
import org.hibernate.Query;

/**
 *
 * @author Renan
 */
public class ClienteDaoHibernate extends DaoHibernate implements ClienteDao{
    
    @Override
    public void salvar(Cliente cliente) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(cliente);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void atualizar(Cliente cliente) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(cliente);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Cliente buscar(String cpf) {
        session.getTransaction().begin();
        String hql = "select c from Cliente c where c.cpf = :cpf";
        Query consulta = session.createQuery(hql);
        consulta.setString("cpf", cpf);
        Cliente cliente = (Cliente) consulta.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return cliente;
    }

    @Override
    public Cliente buscarPorEmail(String email) {
        session.getTransaction().begin();
        String hql = "select c from Cliente c where c.email = :email";
        Query consulta = session.createQuery(hql);
        consulta.setString("email", email);
        Cliente cliente = (Cliente) consulta.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return cliente;
    }

    @Override
    public Cliente validarLogin(String email, String senha) {
        session.getTransaction().begin();
        String hql = "select c from Cliente c where c.email = :email and c.senha = :senha ";
        Query consulta = session.createQuery(hql);
        consulta.setString("email", email);
        consulta.setString("senha", senha);
        Cliente cliente = (Cliente) consulta.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return cliente;
    }
    
}
