/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.ListaInt;

/**
 *
 * @author rickybauch
 */
public class ArbolGenInt {
    private NodoGen raiz;
    
    public ArbolGenInt(){
        this.raiz = null;
    }
    public boolean insertar(int elem,int elemPadre){
        boolean res = true;
        if(this.raiz == null){
            this.raiz = new NodoGen(elem);
        }else{
            NodoGen padre = obtenerNodo(this.raiz,elemPadre);
            if(padre != null){
                padre.setEIzq(new NodoGen(elem,null,padre.getEIzq()));
            }else{
                res = false;
            }
            
        }
        return res;
    }
    private NodoGen obtenerNodo(NodoGen n, int elem){
        NodoGen res = null;
        if(n != null){
            if(n.getElem() == elem){
                res = n;
            }else{
            NodoGen aux = n.getEIzq();
            while(aux != null && res == null){
               res =obtenerNodo(aux,elem);
               aux = aux.getHDer();
            }
        }
    }
        return res;
  }
    public boolean pertenece(int elem){
        return perteneceAux(this.raiz , elem);
    }
    private boolean perteneceAux(NodoGen n,int elem){
        boolean res= false;
        if(n != null){
            if(n.getElem() == elem){
                res = true;
            }else{
                NodoGen hijo = n.getEIzq();
                while(hijo != null && res == false){
                    res = perteneceAux(hijo,elem);
                    hijo = hijo.getHDer();
                }
            }
        }
        return res;
    }
    public int padre(int elem){
        return padreAux(this.raiz,elem);
    }
    private int padreAux(NodoGen n,int elem){
        int res = -1;
        if(n != null){
            if(n.getEIzq() != null && n.getEIzq().getElem() == elem ){
                res = n.getElem();
            }else{
                NodoGen hijo = n.getEIzq();
                while(hijo != null && res == -1){
                    res = padreAux(hijo,elem);
                    hijo = hijo.getHDer();
                }
            }
        }
        return res;
    }
    public int nivel(int elem){
        return nivelAux(this.raiz,elem,0);
    }
    private int nivelAux(NodoGen n,int elem , int piso){
        int res = -1;
        if(n != null){
            if(n.getElem() == elem){
                res = piso;
            }else{
                NodoGen hijo = n.getEIzq();
                while(hijo != null && res == -1){
                     res= nivelAux(hijo,elem,piso+1);
                    hijo = hijo.getHDer();
                }
            }
        }
        return res;
    }
    public int altura(){
        return alturaAux(this.raiz);
    }
    private int alturaAux(NodoGen n){
        int res = -1;
        if(n.getEIzq() == null){
            res = 0;
        }else{
            NodoGen hijo = n.getEIzq();
             res = alturaAux(hijo) +1;
            while(hijo != null && res == -1){
                res = alturaAux(hijo) ;
                hijo = hijo.getHDer();
            }
        }
        return res;
    }
            
