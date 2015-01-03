package poo.ufc;

public class Pessoa implements Passageiro{
	private String nome;
	private long cpf;

	public Pessoa(String nome, long cpf){
		this.nome = nome;
		this.cpf = cpf;
		return;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean equals(Object obj) {
		return ((Pessoa)obj).getID() == this.getID();
	}
	
	@Override
	public String toString() {
		return "Nome:" + this.nome + ". CPF:" + this.cpf + "\n";
	}
	@Override
	public long getID() {
		return this.cpf;
	}

}
