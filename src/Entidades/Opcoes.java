package Entidades;

public class Opcoes {

	public static void MenuBanco(String[] args) {

		System.out.println(Cores.TEXT_CYAN_BOLD + Cores.ANSI_BLACK_BACKGROUND
				+ "*****************************************************");
		System.out.println("                                                     ");
		System.out.println("                   BANCO BLUEZAO                     ");
		System.out.println("                                                     ");
		System.out.println("*****************************************************");
		System.out.println("                                                     ");
		System.out.println("            1 - Criar Conta                          ");
		System.out.println("            2 - Listar todas as Contas               ");
		System.out.println("            3 - Buscar Conta por Numero              ");
		System.out.println("            4 - Atualizar Dados da Conta             ");
		System.out.println("            5 - Apagar Conta                         ");
		System.out.println("            6 - Sacar                                ");
		System.out.println("            7 - Depositar                            ");
		System.out.println("            8 - Transferir valores entre Contas      ");
		System.out.println("            9 - Sair                                 ");
		System.out.println("                                                     ");
		System.out.println("*****************************************************");
		System.out.println("Entre com a opção desejada:                          ");
		System.out.println("                                                     " + Cores.TEXT_RESET);
	}

	public static void Sobre() {
		System.out.println("************************************				 ");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("João Pedro Guimarães - joaopedro.jusus@gmail.com");
		System.out.println("https://github.com/joaopguima");

	}

}
