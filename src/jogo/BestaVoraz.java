package jogo;

import jplay.URL;

public class BestaVoraz extends Ator {

		
		public BestaVoraz(int x, int y) {
			super(URL.sprite("bestona.png"), 8);
			this.x =x;
			this.y=y;
			this.setTotalDuration(2000);
			this.velocidade = 0.6;
		}
		
		public void perseguir(double x, double y){
			if(this.x > x && this.y <= y + 50 && this.y >= y - 50){
				moveTo(x, y, velocidade);
				if(direcao != 1){
					setSequence(1, 7);
					direcao = 1;
				}
				movendo = true;
				}
			
			else if(this.x < x && this.y <= y + 50 && this.y >= - 50){
				moveTo(x, y, velocidade);
				if(direcao != 2){
					setSequence(1, 5);
					direcao = 2;
				}
				movendo = true;
			}
			
			else if(this.y < y){
				moveTo(x, y, velocidade);
				if(direcao != 5){
					setSequence(6, 8);
					direcao = 4;
				}
				movendo = true;
			}
		
			else if(this.y < y){
				moveTo(x, y, velocidade);
				if(direcao != 5){
					setSequence(1, 5);
					direcao = 5;
				}
				movendo = true;
			}
		
			if(movendo){
				update();
				movendo = false;
			}
		}
		

	}