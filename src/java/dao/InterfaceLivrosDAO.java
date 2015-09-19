/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import model.Livros;

/**
 *
 * @author Master
 */
public interface InterfaceLivrosDAO {

    void atualizar(Livros livro) throws LivrariaDAOException;

    void excluir(Livros livro) throws LivrariaDAOException;

    void salvar(Livros livro) throws LivrariaDAOException;

    List todosLivros() throws LivrariaDAOException;

    Livros procurarLivro(int isbn) throws LivrariaDAOException;
}
