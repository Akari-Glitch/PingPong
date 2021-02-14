package game;

import controles.Teclado;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GameCanvas extends Canvas {

    private final int HEIGHT = 600, WIDTH = 800;
    private JFrame frame;
    private static volatile boolean running = false;
    Thread thread;
    Teclado teclado;
    Rectangle limites = new Rectangle(WIDTH, HEIGHT);
    Pelota p = new Pelota((int) limites.getCenterX(), (int)limites.getCenterY());
    Raqueta r1 = new Raqueta(10, 200);
    Raqueta r2 = new Raqueta(WIDTH - 20, HEIGHT / 2);
    

    public GameCanvas() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        teclado = new Teclado();
        addKeyListener(teclado);
        new Hilo(this).start();

        frame = new JFrame("Ping Pong :)");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.pack();
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(this);

    }

    public void paint(Graphics g) {
        Line2D.Double linea = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(), getBounds().getMaxY());

        Graphics2D g2 = (Graphics2D) g;
        
        g2.draw(linea);
        g2.setColor(Color.blue);
        g2.fill(r1.getRaqueta());

        g2.setColor(Color.red);
        g2.fill(r2.getRaqueta());

        g2.setColor(Color.white);
        g2.fill(p.getPelota());
    }

    public void actualizar() {
        teclado.actualizar();
        if (teclado.salir) {
            System.exit(0);
        }
        //actualizar movimiento de las raqueta1// 
        if (teclado.r1Arriba && r1.y > limites.getMinY()) {
            r1.y-=3;
        }
        if (teclado.r1Abajo && r1.y < limites.getMaxY() - r1.HEIGTH) {
            r1.y+=3;
        }
        //fin de actualizar movimiento de la raqueta 1 
        p.moverPelota(limites, colision(r1.getRaqueta()), colision(r2.getRaqueta()));

        //movimiento del bot (raqueta2)
        if(p.direccion == 'y'){
          if(r2.y > limites.getCenterY()){
             r2.y-=3;
          }
          if(r2.y < limites.getCenterY()){
             r2.y+=3; 
          }
        }
        
        if( p.y > r2.y && r2.y< limites.getMaxY()-r2.HEIGTH){
             r2.y+=3;
          }
        if(p.y < r2.y && r2.y > limites.getMinY()){
             r2.y-=3; 
        }
          
    }     

    public boolean colision(Rectangle2D r) {
        return p.getPelota().intersects(r);
    }

}
