package br.edu.ifpb;

import java.util.Scanner;

public class MenuCalculadora
{
    private Calculadora c = new Calculadora();

    public void exibirMenu() {

        while (true)
        {

            Scanner input = new Scanner( System.in );

            System.out.printf( "Calculadora \n" +
                                "================\n" +
                                "   1. Somar\n" +
                                "   2. Subtrair\n" +
                                "   3. Multiplicar\n" +
                                "   4. Dividr\n" +
                                "   5. Sobre a Calculadora\n" +
                                "   6. Sair\n" +
                                "   Digite uma opção:_");

            // ler com scanner a opção
            int opcao = input.nextInt();
            if ( opcao == 6 ) {
                // Sair
                System.out.println("Saindo.");
                break;
            } else {

                double[] numeros = capturarNumeros();

                if (opcao == 1) {
                    // Somar
                    double soma = c.somar(numeros[0], numeros[1]);
                    System.out.println("A adição de " + numeros[0] + " com " + numeros[1] + " é: " + soma);

                } else if (opcao == 2) {
                    // Subtrair
                    double subtracao = c.subtrair(numeros[0], numeros[1]);
                    System.out.println("A diferença de " + numeros[0] + " e " + numeros[1] + " é: " + subtracao);

                } else if (opcao == 3) {
                    // Multiplicar
                    double multiplicacao = c.multiplicar(numeros[0], numeros[1]);
                    System.out.println("O produto de " + numeros[0] + " por " + numeros[1] + " é: " + multiplicacao);

                } else if (opcao == 4) {
                    // Dividir
                    double divisao = c.dividir(numeros[0], numeros[1]);
                    System.out.println("A divisão de " + numeros[0] + " e " + numeros[1] + " é: " + divisao);

                } else if (opcao == 5) {
                    // Exibir descrição
                    System.out.println(c.consultarDescricao());

                }

                Boolean continua = true;

                System.out.printf(  "Deseja continuar? \n" +
                        "   1. Sim \n" +
                        "   0. Nao \n");

                while (true) {
                    int escolha = input.nextInt();
                    if ( escolha == 0 ) {
                        System.out.println("Saindo");
                        continua = false;
                        break;
                    } else if ( escolha == 1 ) {
                        System.out.println();
                        break;
                    } else {
                        System.out.println( "Escolha invalida. Escolha de novo: \n" +
                                            "   1. Sim \n" +
                                            "   0. Nao \n");
                    }
                }

                if (!continua) {
                    break;
                }
            }
        }
    }

    public double[] capturarNumeros() {
        double [] temp = new double[2];
        Scanner input = new Scanner( System.in );
        System.out.printf("Digite o primeiro número: ");
        temp[0] = input.nextInt();
        System.out.printf("Digite o segundo número: ");
        temp[1] = input.nextInt();
        return temp;
    }
}
