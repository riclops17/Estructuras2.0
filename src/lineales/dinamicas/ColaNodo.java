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
public class ColaNodo {
    private NodoNodoArbol frente;
    private NodoNodoArbol fin;
    
    public boolean poner(NodoArbol elemn){
       NodoNodoArbol nuevo = new NodoNodoArbol( elemn,null);
       if(fin!= null){
           this.fin.setEnlace(nuevo);
       }else{
           this.frente = nuevo;
       }
       this.fin= nuevo;
       return true;
    }
    public boolean sacar(){
        boolean exito = true;
        if(this.frente == null){
            // la cola esta vacia
            exito = false;
            
        }else{
            // al menos hay un elemento
            // quita el primer elmento y actualiza frente (y fin si queda vacia)
            this.frente = this.frente.getEnlace();
            if(this.frente == null){
                this.fin = null;
            }
        }
        return exito;
    }
    public void vaciar(){
        frente= null;
        fin = null;
    }
    public boolean esVacia(){
       return this.frente==null  ;
    }
    public String toString(){
         String s = "";
        NodoNodoArbol aux = this.frente;
        while( aux!= null){
            s += aux.getElem()+ ", ";
            aux = aux.getEnlace();
        }
        return s;
    }
     public NodoArbol obtenerFrente(){
        NodoArbol elemn;
        if(this.frente== null){
            elemn = null;
        }else{
            elemn = this.frente.getElem();
        }
        return elemn;
    }
}
    