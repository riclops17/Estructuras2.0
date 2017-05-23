/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author rickybauch
 */
public class NodoHash {
  private int elem;
  private NodoHash enlace; 
     
   public NodoHash(int elem1,NodoHash enlace1){
        this.elem = elem1;
        this.enlace = enlace1;
    }
    public NodoHash(int elem1 ){
        this.elem = elem1;
        this.enlace = null;
    }
 
    public int getElem(){
        return elem;
    }
    public void setElem(int elem1){
        this.elem = elem1;
    }
    public NodoHash getEnlace(){
        return this.enlace;
    }
    public void setEnlace(NodoHash enlace1){
        this.enlace = enlace1;
    }
}
