package br.com.guilherme;

public class Cartao {
    public String msg() {
        return "Cartão Genérico";
    }

    public void enviar() {
        System.out.println(this.msg());
    }
}
