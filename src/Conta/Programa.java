package Conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import Controller.ContaController;
import Entidades.Cores;
import Entidades.Opcoes;
import Entidades.Conta;
import Entidades.ContaCorrente;
import Entidades.ContaPoupanca;

public class Programa extends Opcoes {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Marina dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		while (true) {
			MenuBanco(args);

			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				sc.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil - O Seu futuro começa aqui!\n");
				Sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

				System.out.printf("Digite o Numero da Agência: ");
				agencia = sc.nextInt();
				System.out.printf("Digite o Nome do Titular: ");
				sc.skip("\\R?");
				titular = sc.nextLine();

				do {
					System.out.printf("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = sc.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.printf("Digite o Saldo da Conta (R$): ");
				saldo = sc.nextFloat();

				switch (tipo) {
					case 1 -> {
						System.out.printf("Digite o Limite de Crédito (R$): ");
						limite = sc.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.printf("Digite o dia do Aniversário da Conta: ");
						aniversario = sc.nextInt();
						contas.cadastrar(
								new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");
				
				System.out.printf("Digite o número da conta: ");
				numero = sc.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
					
					System.out.printf("Digite o Numero da Agência: ");
					agencia = sc.nextInt();
					System.out.printf("Digite o Nome do Titular: ");
					sc.skip("\\R?");
					titular = sc.nextLine();
					
					System.out.printf("Digite o Saldo da Conta (R$): ");
					saldo = sc.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.printf("Digite o Limite de Crédito (R$): ");
							limite = sc.nextFloat();
							
							contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.printf("Digite o dia do Aniversario da Conta: ");
							aniversario = sc.nextInt();
							
							contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						}
						default -> {
							System.out.println("Tipo de conta inválido! ");
						}
					}
				} else {
					System.out.println("A Conta não foi encontrada!");
				}
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");
				
				System.out.printf("Digite o número da conta: ");
				numero = sc.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");
				
				System.out.printf("Digite o número da conta: ");
				numero = sc.nextInt();
				
				do {
					System.out.printf("Digite o Valor do Saque (R$): ");
					valor = sc.nextFloat();
				} while(valor <= 0);
				
				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");
				
				System.out.printf("Digite o número da conta: ");
				numero = sc.nextInt();
				
				do {
					System.out.printf("Digite o Valor do Depósito (R$): ");
					valor = sc.nextFloat();
				} while (valor <= 0);
				
				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");
				
				System.out.printf("Digite o Número da Conta de Origem: ");
				numero = sc.nextInt();
				System.out.printf("Digite o Número da Conta de Destino: ");
				numeroDestino = sc.nextInt();
				
				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = sc.nextFloat();					
				} while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida\n");
				keyPress();
				break;
			}
		}
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
