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
public class ListaInt {

    private NodoInt cabecera;
    private int longitud;

    public ListaInt() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public boolean insertar(int nElem, int pos) {
        boolean res = true;
        int i = 1;
        if (pos < 1 || pos > this.longitud + 1) {
            res = false;
        } else {
            if (pos == 1) {
                // cre un nuevo nodo y se enlaza en la cabecera
                this.cabecera = new NodoInt(nElem, this.cabecera);
            } else {
                NodoInt aux = this.cabecera;
                // avanza hasta el elemento pos -1
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;

                }
                NodoInt nuevo = new NodoInt(nElem, aux.getEnlace());
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
                NodoInt aux = this.cabecera;
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

    public int recuperar(int pos) {
        int r = Integer.MIN_VALUE;
        boolean res = true;
        int i = 1;
        if (pos >= 1 && pos <= this.longitud) {
            NodoInt aux = this.cabecera;
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

    public int localizar(int elem) {
        NodoInt aux = this.cabecera;
        boolean res = true;
        int i = 1;
        while (aux != null && res) {
            if (aux.getElem() == elem) {
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
        NodoInt aux = this.cabecera;
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

    public void eliminarMayores(int elem) {
        // ******
       NodoInt aux = this.cabecera;
       while(aux != null &&  aux.getElem() > elem) {
            aux = aux.getEnlace();
            this.cabecera = this.cabecera.getEnlace();
            this.longitud--;
        } 
       while (aux.getEnlace() != null) {
                if (aux.getEnlace().getElem()  > elem) {
                    aux.setEnlace(aux.getEnlace().getEnlace());
                    this.longitud--;
                    
                }else{
                    
                aux = aux.getEnlace();
            }
            
        }
    }
    public void eliminarPares(){
        NodoInt aux = this.cabecera;
        while(!this.esVacia() && aux.getElem()%2 == 0 ){
            aux = aux.getEnlace();
            this.cabecera = this.cabecera.getEnlace();
            this.longitud--;
        }
        while(aux.getEnlace() != null){
            if(aux.getEnlace().getElem()%2 == 0){
                aux.setEnlace(aux.getEnlace().getEnlace());
                this.longitud--;
            }else{
                aux = aux.getEnlace();
            }
        }
    }

    public void insertarPromedio() {
        NodoInt aux = this.cabecera;
        int p = 0;
        int i = 0;
        int prom;
        if (aux == null) {
            this.cabecera = new NodoInt(0, null);
        } else {
            while (aux.getEnlace() != null) {
                p = p + aux.getElem();
                i++;
                aux = aux.getEnlace();
            }
            p = p + aux.getElem();
            prom = (p / i);
            NodoInt n = new NodoInt(prom, null);
            aux.setEnlace(n);
        }
        this.longitud++;

    }
    public ListaInt clonar(){
     ListaInt clon = new ListaInt();
     if(this.cabecera != null){
         clon.cabecera = new NodoInt(this.cabecera.getElem(),clonarAux(this.cabecera.getEnlace()));
         clon.longitud = this.longitud;
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
