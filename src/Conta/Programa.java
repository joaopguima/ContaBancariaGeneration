package Conta;

import java.util.Locale;
import java.util.Scanner;
import Entidades.Cores;
import Entidades.Opcoes;
import Entidades.Conta;

public class Programa extends Opcoes {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Conta c1 = new Conta(1, 123, 1, "Joao", 10000.0f);
		c1.visualizar();
		c1.sacar(120000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
		
		int opcao;

		while (true) {
			MenuBanco(args);

			opcao = sc.nextInt();

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil - O Seu futuro começa aqui!\n");
				Sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as contas\n\n");

				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida\n");
				break;
			}
		}
	}

}
