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
import model.Livro;

/**
 *
 * @author Master
 */
public class AtualizarLiv implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InterfaceLivrosDAO dao;
        dao = new LivrariaDao();
        Livro livro = new Livro();
        livro.setIsbn(Integer.parseInt(request.getParameter("isbn")));
        livro.setTitulo(request.getParameter("titulo"));
        livro.setEdicao(Integer.parseInt(request.getParameter("edicao")));
        livro.setPublicacao(Integer.parseInt(request.getParameter("publicacao")));
        livro.setDescricao(request.getParameter("descricao"));
        dao.atualizar(livro);
        return "Livraria?logica=ListarLiv";

    }

}
