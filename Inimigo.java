import java.awt.Color;
import java.awt.Graphics;

public class Inimigo {
    public double x;
    public double y;
    public int larguraInimigo;
    public int alturaInimigo;

    public Inimigo(int x, int y){
        this.x = x;
        this.y = y;
        this.larguraInimigo = 10;
        this.alturaInimigo = 100;
    }

    public void draw(Graphics g){
        g.setColor(new Color(0,0,255));
        g.fillRect((int)x, (int)y, larguraInimigo, alturaInimigo);
    }

    public void atualizar(){
        y += (Game.bola.y - y - 5) * 0.5; 
        //colisao
        if(y + alturaInimigo > Game.altura){
            y = Game.altura - alturaInimigo;
        }else if(y < 0){
            y = 0;
        }
    }
}
