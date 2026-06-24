package conta_bancaria.model;

public class ContaCorrente extends Conta{

	private float limite;
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite= limite;	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	@Override
	public boolean sacar(float valor) {
		if(this.getSaldo() < valor) {
			return false; //Não bem sucedida
		}
		this.setSaldo(this.getSaldo() - valor);
		return true; //Operação bem sucessida
	}
	
	@Override
	public void visualizar() {
		super.visualizar(); // Puxa o comportamento da classe mãe
	    System.out.printf("Limite da conta: %.2f%n", this.limite); // Adiciona o limite
	}
}
