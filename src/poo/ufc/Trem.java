package poo.ufc;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import ufc.poo.engine.drawable.BugDrawable;

public class Trem implements BugDrawable {
	private Locomotiva locomotiva;
	private List<Vagao> vagoes;
	public Trem(){}
	public Trem(Locomotiva locomotiva) {
		this.setLocomotiva(locomotiva);
		setVagoes(new ArrayList<Vagao>());
	}
	public boolean adicionarVagao(Vagao vagao){
		if(this.vagoes.size() == this.locomotiva.getLimiteVagoes()){
			return false;
		}else{
			this.vagoes.add(vagao);
			return true;
		}
		
	}
	public boolean removerVagao(int index){
		if(this.vagoes.size() == 0){
			System.out.println("Falha ao remover Vagão");
			return false;
		}else{
			Vagao temp; 
			try {
				temp = this.vagoes.remove(index);
			} catch (Exception e) {
				System.out.println("Falha ao remover Vagão");
				return false;
			}
			if(temp != null){
				System.out.println("Vagão Removido com Sucesso");
				return true;
			}else{
				System.out.println("Falha ao remover Vagão");
				return false;
			}
		}
		
	}
	
	public boolean embarcar(Passageiro passageiro){
		for (Vagao v : this.getVagoes()) {
			if(v.espacoLivre() > 0){
				v.embarcar(passageiro);
				System.out.println("Passageiro embarcado com Sucesso");
				return true;
			}
		}	
		return false;
	}
	public boolean desembarcar(long cpf){
		for (Vagao v : this.getVagoes()) {
			if(v.getPassageiros().remove(new Passageiro(" ", cpf))){
				return true;
			};
		}		
		return false;
	}
	public Passageiro buscar(long cpf){
		for (Vagao v : this.getVagoes()) {
			for (Passageiro p : v.getPassageiros()) {
				if(p.equals(new Passageiro(" ", cpf))){
					return p;
				}
			}
		}
		return null;
	}
	public int numeroVagoes(){
		return this.vagoes.size();
		
	}
	public int numeroPassageiro(){
		int quantPassageiros=0;
		for (Vagao v : this.getVagoes()) {
			quantPassageiros += v.getPassageiros().size();
		}
		return quantPassageiros;
		
	}
	public void acelerar(){
		this.locomotiva.acelerar();
	}
	public void desacelerar(){
		this.locomotiva.desacelerar();
	}
	public void parar(){
		this.locomotiva.parar();
	}
	public Locomotiva getLocomotiva() {
		return locomotiva;
	}
	public void setLocomotiva(Locomotiva locomotiva) {
		this.locomotiva = locomotiva;
	}
	public List<Vagao> getVagoes() {
		return vagoes;
	}
	public List<Passageiro>  getPassageiros(){
		List<Passageiro> p = new ArrayList<Passageiro>();
		for (Vagao v : this.getVagoes()) {
			for (Passageiro passageiro : v.getPassageiros()) {
				p.add(passageiro);
			}
		}
		return p;
	}
	public void setVagoes(List<Vagao> vagoes) {
		this.vagoes = vagoes;
	} 
	public void update(){
		if(this.getVagoes().size() == 0){
			if(locomotiva.getImagem().getX()+ locomotiva.getImagem().getWidth() <= 0){
				locomotiva.getImagem().setPos(new Point(Macros.DIMENCOES_TELA.x ,locomotiva.getImagem().getY()));
			}
		}else{
			if(locomotiva.getImagem().getX() + (locomotiva.getImagem().getWidth() * (this.getVagoes().size()+1)) <= 0 ){
				locomotiva.getImagem().setPos(new Point(Macros.DIMENCOES_TELA.x ,locomotiva.getImagem().getY()));
			}
		}
		
		float unidade =  locomotiva.getImagem().getX() + locomotiva.getImagem().getWidth();
		int i=1;
		Vagao anterior = new Vagao(0);
		for (Vagao v : this.getVagoes()){
			if(i == 1){
				v.update((int)unidade, locomotiva.getImagem().getY());
				
			}else{
				v.update((int)(anterior.getImagem().getX() + locomotiva.getImagem().getWidth()), locomotiva.getImagem().getY());
			}
			anterior = v;
			i++;
		}
		locomotiva.update(this);
	}
	public void removerTodosPassageiros(){
		for (Vagao v : this.vagoes) {
			v.getPassageiros().clear();
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		getLocomotiva().getImagem().paint(g);
		for (Vagao v : vagoes){
			v.getImagem().paint(g);
		}
	}

}
