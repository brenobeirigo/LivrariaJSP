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
        <h1>MOSTRAR LIVROS</h1>
        <table border="l" cellpadding="0" cellspacing="0">
            <tr>
                <th>ISBN</th>
                <th>Título</th>
                <th>Publicado em</th>
                <th>Edição</th>
                <th>Descrição</th>

            </tr>
            <%
                List livrosList = (List) request.getAttribute("livrosList");
                for (Iterator i = livrosList.iterator(); i.hasNext();) {
                    Livros l = (Livros) i.next();
            %>
            <tr>
                <td> 
                    <%=l.getIsbn()%>
                </td>
                <td><%=l.getTitulo()%></td>
                <td>
                    <%= l.getPublicacao()%>
                </td>
                <td>
                    <%= l.getEdicao()%>
                </td>
                <td>
                    <%= l.getDescricao()%>
                </td>
            </tr>
            <%
                }//end for
            %>
        </table>
        <a href="cadastrarLivros.html">>>Cadastrar livros</a>
    </body>
</html>
