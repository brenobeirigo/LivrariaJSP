<%-- 
    Document   : formAtuLivro
    Created on : 2016-05-14
    Author     : Breno Beirigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualiza Livro</title>
        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    </head>
    <body>
        <jsp:useBean id="livro" scope="session" class="model.Livro" />
        <div style="width:60%; margin: auto;">
            <h1>
                Atualizar Livro
            </h1>
            <form action=" Livraria?logica=AtualizarLiv" method="post" class="ui form" >

                <div class="form-group">
                    <label for="isbn">ISBN:</label>
                    <input type="text" class="form-control" value="${livro.isbn}" readonly="readonly" name="isbn" />
                </div>
                <div class="form-group">
                    <label for="titulo">Título:</label>
                    <input type="text" class="form-control" value="${livro.titulo}" name="titulo" />
                </div>
                <div class="form-group">
                    <label for="edicao">Edição:</label>
                    <input type="text" class="form-control" value="${livro.edicao}" name= "edicao" />
                </div>
                <div class="form-group">
                    <label for="publicacao">Publicação:</label>
                    <input type="text" class="form-control" value="${livro.publicacao}" name="publicacao">
                </div>
                <div class="form-group">
                    <label for="descricao">Descrição:</label>
                    <textarea name="descricao" rows="5" class="form-control" cols="25">${livro.descricao}</textarea>
                </div>
                <button class="btn btn-default" type="submit">Atualizar</button>
                <a href="Livraria?logica=ListarLiv">Mostrar livros cadastrados</a>
            </form>
        </div>
    </body>
</html>
