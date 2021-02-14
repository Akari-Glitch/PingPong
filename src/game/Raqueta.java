package game;
import controles.Teclado;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
public class Raqueta{
        
    public  int x = 0, y = 0;
    public final int WIDTH = 10, HEIGTH = 70; 
    Teclado teclado; 
    
    public Raqueta(int x, int y){
      this.x = x;
      this.y = y; 
    }
    
    
    public Rectangle2D getRaqueta(){
       return new Rectangle2D.Double(x,y,WIDTH,HEIGTH);          
    } 
    
}
