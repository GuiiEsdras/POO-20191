package br.com.guilherme.cli.exceptions;

public class EntradaInválidaException extends RuntimeException {
    public EntradaInválidaException() {
        this("Erro! Entrada inválida!");
    }

    public EntradaInválidaException(String messagem) {
        super(messagem);
    }
}
