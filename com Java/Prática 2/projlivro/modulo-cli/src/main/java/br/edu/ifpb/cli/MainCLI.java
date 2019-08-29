package br.edu.ifpb.cli;

import br.edu.ifpb.services.CatalogoLivros;

public class MainCLI {
    public static void main(String[] args) {
        CatalogoLivros CatLiv = new CatalogoLivros();
        System.out.println( CatLiv.getLivro() );
    }
}
