package br.com.guilherme.cli;

import br.com.guilherme.banco.*;
import br.com.guilherme.contacorrente.ContaCorrente;
import br.com.guilherme.enums.*;
import br.com.guilherme.exceptions.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class MainCLI {
    public static void main(String[] args) {

        // Objetos principais
        Banco banco = new Banco();
        Menu menu = new Menu();

        // Variáveis auxiliares - Banco
        String nomeDoBanco;

        // Variáveis auxiliares - ContaCorrente
        String titular;
        String senha;
        double saldoInicial;

        // Variáveis auxiliares - Menu
        int op;

        menu.saudações();

        boolean primeiraVisita = true;
        while (true) {

            try (Scanner input = new Scanner(in)) {

                if (primeiraVisita) {
                    nomeDoBanco = menu.lerEntrada("Antes de prosseguir, digite o nome do banco: ", input);
                    banco.setBankName(nomeDoBanco);
                    primeiraVisita = false;
                }

                menu.exibirMenuBanco( banco.getBankName() );

                op = Integer.parseInt( menu.lerEntrada("\n\t Digite uma opção: ", input) );

                menu.setOpção( op );

                OpçõesDoMenuBanco opçãoBanco = OpçõesDoMenuBanco.values()[menu.getOpção()];

                switch (opçãoBanco) {

                    case ALTERAR_NOME_DO_BANCO:
                        nomeDoBanco = menu.lerEntrada("Digite o novo nome do banco: ", input);
                        banco.setBankName(nomeDoBanco);
                        break;

                    case CADASTRAR_CONTA_CORRENTE:
                        titular = menu.lerEntrada("Digite o nome do titular: ", input);
                        senha = menu.lerEntrada("Digite a senha: ", input);
                        saldoInicial = Double.parseDouble(menu.lerEntrada("Digite o depósito inicial: R$", input));

                        if (banco.adicionaConta(new ContaCorrente(titular, senha, saldoInicial))) {
                            menu.println("Conta criada com sucesso!");
                        }

                        break;

                    case EDITAR_CONTA_CORRENTE:
                        // ...
                        break;

                    case REALIZAR_OPERACOES_EM_CONTA_CORRENTE:

                        int número = Integer.parseInt(menu.lerEntrada("Digite o número da conta: ", input));
                        if (!banco.existeConta(número)) {
                            menu.println("Conta não encontrada!");
                            break;
                        }

                        boolean sairDoMenuContaCorrente = false;

                        while (!sairDoMenuContaCorrente) {

                            try {
                                menu.exibirMenuContaCorrente(número);
                                menu.setOpção(Integer.parseInt(menu.lerEntrada(input)));

                                OpçõesDoMenuContaCorrente opçãoContaCorrente = OpçõesDoMenuContaCorrente.values()[menu.getOpção()];

                                switch (opçãoContaCorrente) {

                                    case SAQUE:
                                        menu.println("Realizando saque...");
                                        break;

                                    case DEPOSITO:
                                        menu.println("Realizando depósito...");
                                        break;

                                    case SALDO:
                                        menu.println("Verificando saldo...");
                                        break;

                                    case EXTRATO:
                                        menu.println("Verificando extrato...");
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
                        if (banco.quantidadeDeContas() > 0) {
                            banco.getListaDeContasCorrente().forEach(out::println);
                        } else {
                            menu.println("Ainda não existem contas cadastradas no banco!");
                        }
                        break;

                    case EXIBIR_DADOS_BANCO:
                        menu.println("Nome do Banco: " + banco.getBankName());
                        menu.println("Quantidade de Contas Cadastradas: " + banco.quantidadeDeContas());
                        break;

                    case EXIBIR_DADOS_CONTA:
                        menu.println("Exibindo dados...");
                        break;

                    case SAIR:
                        SAIR();
                }

            } catch (OpçãoInválidaException oie) {
                err.println("Opção inválida! Tente de novo.");

            } catch (InputMismatchException ime) {
                err.println("...");

            } catch (NomeInválidoException nie) {
                err.println("O nome do banco não pode ficar em branco!");

            } catch (NumberFormatException nfe) {
                err.println("Você deve digitar apenas números!");

            }

        }
    }

    private static void SAIR() {
        out.println("Saindo do programa. Volte sempre!");
        exit(0);
    }
}
