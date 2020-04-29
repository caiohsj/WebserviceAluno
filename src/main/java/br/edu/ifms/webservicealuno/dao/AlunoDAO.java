/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.webservicealuno.dao;

import br.edu.ifms.webservicealuno.model.Aluno;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Caio Henrique
 */
public class AlunoDAO {
    private EntityManager em;
    
    public AlunoDAO() {
        this.em = FabricaDeGerenciadorDeEntidades.getEntityManager();
    }
    
    public void inserir(Aluno aluno) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        
        em.persist(aluno);
        em.getTransaction().commit();
    }
    
    public void alterar(Aluno aluno) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        em.merge(aluno);
        em.getTransaction().commit();
    }
    
    public void remover(int id) {
        em.getTransaction().begin();
        em.remove(buscarPorId(id));
        em.getTransaction().commit();
    }
    
    public Aluno buscarPorId(int id) {
        return em.find(Aluno.class, id);
    }
    
    public List<Aluno> listarTodos() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT a ");
        query.append("FROM ");
        query.append("Aluno ");
        query.append("a");
        return em.createQuery(query.toString()).getResultList();
    }
}
