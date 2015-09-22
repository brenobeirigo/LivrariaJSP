/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logica;

import dao.InterfaceLivrosDAO;
import dao.LivrariaDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Livros;

/**
 *
 * @author Master
 */
public class ExcluirLiv implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InterfaceLivrosDAO dao;
        dao = new LivrariaDao();
        Livros livro = new Livros();
        livro.setIsbn(Integer.parseInt(request.getParameter("isbn")));
        dao.excluir(livro);
        return "Livraria?logica=ListarLiv";
    }

}