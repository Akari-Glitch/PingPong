package controles;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Teclado implements KeyListener{
     
    private final int numeroTeclas = 120; 
    private boolean[] teclas = new boolean[numeroTeclas]; 
    public boolean salir; 
    public boolean r1Arriba; //raquete izquierda arriba
    public boolean r1Abajo; //raqueta izquierda abajo
 
     
    public void actualizar(){
      salir = teclas[KeyEvent.VK_ESCAPE]; 
      
      r1Arriba = teclas[KeyEvent.VK_W]; 
      r1Abajo = teclas[KeyEvent.VK_S];
     
    }
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true; 
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false; 
    }
     
   @Override
    public void keyTyped(KeyEvent e) {
        
    }

}
