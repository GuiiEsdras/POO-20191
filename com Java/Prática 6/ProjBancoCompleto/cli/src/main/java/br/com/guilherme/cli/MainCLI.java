package br.com.guilherme.cli;

import br.com.guilherme.banco.*;
import br.com.guilherme.enums.*;
import br.com.guilherme.menu.*;

import java.util.Scanner;

import static java.lang.System.*;

public class MainCLI {
    public static void main(String[] args) {

        Scanner input = new Scanner(in);

        Banco banco = new Banco();
        Menu menu = new Menu();

        menu.saudações();
        banco.setBankName(MainCLI.inputString(input));

        while (true) {

            while (true) {
                menu.exibirMenuBanco(banco.getBankName());
                menu.setOpção(MainCLI.inputInt(input));

                if (menu.getOpção() < 0 || menu.getOpção() > OpçõesDoMenuBanco.values().length) {
                    out.println("Opção inválida!");
                } else {
                    break;
                }
            }

            OpçõesDoMenuBanco opçãoBanco = OpçõesDoMenuBanco.values()[menu.getOpção()];

            switch (opçãoBanco) {

                case ALTERAR_NOME_DO_BANCO:
                    out.println("Alterar dados");
                    break;

                case SAIR:
                    out.println("Saindo...");
                    exit(0);

            }
        }
    }

    private static int inputInt(Scanner input) {
        return input.nextInt();
    }

    private static String inputString(Scanner input) {
        return input.nextLine();
    }

    private static double inputDouble(Scanner input) {
        return input.nextDouble();
    }
}
