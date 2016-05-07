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
        <link rel="stylesheet" type="text/css" href="semantic/dist/semantic.min.css">
        <script src="semantic/dist/semantic.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    </head>
    <body>
        <jsp:useBean id="livro" scope="session" class="model.Livro" />
        <div style="width:60%; margin: auto;">
            <h1>
                Atualizar Livro
            </h1>
            <form action=" Livraria?logica=AtualizarLiv" method="post" class="ui form" >

                <div class="field">
                    <label>ISBN:</label><input type="text" value="${livro.isbn}" readonly="readonly" name="isbn" />
                </div>
                <div class="field">
                    <label>Título:</label><input type="text" value="${livro.titulo}" name="titulo" />
                </div>
                <div class="field">
                    <label>Edição:</label><input type="text" value="${livro.edicao}" name= "edicao" />
                </div>
                <div class="field">
                    <label>Publicação:</label><input type="text" value="${livro.publicacao}" name="publicacao">
                </div>
                <div class="field">
                    <label>Descrição:</label>
                    <label><textarea name="descricao" rows="5"  cols="25">${livro.descricao}</textarea>
                </div>
                <button class="ui button" type="submit">Atualizar</button>
                <a href="Livraria?logica=ListarLiv">Mostrar livros cadastrados</a>
            </form>
        </div>
    </body>
</html>
