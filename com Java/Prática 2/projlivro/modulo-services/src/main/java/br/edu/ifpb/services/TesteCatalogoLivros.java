package br.edu.ifpb.services;

import br.edu.ifpb.livro.Categoria;

import java.util.Date;

public class TesteCatalogoLivros {
    public static void main(String[] args) {
        CatalogoLivros myBooks = new CatalogoLivros();

        System.out.println(myBooks.catalogoVazio());

        myBooks.adicionarLivro("Livro Gui", "Guilherme", Categoria.valueOf("Terror".toUpperCase()), 125.25, new Date());
        myBooks.adicionarLivro("Outro Livro", "Guiih", Categoria.valueOf("Comédia".toUpperCase()), 175.50, new Date());
        myBooks.adicionarLivro("Mais um :3", "Esdras", Categoria.valueOf("Drama".toUpperCase()), 89.90, new Date());

        System.out.println(myBooks.listarLivros());
        System.out.println("-----------");

        myBooks.removerLivroPorTítulo("Livro Gui");
        System.out.println(myBooks.listarLivros());
        System.out.println("-----------");

        myBooks.removerLivro(3);
        System.out.println(myBooks.listarLivros());

        System.out.println(myBooks.catalogoVazio());
    }
}
