/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author rickybauch
 */
public class NodoGen {
    private Object elem;
    private NodoGen eIzq;
    private NodoGen hDer;
    
    public NodoGen(Object elem1,NodoGen izq,NodoGen der){
        this.elem = elem1;
        this.eIzq =izq;
        this.hDer = der;
    }
    public NodoGen( Object elem1){
        this.elem = elem1;
        this.eIzq = null;
        this.hDer = null;
    }
    public Object getElem(){
        return this.elem;
    }
    public NodoGen getEIzq(){
        return this.eIzq;
        
    }
    public NodoGen getHDer(){
        return this.hDer;
    }
    public void setElem(Object elem1){
        this.elem = elem1;
    }
    public void setEIzq(NodoGen e1){
        this.eIzq = e1;
    }
    public void setHDer(NodoGen d1){
        this.hDer = d1;
    }
}
