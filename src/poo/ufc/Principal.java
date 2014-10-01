package poo.ufc;

import java.io.IOException;

import ufc.poo.engine.drawable.BugImage;
import ufc.poo.engine.view.BugWindow;

public class Principal {
	
	
	public static void main(String[] args) throws IOException {
		BugWindow window = new BugWindow(Macros.DIMENCOES_TELA.x,Macros.DIMENCOES_TELA.y,"MyTrem");
		Locomotiva l = new Locomotiva(10, new BugImage("/imagens/locomotiva.png", window.getWidth()-Macros.DIMENCOES_TREM.x, 300, Macros.DIMENCOES_TREM.x, Macros.DIMENCOES_TREM.y));
		Trem t = new Trem(l);
		Controlador control = new Controlador();
		//PlayMusic playmusic = new PlayMusic();
		
		control.criaControles(t);
		
		while(window.isVisible()){
			window.clear();
			
			//control.emiteSons(t, playmusic);
			window.paint(Macros.BACKGROUND);
			t.update();
			
			window.paint(t);
			
			window.paintAll();
		}
	}
}
