/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.sr.dw.persistencia;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;

/**
 *
 * @author Renan
 */
@Getter
@Setter
public class DaoHibernate {
    protected Session session;
}
