package br.com.guilherme.banco;

import br.com.guilherme.contacorrente.ContaCorrente;

import static java.lang.System.*;

public class TesteBanco {
    public static void main(String[] args) {

        Banco novoBanco = new Banco("Gui");

        ContaCorrente acc1 = new ContaCorrente(1, "Gui", 100);
        ContaCorrente acc2 = new ContaCorrente(2, "Esdras", 250);

        novoBanco.adicionaConta(acc1);
        novoBanco.adicionaConta(acc2);

        out.println(novoBanco);

        novoBanco.removeConta(1);

        out.println(novoBanco);

    }
}
