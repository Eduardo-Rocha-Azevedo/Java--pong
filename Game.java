import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;


public class Game extends Canvas implements Runnable, KeyListener{
    public static int largura = 450;
    public static int altura = 400;
    public static Jogador jogador;
    public static Inimigo inimigo;
    public static Bola bola;

    public Game(){
        this.setPreferredSize(new Dimension(largura, altura)); 
        jogador = new Jogador(15, 150);
        this.addKeyListener(this);
        inimigo = new Inimigo(largura - 25, 150);
        bola = new Bola(255,200);
    }   
   public static void main(String[] args) {
        
        Game jogo = new Game();
        JFrame frame = new JFrame("Jogo");
       
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
                Thread.sleep(1000/30);
               
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
            inimigo.draw(g);
            bola.draw(g);
            bs.show();
        }
    
        private void atualizar(){
            jogador.atualizar();
            inimigo.atualizar();
            bola.atualizar();
        }

        @Override
        public void keyTyped(KeyEvent e) {
            
            
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
                jogador.up = true;
            }else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN  ){
                jogador.down = true;
            }
            
        }
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
                jogador.up = false;
            }else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
                jogador.down = false;
            }
            
        }
    }
