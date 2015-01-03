package poo.ufc;

import ufc.poo.engine.drawable.BugImage;


public class VagaoAnimal extends Vagao {
	public VagaoAnimal(int capacidade) {
		super(capacidade);
		this.setImagem(new BugImage("/imagens/VagaoAnimal/vagao"+ this.numeroPassageiros() +".png", 0 , 0, Macros.DIMENCOES_TREM.x, Macros.DIMENCOES_TREM.y));
	}
	public int espacoLivre() {
		int peso = 0;
		for (Passageiro p : passageiros) {
			peso += ((Animal)p).getPeso();
		}
		return capacidade - peso;
	}
	@Override
	public boolean embarcar(Passageiro passageiro) {
		if(espacoLivre() > ((Animal)passageiro).getPeso()){
			this.passageiros.add(passageiro);
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean desembarcar(long id) {
		System.out.println("Animal Desembarcado com Sucesso!!!");
		return passageiros.remove(new Animal(id, " ",0));
	}
	@Override
	public void update(int x, int y) {
		this.setImagem(new BugImage("/imagens/VagaoAnimal/vagao"+ this.numeroPassageiros() +".png", x , y, Macros.DIMENCOES_TREM.x, Macros.DIMENCOES_TREM.y));
	}
}
