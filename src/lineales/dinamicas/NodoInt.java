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
public class NodoInt {
    private int elem;
    private NodoInt enlace;
    
    public NodoInt(int elem1,NodoInt enlace1){
        this.elem = elem1;
        this.enlace = enlace1;
    }
    public NodoInt(int elem1 ){
        this.elem = elem1;
        this.enlace = null;
    }
    public int getElem(){
        return elem;
    }
    public void setElem(int elem1){
        this.elem = elem1;
    }
    public NodoInt getEnlace(){
        return this.enlace;
    }
    public void setEnlace(NodoInt enlace1){
        this.enlace = enlace1;
    }
}
