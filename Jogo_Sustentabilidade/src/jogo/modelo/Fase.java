package jogo.modelo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
	
	private Image fundo;
	public Player player;
	private Timer timer;
	private List<Enemy> enemy;
	public int pontuacao = 0;
	
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon("res\\fundo.jpg");
		fundo = referencia.getImage();
		
		player = new Player();
		player.load();
		
		addKeyListener(new TecladoAdapter());
		
		timer = new Timer(5, this);
		timer.start();
		
		inicializaInimigos();
	}
	
	//numero de inimigos
	public void inicializaInimigos() {
		int coordenadas [] = new int [7];
		enemy = new ArrayList<Enemy>();
		
		for (int i = 0; i < coordenadas.length; i++) {
			
			enemy.add(new Enemy(this));
		}
		
	}
	
	//render
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage (fundo, 0, 0, null);
		graficos.drawImage (player.getImagem(), player.x, player.y, this);

		for (int o = 0; o < enemy.size(); o++) {
			Enemy in = enemy.get(o);
			in.load();
			graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
		}
		
		g.setFont(new Font("Arial", Font.BOLD,23));
		g.drawString("pontos: "+ pontuacao, WIDTH/2,20);
		
		g.dispose();
	}
	
	//update
	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		
		for (int o = 0; o < enemy.size(); o++) {
			Enemy in = enemy.get(o);
				if(in.isVisivel()) {
					in.update();
				} else {
					enemy.remove(o);
				}
		}
		
		repaint();
		}
	
	//teclado
	private class TecladoAdapter implements KeyListener{

        @Override
        public void keyPressed(KeyEvent e) {
           player.KeyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.KeyRelease(e);
        }

		@Override
		public void keyTyped(KeyEvent e) {
			
		}
	}
}
