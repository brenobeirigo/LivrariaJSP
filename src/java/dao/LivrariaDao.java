/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Master
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Livros;
import util.ConnectionLivrariaFactory;

public class LivrariaDao implements InterfaceLivrosDAO {

    private Connection conn;

    public LivrariaDao() throws LivrariaDAOException {
        try {
            this.conn = ConnectionLivrariaFactory.getConnection();
        } catch (Exception e) {
            throw new LivrariaDAOException("Erro: " + " : \n" + e.getMessage());
        }
    }

    public void salvar(Livros livro) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        if (livro == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
        }

        try {
            String SQL = "INSERT INTO livros (isbn, titulo, edicao_num, ano_publicacao, descricao) values (?, ?, ?, ?, ?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, livro.getIsbn());
            ps.setString(2, livro.getTitulo());
            ps.setInt(3, livro.getEdicao());
            ps.setInt(4, livro.getPublicacao());
            ps.setString(5, livro.getDescricao());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new LivrariaDAOException("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps);
        }
    }

    public void excluir(Livros livro) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        if (livro == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
        }
        try {
            conn = this.conn;
            ps = conn.prepareStatement("delete from livros where isbn=?");
            ps.setInt(1, livro.getIsbn());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new LivrariaDAOException("Erro ao excluir dados:" + sqle);
        } finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps);
        }

    }

    public void atualizar(Livros livro) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        if (livro == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
        }
        try {
            String SQL = "UPDATE livros SET titulo=?, edicao_num=?, ano_publicacao=?, descricao=? where isbn=?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, livro.getTitulo());
            ps.setInt(2, livro.getEdicao());
            ps.setInt(3, livro.getPublicacao());
            ps.setString(4, livro.getDescricao());
            ps.setInt(5, livro.getIsbn());
            ps.executeUpdate();
        } catch (SQLException sql) {
            throw new LivrariaDAOException("Erro ao atualizar dados: " + sql);
        } finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps);
        }
    }

    public List todosLivros() throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from livros");
            rs = ps.executeQuery();
            List<Livros> list = new ArrayList<Livros>();
            while (rs.next()) {
                int isbn = rs.getInt(1);
                String titulo = rs.getString(2);
                int edicao = rs.getInt(3);
                int publicacao = rs.getInt(4);
                String descricao = rs.getString(5);
                list.add(new Livros(isbn, titulo, edicao, publicacao, descricao));

            }
            return list;
        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
    }

    public Livros procurarLivro(int isbn) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from livros where isbn =?");
            ps.setInt(1, isbn);
            rs = ps.executeQuery();
            if (!rs.next()) {
                throw new LivrariaDAOException("Não foi encontrado nenhum registro com o ISBN: " + isbn);
            }
            String titulo = rs.getString(2);
            int edicao = rs.getInt(3);
            int publicacao = rs.getInt(4);
            String descricao = rs.getString(5);
            return new Livros(isbn, titulo, edicao, publicacao, descricao);

        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
    }
}
