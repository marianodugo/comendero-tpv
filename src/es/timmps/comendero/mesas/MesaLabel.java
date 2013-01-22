/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.timmps.comendero.mesas;

import es.timmp.componets.JLabelEditable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author aperalta
 */
public class MesaLabel extends JLabelEditable implements MouseListener{

    private static final String BASE_RUTA = "es/timmps/comandero/mesas/imgs/";
    private static final String GRANDE = "grande/";
    private static final String MEDIANO = "medio/";
    private static final String PEQUE = "peque/";
    
   /* 
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 10;
    
    public static final int  MESA_CUATRO = 4;
    public static final int  MESA_SEIS = 6;
    public static final int  MESA_OCHO = 8;
    public static final int  MESA_DIEZ = 10;
    */
    public enum Mesas{
       MESA_CUATRO,
       MESA_SEIS,
       MESA_OCHO,
       MESA_DIEZ
    }
    public enum Posicion{
        HORIZONTAL,
        VERTICAL
    }
    public enum SizeImg{
        GRANDE,MEDIANO,PEQUE
    }
    
    private int comensales = 0;
    private String nombre = "";
    private boolean ocupada = false;
    private Mesas tipoMesa = Mesas.MESA_CUATRO;
    private Posicion direccion = Posicion.HORIZONTAL;
    private SizeImg sizeImg = SizeImg.GRANDE;
    
    public MesaLabel(){
        this.addMouseListener(this);
        
    }
    public void rotar(){
        if(direccion == Posicion.HORIZONTAL){
            direccion  = Posicion.VERTICAL; 
            this.setIcon(new ImageIcon(getClass().getResource("/es/timmp/componets/resources/onRelax.png")));
        }
    }
    @Override
    public void mouseClicked(MouseEvent me) {
       
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
   private String getImagen(){
      
       switch(tipoMesa){
           case MESA_CUATRO: { 
               if(direccion == Posicion.HORIZONTAL){
                    return"";
               }else{
                    return"";
               }
           }
       
       }
   }
   
    
}
