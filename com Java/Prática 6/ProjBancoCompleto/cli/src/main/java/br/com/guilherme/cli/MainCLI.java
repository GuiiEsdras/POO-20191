package br.com.guilherme.cli;

import br.com.guilherme.banco.*;
import br.com.guilherme.enums.*;
import br.com.guilherme.exceptions.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class MainCLI {
    public static void main(String[] args) {

        Scanner input = new Scanner(in);

        Banco banco = new Banco();
        Menu menu = new Menu();

        menu.saudações();
        menu.alteraNomeDoBanco( banco, menu.lerEntrada("Antes de prosseguir, digite o nome do banco: ", input) );

        while (true) {

            try {
                menu.exibirMenuBanco(banco.getBankName());
                menu.setOpção( Integer.parseInt( menu.lerEntrada(input) ) );

                OpçõesDoMenuBanco opçãoBanco = OpçõesDoMenuBanco.values()[menu.getOpção()];

                switch (opçãoBanco) {

                    case ALTERAR_NOME_DO_BANCO:
                        menu.alteraNomeDoBanco(banco, menu.lerEntrada("Digite o novo nome do banco: ", input));
                        break;

                    case CADASTRAR_CONTA_CORRENTE:
                        // ...
                        break;

                    case EDITAR_CONTA_CORRENTE:
                        // ...
                        break;

                    case REALIZAR_OPERACOES_EM_CONTA_CORRENTE:

                        int número = Integer.parseInt( menu.lerEntrada("Digite o número da conta: ", input) );
                        if (!banco.existeConta(número)) {
                            menu.println("Conta não encontrada!");
                            break;
                        }

                        boolean sairDoMenuContaCorrente = false;

                        while (!sairDoMenuContaCorrente) {

                            try {
                                menu.exibirMenuContaCorrente(número);
                                menu.setOpção( Integer.parseInt( menu.lerEntrada(input) ) );

                                OpçõesDoMenuContaCorrente opçãoContaCorrente = OpçõesDoMenuContaCorrente.values()[menu.getOpção()];

                                switch (opçãoContaCorrente) {

                                    case SAQUE:
                                        // ...
                                        break;

                                    case DEPOSITO:
                                        // ...
                                        break;

                                    case SALDO:
                                        // ...
                                        break;

                                    case EXTRATO:
                                        // ...
                                        break;

                                    case VOLTAR:
                                        sairDoMenuContaCorrente = true;
                                        break;

                                    case SAIR:
                                        SAIR();
                                }

                            } catch (OpçãoInválidaException oie) {
                                menu.println("Opção inválida! Tente de novo.");
                            }
                        }

                        break;

                    case EXIBIR_CONTAS_CADASTRADAS:
                        // ...
                        break;

                    case EXIBIR_DADOS_BANCO:
                        // ...
                        break;

                    case EXIBIR_DADOS_CONTA:
                        // ...
                        break;

                    case SAIR:
                        SAIR();
                }

            } catch (OpçãoInválidaException oie) {
                menu.println("Opção inválida! Tente de novo.");

            } catch (InputMismatchException ime) {
                menu.println("...");
            }

        }
    }

    private static void SAIR() {
        out.println("Saindo do programa. Volte sempre!");
        exit(0);
    }
}
