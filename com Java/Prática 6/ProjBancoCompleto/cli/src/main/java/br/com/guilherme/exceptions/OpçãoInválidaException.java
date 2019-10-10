package br.com.guilherme.exceptions;

public class OpçãoInválidaException extends RuntimeException {
    public OpçãoInválidaException() {
        this("Erro! Opção inválida!");
    }

    public OpçãoInválidaException(String messagem) {
        super(messagem);
    }
}
