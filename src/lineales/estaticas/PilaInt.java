/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author rickybauch
 */
public class PilaInt {
    private int [] pila;
    private int tope;
    private static final int tam = 10;
    
    public PilaInt(){
        this.pila = new int[tam];
        this.tope = -1;
    }
    public boolean apilar(int nElem){
        boolean exito;
        if(this.tope+1 >= this.tam){
            exito = false;
            
        }else{
            this.tope++;
            this.pila[tope]= nElem;
            exito = true;
        }
        return exito;
    }
    public boolean desapilar(){
        boolean exito;
        if(this.tope == -1){
            exito = false;
        }else{
            this.tope--;
            exito = true;
        }
        return exito;
    }
    public int obtenerTope(){
        return this.pila[tope];
    }
    public boolean esVacia(){
        return this.tope == -1;
    }
    public void vaciar(){
        this.tope = -1;
    }
    public PilaInt clonar(){
        PilaInt p = new PilaInt();
        p.tope = this.tope;
        p.pila= pila.clone();
        return p;
                
    }
    public String toString(){
        String s;
        s = "";
        if (this.tope == -1) {
            s = "la pila esta vacia";
        } else {
            for (int i = 0; i < this.tope + 1; i++) {
                s += this.pila[i] + "->";
            }
            s += "/";
        }

        return s;
    }
    
  }

