<%-- 
    Document   : mostrarLivrosCads
    Created on : 2016-05-14
    Author     : Breno Beirigo
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.Livro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibe livros</title>
        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    </head>
    <body>
        
        <div style="width: 60%; margin: auto">
            <h1>Livros cadastrados</h1>
        <table class="table table-striped">
            <tr>
                <th>ISBN - Atualizar</th>
                <th>Título</th>
                <th>Publicado em</th>
                <th>Excluir Livro</th>
            </tr>
            <%
                List livrosList = (List) request.getAttribute("livrosList");
                for (Iterator i = livrosList.iterator(); i.hasNext();) {
                    Livro l = (Livro) i.next();
            %>
            <tr>
                <td>
                    <a href= "Livraria?logica=AtualizarLivForm&isbn=<%=l.getIsbn()%>">
                        <%=l.getIsbn()%>
                    </a>
                </td>
                <td><%=l.getTitulo()%></td>
                <td>
                    <%= l.getPublicacao()%>
                </td>
                <td>
                    <a href= "Livraria?logica=ExcluirLiv&isbn=<%=l.getIsbn()%>">
                        Excluir
                    </a>
                </td>
            </tr>
            <%
                    }//end for
%>
        </table>
        <a href="Livraria?logica=AdicionarLivForm">>>Adicionar mais livros</a>
        </div>
    </body>
</html>
