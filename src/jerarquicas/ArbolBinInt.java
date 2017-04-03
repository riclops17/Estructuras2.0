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
public class ArbolBinInt {

    private NodoArbol raiz;

    public ArbolBinInt() {
        this.raiz = null;
    }

    public boolean insertar(int elemN, int elemPadre, char lugar) {
        boolean exito = true;
        if (this.raiz == null) {
            // si el arbol esta vacio , ponemos el elemento en la raiz
            this.raiz = new NodoArbol(elemN);
        } else {
            // si no esta vacio ,se busca al padre
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzq() == null) {
                    // si el padre existe y no tiene hijo izq se lo agrega
                    nodoPadre.setIzq(new NodoArbol(elemN));
                } else {
                    if (lugar == 'D' && nodoPadre.getDer() == null) {
                        //si el padre existe y no tiene hijo der se lo agrega
                        nodoPadre.setDer(new NodoArbol(elemN));
                    } else {
                        // si el padre no existe o tiene ese hijo da error
                        exito = false;

                    }
                }

            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, int buscado) {
        // metodo privado que busca un elemento y devuelve el nodo
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem() == buscado) {
                //si el buscado es n, lo devuelve
                resultado = n;

            } else {
                // no es el buscado : primero busca en el Hi
                resultado = obtenerNodo(n.getIzq(), buscado);

                if (resultado == null) {
                    resultado = obtenerNodo(n.getDer(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public ListaInt listarPreorden() {
        ListaInt l1 = new ListaInt();
        preordenAux(this.raiz, l1);
        return l1;
    }

    private void preordenAux(NodoArbol n, ListaInt l1) {
        if (n != null) {
            l1.insertar(n.getElem(), l1.longitud() + 1);
            preordenAux(n.getIzq(), l1);
            preordenAux(n.getDer(), l1);
        }
    }

    public ListaInt listarInorden() {
        ListaInt l1 = new ListaInt();
        inordenAux(this.raiz, l1);
        return l1;
    }

    private void inordenAux(NodoArbol n, ListaInt l1) {
        if (n != null) {
            preordenAux(n.getIzq(), l1);
            l1.insertar(n.getElem(), l1.longitud() + 1);
            preordenAux(n.getDer(), l1);
        }
    }

    public ListaInt listarPosorden() {
        ListaInt l1 = new ListaInt();
        posordenAux(this.raiz, l1);
        return l1;
    }

    private void posordenAux(NodoArbol n, ListaInt l1) {
        if (n != null) {
            posordenAux(n.getIzq(), l1);
            posordenAux(n.getDer(), l1);
            l1.insertar(n.getElem(), l1.longitud() + 1);
        }
    }
    public boolean pertenece (int elem){
        return perteneceAux(this.raiz , elem);
        
    }
    private boolean perteneceAux(NodoArbol n , int elem){
        boolean res = false;
        if(n!= null){
            if(n.getElem() == elem){
                res = true;
            }else{
                res = perteneceAux(n.getIzq(),elem);
                if(!res){
                    res = perteneceAux(n.getDer(), elem);
                }
            }
            
        }
        return res;
    }

    public ListaInt frontera() {
        ListaInt l1 = new ListaInt();
        fronteraAux(this.raiz, l1);
        return l1;

    }

    private void fronteraAux(NodoArbol n, ListaInt l1) {
        if (n != null) {
            if (n.getIzq() == null && n.getDer() == null) {
                l1.insertar(n.getElem(), l1.longitud() + 1);
            }

            fronteraAux(n.getIzq(), l1);
            fronteraAux(n.getDer(), l1);
        }
    }

    public int padre(int elem) {
        int res = 0;
        if (this.raiz == null) {
            res = -1;
        } else {
            res = padreAux(this.raiz, elem);
        }
        return res;
    }

    private int padreAux(NodoArbol n, int elem) {
        int res = -1;
        if (n != null) {
            if ((n.getIzq() != null && n.getIzq().getElem() == elem) || (n.getDer() != null && n.getDer().getElem() == elem)) {
                res = n.getElem();
            } else {
                res = padreAux(n.getIzq(), elem);
                if (res == -1) {
                    res = padreAux(n.getDer(), elem);
                }
            }
        }
        return res;
    }

    public int nivel(int elem) {
        int res = 0;
        if (this.raiz == null) {
            res = -1;
            
        } else {
            res = nivelAux(this.raiz, elem);
        }
        return res;
    }

    private int nivelAux(NodoArbol n, int elem) {
        int res = -1;
        int aux = -1;
        if (n != null) {
            if (n.getElem() == elem) {
                res = 0;
            } else {
                aux = nivelAux(n.getIzq(), elem) + 1;
                if (aux == 0) {
                    aux = nivelAux(n.getDer(), elem) + 1;
                }
                if(aux == 0){
                    res = -1;
                }else{
                    res = aux;
                }
                   
            }
        }
        return res;
    }

    public int altura() {
        int res;
        if (this.raiz == null) {
            res = -1;
        } else {
            res = alturaAux(this.raiz);
        }
        return res;
    }

    private int alturaAux(NodoArbol n) {
        int alt1, alt2, res;
        if (n.getIzq() != null) {
            alt1 = alturaAux(n.getIzq()) + 1;
        } else {
            alt1 = 0;
        }
        if (n.getDer() != null) {
            alt2 = alturaAux(n.getDer()) + 1;
        } else {
            alt2 = 0;
        }
        if (alt1 > alt2) {
            res = alt1;
        } else {
            res = alt2;
        }
        return res;
    }
    public void sumarRamas(){
        sumarRamasAux(this.raiz, 0);
    }
    private void sumarRamasAux(NodoArbol n, int res){
        if(n != null){
        res = res + n.getElem();
        if(n.getIzq() == null && n.getDer() == null ){
            if(res % 2 == 0 ){
                n.setDer(new NodoArbol(res));
            }else{
                n.setIzq(new NodoArbol(res));
            }
        }else{
           
           sumarRamasAux(n.getIzq(), res);
           sumarRamasAux(n.getDer(), res);
           
        }
        
       }
        
    }
    public String toString() {
        String s = "";
        if (this.raiz != null) {
            s = stringAux(this.raiz);
        } else {
            s = "arbol vacio";
        }
        return s;

    }

    private String stringAux(NodoArbol n) {
        String s = "" + n.getElem();
        if (n.getIzq() != null) {
            s = s + "HI:" + n.getIzq().getElem();

        } else {
            s = s + "HI:#";
        }
        if (n.getDer() != null) {
            s = s + "HD:" + n.getDer().getElem() + "\n";

        } else {
            s = s + "HD:#" + "\n";
        }

        if (n.getIzq() != null) {
            s += stringAux(n.getIzq());
        }
        if (n.getDer() != null) {
            s += stringAux(n.getDer());

        }
        return s;
    }
}
