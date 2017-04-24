/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author rickybauch
 */
public class Nodo {
      
    private Object elem; 
    private Nodo enlace;
    
    public Nodo (Object elem){
        this.elem = elem;
    }
    
    public Nodo (Object elem, Nodo siguiente){
        this.elem = elem;
        this.enlace = siguiente;
    }
    
    public Object getElem (){
        return this.elem;
    }
    
    public Nodo getEnlace (){
        return this.enlace;
    }
    
    public void setElem (Object elem){
        this.elem = elem;        
    }
    
    public void setEnlace (Nodo siguiente){
        this.enlace = siguiente;
    }
}
