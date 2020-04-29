/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.webservicealuno.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author caioc
 */
public class FabricaDeGerenciadorDeEntidades {
    private EntityManagerFactory emf;
    private EntityManager em;
    private static FabricaDeGerenciadorDeEntidades fabrica;

    private FabricaDeGerenciadorDeEntidades() {
        emf = Persistence.createEntityManagerFactory("aluno-pu");
        em = emf.createEntityManager();
    }

    private static FabricaDeGerenciadorDeEntidades getInstance() {
        if (fabrica == null) {
            fabrica = new FabricaDeGerenciadorDeEntidades();
        }
        return fabrica;
    }

    public static EntityManager getEntityManager() {
        return getInstance().getEm();
    }

    private EntityManager getEm() {
        return em;
    }
}
