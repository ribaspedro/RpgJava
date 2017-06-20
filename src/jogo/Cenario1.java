package jogo;

import jplay.Keyboard;

import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 {
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	private Dragonites dragao;
	private BestaVoraz besta;
	public Cenario1(Window window) {
		
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1.csn"));
		jogador = new Jogador(640, 350);
		teclado = janela.getKeyboard();
		dragao = new Dragonites(300, 300);
		besta = new BestaVoraz(400, 400);
		run();
	}

	
	public void run() {
		while (true) {
			//cena.draw();
			jogador.controle(janela, teclado);
			jogador.caminho(cena);
			
			dragao.caminho(cena);
			dragao.perseguir(jogador.x, jogador.y);
			besta.caminho(cena);
			besta.perseguir(jogador.x, jogador.y);
			cena.moveScene(jogador);
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();

			dragao.x += cena.getXOffset();
			dragao.y += cena.getYOffset();
			besta.x += cena.getXOffset();
			besta.y += cena.getYOffset();
			
			jogador.draw();
			dragao.draw();
			besta.draw();
			janela.update();
			
		}

	}
	
	

}
