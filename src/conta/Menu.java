package conta;

import conta.controller.ContaController;
import conta.util.Cores;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        ContaController contas = new ContaController();

        System.out.println("\nCriar Contas\n");

        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Igreja Jardim", 1000f, 100.0f);
        contas.cadastrar(cc1);

        ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 111, 1, "Bianca Soares", 2000f, 100.0f);
        contas.cadastrar(cc2);

        ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 222, 2, "Alanis Soares", 4000f, 12);
        contas.cadastrar(cp1);

        ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 333, 2, "Astrid Soares", 8000f, 15);
        contas.cadastrar(cp2);

        contas.listarTodas();

        Scanner sc = new Scanner(System.in);
        int opcao, numero, agencia, tipo, aniversario, numeroDestino;
        String titular;
        float saldo = 0;
        float limite, valor;

        while (true) {

            System.out.println(Cores.TEXT_GREEN
                    + "******************************************************");
            System.out.println("                                                      ");
            System.out.println("                    BANCO IDEPE                       ");
            System.out.println("                                                      ");
            System.out.println("******************************************************");
            System.out.println("                                                      ");
            System.out.println(Cores.TEXT_WHITE_BOLD +
                    "        1- Criar Conta                                ");
            System.out.println("        2- Listar Todas as Contas                     ");
            System.out.println("        3- Buscar Conta por Número                    ");
            System.out.println("        4- Atualizar Dados da Conta                   ");
            System.out.println("        5- Apagar Conta                               ");
            System.out.println("        6- Sacar                                      ");
            System.out.println("        7- Depositar                                  ");
            System.out.println("        8- Transferir Valores entre contas            ");
            System.out.println("        9- Sair                                       "
                    + Cores.TEXT_RESET);
            System.out.println("                                                      ");
            System.out.println(Cores.TEXT_GREEN +
                    "******************************************************");
            System.out.println(Cores.TEXT_WHITE_BOLD +
                    "Entre com a opção desejada:                           ");
            System.out.println("                                                      "
                    + Cores.TEXT_RESET);

            opcao = sc.nextInt();

            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros!");
                sc.nextLine();
                opcao = 0;
            }

            if (opcao == 9) {
                System.out.println("\nBanco Idepe - O banco que impulsiona sonhos!");
                sobre();
                sc.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Criar Conta\n");

                    System.out.println("Digite o Número da Agência: ");
                    agencia = sc.nextInt();
                    System.out.println("Digite o Nome do Titular: ");
                    sc.skip("\\R?");
                    titular = sc.nextLine();

                    do {
                        System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
                        tipo = sc.nextInt();
                    }while (tipo < 1 && tipo > 2);

                    System.out.println("Digite o Saldo da Conta (R$): ");
                    limite = sc.nextFloat();

                    switch (tipo) {
                        case 1 -> {
                            System.out.println("Digite o Limite de Crédito (R$): ");
                            limite = sc.nextFloat();
                            contas.cadastrar(new ContaCorrente(contas.gerarNumero(),
                                    agencia,
                                    tipo,
                                    titular,
                                    saldo,
                                    limite));
                        }
                        case 2 -> {
                            System.out.println("Digite o dia do Aniversário da Conta: ");
                            aniversario = sc.nextInt();
                            contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),
                                    agencia,
                                    tipo,
                                    titular,
                                    saldo,
                                    (int) limite));
                        }
                    }

                    keyPress();
                    break;
                case 2:
                    System.out.println("Listar todas as Contas\n");
                    contas.listarTodas();
                    keyPress();
                    break;
                case 3:
                    System.out.println("Consultar dados da Conta - por número\n");
                    System.out.println("Digite o Número da Conta: ");
                    numero = sc.nextInt();
                    contas.procurarPorNumero(numero);

                    keyPress();
                    break;
                case 4:
                    System.out.println("Atualizar dados da Conta\n");

                    System.out.println("Digite o número da conta: ");
                    numero = sc.nextInt();

                    var buscaConta = contas.buscarNaCollection(numero);

                    if (buscaConta != null) {

                        System.out.println("Digite o Numero da Agência: ");
                        agencia = sc.nextInt();
                        System.out.println("Digite o Nome do Titular: ");
                        sc.skip("\\R?");
                        titular = sc.nextLine();

                        System.out.println("Digite o Saldo da Conta (R$): ");
                        saldo = sc.nextFloat();

                        tipo = buscaConta.getTipo();

                        switch (tipo) {
                            case 1 -> {
                                System.out.println("Digite o Limite de Crédito (R$): ");
                                limite = sc.nextFloat();
                                contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
                            }
                            case 2 -> {
                                System.out.println("Digite o dia do Aniversario da Conta: ");
                                aniversario = sc.nextInt();
                                contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
                            }
                            default -> {
                                System.out.println("Tipo de conta inválido!");
                            }
                        }

                    } else
                        System.out.println("\nConta não encontrada!");

                    keyPress();
                    break;
                case 5:
                    System.out.println("Apagar a Conta\n");
                    System.out.println("Digite o Número da Conta: ");
                    numero = sc.nextInt();
                    contas.deletar(numero);

                    keyPress();
                    break;
                case 6:
                    System.out.println("Saque\n");
                    System.out.println("Digite o Número da Conta: ");
                    numero = sc.nextInt();
                    do {
                        System.out.println("Digite o Valor do Saque(R$): ");
                        valor = sc.nextFloat();
                    }while (valor <= 0);
                    contas.sacar(numero, valor);

                    keyPress();
                    break;
                case 7:
                    System.out.println("Depósito\n");
                    System.out.println("Digite o Numero da conta: ");
                    numero = sc.nextInt();

                    do {
                        System.out.println("Digite o Valor do Depósito (R$): ");
                        valor = sc.nextFloat();
                    } while (valor <= 0);

                    contas.depositar(numero, valor);

                    keyPress();
                    break;
                case 8:
                    System.out.println("Transferência entre Contas\n");
                    System.out.println("Digite o Numero da Conta de Origem: ");
                    numero = sc.nextInt();
                    System.out.println("Digite o Numero da Conta de Destino: ");
                    numeroDestino = sc.nextInt();

                    do {
                        System.out.println("Digite o Valor da Transferência (R$): ");
                        valor = sc.nextFloat();
                    } while (valor <= 0);

                    contas.transferir(numero, numeroDestino, valor);

                    keyPress();
                    break;
                default:
                    System.out.println("\nOpção Inválida!\n");

                    keyPress();
                    break;

            }
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto Desenvolvido por: Bianca Soares ");
        System.out.println("Contato: blancasuarz@gmail.com");
        System.out.println("github.com/biancasuarz");
        System.out.println("*********************************************************");
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {

            System.out.println("Você pressionou uma tecla diferente de enter!");
        }
    }
}