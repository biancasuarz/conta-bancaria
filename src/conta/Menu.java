package conta;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        while(true){

            System.out.println("******************************************************");
            System.out.println("                                                      ");
            System.out.println("                    BANCO IDEPE                       ");
            System.out.println("                                                      ");
            System.out.println("******************************************************");
            System.out.println("                                                      ");
            System.out.println("        1- Criar Conta                                ");
            System.out.println("        2- Listar Todas as Contas                     ");
            System.out.println("        3- Buscar Conta por Número                    ");
            System.out.println("        4- Atualizar Dados da Conta                   ");
            System.out.println("        5- Apagar Conta                               ");
            System.out.println("        6- Sacar                                      ");
            System.out.println("        7- Depositar                                  ");
            System.out.println("        8- Transferir Valores entre contas            ");
            System.out.println("        9- Sair                                       ");
            System.out.println("                                                      ");
            System.out.println("******************************************************");
            System.out.println("Entre com a opção desejada:                           ");
            System.out.println("                                                      ");

            opcao = sc.nextInt();

            if (opcao == 9) {
                System.out.println("\nBanco Idepe - O banco que impulsiona sonhos!");
                sobre();
                sc.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Criar Conta\n");

                    break;
                case 2:
                    System.out.println("Listar todas as Contas\n");

                    break;
                case 3:
                    System.out.println("Consultar dados da Conta - por número\n");

                    break;
                case 4:
                    System.out.println("Atualizar dados da Conta\n");

                    break;
                case 5:
                    System.out.println("Apagar a Conta\n");

                    break;
                case 6:
                    System.out.println("Saque\n");

                    break;
                case 7:
                    System.out.println("Depósito\n");

                    break;
                case 8:
                    System.out.println("Transferência entre Contas\n");

                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");
                    break;
            }
        }
    }
    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Bianca Soares ");
        System.out.println("github.com/biancasuarz");
        System.out.println("*********************************************************");
    }
}

