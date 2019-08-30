package br.edu.ifpb.livro;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class LivroTest {


    @Test
    public void setCódigo() {
        Livro livro1 = new Livro("Título", "Autor", Categoria.ROMANCE, 50.00, new Date());
        Assert.assertEquals(1, livro1.getCódigo());

        Livro livro2 = new Livro("Outro", "Exemplo", Categoria.TERROR, 100.00, new Date());
        Assert.assertEquals(2, livro2.getCódigo());
    }

    @Test
    public void getGênero() {
        Livro livro3 = new Livro("Título", "Autor", Categoria.FANTASIA, 50.00, new Date());
        Assert.assertEquals("Fantasia", livro3.getGênero().toString());

        livro3.setGênero(Categoria.COMÉDIA);
        Assert.assertEquals("Comédia", livro3.getGênero().toString());
    }

    @Test
    public void getCódigo() {
        Livro livro4 = new Livro("Título", "Autor", Categoria.ROMANCE, 50.00, new Date());
        Assert.assertEquals(4, livro4.getCódigo());

        Livro livro5 = new Livro("Outro", "Exemplo", Categoria.TERROR, 100.00, new Date());
        Assert.assertEquals(5, livro5.getCódigo());
    }

    @Test
    public void getTítulo() {
        Livro livro = new Livro("Título", "Autor", Categoria.TERROR, 50.00, new Date());
        Assert.assertEquals("Título", livro.getTítulo());

        livro.setTítulo("Exemplo");
        Assert.assertEquals("Exemplo", livro.getTítulo());
    }

    @Test
    public void setTítulo() {
        Livro livro = new Livro("Título", "Autor", Categoria.TERROR, 50.00, new Date());
        Assert.assertEquals("Título", livro.getTítulo());

        livro.setTítulo("Exemplo");
        Assert.assertEquals("Exemplo", livro.getTítulo());

        livro.setTítulo("");
        Assert.assertEquals("Exemplo", livro.getTítulo());
    }

    @Test
    public void getAutor() {
        Livro livro = new Livro("Título", "Autor", Categoria.DRAMA, 50.00, new Date());
        Assert.assertEquals("Autor", livro.getAutor());

        livro.setAutor("Outro");
        Assert.assertEquals("Outro", livro.getAutor());
    }

    @Test
    public void setAutor() {
        Livro livro = new Livro("Título", "Autor", Categoria.DRAMA, 50.00, new Date());
        Assert.assertEquals("Autor", livro.getAutor());

        livro.setAutor("Outro");
        Assert.assertEquals("Outro", livro.getAutor());
    }

    @Test
    public void setGênero() {
        Livro livro = new Livro("Título", "Autor", Categoria.ROMANCE, 50.00, new Date());
        Assert.assertEquals("Romance", livro.getGênero().toString());

        livro.setGênero(Categoria.DRAMA);
        Assert.assertEquals("Drama", livro.getGênero().toString());
    }

    @Test
    public void getPreço() {
        Livro livro = new Livro("Título", "Autor", Categoria.ROMANCE, 50.00, new Date());
        Assert.assertEquals(50.00, livro.getPreço(), 0);

        livro.setPreço(225.00);
        Assert.assertEquals(225.00, livro.getPreço(), 0);
    }

    @Test
    public void setPreço() {
        Livro livro = new Livro("Título", "Autor", Categoria.ROMANCE, 50.00, new Date());
        Assert.assertEquals(50.00, livro.getPreço(), 0);

        livro.setPreço(150.00);
        Assert.assertEquals(150.00, livro.getPreço(), 0);
    }
}