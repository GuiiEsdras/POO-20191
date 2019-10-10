package br.com.guilherme.exceptions;

public class NomeDeTitularInválidoException extends RuntimeException {
    public NomeDeTitularInválidoException() {
        this("Erro! O nome de titular é inválido!");
    }

    public NomeDeTitularInválidoException(String msg) {
        super(msg);
    }
}
