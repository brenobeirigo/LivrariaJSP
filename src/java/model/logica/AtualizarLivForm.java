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
import javax.servlet.http.HttpSession;
import model.Livros;

/**
 *
 * @author Master
 */
public class AtualizarLivForm implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InterfaceLivrosDAO dao;
        dao = new LivrariaDao();
        Livros livro = dao.procurarLivro(Integer.parseInt(request.getParameter("isbn")));
        HttpSession session = request.getSession(true);
        session.setAttribute("livro", livro);
        return "atualizarLivros.jsp";
    }

}
