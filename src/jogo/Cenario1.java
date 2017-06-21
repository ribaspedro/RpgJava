package jogo;

import jplay.Keyboard;

import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 extends Cenario {

    private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	private Dragonites dragao;
    BestaVoraz besta[] = new BestaVoraz [5];	
	
	
	
	public Cenario1(Window window) {
		
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1.csn"));
		jogador = new Jogador(640, 350);
		teclado = janela.getKeyboard();
		dragao = new Dragonites(310, 320);
		
		
		run();
	}

	
	public void run() {
		for(int i=0; i<5; i++){
			besta[i] = new BestaVoraz(100*i, 100*i);
		}
		while (true) {
			//cena.draw();

			
			jogador.controle(janela, teclado);
			jogador.caminho(cena);	
			
			cena.moveScene(jogador);
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			
			jogador.draw();
			
			
			
			
			dragao.caminho(cena);
			dragao.perseguir(jogador.x, jogador.y);
			dragao.x += cena.getXOffset();
			dragao.y += cena.getYOffset();
			dragao.draw();	
			
			
			
			for(int i=0 ; i<besta.length; i++){
				besta[i].caminho(cena);
				besta[i].perseguir(jogador.x, jogador.y);
				besta[i].x += cena.getXOffset();
				besta[i].y += cena.getYOffset();
				besta[i].draw();
				jogador.atirar(janela, cena, teclado);
				
								
			}
			
									
			janela.update();		
			mudarcenario();
		}

	}
	
	private void mudarcenario(){
		if(tileCollision(5, jogador, cena) == true){
			new Cenario2(janela);
		}
	}

}
