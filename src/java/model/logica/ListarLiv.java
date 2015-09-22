/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.logica;

import dao.LivrariaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Master
 */
public class ListarLiv implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LivrariaDao dao = new LivrariaDao();
        List livrosList = dao.todosLivros();
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("livrosList", livrosList);
        return "mostrarLivros.jsp";
    }

}
