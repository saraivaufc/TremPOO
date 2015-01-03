package poo.ufc;

import ufc.poo.engine.drawable.BugImage;

public class VagaoPessoa extends Vagao{
	
	public VagaoPessoa(int capacidade) {
		super(capacidade);
		this.setImagem(new BugImage("/imagens/VagaoPessoa/vagao"+ this.numeroPassageiros() +".png", 0 , 0, Macros.DIMENCOES_TREM.x, Macros.DIMENCOES_TREM.y));
	}

	@Override
	public int espacoLivre() {
		return capacidade - this.passageiros.size();
	}

	@Override
	public boolean embarcar(Passageiro passageiro) {
		if(espacoLivre() > 0){
			this.passageiros.add(passageiro);
			return true;
		}else{
			return false;
		}
	}
	@Override
	public String toString() {
		String info = new String();
		for (Passageiro passageiro : passageiros) {
			info += passageiro.toString();
		}
		return info;
	}

	@Override
	public boolean desembarcar(long id) {
		System.out.println("Pessoa desembarcada com sucesso!!!");
		return passageiros.remove(new Pessoa(null, id));
	}

	@Override
	public void update(int x, int y) {
		this.setImagem(new BugImage("/imagens/VagaoPessoa/vagao"+ this.numeroPassageiros() +".png", x , y, Macros.DIMENCOES_TREM.x, Macros.DIMENCOES_TREM.y));
	}
}
