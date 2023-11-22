import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bola extends JFrame{
    public double x;
    public double y;
    public int larguraBola;
    public int alturaBola;
    public double dx;
    public double dy;
    public double speed = 7.0;

    public Bola(int x, int y){
        this.x = x;
        this.y = y;
        this.larguraBola = 7;
        this.alturaBola = 7;

        int angle = new Random().nextInt(70);
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
    }

    public void draw(Graphics g){
        g.setColor(new Color(238,173,45));
        g.fillRect((int)x, (int)y, larguraBola, alturaBola);
    }

    public void atualizar(){
        if(y+(dy*speed) +alturaBola >= Game.largura) {
            dy *= -1;
        }else if(y+(dy*speed) < 0){
            dy *= -1;
        }

        Rectangle bola = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)), larguraBola, alturaBola);
        Rectangle jogador = new Rectangle(Game.jogador.x, Game.jogador.y, Game.jogador.larguraJogador, Game.jogador.alturaJogador);
        Rectangle inimigo = new Rectangle((int)Game.inimigo.x, (int)Game.inimigo.y, Game.inimigo.larguraInimigo, Game.inimigo.alturaInimigo);

        //colisao
        if(bola.intersects(jogador)){
            int angle = new Random().nextInt(80);
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if(dx < 0){
                dx *= -1;
            }
        }else if(bola.intersects(inimigo)){
            int angle = new Random().nextInt(80);
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if(dx > 0){
                dx *= -1;
            }

        }
        //ponto
         
        if(x >= Game.largura){
            new Game();
            return;
        }else if(x < 0){
           
            new Game();
            return;
        }
        x += dx*speed;
        y += dy*speed;
    }
}
