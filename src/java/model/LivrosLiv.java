/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.logica.Logica;
import dao.InterfaceLivrosDAO;
import dao.LivrariaDao;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Master
 */
public class LivrosLiv implements Logica {

    private int isbn;
    private String titulo;
    private int edicao;
    private int publicacao;

    private String descricao;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(int publicacao) {
        this.publicacao = publicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LivrosLiv() {
    }

    public LivrosLiv(int isbn, String titulo, int edicao, int publicacao, String descricao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicao = edicao;
        this.publicacao = publicacao;
        this.descricao = descricao;
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cmd = request.getParameter("cmd");
        if (cmd == null) {
            return "formInserindoDados.html";
        }
        
        InterfaceLivrosDAO dao;

       
            try {
                dao = new LivrariaDao();
                RequestDispatcher rd = null;
                if (cmd.equalsIgnoreCase("listar")) {
                    
                } else if (cmd.equalsIgnoreCase("addliv")) {
                    
                } else if (cmd.equalsIgnoreCase("exc")) {
                    Livros livro = new Livros();
                    livro.setIsbn(Integer.parseInt(request.getParameter("isbn")));
                    dao.excluir(livro);
                    return "LivrariaServlet?cmd=listar";
                } else if (cmd.equalsIgnoreCase("atu")) {
                    Livros livro = dao.procurarLivro(Integer.parseInt(request.getParameter("isbn")));
                    HttpSession session = request.getSession(true);
                    session.setAttribute("livro", livro);
                    return "formAtuLivro.jsp";
                } else if (cmd.equalsIgnoreCase("atualizar")) {
                    Livros livro = new Livros();
                    livro.setIsbn(Integer.parseInt(request.getParameter("isbn")));
                    dao.atualizar(livro);
                    rd = request.getRequestDispatcher("LivrariaServlet?cmd=listar");
                } else if (cmd.equalsIgnoreCase("principal")) {
                    return "index.jsp";
                }
                rd.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        return null;
        
    }

}
