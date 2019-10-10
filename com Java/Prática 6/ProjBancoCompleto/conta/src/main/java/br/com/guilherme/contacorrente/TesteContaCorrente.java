package br.com.guilherme.contacorrente;

import static java.lang.System.*;

public class TesteContaCorrente {
    public static void main(String[] args) {

        ContaCorrente c1 = new ContaCorrente();
        c1.setNúmero( 1 );
        c1.setTitular("Exemplo Um");
        c1.setSaldo(500);
        out.println(c1);

        out.println("-----");

        ContaCorrente c2 = new ContaCorrente(2, "Exemplo Dois", 500);
        out.println(c2);
        c2.depositar(500);
        out.println(c2);
        out.println("Valor sacado: " + c2.sacar(500));
        out.println(c2);

    }
}
