package br.edu.ifpb.services;

import br.edu.ifpb.livro.Categoria;
import br.edu.ifpb.livro.Livro;

import java.util.ArrayList;
import java.util.Date;

public class CatalogoLivros {

    ArrayList<Livro> listaDeLivros;

    public CatalogoLivros() {
        this.listaDeLivros = new ArrayList<Livro>();
    }

    public ArrayList<Livro> getListaDeLivros() {
        return listaDeLivros;
    }

    public boolean adicionarLivro(String título, String autor, Categoria gênero, double preço, Date aquisição) {

        Livro livroTemp = new Livro(título, autor, gênero, preço, aquisição);

        if (this.listaDeLivros.contains(livroTemp)) return false;

        this.listaDeLivros.add(livroTemp);

        return true;
    }

    public boolean removerLivro(int código) {

        for (Livro livro : listaDeLivros) {
            if (livro.getCódigo() == código) {
                listaDeLivros.remove(livro);
                return true;
            }
        }

        return false;
    }

    public boolean removerLivroPorTítulo(String título) {

        for (Livro livro: listaDeLivros) {
            if (livro.getTítulo() == título) {
                listaDeLivros.remove(livro);
                return true;
            }
        }

        return false;
    }

    public boolean pesquisarLivro(int código) {

        for (Livro livro : listaDeLivros) {
            if (livro.getCódigo() == código) {
                return true;
            }
        }

        return false;
    }

    public int pesquisarLivroPorTítulo(String título) {

        for (Livro livro : listaDeLivros) {
            if (livro.getTítulo() == título) {
                return livro.getCódigo();
            }
        }

        return -1;
    }

    public boolean catalogoVazio() {
        return this.listaDeLivros.isEmpty();
    }

    public String listarLivros() {

        StringBuilder catalogo = new StringBuilder();

        for (Livro livro : listaDeLivros) {
            catalogo.append(livro.toString() + "\n");
        }

        return catalogo.toString();
    }
}
