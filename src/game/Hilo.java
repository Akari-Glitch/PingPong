package game;
public class Hilo extends Thread{
    
   private final GameCanvas canvas;
   boolean empezar = true;
   public Hilo(GameCanvas canvas){
     this.canvas = canvas; 
   }
   
    @Override
    public void run() {
         final int NS_POR_SEGUNDO = 1000000000; 
         final byte  APS_OBJETIVO = 60; 
         final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO/APS_OBJETIVO;
            
         long referenciaActualizacion = System.nanoTime();
         long referenciaContador = System.nanoTime(); 
        
         double tiempoTranscurrido; 
         double delta = 0; 
        
        
        while(empezar){
           final long inicioBucle = System.nanoTime();
           
           tiempoTranscurrido = inicioBucle - referenciaActualizacion;
           referenciaActualizacion = inicioBucle; 
           
           delta+= tiempoTranscurrido/NS_POR_ACTUALIZACION; 
              
            while (delta >= 1) {
                 delta--;   
                 canvas.actualizar();
                 canvas.repaint();
            }
            
           if(System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){
              referenciaContador = System.nanoTime(); 
           }
        }
        
     } 
    }
    
