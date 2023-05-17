
package com.mycompany.gerenciabanco;

/**
 *
 * @author CLEITON
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class GerenciaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 0.0;

        System.out.println("Bem-vindo à aplicação de gerenciamento bancário!");

        System.out.print("\nDigite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        // Verifica se todos os campos foram preenchidos
        if (nome.isEmpty() || sobrenome.isEmpty() || cpf.isEmpty()) {
            System.out.println("É obrigatório informar nome, sobrenome e CPF.");
            System.exit(0);
        }

        System.out.println("\nUsuário: " + nome + " " + sobrenome);
        System.out.println("CPF: " + cpf);

        // Arredonda o valor para que o saldo seja exibido com apenas 2 casas decimais 
        DecimalFormat df = new DecimalFormat("#.##");

        while (true) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Encerrar o uso da aplicação");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo atual: R$" + df.format(saldo));
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: R$");
                    double valorDeposito = scanner.nextDouble();
                    saldo += valorDeposito;
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: R$");
                    double valorSaque = scanner.nextDouble();
                    if (valorSaque <= saldo) {
                        saldo -= valorSaque;
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para o saque.");
                    }
                    break;
                case 4:
                    System.out.println("Obrigado por utilizar a aplicação de gerenciamento bancário!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
            }
        }
    }
}