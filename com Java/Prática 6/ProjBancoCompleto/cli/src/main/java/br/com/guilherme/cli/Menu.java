package br.com.guilherme.cli;

import br.com.guilherme.banco.Banco;
import br.com.guilherme.enums.*;
import br.com.guilherme.exceptions.*;

import java.util.EnumSet;
import java.util.Scanner;

import static java.lang.System.*;

public class Menu {
    private int opção;

    public int getOpção() {
        return opção;
    }

    public void setOpção(int opção) {
        if (opção > 0 && opção <= OpçõesDoMenuBanco.values().length) {
            this.opção = opção - 1;
        } else {
            throw new OpçãoInválidaException();
        }
    }

    public void saudações() {
        println("| Bem Vindo ao Projeto Banco/Conta Corrente |");
    }

    public void exibirMenuBanco(String nomeDoBanco) {
        println("--- Menu do Banco " + nomeDoBanco + " ---");
        print("  O que deseja fazer?");

        EnumSet.allOf(OpçõesDoMenuBanco.class).forEach(
                OpçõesDoMenuBanco -> out.print(
                        "\n\t " +
                                (OpçõesDoMenuBanco.ordinal() +1) +
                                ". " +
                                OpçõesDoMenuBanco.toString()
                )
        );

        print("\n\t Digite uma opção:__");
    }

    public void exibirMenuContaCorrente(int número) {
        println("--- Menu da Conta " + número + " ---");
        print("  O que deseja fazer?");

        EnumSet.allOf(OpçõesDoMenuContaCorrente.class).forEach(
                OpçõesDoMenuContaCorrente -> out.print(
                        "\n\t " +
                                (OpçõesDoMenuContaCorrente.ordinal() +1) +
                                ". " +
                                OpçõesDoMenuContaCorrente.toString()
                )
        );

        print("\n\t Digite uma opção:__");
    }

    public void alteraNomeDoBanco(Banco banco, String nome) {
        do {
            try {
                banco.setBankName( nome );
                break;
            } catch (NomeInválidoException nie) {
                print(  "O nome do banco não pode ficar em branco!\n" +
                        "Digite um nome válido: ");
            }
        } while (true);
    }

    public String lerEntrada(String msg, Scanner input) {
        print(msg);
        return input.nextLine();
    }

    public String lerEntrada(Scanner input) {
        return input.nextLine();
    }

    public void println(String msg) {
        out.println(msg);
    }

    public void print(String msg) {
        out.print(msg);
    }
}
