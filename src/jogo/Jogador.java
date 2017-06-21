package jogo;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.Vector;

import jplay.GameObject;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;
import jplay.URL;
import jplay.Window;

public class Jogador extends Ator {

	
	
	static double energia = 100;

	

	public Jogador(int x, int y) {
		super(URL.sprite("jogador.png"), 20);
		this.x = x;
		this.y = y;
		
		this.setTotalDuration(2000);

	}
	ControleTiros tiros = new ControleTiros();
	public void atirar(Window janela, Scene cena, Keyboard teclado){
		
		if(teclado.keyDown(KeyEvent.VK_A)){
			tiros.adicionaTiro(x + 5, y + 12, direcao, cena);
		}
		tiros.run();
	}

	public void controle(Window janela, Keyboard teclado) {


		if (teclado.keyDown(Keyboard.LEFT_KEY)) {
			if (this.x > 0)
				this.x -= velocidade;
			if (direcao != 1) {
				setSequence(4, 8);
				direcao = 1;
			}
			movendo = true;

		} else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
			if (this.x < janela.getWidth() - 60)
				this.x += velocidade;
			if (direcao != 2) {
				setSequence(8, 12);
				direcao = 2;
			}
			movendo = true;

		} else if (teclado.keyDown(Keyboard.UP_KEY)) {
			if (this.y > 0)
				this.y -= velocidade;
			if (direcao != 4) {
				setSequence(12, 16);
				direcao = 4;
			}
			movendo = true;

		} else if (teclado.keyDown(Keyboard.DOWN_KEY)) {
			if (this.y < janela.getHeight() - 60)
				this.y += velocidade;
			if (direcao != 5) {
				setSequence(0, 4);
				direcao = 5;
			}
			movendo = true;
		}
		if (movendo) {
			update();
			movendo = false;
		}
	}
}

	

	