package game;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Pelota {
   
    GameCanvas gc; 
    private final int  WIDTH = 20, HEIGTH = 20;
    public double x, y, dx = -2.9,dy = -2;
    private boolean empezar = true; 
    public  char direccion = 'c'; 
    public Pelota(int x, int y){
      this.x = x; 
      this.y = y; 
    }
    
    public void moverPelota(Rectangle limites, boolean r1, boolean r2){
        x += dx;
        y += dy; 
      if(r1){
          dx = -dx;
          x = 20;
      }  
      if(r2){
         dx = -dx;
         x = 755; 
      }
      if(x < limites.getMinX()){
         x = limites.getCenterX();
         y = limites.getCenterY();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
            }
      }  
      if(x > limites.getMaxX()){
         x = limites.getCenterX();
         y = limites.getCenterY();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      if (y < limites.getMinY()) {
          y = limites.getMinY();
          dy = -dy;
        }
      if (y  >= limites.getMaxY()-HEIGTH) {
          y = limites.getMaxY() - HEIGTH;
          dy = -dy;
     }
      if(x < limites.getCenterY()){
        direccion = 'y';
    }else{
        direccion = 'n';
    }

}
    
    
    public Rectangle2D getPelota(){
      return new Rectangle2D.Double(x,y,WIDTH,HEIGTH);     
    }
         
        
}
