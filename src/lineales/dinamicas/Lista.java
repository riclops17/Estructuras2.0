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
public class Lista {
     private Nodo cabecera;
    private int longitud;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public boolean insertar(Object nElem, int pos) {
        boolean res = true;
        int i = 1;
        if (pos < 1 || pos > this.longitud + 1) {
            res = false;
        } else {
            if (pos == 1) {
                // cre un nuevo nodo y se enlaza en la cabecera
                this.cabecera = new Nodo(nElem, this.cabecera);
            } else {
                Nodo aux = this.cabecera;
                // avanza hasta el elemento pos -1
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;

                }
                Nodo nuevo = new Nodo(nElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            this.longitud++;
        }
        return res;
    }

    public boolean eliminar(int pos) {
        // corregir
        boolean res = true;
        if (pos < 1 || pos > this.longitud) {
            res = false;
        } else {
           
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                int i = 1;
                Nodo aux = this.cabecera;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud--;
            
        }

        return res;
    }

    public Object recuperar(int pos) {
        Object r = Integer.MIN_VALUE;
        boolean res = true;
        int i = 1;
        if (pos >= 1 && pos <= this.longitud) {
            Nodo aux = this.cabecera;
            while (aux != null && res) {
                if (i == pos) {
                    res = false;
                    r = aux.getElem();
                } else {
                    aux = aux.getEnlace();
                    i++;
                }

            }

        }
        return r;

    }

    public int localizar(Object elem) {
        Nodo aux = this.cabecera;
        boolean res = true;
        int i = 1;
        while (aux != null && res) {
            if (aux.getElem().equals(elem)) {
                res = false;
            } else {
                aux = aux.getEnlace();
                i++;
            }

        }
        if (res == true) {
            i = -1;
        }
        return i;
    }

    public String toString() {

        String s = "";
        //se ubica al principio de la estrucutra
        Nodo aux = this.cabecera;
        if (this.cabecera == null) {
            s = "lista vacia";
        } else {
            s = "[";
            while (aux != null) {
                //agrega el elemento al String
                s += aux.getElem();
                //avanza al siguiente nodo
                aux = aux.getEnlace();
                if (aux != null) {
                    s += ",";
                }
            }
            s += "]";
        }
        return s;
    }

    public boolean esVacia(){
        return this.cabecera == null;
    }


   
    

    public void insertarPromedio() {
        Nodo aux = this.cabecera;
        int p = 0;
        int i = 0;
        int prom;
        if (aux == null) {
            this.cabecera = new Nodo(0, null);
        } else {
            while (aux.getEnlace() != null) {
                p = p  +(int) aux.getElem();
                i++;
                aux = aux.getEnlace();
            }
            p = p + (int)aux.getElem();
            prom = (p / i);
            Nodo n = new Nodo(prom, null);
            aux.setEnlace(n);
        }
        this.longitud++;

    }
    public Lista clonar(){
     Lista clon = new Lista();
     if(this.cabecera != null){
         clon.cabecera = new Nodo(this.cabecera.getElem(),clonarAux(this.cabecera.getEnlace()));
         clon.longitud = this.longitud;
     }
     return clon;
   }
     private Nodo clonarAux(Nodo n){
         Nodo res;
         if(n == null){
             res = null;
     }else{
             res = new Nodo((n.getElem()), clonarAux(n.getEnlace()));
             
         }
         return res;
   }
    
    
   private boolean esPrimo(int num){
      int i = 2;
      boolean res = true;
      if( num == 1 ){
          res = false;
      }
      while(i  < num && res){
          if(num % i == 0){
             res = false;
          }
          i++;
      }
      return res;
   }
  
   
}

