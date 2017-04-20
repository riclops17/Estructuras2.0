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
public class PilaInt {
   private NodoInt tope;
   
   public PilaInt(){
       this.tope = null;
   }
   public boolean apilar(int nElem){
       // crea un nuevo nodo con el elemento apuntando al tope actual
       NodoInt n = new NodoInt(nElem,this.tope);
       //actualiza el tope para q apunte al nuevo nodo 
       this.tope = n;
       return true;
               
   }
   public boolean desapilar(){
       boolean res;
       if(this.tope == null){
           res = false;
       }else{
           this.tope = tope.getEnlace();
           res = true;
       }
       return res;
   }
   public int obtenerTope(){
       int elem;
       if(this.tope == null){
       elem = -1;
       }else{
       elem = this.tope.getElem();
   }
       return elem;
   }
   public void vaciar(){
       this.tope = null;
   }
   public boolean esVacia(){
       return this.tope == null;
   }
   public String toString(){
       String s = "";
       //se ubica al principio de la estrucutra
       NodoInt aux = this.tope;
       if(this.tope == null ){
           s = "Pila Vacia";                 
       }else{
           s = "[";
           while(aux != null){
               //agrega el elemento al String
               s += aux.getElem();
               //avanza al siguiente nodo
               aux = aux.getEnlace();
               if (aux != null){
                   s += ",";
               }
           }
           s += "]";
       }
       return s;
   }
   public PilaInt clonar(){
     PilaInt clon = new PilaInt();
     if(this.tope != null){
         clon.tope = new NodoInt(this.tope.getElem(),clonarAux(this.tope.getEnlace()));
     }
     return clon;
   }
     private NodoInt clonarAux(NodoInt n){
         NodoInt res;
         if(n == null){
             res = null;
     }else{
             res = new NodoInt((n.getElem()), clonarAux(n.getEnlace()));
             
         }
         return res;
   }
   
}
