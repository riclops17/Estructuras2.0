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
public class NodoAVL {
    private int elem;
    private NodoArbol izq;
    private NodoArbol der;
    private int altura;
    public NodoAVL(int elem1, NodoArbol izq1 ,NodoArbol der1){
        this.elem = elem1;
        this.izq = izq1;
        this.der = der1;
        this.altura = 0;
    }
    public NodoAVL(int elem1){
        this.elem = elem1;
        this.izq = null;
        this.der = null;
        this.altura = 0;
    }
    public int getElem(){
        return this.elem;
    }
    public NodoArbol getIzq(){
        return this.izq;
    }
    public NodoArbol getDer(){
        return this.der;
    }
    public void setElem(int elem1 ){
        this.elem = elem1;
    }
    public void setIzq(NodoArbol izq1){
        this.izq = izq1;
    }
    public void setDer(NodoArbol der1){
        this.der = der1;
    }
}


