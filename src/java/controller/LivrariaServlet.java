/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.InterfaceLivrosDAO;
import dao.LivrariaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Livros;

/**
 *
 * @author Master
 */
@WebServlet(name = "LivrariaServlet", urlPatterns = {"/LivrariaServlet"})
public class LivrariaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String logica = request.getParameter("logica");
        InterfaceLivrosDAO dao;

        try {
            dao = new LivrariaDao();
            RequestDispatcher rd = null;
            if (logica.equalsIgnoreCase("MostrarLivros")) {
                List livrosList = dao.todosLivros();
                response.setContentType("text/html;charset=UTF-8");
                request.setAttribute("livrosList", livrosList);
                rd = request.getRequestDispatcher("mostrarLivros.jsp");
            } else if (logica.equalsIgnoreCase("AdicionarLivros")) {
                Livros livro = new Livros();
                livro.setIsbn(Integer.parseInt(request.getParameter("isbn")));
                livro.setTitulo(request.getParameter("titulo"));
                String edicao = request.getParameter("edicao");
                if (edicao == null) {
                    edicao = "1";
                }
                livro.setPublicacao(Integer.parseInt(request.getParameter("publicacao")));
                livro.setDescricao(request.getParameter("descricao"));
                dao.salvar(livro);
                rd = request.getRequestDispatcher("LivrariaServlet?logica=MostrarLivros");
            }
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
