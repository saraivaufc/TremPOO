package poo.ufc;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sons {
	private AudioClip   railclack;
    private AudioClip   apitoSaida;  
    private AudioClip   apitoChegada;  
    private AudioClip   buzina;
    private AudioClip   sinoPassagem;
    
  
	public Sons() {
        URL urlRailclack = Sons.class.getResource("/sons/railclack.wav");
		railclack    = Applet.newAudioClip(urlRailclack);
		
		URL urlSinoPassagem = Sons.class.getResource("/sons/sinopassagem.wav");
		sinoPassagem    = Applet.newAudioClip(urlSinoPassagem);
		
		
		URL urlApitoSaida = Sons.class.getResource("/sons/apitosaida.wav");
		apitoSaida   = Applet.newAudioClip(urlApitoSaida);
		
		URL urlApitoChegada = Sons.class.getResource("/sons/apitochegada.wav");
		apitoChegada     = Applet.newAudioClip(urlApitoChegada);  
		
		URL urlBuzina = Sons.class.getResource("/sons/buzina.wav");
		buzina      = Applet.newAudioClip(urlBuzina);  
    }
	public void tocaRailclackLoop(){
		System.out.println("Tocando Railclack");
		this.railclack.loop();
	}
	public void pareRailclackLoop(){
		System.out.println("Parando Railclack");
		this.railclack.stop();
	}
	public void apitoSaida(){
		System.out.println("Tocando Apito Saida");
		this.apitoSaida.play();
	}
	public void apitoChegada(){
		System.out.println("Tocando Apito Chagada");
		this.apitoChegada.play();
	}
	
	public void sinoPassagem(){
		System.out.println("Tocando Sino Passagem");
		this.sinoPassagem.play();
	}
	public void buzina(){
		System.out.println("Tocando Buzina");
		this.buzina.play();
	}
}