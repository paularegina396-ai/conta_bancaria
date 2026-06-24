package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		//Declaração Scanner
		Scanner leia = new Scanner(System.in);
		//Declaração da variavel de leitura do Menu que será escolhida pelo usuário
		int opcao;
		
		/*Instanciar Objetos da Classe Conta*/
		/*Conta c1 = new Conta(1, 123, 1, "Isabella", 200000.00f);
		c1.visualizar();
		
		Conta c2 = new Conta(2, 123, 2, "Thiago", 100000.00f);
		c2.visualizar();
		
		//Alteração saldo
		c1.setSaldo(300000.00f);
		c1.setTitular("Aisa Bruno");
		c1.visualizar();
		
		System.out.println("Sacar R$1.000,00 da conta C2:" + (c2.sacar(1000.00f) ? "Saque efetuado com sucesso" : "Saldo insuficiente" ));
		//Ele vai responder se o saque deu certo ou não
		c2.visualizar();
		
		//Deposito
		c2.depositar(50000.00f);
		c2.visualizar(); */
		
		//Instanciar objetos da Classe ContaCorrente
		//ContaCorrente cc1 = new ContaCorrente(3, 789, 1, "Raquel", 200000.00f, 2000.00f);
		//cc1.visualizar();
		
		//System.out.println("\nSacar R$ 202.000,00 da conta Cc1: " + (cc1.sacar(201000.00f) ? "Saque efetuado com sucesso! | Saldo: " + cc1.getSaldo() : "Saldo insuficiente!| Saldo: " + cc1.getSaldo()));
		
		
		
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
