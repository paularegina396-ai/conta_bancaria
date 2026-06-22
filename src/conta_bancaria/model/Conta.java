package conta_bancaria.model;

public class Conta {
	/*Atributos da Classe*/
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	//Método Construtor - Gerar as instancias (Objetos) da classe
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {//aqui é parametro não atributo, é oq recebemos quando cosntruimos os objetos
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	public Conta() {}
	//Métodos Get (Visualizar os dados) e Set (Modificar os dados)
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	//Métodos Auxiliares
	public boolean sacar(float valor) {
		if(this.saldo < valor) {
			return false; //Não bem sucedida
		}
		this.saldo -= valor;
		return true; //Operação bem sucessida
	}
	public void depositar(float valor) {
		this.saldo += valor;
	}
	////
	public void visualizar() {
		
		String tipo = "";
		switch(this.tipo) {
		case 1:
			tipo = "Conta Corrente";
		break;
		case 2:
			tipo = "Conta Poupança";
		break;
		}
		
		System.out.println("*****************************************************");
		System.out.println("*******        DADOS DA CONTA             ***********");
		System.out.println("*****************************************************");
		System.out.printf("Número da conta: %d%n", this.numero);
		System.out.printf("Número da agencia: %d%n", this.agencia);
		System.out.printf("Tipo da conta: %s%n", tipo);
		System.out.printf("Nome do titular da conta: %s%n", this.titular);
		System.out.printf("Saldo da conta: %.2f%n", this.saldo);
	}
	
	

	
}
