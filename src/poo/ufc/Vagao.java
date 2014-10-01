package poo.ufc;

import java.util.ArrayList;
import java.util.List;

import ufc.poo.engine.drawable.BugImage;

public class Vagao {
	private int capacidade;
	private List<Passageiro> passageiros;
	private BugImage imagem;
	
	public Vagao(int capacidade) {
		this.capacidade = capacidade;
		this.passageiros = new ArrayList<Passageiro>();
		this.setImagem(new BugImage("/imagens/vagao"+ String.valueOf(this.passageiros.size()) +".png", 0 , 0, Macros.DIMENCOES_TREM.x, Macros.DIMENCOES_TREM.y));
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public List<Passageiro> getPassageiros() {
		return passageiros;
	}
	public void setPassageiros(List<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}
	public int espacoLivre(){
		return capacidade - this.passageiros.size();
	}
	public int numeroPassageiros(){
		return this.passageiros.size();
	} 
	public boolean embarcar(Passageiro passageiro){
		if(this.capacidade == numeroPassageiros()){
			return false;
		}else{
			this.passageiros.add(passageiro);
			return true;
		}
	}
	public boolean desembarcar(long cpf){
		System.out.println("Passageiro Desenbarcado com Sucessor");
		return this.passageiros.remove(new Passageiro(" ", cpf));
	}
	public Passageiro buscar(long cpf){
		Passageiro passageiro = new Passageiro(" ", cpf);
		for (Passageiro p : this.passageiros) {
			if(p == passageiro){
				return p;
			}
		}
		return null;
	}
	@Override
	public String toString() {
		return "Capacidade:" + this.capacidade + "\n";
	}
	public BugImage getImagem() {
		return this.imagem;
	}
	public void setImagem(BugImage imagem) {
		this.imagem = imagem;
	}
	public void update(int x, int y){
		this.setImagem(new BugImage("/imagens/vagao"+ String.valueOf(this.passageiros.size()) +".png", x , y, Macros.DIMENCOES_TREM.x, Macros.DIMENCOES_TREM.y));
	}
}
