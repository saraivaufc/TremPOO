package poo.ufc;

import java.awt.event.KeyEvent;
import java.io.IOException;

import ufc.poo.engine.drawable.BugImage;
import ufc.poo.engine.view.BugWindow;

public class Principal {
	
	
	public static void main(String[] args) throws IOException {
		BugWindow window = new BugWindow(Macros.DIMENCOES_TELA.x,Macros.DIMENCOES_TELA.y,"MyTrem");
		Locomotiva l = new Locomotiva(10, new BugImage("/imagens/locomotiva.png", window.getWidth()-Macros.DIMENCOES_TREM.x, 300, Macros.DIMENCOES_TREM.x, Macros.DIMENCOES_TREM.y));
		Trem t = new Trem(l);
		
		t.adicionarVagao(new VagaoPessoa(10), 1);
		t.adicionarVagao(new VagaoAnimal(12312), 2);
		t.adicionarVagao(new VagaoPessoa(10), 1);
		t.adicionarVagao(new VagaoPessoa(10), 1);
		
		t.embarcar(new Fresca("oiad", 2323, 1));
		
		
		final Controlador control = new Controlador();
		
		Sons som = new Sons();
		
		//aqui eu crio a interface dos controles
		control.criaControles(t);
		
		
		
		while(window.isVisible()){
			window.clear();
			
			//atualizo a posicao do trem
			t.update();
			
			//reproduzo os sons
			control.emiteSons(t, som);
			
			//teclado
			
			//imprimo o plano de fundo
			window.paint(Macros.BACKGROUND);
			
			//imprimo o trem
			window.paint(t);
			
			
			window.paintAll();
			
			if(window.isKeyPressed()) {
				KeyEvent e = window.getKeyPressed();
				//caso aperte espaco
				if(e.getKeyCode() == KeyEvent.VK_SPACE){
					control.criaControles(t);
				}
				
			}
		}
	}
}
