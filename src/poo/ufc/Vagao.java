package poo.ufc;

import java.util.ArrayList;
import java.util.List;

import ufc.poo.engine.drawable.BugImage;

public abstract class Vagao {
	protected int capacidade;
	protected List<Passageiro> passageiros;
	private BugImage imagem;
	
	public Vagao(int capacidade) {
		this.capacidade = capacidade;
		this.passageiros = new ArrayList<Passageiro>();
	}
	public int getCapacidade() {
		return capacidade;
	}
	public List<Passageiro> getPassageiros() {
		return passageiros;
	}
	
	public int numeroPassageiros(){
		return this.passageiros.size();
	}
	
	public Passageiro buscar(long id){
		for (Passageiro p : this.passageiros) {
			if(p.getID() == id){
				return p;
			}
		}
		return null;
	}
	public BugImage getImagem() {
		return this.imagem;
	}
	public void setImagem(BugImage imagem) {
		this.imagem = imagem;
	}
	
	public abstract void update(int x, int y);
	
	public abstract int espacoLivre();
	
	public abstract boolean embarcar(Passageiro passageiro);
	
	public abstract boolean desembarcar(long id);
	
}
