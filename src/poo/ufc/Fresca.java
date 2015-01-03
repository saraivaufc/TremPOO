package poo.ufc;

public class Fresca extends Pessoa {
	private int frescura;
	public Fresca(String nome, long cpf) {
		super(nome, cpf);
		// TODO Auto-generated constructor stub
	}
	public Fresca(String nome, long cpf, int frescura) {
		this(nome, cpf);
		this.setFrescura(frescura);
	}
	public int getFrescura() {
		return frescura;
	}
	public void setFrescura(int frescura) {
		if(frescura < 0){
			frescura = 0;
		}else{
		this.frescura = frescura;
		}
	}
	
}
