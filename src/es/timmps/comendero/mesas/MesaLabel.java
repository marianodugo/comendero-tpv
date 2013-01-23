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

    private  final String BASE_RUTA = "/es/timmps/comendero/mesas/imgs/";
    private  final String GRANDE = "grande/";
    private  final String MEDIANO = "medio/";
    private  final String PEQUE = "peque/";
    
    private final String LIBRE ="";
    private final String OCUPADO =  "_m";
    private final String PEDIDO =   "_p";
    private final String SERVIDO =  "_v";
            
    
    
    public  final String HORIZONTAL = "h_";
    public  final String VERTICAL = "v_";
    
    public  final String  MESA_CUATRO = "1x1";
    public  final String  MESA_SEIS = "2x1";
    public  final String  MESA_OCHO = "3x1";
    public  final String  MESA_DIEZ = "4x1";
    
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
    public enum EstadoMesa{
        LIBRE,OCUPADO,PEDIDO,SERVIDO
    }
    public enum Modos{
        EDICION,PRODUCCION;
    }
    
    private int comensales = 0;
    private String nombre = "";
    private ImageIcon imagen;
    
    
    private boolean selected = false;
    
    
    
    private Modos modo = Modos.PRODUCCION;
    private EstadoMesa estado = EstadoMesa.LIBRE;
    private Mesas tipoMesa = Mesas.MESA_CUATRO;
    private Posicion direccion = Posicion.HORIZONTAL;
    private SizeImg sizeImg = SizeImg.GRANDE;
    
    public MesaLabel(){
        this.addMouseListener(this);
        _updateImagen();
        //this.setEdicion(true);
        //this.resizeStart();
    }
    public void rotar(){
        if(direccion.equals(Posicion.HORIZONTAL)){
           
            direccion  = Posicion.VERTICAL;   
        }else{
            direccion  = Posicion.HORIZONTAL;
        }
        _updateImagen();
    }
   
    private void _updateImagen(){
        imagen = new ImageIcon(getClass().getResource(_getImagen()));
        this.setIcon(imagen);
        this.setSize(imagen.getIconWidth(),imagen.getIconHeight());
        this.updateUI();
    
    }
    
    /**
     * Monta la uri del icono segun tamaño direccion y estado
     * @return 
     */
   private String _getImagen(){
      
       switch(tipoMesa){
           case MESA_CUATRO: 
                return this.BASE_RUTA+_getSizeMesa()+_getDireccion()+MESA_CUATRO+_getEstado()+".png";
             case MESA_SEIS: 
                return this.BASE_RUTA+_getSizeMesa()+_getDireccion()+MESA_SEIS+_getEstado()+".png";    
            case MESA_OCHO: 
                return this.BASE_RUTA+_getSizeMesa()+_getDireccion()+MESA_OCHO+_getEstado()+".png";
             case MESA_DIEZ: 
                return this.BASE_RUTA+_getSizeMesa()+_getDireccion()+MESA_DIEZ+_getEstado()+".png";     
           default:
               return "";
       }
       
   }
   
   private String _getDireccion(){
       switch(direccion){
           case HORIZONTAL:
               return HORIZONTAL;
           case VERTICAL:
               return VERTICAL;
           default :
               return HORIZONTAL;
       }
   }
   
   private String _getSizeMesa(){
       switch(sizeImg){
           case GRANDE:
               return GRANDE;
           case MEDIANO:
               return MEDIANO;
           case PEQUE:
               return PEQUE;
           default:
               return GRANDE;
       }
       
   }
   private String _getEstado(){
   switch(estado){
           case LIBRE:
               return LIBRE;
           case OCUPADO:
               return OCUPADO;
           case PEDIDO:
               return PEDIDO;
           case SERVIDO:
               return SERVIDO;
           default:
               return "";    
     }
   }

    public int getComensales() {
        return comensales;
    }

    public void setComensales(int comensales) {
        this.comensales = comensales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Modos getModo() {
        return modo;
    }

    public void setModo(Modos modo) {
        this.modo = modo;
        switch(modo){
            case PRODUCCION:
                this.setEdicion(false);
            case EDICION:
                this.setEdicion(true);    
        }
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
        _updateImagen();
    }

    public Mesas getTipoMesa() {
        return tipoMesa;
    }

    public void setTipoMesa(Mesas tipoMesa) {
        this.tipoMesa = tipoMesa;
        _updateImagen();
        
    }

    public Posicion getDireccion() {
        return direccion;
    }

    public void setDireccion(Posicion direccion) {
        this.direccion = direccion;
        _updateImagen();
    }

    public SizeImg getSizeImg() {
        return sizeImg;
    }

    public void setSizeImg(SizeImg sizeImg) {
        this.sizeImg = sizeImg;
        _updateImagen();
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
   
   
   
     @Override
    public void mouseClicked(MouseEvent me) {
       if(this.modo.equals(Modos.EDICION)){
           this.selected = true;
           this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
           this.updateUI();
           
       }else{
           
       }
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
}
