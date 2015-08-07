/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import br.edu.ifes.sr.dw.conexao.HibernateUtil;

/**
 *
 * @author Renan
 */
public class DaoFactory {

    public DaoFactory() {
    }

    public static ProdutoDao criarProdutoDao() {
        ProdutoDaoHibernate produtoDaoHibernate = new ProdutoDaoHibernate();
        produtoDaoHibernate.setSession(HibernateUtil.getSessionFactory().openSession());
        return produtoDaoHibernate;
    }
    
    public static InstituicaoDao criarInstituicaoDao() {
        InstituicaoDaoHibernate instituicaoDaoHibernate = new InstituicaoDaoHibernate();
        instituicaoDaoHibernate.setSession(HibernateUtil.getSessionFactory().openSession());
        return instituicaoDaoHibernate;
    }
    
    public static ClienteDao criarClienteDao() {
        ClienteDaoHibernate clienteDaoHibernate = new ClienteDaoHibernate();
        clienteDaoHibernate.setSession(HibernateUtil.getSessionFactory().openSession());
        return clienteDaoHibernate;
    }
    
    public static CupomDao criarCupomDao() {
        CupomDaoHibernate cupomDaoHibernate = new CupomDaoHibernate();
        cupomDaoHibernate.setSession(HibernateUtil.getSessionFactory().openSession());
        return cupomDaoHibernate;
    }
    
    public static ComprasDao criarComprasDao() {
        ComprasDaoHibernate comprasDaoHibernate = new ComprasDaoHibernate();
        comprasDaoHibernate.setSession(HibernateUtil.getSessionFactory().openSession());
        return comprasDaoHibernate;
    }
}
