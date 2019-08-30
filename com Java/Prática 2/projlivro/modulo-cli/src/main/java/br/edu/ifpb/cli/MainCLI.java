package br.edu.ifpb.cli;

import br.edu.ifpb.livro.Categoria;
import br.edu.ifpb.livro.Livro;
import br.edu.ifpb.services.CatalogoLivros;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.Scanner;

public class MainCLI {
    public static void main(String[] args) {

        System.out.println(MainCLI.Welcome());

        CatalogoLivros myBookCase = new CatalogoLivros();

        if (myBookCase.catalogoVazio()) {
            System.out.println("Seu catálogo ainda está vazio, adicione livros!");
        }

        int op;
        System.out.print(MainCLI.MenuTitle());
        while (true) {
            System.out.print(MainCLI.Menu());
            op = capturaInteiro();
            if (op < 1 || op > 4) {
                System.out.println("---\n Opção inválida! Tente novamente \n---");
            } else {
                switch (op) {
                    case 1:
                        System.out.print("Digite o título do livro: ");
                        String título = capturaString();

                        System.out.print("Digite o autor do livro: ");
                        String autor = capturaString();

                        System.out.println("Estes são os gêneros disponíveis: ");
                        for (Categoria cat : EnumSet.allOf(Categoria.class)) {
                            System.out.println("-" + cat);
                        }
                        System.out.print("Digite o gênero do livro: ");
                        String gênero = capturaString();

                        System.out.print("Digite o preço do livro: ");
                        double preço = capturaDouble();

                        if (myBookCase.adicionarLivro(título, autor, Categoria.valueOf(gênero.toUpperCase()), preço, new Date())) {
                            System.out.println("Livro adicionado ao catálogo com sucesso!");
                        } else {
                            System.out.println("Houve um erro ._.");
                        }
                        break;

                    case 2:
                        System.out.print("Digite o título do livro à buscar: ");
                        String buscaTítulo = capturaString();
                        int codBuscado = myBookCase.pesquisarLivroPorTítulo(buscaTítulo);
                        if (codBuscado > 0) {
                            System.out.println("Livro encontrado! Dados:");
                            for (Livro livro : myBookCase.getListaDeLivros()) {
                                if (livro.getCódigo() == codBuscado) {
                                    System.out.println(livro);
                                }
                            }
                        } else {
                            System.out.println("Livro não encontrado! ._.");
                        }
                        break;

                    case 3:
                        System.out.print("Digite o título do livro à remover: ");
                        String títuloARemover = capturaString();
                        if (myBookCase.removerLivroPorTítulo(títuloARemover)) {
                            System.out.println("Livro removido com sucesso!");
                        } else {
                            System.out.println("Livro não encontrado!");
                        }
                        break;

                    case 4:
                        System.out.println(myBookCase.listarLivros());
                        break;

                    case 5:
                        System.out.println("Obrigado! =) Volte sempre o/");
                        System.exit(0);
                }
            }
        }

    }

    private static String Welcome() {

        int aux = 5;
        String welcome = String.format("%s Bem Vindo ao My BookCase!!! %s", "-".repeat(aux), "-".repeat(aux));

        StringBuilder strFinal = new StringBuilder();
        strFinal.append("-".repeat(welcome.length()) + "\n")
                .append(welcome + "\n")
                .append("-".repeat(welcome.length()) + "\n");

        return strFinal.toString();
    }

    private static String MenuTitle() {

        int aux = 12;
        String header = String.format("%s Menu %s", "-".repeat(aux), "-".repeat(aux));
        StringBuilder título = new StringBuilder();

        título.append("\n")
                .append("-".repeat(header.length()) + "\n")
                .append(header + "\n")
                .append("-".repeat(header.length()) + "\n");

        return título.toString();
    }

    private static String Menu() {

        StringBuilder menu = new StringBuilder();

        menu.append("- 1. Adicionar Livro \n")
            .append("- 2. Buscar Livro (Por Título) \n")
            .append("- 3. Remover Livro (Por Título) \n")
            .append("- 4. Listar Livros \n")
            .append("- 5. Sair \n")
            .append("  Digite sua opção: ");

        return menu.toString();
    }

    private static int capturaInteiro() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static double capturaDouble() {
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    public static String capturaString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

}
