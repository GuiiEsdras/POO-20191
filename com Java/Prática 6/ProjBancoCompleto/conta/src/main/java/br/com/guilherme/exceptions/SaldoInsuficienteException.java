package br.com.guilherme.exceptions;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException() {
        this("Erro! Saldo insuficiente!");
    }

    public SaldoInsuficienteException(String messagem) {
        super(messagem);
    }
}
