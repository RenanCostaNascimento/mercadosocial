/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.conexao.HibernateUtil;
import br.edu.ifes.sr.dw.modelos.Compra;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Renan
 */
public class ComprasDaoHibernate extends DaoHibernate implements ComprasDao{

    @Override
    public void salvar(Compra compra) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(compra);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Compra> listarCliente(String email) {
        session.getTransaction().begin();
        String hql = "select c from Compra c inner join c.cliente cl where cl.email = :email";
        Query consulta = session.createQuery(hql);
        consulta.setString("email", email);
        List<Compra> lista = (List<Compra>) consulta.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

}
