package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {
		//Declaração Scanner
		//Scanner leia = new Scanner(System.in);
		//Declaração da variavel de leitura do Menu que será escolhida pelo usuário
		int opcao;
		
		criarContasTeste();
		

		
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
		
		try {
		opcao = leia.nextInt();
		leia.nextLine();
		} catch(InputMismatchException e) {
			opcao = -1;
			System.out.println("Digite um número inteiro entre 0 e 8");
			leia.nextLine();
		}
		
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
			cadastrarConta();
			keyPress();
			break;
		case 2:
			System.out.println(Cores.TEXT_WHITE + "Listar Todas as Contas");
			listarContas();
			keyPress();
			break;
		case 3:
			System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta");
			procurarContaPorNumero();
			
			keyPress();
			break;
		case 4:
			System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta");
			atualizarConta();
			keyPress();
			break;
		case 5:
			System.out.println(Cores.TEXT_WHITE + "Apagar Conta");
			deletarConta();
			
			keyPress();
			break;
		case 6:
			System.out.println(Cores.TEXT_WHITE + "Sacar");
			keyPress();
			break;
		case 7:
			System.out.println(Cores.TEXT_WHITE + "Depositar");
			keyPress();
			break;
		case 8:
			System.out.println(Cores.TEXT_WHITE + "Transferir Valores");
			keyPress();
			break;
		default:
			System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida" + Cores.TEXT_RESET);
			keyPress();
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

	public static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
	contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10)); 

	}
	
	public static void listarContas() {
		contaController.listarTodas();
	}
	
	public static void cadastrarConta() {
		System.out.println("Digite o número da agência: ");
		int agencia = leia.nextInt();
		
		System.out.println("Digite o nome do titular da agência: ");
		String titular = leia.next();
		
		System.out.println("Digite o tipo da conta (1 - CC | 2 - CP): ");
		int tipo = leia.nextInt();
		
		System.out.println("Digite o saldo da conta: ");
		float saldo = leia.nextFloat();
		
		switch(tipo) {
		case 1 -> {
			System.out.println("Digite o limite da conta: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
			case 2 ->{
				System.out.println("Digite o dia de aniversário da conta: ");
				int aniversario = leia.nextInt();
				leia.nextLine();
				
				contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
			
			}
			default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválida!" + Cores.TEXT_RESET);
		}
		}
	
	
	public static void procurarContaPorNumero() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();//Faz a leitura do n da conta que queremos pesquisar
		leia.nextLine(); //Não ter problema com o keypress menu
		
		contaController.procurarPorNumero(numero);//chama metodo contracontroller
	}
	
	
	public static void deletarConta() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();//Faz a leitura do n da conta que queremos pesquisar
		leia.nextLine(); //Não ter problema com o keypress menu
		//Checa se a conta existe se sim, pergunta se quer mesmo, se não ja devovle que não existe e nem deixa chegar na controladora para no front mesmo
		
		Optional<Conta> conta = contaController.buscarNaCollection(numero);
		
		if(conta.isPresent()) {//Logica pra exclusão
			//Confirmação da exclusão
			System.out.printf("\nTem certeza que você deseja excluir a conta numero %d?(S/N)",numero);
			String confirmacao = leia.nextLine();
			if(confirmacao.equalsIgnoreCase("S"))
				contaController.deletar(numero);
			else
				System.out.println("\nA operação de exclusão cancelada. Você desistiu.");
		} else {
			System.out.printf("\nA conta número %d não foi encontrada.", numero);
		}
		
	}
	
	//Atualizar
	public static void atualizarConta() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();//Faz a leitura do n da conta que queremos pesquisar
		leia.nextLine(); //Não ter problema com o keypress menu
		Optional<Conta> conta = contaController.buscarNaCollection(numero);
		if(conta.isPresent()) {//Aqui obtem os dadso atuais da conta
			//Logica do atualizar/de alteração
			//Aqui obtem os dadso atuais da conta
			int agencia = conta.get().getAgencia();
			String titular = conta.get().getTitular();
			int tipo = conta.get().getTipo();
			float saldo = conta.get().getSaldo();
			
			//Atualiza a agencia ou mantem o valor atual
			System.out.printf("Agencia atual:  %d%nDigite o número da nova agência(Pressione Enter para manter o valor atual): ", agencia);
			String entrada = leia.nextLine();
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);
			
			//Atualiza o titular ou mantem o valor atual
			System.out.printf("Titular atual: %s%nDigite o nome do novo titular(Pressione Enter para manter o valor atual): ", titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada;
			//Tipo não muda
			
			//Atualiza o saldo ou mantem o valor atual
			System.out.printf("Saldo atual: %.2f%nDigite o novo saldo(Pressione Enter para manter o valor atual): ", saldo);
			entrada = leia.nextLine();
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada.replace(",", "."));
			
			switch(tipo) {
			case 1 ->{
				ContaCorrente contaCorrente = (ContaCorrente) conta.get();
				float limite = contaCorrente.getLimite();
				
				//Atualiza o limite ou mantem o valor atual
				System.out.printf("Limite atual: %.2f%nDigite o novo limite(Pressione Enter para manter o valor atual): ", limite);
				entrada = leia.nextLine();
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada.replace(",", "."));
		
				contaController.atualizar( new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
			
			}
			case 2 ->{
				ContaPoupanca contaPoupanca = (ContaPoupanca) conta.get();
				int aniversario = contaPoupanca.getAniversario();
				
				//Atualiza o aniversario ou mantem o valor atual
				System.out.printf("Dia do aniversario atual: %.2f%nDigite o novo dia do aniversario(Pressione Enter para manter o valor atual): ", aniversario);
				entrada = leia.nextLine();
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
		
				contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
			
			}
			default -> System.out.println(Cores.TEXT_RED + "Tipo da conta é inválido!" + Cores.TEXT_RESET);
			}
			
			
		} else {
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		}
	}
	
		
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}
		
	}

