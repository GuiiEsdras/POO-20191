package br.com.guilherme.conta.exceptions;

public class QuantiaNegativaException extends RuntimeException {
    public QuantiaNegativaException() {
        this("Erro! Quantia negativa!");
    }

    public QuantiaNegativaException(String messagem) {
        super(messagem);
    }
}
