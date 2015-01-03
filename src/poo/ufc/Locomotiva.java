package poo.ufc;

import java.awt.Point;

import ufc.poo.engine.drawable.BugImage;

public class Locomotiva {
	private int limiteVagoes;
	private float velocidade;
	private BugImage imagem;
	
	public Locomotiva(){
		
	}
	
	public Locomotiva(int limiteVagoes, BugImage imagem) {
		this.setLimiteVagoes(limiteVagoes);
		this.setImagem(imagem);
		this.velocidade = 0;
	}
	public void acelerar(){
		this.velocidade +=5;
	}
	public void desacelerar(){
		this.velocidade -=5;
		if(this.velocidade < 0){
			this.velocidade = 0;
		}
	}
	public int getLimiteVagoes() {
		return limiteVagoes;
	}
	public void setLimiteVagoes(int limiteVagoes) {
		this.limiteVagoes = limiteVagoes;
	}
	public void parar(){
		this.velocidade = 0;
	}
	public BugImage getImagem() {
		return imagem;
	}
	public void setImagem(BugImage imagem) {
		this.imagem = imagem;
	}
	public void update(Trem t){
		this.imagem.setPos(new Point((int) (imagem.getX()- this.velocidade), this.imagem.getY()));
	}

	public float getVelocidade() {
		return velocidade;
	}
}
