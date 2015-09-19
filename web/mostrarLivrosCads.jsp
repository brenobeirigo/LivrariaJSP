<%-- 
    Document   : mostrarLivrosCads
    Created on : Sep 15, 2015, 11:19:11 PM
    Author     : Master
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.Livros"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibe livros</title>
    </head>
    <body>
        <h1>LIVRARIA</h1>
        <table border="l" cellpadding="2" cellspacing="O">
            <tr>
                <th>ISBN - Atualizar</th>
                <th>Título</th>
                <th>Publicado em</th>
                <th>Excluir Livro</th>
            </tr>
                <%
                    List livrosList = (List) request.getAttribute("livrosList");
                    for (Iterator i = livrosList.iterator(); i.hasNext();) {
                        Livros l = (Livros) i.next();
                %>
                <tr>
                    <td>
                        <a href= "LivrariaServlet?cmd=atu&isbn=<%=l.getIsbn()%>">
                            <%=l.getIsbn()%>
                        </a>
                    </td>
                    <td><%=l.getTitulo()%></td>
                    <td>
                        <%= l.getPublicacao()%>
                    </td>
                    <td>
                        <a href=" LivrariaServlet?cmd=exc&isbn=<%=l.getIsbn()%>">
                            Excluir
                        </a>
                    </td>
                </tr>
                <%
                    }//end for
                %>
        </table>
    </body>
</html>
