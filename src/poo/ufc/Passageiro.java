package poo.ufc;

public class Passageiro {
	private String nome;
	private long cpf;

	public Passageiro(String nome, long cpf){
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

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public boolean equals(Object obj) {
		return this.cpf == ((Passageiro) obj).getCpf();
	}
	@Override
	public String toString() {
		return "Nome:" + this.nome + ". CPF:" + this.cpf + "\n";
	}

}
