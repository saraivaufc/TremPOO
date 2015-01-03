package poo.ufc;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import ufc.poo.engine.drawable.BugDrawable;

public class Trem implements BugDrawable{
	private Locomotiva locomotiva;
	private List<Vagao> vagoes;
	
	public Trem(){
		setVagoes(new ArrayList<Vagao>());
	}
	
	public Trem(Locomotiva locomotiva) {
		this.setLocomotiva(locomotiva);
		setVagoes(new ArrayList<Vagao>());
	}
	public boolean adicionarVagao(Vagao vagao, int tipo){
		if(this.getQuantidadeVagoes() >= this.locomotiva.getLimiteVagoes()){
			return false;
		}else{
			if(tipo == 1){
				this.vagoes.add((VagaoPessoa)vagao);
			}else if(tipo == 2){
				this.vagoes.add((VagaoAnimal)vagao);
			}else{
				return false;
			}
			return true;
		}
		
	}
	
	public int getQuantidadeVagoes(){
		return vagoes.size();
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
			 int index = 0;
			 for (Vagao v : this.vagoes) {
				if(v instanceof VagaoPessoa){
					if(v.espacoLivre() <= 0)
						continue;
					
					
					if(passageiro instanceof Fresca){
						boolean passeEsq = true;
						boolean passDir = true;
						for (int i = index; (i <= index + ((Fresca)passageiro).getFrescura()) && (i < this.numeroVagoes()); i++) {
							if(vagoes.get(i) instanceof VagaoAnimal){
								passeEsq = false;
							}
						}
						for (int k = index; (k >= index - ((Fresca)passageiro).getFrescura()) && (k >= 0); k--) {
							if(vagoes.get(k) instanceof VagaoAnimal){
								passDir = false;
							}
						}
						if(passDir && passeEsq){
							v.embarcar((Fresca)passageiro);
							System.out.println("Passageiro(Fresca) embarcado com Sucesso");
							return true;
						}
					}else if(passageiro instanceof Pessoa){
						v.embarcar((Pessoa)passageiro);
						System.out.println("Passageiro embarcado com Sucesso");
						return true;
					}
				}else if(v instanceof VagaoAnimal){
					if(passageiro instanceof Animal){
						if(v.espacoLivre() < ((Animal)passageiro).getPeso())
							continue;
						
						v.embarcar((Animal)passageiro);
						System.out.println("Passageiro embarcado com Sucesso");
						return true;
					}
				}
				index++;
			}
		return false;
	}
	public boolean desembarcar(long id){
		for (Vagao v : this.vagoes) {
			if(v.getPassageiros().remove(new Pessoa(" ", id))){
				return true;
			};
		}		
		return false;
	}
	public Passageiro buscar(long cpf){
		for (Vagao v : this.vagoes) {
			for (Passageiro p : v.getPassageiros()) {
				if(p.equals(new Pessoa(" ", cpf))){
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
		for (Vagao v : this.vagoes) {
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
	public List<Passageiro>  getPassageiros(){
		List<Passageiro> p = new ArrayList<Passageiro>();
		for (Vagao v : this.vagoes) {
			for (Passageiro passageiro : v.getPassageiros()) {
				p.add(passageiro);
			}
		}
		return p;
	}
	
	public int getQuantVagoes(){
		return this.vagoes.size();
	}
	
	public void setVagoes(List<Vagao> vagoes) {
		this.vagoes = vagoes;
	} 
	public void update(){
		if(getQuantVagoes() == 0){
			if(locomotiva.getImagem().getX()+ locomotiva.getImagem().getWidth() <= 0){
				locomotiva.getImagem().setPos(new Point(Macros.DIMENCOES_TELA.x ,locomotiva.getImagem().getY()));
			}
		}else{
			if(locomotiva.getImagem().getX() + (locomotiva.getImagem().getWidth() * (getQuantVagoes() + 1 )) <= 0 ){
				locomotiva.getImagem().setPos(new Point(Macros.DIMENCOES_TELA.x ,locomotiva.getImagem().getY()));
			}
		}
		
		float unidade =  locomotiva.getImagem().getX() + locomotiva.getImagem().getWidth();
		int i=1;
		Vagao anterior = new VagaoPessoa(0);
		for (Vagao v : this.vagoes){
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
		getLocomotiva().getImagem().paint(g);
		for (Vagao v : this.vagoes) {
			v.getImagem().paint(g);
		}
	}

}
