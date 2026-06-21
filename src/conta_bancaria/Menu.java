package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		//Declaração Scanner
		Scanner leia = new Scanner(System.in);
		//Declaração da variavel de leitura do Menu que será escolhida pelo usuário
		int opcao;
		
		//Loop do Menu
		while (true) {
		System.out.println(Cores.TEXT_PURPLE_BOLD + Cores.ANSI_BLACK_BACKGROUND_BRIGHT +"*************************************************************");
		System.out.println("                                                             ");
		System.out.println("                   BANCO DO BRAZIL COM Z                     ");
		System.out.println("                                                             ");
		System.out.println("*************************************************************");
		System.out.println("                                                             ");
		System.out.println("                1 - Criar Conta                              ");
		System.out.println("                2 - Listar Todas as Contas                   ");
		System.out.println("                3 - Buscar Conta Por Número                  ");
		System.out.println("                4 - Atualizar Dados da Conta                 ");
		System.out.println("                5 - Apagar Conta                             ");
		System.out.println("                6 - Sacar                                    ");
		System.out.println("                7 - Depositar                                ");
		System.out.println("                8 - Transferir valores entre Contas          ");
		System.out.println("                0 - Sair                                     ");
		System.out.println("*************************************************************");
		System.out.println("Entre com a opção desejada:                                  ");
		System.out.println("                                                             " + Cores.TEXT_RESET);
		opcao = leia.nextInt();
		
		if (opcao == 0) {
			System.out.println(Cores.TEXT_WHITE_BOLD +"*************************************************************");
			System.out.println( "Banco do Brazil com Z");
			sobre();
			leia.close();
			System.exit(0);
		}
		switch (opcao) {
		case 1:
			System.out.println(Cores.TEXT_WHITE + "Criar Conta");
			break;
		case 2:
			System.out.println(Cores.TEXT_WHITE + "Listar Todas as Contas");
			break;
		case 3:
			System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta");
			break;
		case 4:
			System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta");
			break;
		case 5:
			System.out.println(Cores.TEXT_WHITE + "Apagar Conta");
			break;
		case 6:
			System.out.println(Cores.TEXT_WHITE + "Sacar");
			break;
		case 7:
			System.out.println(Cores.TEXT_WHITE + "Depositar");
			break;
		case 8:
			System.out.println(Cores.TEXT_WHITE + "Transferir Valores");
			break;
		default:
			System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida" + Cores.TEXT_RESET);
			break;
		}
		
	}
		
		
		
		
		}
	
	public static void sobre() {
		System.out.println("Projeto Desenvolvido por:");
		System.out.println("Paula Leão - paularegina396@gmail.com");
		System.out.println("https://github.com/paularegina396-ai/");
		System.out.println("*************************************************************");
	}

}
