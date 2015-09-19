<%-- 
    Document   : formAtuLivro
    Created on : Sep 15, 2015, 11:40:46 PM
    Author     : Master
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualiza Livro</title>
    </head>
    <body>
        <jsp:useBean id="livro" scope="session" class="model.Livros" />
        <form action=" LivrariaServlet?cmd=atualizar" method="post">
            <table>
                <tr>
                    <td>ISBN:</td>
                    <td>
                        <input type="text" name="isbn" value="${livro.isbn}" readonly="readonly" />
                    </td>
                </tr>
                <tr>
                    <td>Título:</td>
                    <td>
                        <input type="text" name="titulo" value="${livro.titulo}" />
                    </td>
                </tr>
                <tr>
                    <td>Edição:</td>
                    <td>
                        <input type="text" name="edicao" value="${livro.edicao}" />
                    </td>
                </tr>
                <tr>
                    <td>Publicação:</td>
                    <td>
                        <input type="text" name="publicacao" value="${livro.publicacao}" />
                    </td>
                </tr>
                <tr>
                    <td>Descrição:</td>
                    <td>
                        <textarea name="descricao" rows="5" cols="25">
                            ${livro.descricao}
                        </textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="btAtualizar" value= "Atualizar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
