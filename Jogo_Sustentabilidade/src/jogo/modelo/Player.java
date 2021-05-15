package jogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {
	public int x,y;
	private int dx,dy;
	private Image imagem;
	private int altura, largura;
	
	public Player() {
		this.x = 100;
		this.y = 560;
		
	}
	//carregando a imagem do jogador
	public void load() {
		ImageIcon referencia = new ImageIcon("res\\lixeira.png");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getHeight(null);
	}
	
	public void update( ) {
		x += dx;
		y += dy;
	}
	
	
	//comandos teclados
	public void KeyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
			
		if(codigo == KeyEvent.VK_LEFT) {
			dx=-7;
		}
		
		if(codigo == KeyEvent.VK_RIGHT) {
			dx=7;
		}
	}
	
	public void KeyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		
		if(codigo == KeyEvent.VK_LEFT) {
			dx=0;
		}
		
		if(codigo == KeyEvent.VK_RIGHT) {
			dx=0;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}
	
	public int getLargura() {
		return largura;
	}
	
}
