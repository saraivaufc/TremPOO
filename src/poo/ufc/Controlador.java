package poo.ufc;

import javax.swing.JOptionPane;

public class Controlador {
	private Sons sons;
	private boolean  somLocomotiva;
	
	private ControleWindow ui;
	
	public Controlador() {
		this.setSons(new Sons());
		this.somLocomotiva = false;
		this.ui = null;
	}
	public void criaControles(Trem t){
		if(ui != null){
			ui.setVisible(false);
		}
		this.ui = new ControleWindow(t);
		ui.setSize(360, 190);
		ui.setVisible(true);		
	}
	public void emiteSons(Trem t, Sons s){
		if(t.getLocomotiva().getVelocidade() > 0 && somLocomotiva == false){
			somLocomotiva = true;
			s.tocaRailclackLoop();
			if(t.getLocomotiva().getImagem().getX() < (Macros.DIMENCOES_TELA.getX()/2) + 20 &&  t.getLocomotiva().getImagem().getX() > (Macros.DIMENCOES_TELA.getX()/2) - 20 ){
				s.sinoPassagem();
			}
		}
		if(t.getLocomotiva().getVelocidade() == 0){
			somLocomotiva = false;
			s.pareRailclackLoop();
		}
	}
	
	public Sons getSons() {
		return sons;
	}
	public void setSons(Sons sons) {
		this.sons = sons;
	}
	
	public static int opcaoPassageiro(){
		int opcao=-1;
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opcao:\n1:Pessoa\n2:Animal\n3:Fresca\nOpcao:"));
		if(opcao != 1 && opcao != 2 && opcao != 3){
			return -1;
		}else{
			return opcao;
		}
	}
	public static int opcaoVagao(){
		int opcao=-1;
		try{
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opcao:\n1:Vagao de Pessoa\n2:Vagao de Animal\nOpcao:"));
		}catch(NumberFormatException e1){
			return -1;
		}
			if(opcao != 1 && opcao != 2){
			return -1;
		}else{
			return opcao;
		}
	}
			
}
