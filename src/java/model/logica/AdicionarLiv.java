/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logica;

import dao.LivrariaDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Livros;

/**
 *
 * @author Master
 */
public class AdicionarLiv implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LivrariaDao dao = new LivrariaDao();
        Livros livro = new Livros();
        livro.setIsbn(Integer.parseInt(request.getParameter("isbn")));
        livro.setTitulo(request.getParameter("titulo"));
        String edicao = request.getParameter("edicao");
        if (edicao == null) {
            edicao = "1";
        }
        livro.setEdicao(Integer.parseInt(edicao));
        livro.setPublicacao(Integer.parseInt(request.getParameter("publicacao")));
        livro.setDescricao(request.getParameter("descricao"));
        System.out.println("LIVRO:"+livro);
        dao.salvar(livro);
        return "Livraria?logica=ListarLiv";
    }

}
