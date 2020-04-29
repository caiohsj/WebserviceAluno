/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.webservicealuno;

import br.edu.ifms.webservicealuno.dao.AlunoDAO;
import br.edu.ifms.webservicealuno.model.Aluno;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.PersistenceException;
import org.jboss.logging.Logger;

/**
 *
 * @author Caio Henrique
 */
@WebService(targetNamespace = "http://localhost:8000/alunows")
public class WebserviceAluno {
    private AlunoDAO dao;
    
    public WebserviceAluno() {
        try {
            dao = new AlunoDAO();
        } catch(PersistenceException e) {
            Logger.getLogger(WebserviceAluno.class.getName()).log(Logger.Level.FATAL, null, e);
        }
    }
    
    @WebMethod
    public void inserir(@WebParam(name = "aluno") Aluno aluno) {
        dao.inserir(aluno);
    }
    
    @WebMethod
    public void alterar(@WebParam(name = "aluno") Aluno aluno) {
        dao.alterar(aluno);
    }
    
    @WebMethod
    public void remover(@WebParam(name = "id") int id) {
        dao.remover(id);
    }
    
    @WebMethod
    public List<Aluno> listar() {
        return dao.listarTodos();
    }
}
