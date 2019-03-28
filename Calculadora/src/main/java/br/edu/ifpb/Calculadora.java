package br.edu.ifpb;

public class Calculadora
{
    public String descricao;
    double memoria;

    public double somar(double umNumero, double outroNumero) {
        return umNumero + outroNumero;
    }

    public double subtrair(double umNumero, double outroNumero) {
        return umNumero - outroNumero;
    }

    public double multiplicar(double umNumero, double outroNumero) {
        return umNumero * outroNumero;
    }

    public double dividir(double umNumero, double outroNumero) {
        return umNumero / outroNumero;
    }

    public void gravarMemoria(double umNumero) {
        this.memoria = umNumero;
    }

    public double lerMemoria() {
        return this.memoria;
    }

    public void alterarDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String consultarDescricao() {
        return this.descricao;
    }
}
