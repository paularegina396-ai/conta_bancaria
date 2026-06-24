package conta_bancaria.model;

//1. 'extends Conta' define o relacionamento de Herança (ContaPoupanca "é uma" Conta)
public class ContaPoupanca extends Conta {
	// Atributo específico privado da poupança
	private int aniversario;
	
	// Construtor da subclasse
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		// O 'super(...)' envia os dados básicos para o construtor da classe mãe organizar
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario; // O 'this' aponta para o atributo desta classe
		
		}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	// Polimorfismo de Sobrescrita: modificando o visualizar para incluir o aniversário
	//conceito é Polimorfismo de Sobrescrita. "Polimorfismo" significa muitas formas. 
	//Ou seja, o método visualizar() passa a ter duas formas diferentes: 
	//--a forma da classe mãe (Conta) 
	//--e a forma modificada da classe filha (ContaCorrente).
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversário da conta: "+ this.aniversario);
	}
	

}
