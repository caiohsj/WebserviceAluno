/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.webservicealuno;

import javax.xml.ws.Endpoint;

/**
 *
 * @author Caio Henrique
 */
public class Main {
    public static void main(String[] args) {
        WebserviceAluno ws = new WebserviceAluno();
        String url = "http://localhost:8000/alunows";
        System.out.println("AlunoWS rodando em "+url);
        Endpoint.publish(url, ws);
    }
}