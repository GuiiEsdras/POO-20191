package br.edu.ifpb.livro;

import java.util.Date;

public class TesteLivro {
    public static void main(String[] args) {

        String categoria = "Comédia";
        Livro livro = new Livro("Livro do Gui", "Guilherme",
                Categoria.valueOf(categoria.toUpperCase()), 157.78, new Date());
        System.out.println(livro);

        Livro livro2 = new Livro("Outro Livro", "Gui Esdras", Categoria.DRAMA, 200, new Date());
        System.out.println(livro2);

        Livro livro3 = new Livro("Último", "Esdras",
                Categoria.valueOf("Terror".toUpperCase()), 0, new Date());
        System.out.println(livro3);

    }
}