    public ListaInt listarPreorden(){
        ListaInt l1 = new ListaInt();
        listarPreordenAux(this.raiz,l1);
        return l1;  
    }
    private void listarPreordenAux(NodoGen n,ListaInt l1){
        if(n != null){
            l1.insertar(n.getElem(), l1.longitud()+1);
            NodoGen aux = n.getEIzq();
            while(aux != null){
                listarPreordenAux(aux,l1);
                aux= aux.getHDer();
                
            }
        }
    }
     public ListaInt listarInorden(){
        ListaInt l1 = new ListaInt();
        listarInordenAux(this.raiz,l1);
        return l1;
    }
    private void listarInordenAux(NodoGen n , ListaInt l1){
        if(n != null){
            NodoGen aux = n.getEIzq();
            if(aux != null){
                listarInordenAux(aux,l1);
            }
            l1.insertar(n.getElem(), l1.longitud() +1);
            while(aux != null){
                aux = aux.getHDer();
                listarInordenAux(aux,l1);
            }
        }
    }
    
    
    public ListaInt listarPosorden(){
        ListaInt l1 = new ListaInt();
        listarPosordenAux(this.raiz,l1);
        return l1;
    }
    private void listarPosordenAux(NodoGen n,ListaInt l1){
        if(n != null){
            NodoGen hijo = n.getEIzq();
            while(hijo != null){
                listarPosordenAux(hijo,l1);
                hijo = hijo.getHDer();
            }
            l1.insertar(n.getElem(), l1.longitud() +1);
        }
    }
    public String toString(){
        return toStringAux(this.raiz);
    }
    private String toStringAux(NodoGen n){
        String s = "";
        if(n != null){
            s += n.getElem() + " -> ";
            NodoGen hijo = n.getEIzq();
            while(hijo != null){
                s += hijo.getElem() + ", ";
                hijo = hijo.getHDer();
            }
            hijo = n.getEIzq();
            while(hijo != null){
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHDer();
            }
        }
        return s;
    }
    public ListaInt frontera(){
        ListaInt l1 = new ListaInt();
        fronteraAux(this.raiz,l1);
        return l1;
    }
    private void fronteraAux(NodoGen n,ListaInt l1){
        if(n != null){
            if(n.getEIzq() == null ){
                l1.insertar(n.getElem(), l1.longitud() +1);
                
            }
            NodoGen hijo = n.getEIzq();
            while(hijo != null){
                fronteraAux(hijo,l1);
                hijo = hijo.getHDer();
            }
        }
    }
    public ListaInt entreNiveles(int min , int max ){
        ListaInt l1 = new ListaInt();
        entreNivelesAux(this.raiz,min,max,l1,0);
        return l1;
    }
    private void entreNivelesAux(NodoGen n, int min,int max,ListaInt l1,int piso){
        if( n!= null){
            if(min <= piso && max >= piso){
                l1.insertar(n.getElem(), l1.longitud() +1);
            }
            NodoGen hijo = n.getEIzq();
            while(hijo != null){
                entreNivelesAux(hijo,min,max,l1,piso + 1);
                hijo = hijo.getHDer();
            }
        }
    }
    public void eliminarEHijoIzq(int elem){
         NodoGen e =  obtenerNodoPadre(this.raiz,elem);
         if(e.getEIzq() != null){
             e.setEIzq(e.getEIzq().getHDer());
             
         }
     }
    private NodoGen obtenerNodoPadre(NodoGen n , int elem){
        NodoGen res = null;
        if(n != null){
            if(n.getEIzq() != null && n.getEIzq().getElem() == elem){
                res = n;
            }else{
                NodoGen hijo = n.getEIzq();
                while(hijo != null && res == null){
                    res =obtenerNodoPadre(hijo,elem);
                    hijo = hijo.getHDer();
                }
            }
        }
        return res;
    }
    public ListaInt listarAncestros(int elem){
        ListaInt l1 = new ListaInt();
        listarAncestrosAux(this.raiz,l1, elem);
        return l1;
    }
    private void listarAncestrosAux(NodoGen n,ListaInt l1 , int elem){
        if(n != null){
            if(n.getElem() == elem){
                l1.insertar(n.getElem(), l1.longitud() +1);
            }else{
                NodoGen hijo = n.getEIzq();
                while(hijo != null && l1.esVacia()){
                    listarAncestrosAux(hijo,l1,elem);
                    hijo = hijo.getHDer();
                }
                if(!l1.esVacia()){
                   l1.insertar(n.getElem(), l1.longitud()+1);
                }
            }
        }
    }
    
    public ListaInt listarCaminoMasLargo(){
       ListaInt visitados = new ListaInt();
       ListaInt caminoLargo = new ListaInt();
        return listarCaminoMasLargoAux(this.raiz,visitados,caminoLargo);
    }
    private ListaInt listarCaminoMasLargoAux(NodoGen n, ListaInt visitados,ListaInt l1){
        if(n != null){
            visitados.insertar(n.getElem(), visitados.longitud()+1);
            if(n.getEIzq() == null && visitados.longitud() > l1.longitud()){
                l1 = visitados.clonar();
            }
                NodoGen hijo = n.getEIzq();
                while(hijo != null){
                    l1 = listarCaminoMasLargoAux(hijo,visitados,l1);
                    hijo = hijo.getHDer();
                   
               }
                 visitados.eliminar(visitados.longitud());
               
        }
        return l1;
    }
    public ArbolGenInt clonar(){
        ArbolGenInt c = new ArbolGenInt();
        c.raiz = clonarAux(this.raiz);
        return c;
    }
    private NodoGen clonarAux(NodoGen n){
        NodoGen nodoClon = null;
        if(n != null){
           nodoClon = new NodoGen(n.getElem());
           nodoClon.setEIzq (clonarAux(n.getEIzq()));
           nodoClon.setHDer(clonarAux(n.getHDer()));
           
       }
        return nodoClon;
    }
    public boolean verificarPatron(ListaInt l1){
        return verificarPatronAux(this.raiz,l1);
    }
    private boolean verificarPatronAux(NodoGen n ,ListaInt l1){
        boolean res = true;
       if (n != null) {
            NodoGen hijo = n.getEIzq();
            if (hijo != null) {
                res = verificarPatronAux(hijo, l1);
            }

           if (!l1.esVacia() && n.getElem()== l1.recuperar(1)&& res) {  
                l1.eliminar(1);
                while (hijo != null && res) {
                    res = verificarPatronAux(hijo.getHDer(), l1);
                    hijo = hijo.getHDer();
                }
               } else {
                res = false;
              }
        }
       return res;
    }
    public boolean equals(ArbolGenInt otro){
        return equalsAux(this.raiz,otro.raiz);
    }
    private boolean equalsAux(NodoGen n , NodoGen n2){
        boolean res = false;
        if(n!= null && n2 != null){
            if(n.getEIzq()== null && n2.getEIzq() == null && n.getElem() == n2.getElem()){
                res = true;
            }else{
                NodoGen hijo =  n.getEIzq();
                NodoGen hijo2 = n2.getEIzq();
                while(hijo != null && hijo2 != null && res == false){
                    res = equalsAux(hijo ,hijo2);
                    hijo = n.getHDer();
                    hijo2 = n.getHDer();
                }
            }
        }
        return res;
    }
    
    
    
    
    
}
