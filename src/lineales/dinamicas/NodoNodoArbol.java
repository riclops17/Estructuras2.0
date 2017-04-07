/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;
import jerarquicas.NodoArbol;
/**
 *
 * @author rickybauch
 */
public class NodoNodoArbol {
    private NodoArbol elem;
    private NodoNodoArbol enlace;
    
    public NodoNodoArbol(NodoArbol elem,NodoNodoArbol enlace){
        this.elem = elem;
        this.enlace = enlace;
    }
    public NodoNodoArbol(NodoArbol elem1){
        this.elem = elem1;
        this.enlace = null;
    }
    public NodoArbol getElem(){
        return elem;
    }
    public void setElem(NodoArbol elem){
        this.elem = elem;
    }
    public NodoNodoArbol getEnlace(){
        return enlace;
    }
    public void setEnlace(NodoNodoArbol enlace){
        this.enlace = enlace;
    }
}
