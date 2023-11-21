import java.awt.*;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;


public class Game extends Canvas implements Runnable{
    public static int largura = 450;
    public static int altura = 400;
    public  int fps = 1000;
    public static Jogador jogador;

    public Game(){
        this.setPreferredSize(new Dimension(largura, altura));
    }   
   public static void main(String[] args) {
        
        Game jogo = new Game();
        JFrame frame = new JFrame("Jogo");
        jogador = new Jogador(15, 150);
        frame.setVisible(true);
        frame.add(jogo);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Thread(jogo).start();
        
    }

    //FPS
    @Override
    public void run() {
            try {
                while(true){
                //chama as funcoes de atualizar e desenhar
                desenhar();
                atualizar();
                Thread.sleep(this.fps);
               
             } 
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void desenhar(){
            BufferStrategy bs = this.getBufferStrategy();
            if(bs == null){
                this.createBufferStrategy(3);
                return;
            }
    
            Graphics g = bs.getDrawGraphics();
            g.setColor(new Color(0,0,0));
            g.fillRect(0, 0, largura, altura);
            jogador.draw(g);
            bs.show();
        }
    
        private void atualizar(){
    
        }
    }
