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
    private NodoAVL izq;
    private NodoAVL der;
    private int altura;
    public NodoAVL(int elem1, NodoAVL izq1 ,NodoAVL der1){
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
    public int getAltura(){
        return this.altura;
    }
    public NodoAVL getIzq(){
        return this.izq;
    }
    public NodoAVL getDer(){
        return this.der;
    }
    public void setAltura(int alt1){
        this.altura = alt1;
    }
    public void setElem(int elem1 ){
        this.elem = elem1;
    }
    public void setIzq(NodoAVL izq1){
        this.izq = izq1;
    }
    public void setDer(NodoAVL der1){
        this.der = der1;
    }
}


