import java.awt.Graphics;
import java.awt.Color;

public class Jogador {
    //atributos=========================
    public boolean up, down;
    public int x, y;
    public int larguraJogador, alturaJogador;
    //construtor========================
    public Jogador(int x, int y){
        this.x = x;
        this.y = y;
        this.larguraJogador = 10;
        this.alturaJogador = 100;
    }
    //metodos===========================
    public void draw(Graphics g){
        g.setColor(new Color(255,255,255));
        g.fillRect(x, y, larguraJogador, alturaJogador);
    }


}
