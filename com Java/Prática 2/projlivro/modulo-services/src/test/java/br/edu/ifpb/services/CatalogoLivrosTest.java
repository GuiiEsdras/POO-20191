package br.edu.ifpb.services;

import br.edu.ifpb.livro.Categoria;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CatalogoLivrosTest {

//    @Test
//    void removerLivroPorTítulo() {
//        CatalogoLivros MyBookRack = new CatalogoLivros();
//        MyBookRack.adicionarLivro("Título", "Autor", Categoria.valueOf("Comédia"), 150.00, new Date());
//        Assert.assertTrue(MyBookRack.pesquisarLivroPorTítulo("Título"));
//
//        MyBookRack.removerLivroPorTítulo("Título");
//        Assert.assertFalse(MyBookRack.pesquisarLivroPorTítulo("Título"));
//    }
//
//    @Test
//    void pesquisarLivroPorTítulo() {
//        CatalogoLivros MyBookRack = new CatalogoLivros();
//        MyBookRack.adicionarLivro("Título", "Autor", Categoria.COMÉDIA, 150.00, new Date());
//        Assert.assertTrue(MyBookRack.pesquisarLivroPorTítulo("Título"));
//
//        MyBookRack.removerLivroPorTítulo("Título");
//        Assert.assertFalse(MyBookRack.pesquisarLivroPorTítulo("Título"));
//    }


    @Test
    void catalogoVazio() {
        CatalogoLivros MyBookRack = new CatalogoLivros();
        Assert.assertTrue(MyBookRack.catalogoVazio());

        MyBookRack.adicionarLivro("Título", "Autor", Categoria.COMÉDIA, 150.00, new Date());
        Assert.assertFalse(MyBookRack.catalogoVazio());
    }
}