/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.LivrariaDao;
import dao.LivrariaDAOException;

/**
 *
 * @author Master
 */
public class Livros implements java.io.Serializable {

    private int isbn;
    private String titulo;
    private int edicao;
    private int publicacao;

    
    private String descricao;
   
    
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(int publicacao) {
        this.publicacao = publicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Livros() {
    }

    
    public Livros(int isbn, String titulo, int edicao, int publicacao, String descricao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicao = edicao;
        this.publicacao = publicacao;
        this.descricao = descricao;
    }
    
   
    public static void main(String[] args) throws LivrariaDAOException{
        LivrariaDao d = new LivrariaDao();
        Livros a = d.procurarLivro(1);
        System.out.println(a.getDescricao());
    }
}