package conta_bancaria.repository;

public interface ContaRepository {
	
	//CRUD
	public void listarTodas();
	public void cadastrar();
	public void procurarPorNumero();
	public void atualizar();
	public void deletar();
	
	public void sacar();
	public void depositar();
	public void transferir();
	

}
