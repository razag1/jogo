package jogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy {
	private int x,y;
	private int dy;
	private Image imagem;
	private int altura, largura;
	private boolean isVisivel;
	private Fase fase;
	
	public Enemy(Fase faseReferencia) {
		fase = faseReferencia;
		x = (int)(Math.random()*924);
		y = (int)(Math.random()*-1000);
		isVisivel = true;
		
	}
	//carregando a imagem do jogador
	public void load() {
		ImageIcon referencia1 = new ImageIcon("res\\enemy.png");
		imagem = referencia1.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getHeight(null);
	}
	
	public void update() {
		if(y >= fase.player.y && x >= fase.player.x - 30 && x + largura - 2 <= fase.player.x + 140) {
			fase.pontuacao += 1;
			x = (int)(Math.random()*924);
			y = (int)(Math.random()*-1000);
		} 
		
		else if(y >= fase.player.y + 40) {
			x = (int)(Math.random()*924);
			y = (int)(Math.random()*-1000);
		}
		
		dy = 4;
		y += dy;
		}
	///
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}
	
	public boolean isVisivel() {
		return isVisivel;
	}
	
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
}
