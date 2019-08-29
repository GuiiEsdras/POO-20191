package br.edu.ifpb.services;

import br.edu.ifpb.livro.Livro;

public class CatalogoLivros {

    Livro testLivro = new Livro();

    public String getLivro() {
        return "Testando getLivro Catalogo: " +
                testLivro.outraMsg();
    }
}
