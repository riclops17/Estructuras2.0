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
public class ColaInt {
    private NodoInt frente;
    private NodoInt fin;
    
    public ColaInt(){
        this.frente = null;
        this.fin = null;
    }
    public boolean poner(int elem){
        NodoInt n = new NodoInt(elem,null);
       if(this.fin != null){
           this.fin.setEnlace(n);
       }else{
           this.frente = n;
       }
       this.fin = n;
       return true;
    }
    public boolean sacar(){
        boolean res = true ;
        if(this.frente == null){
            // la cola esta vacia
            res = false;
        }else{
            //quita el primer elemento y actualiza frente ( y fin si queda vacia)
            this.frente = this.frente.getEnlace();
            if ( this.frente == null){
                this.fin = null;
            }
        }
        return res;
    }
    public int obtenerFrente(){
        int res;
        if(this.esVacia()){
            res = -1;
            
        }else{
            res = this.frente.getElem();
        }
        return res;
    }
    public boolean esVacia(){
        return this.frente == null;
    }
    public void vaciar(){
        this.frente = null;
        this.fin = null;
    }
    public String toString(){
        
        String s = "";
       //se ubica al principio de la estrucutra
       NodoInt aux = this.frente;
       if(this.frente == null ){
           s = "cola vacia";                 
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
     public ColaInt clonar(){
     ColaInt clon = new ColaInt();
     if(this.frente != null){
         clon.frente = new NodoInt(this.frente.getElem(),clonarAux(this.frente.getEnlace()));
     }
     return clon;
   }
     private NodoInt clonarAux(NodoInt aux){
         NodoInt aux2;
         if(aux == null){
             aux2 = null;
     }else{
             aux2 = new NodoInt((aux.getElem()), clonarAux(aux.getEnlace()));
             
         }
         return aux2;
   }
    
}
