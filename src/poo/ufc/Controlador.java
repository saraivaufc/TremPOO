package poo.ufc;

import javax.swing.JFrame;

public class Controlador {
	private PlayMusic sons;
	private boolean  somLocomotiva;
	public Controlador() {
		this.setSons(new PlayMusic());
		this.somLocomotiva = false;
	}
	
	public void criaControles(Trem t){
		ControleWindow ui = new ControleWindow(t);
		ui.setVisible(true);
		JFrame frame = new JFrame();
		frame.setSize(360, 190);
		frame.add(ui);
		frame.setVisible(true);
	}
	public void emiteSons(Trem t, PlayMusic s){
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
	
	public PlayMusic getSons() {
		return sons;
	}
	public void setSons(PlayMusic sons) {
		this.sons = sons;
	}
}
