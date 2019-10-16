package br.com.guilherme.exceptions;

public class CPFInvalidoException extends RuntimeException {
    public CPFInvalidoException() {
        this("Erro! CPF inválido!");
    }

    public CPFInvalidoException(String messagem) {
        super(messagem);
    }
}
