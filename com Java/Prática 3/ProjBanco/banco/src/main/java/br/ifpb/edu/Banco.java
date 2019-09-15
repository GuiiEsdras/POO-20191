package br.ifpb.edu;

import br.edu.ifpb.ContaCorrente;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<ContaCorrente> listaDeContasCorrente;

    {
        this.setListaDeContasCorrente(new ArrayList<>());
    }


    public List<ContaCorrente> getListaDeContasCorrente() {
        return listaDeContasCorrente;
    }

    public void setListaDeContasCorrente(List<ContaCorrente> listaDeContasCorrente) {
        this.listaDeContasCorrente = listaDeContasCorrente;
    }
}
