/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.conexao.HibernateUtil;
import br.edu.ifes.sr.dw.modelos.Cupom;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Renan
 */
public class CupomDaoHibernate extends DaoHibernate implements CupomDao {
    
    @Override
    public void salvar(Cupom cupom) {
        session.getTransaction().begin();
        session.save(cupom);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void atualizar(Cupom cupom) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.update(cupom);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Cupom> buscarPorInstituicao(String email) {
        session.getTransaction().begin();
        String hql = "select c from Cupom c inner join c.instituicao i where i.email = :email";
        Query consulta = session.createQuery(hql);
        consulta.setString("email", email);
        List<Cupom> cupons = (List<Cupom>) consulta.list();
        session.getTransaction().commit();
        session.close();
        return cupons;
    }

    @Override
    public Cupom buscarCodigoCpfCliente(String codigo, String cpf) {
        session.getTransaction().begin();
        String hql = "select c from Cupom c inner join c.cliente cl where c.codigo = :codigo and cl.cpf = :cpf";
        Query consulta = session.createQuery(hql);
        consulta.setString("codigo", codigo);
        consulta.setString("cpf", cpf);
        Cupom cupom = (Cupom) consulta.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return cupom;
    }
    
    @Override
    public List<Cupom> buscarPorCliente(String email) {
        session.getTransaction().begin();
        String hql = "select c from Cupom c inner join c.cliente cli where cli.email = :email and c.resgatado = :resgatado";
        Query consulta = session.createQuery(hql);
        consulta.setString("email", email);
        consulta.setBoolean("resgatado", false);
        List<Cupom> cupons = (List<Cupom>) consulta.list();
        session.getTransaction().commit();
        session.close();
        return cupons;
    }

}
