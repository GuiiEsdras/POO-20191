package br.com.guilherme.conta.exceptions;

public class CPFInvalidoException extends RuntimeException {
    public CPFInvalidoException() {
        this("Erro! CPF inválido!");
    }

    public CPFInvalidoException(String messagem) {
        super(messagem);
    }
}
