/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

import lineales.dinamicas.ListaInt;

/**
 *
 * @author rickybauch
 */
public class ArbolBB {

    private NodoArbol raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(int elem) {
        boolean res = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(elem);
        } else {
            res = insertarAux(this.raiz, elem);
        }
        return res;
    }

    private boolean insertarAux(NodoArbol n, int elem) {
        // precondicion: n no es nulo
        boolean res = true;
        if ((n.getElem() == elem)) {
            // elemento repetido
            res = false;
        } else {
            if (n.getElem() > elem) {
                // elemento es menor a n.getElem
                // si tiene hijo izquierdo baja a la izq , sino agrega el elemento
                if (n.getIzq() != null) {
                    res = insertarAux(n.getIzq(), elem);
                } else {
                    n.setIzq(new NodoArbol(elem));
                }
            } else {
                // elemento mayor que n.getElem
                // si tiene Hijo derecho baja a la derecha , sino agrega el elemento
                if (n.getDer() != null) {
                    res = insertarAux(n.getDer(), elem);
                } else {
                    n.setDer(new NodoArbol(elem));
                }

            }
        }
        return res;
    }

    public ListaInt listar() {
        ListaInt l1 = new ListaInt();
        listarAux(this.raiz, l1);
        return l1;
    }

    public void listarAux(NodoArbol n, ListaInt l1) {
        if (n != null) {
            listarAux(n.getIzq(), l1);
            l1.insertar(n.getElem(), l1.longitud() + 1);
            listarAux(n.getDer(), l1);
        }

    }

    public ListaInt listarRango(int elemMinimo, int elemMaximo) {
        ListaInt l1 = new ListaInt();
        listarRangoAux(this.raiz, elemMinimo, elemMaximo, l1);
        return l1;
    }

    private void listarRangoAux(NodoArbol n, int elemMinimo, int elemMaximo, ListaInt l1) {
        if (n != null) {
            listarRangoAux(n.getIzq(), elemMinimo, elemMaximo, l1);
            if (n.getElem() >= elemMinimo && n.getElem() <= elemMaximo) {
                l1.insertar(n.getElem(), l1.longitud() + 1);
            }
            listarRangoAux(n.getDer(), elemMinimo, elemMaximo, l1);
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
            s = s + " - HI: " + n.getIzq().getElem();

        } else {
            s = s + " - HI: #";
        }
        if (n.getDer() != null) {
            s = s + " - HD: " + n.getDer().getElem() + "\n";

        } else {
            s = s + " - HD: #" + "\n";
        }

        if (n.getIzq() != null) {
            s += stringAux(n.getIzq());
        }
        if (n.getDer() != null) {
            s += stringAux(n.getDer());

        }
        return s;
    }

    public int minimoElem() {
        return minimoElemAux(this.raiz);
    }

    private int minimoElemAux(NodoArbol n) {
        int res;
        if (n != null) {
            while (n.getIzq() != null) {
                n = n.getIzq();
            }
        }
        return n.getElem();
    }

    public int maximoElem() {
        return maximoElemAux(this.raiz);
    }

    private int maximoElemAux(NodoArbol n) {
        if (n != null) {
            while (n.getDer() != null) {
                n = n.getDer();
            }
        }
        return n.getElem();
    }

    public void eliminarMinimoElem() {
        eliminarMinimoElemAux(this.raiz);
    }

    private void eliminarMinimoElemAux(NodoArbol n) {
        if (n != null) {
            while (n.getIzq().getIzq() != null) {
                n = n.getIzq();
            }
            n.setIzq(null);
        }
    }

    public void eliminar(int elem) {
        NodoArbol n = obtenerNodoPadre(this.raiz, elem);
         if (n != null) {
             // si esta en el izquierdo
            if (n.getIzq().getElem() == elem) {
                //caso1
                if (n.getIzq().getIzq() == null && n.getIzq().getDer() == null) {
                    n.setIzq(null);
                } 
                // caso 2 
                if (n.getIzq().getIzq() != null && n.getIzq().getDer() == null) {
                        n.setIzq(n.getIzq().getIzq());
                    }
                if (n.getIzq().getDer() != null && n.getIzq().getIzq() == null) {
                    n.setIzq(n.getIzq().getDer());
                    }
                // caso 3
                if (n.getIzq().getIzq() != null && n.getIzq().getDer() != null) {
                               
                if(n.getIzq().getIzq().getIzq() == null && n.getIzq().getDer().getDer() == null){
                     NodoArbol hijoIcand = n.getIzq().getIzq();
                     NodoArbol hijoDcand = n.getIzq().getDer();
                     n.setIzq(hijoDcand);
                      hijoDcand.setIzq(hijoIcand);
                    }else{
                         
                     NodoArbol candidato = n.getIzq().getDer();
                     NodoArbol hijoIzqOriginal = n.getIzq().getIzq();
                     NodoArbol hijoDerOriginal = n.getIzq().getDer();
                     NodoArbol hijoDerCandidato = null;
                     while (candidato.getIzq() != null) {
                        candidato = candidato.getIzq();
                         }
                         if (candidato.getDer() != null) {
                            hijoDerCandidato = candidato.getDer();
                          }
                            n.setIzq(candidato);
                            candidato.setIzq(hijoIzqOriginal);
                            candidato.setDer(hijoDerOriginal);
                            hijoDerOriginal.setIzq(hijoDerCandidato);
                            }
                        }

                    }
                
            
         // si esta en el derecho
        if(n.getDer().getElem() == elem){
           // caso 1
           if(n.getDer().getIzq() == null && n.getDer().getIzq() == null ){
               n.setDer(null);
           }
           // caso 2
           if(n.getDer().getIzq() != null && n.getDer().getDer() == null){
               n.setDer(n.getDer().getIzq());
           }
           if(n.getDer().getIzq() == null && n.getDer().getDer() != null){
               n.setDer(n.getDer().getDer());
           }
           // caso 3
           if(n.getDer().getIzq() != null && n.getDer().getIzq() != null){
                if(n.getDer().getIzq().getIzq() == null && n.getDer().getDer().getDer() == null){
                    NodoArbol hijoICandidato = n.getDer().getIzq();
                    NodoArbol hijoDCandidato = n.getDer().getDer();
                    n.setDer(hijoDCandidato);
                    hijoDCandidato.setIzq(hijoICandidato);
                    
                }else{
                    NodoArbol candidato = n.getDer().getDer();
                    NodoArbol hijoIzqOriginal = n.getDer().getIzq();
                    NodoArbol hijoDerOriginal = n.getDer().getDer();
                    NodoArbol hijoDerCandidato = null;
                    while(candidato.getIzq() != null){
                        candidato = candidato.getIzq();
                    }
                    if (candidato.getDer() != null) {
                     hijoDerCandidato = candidato.getDer();
                    }
                    n.setDer(candidato);
                    candidato.setIzq(hijoIzqOriginal);
                    candidato.setDer(hijoDerOriginal);
                    hijoDerOriginal.setIzq(hijoDerCandidato);
                }
                   
            }
            
            
        } 
    }
 }
    
    

    private NodoArbol obtenerNodoPadre(NodoArbol n, int elem) {
        NodoArbol res = null;
        if (n != null) {
            if (n.getIzq() != null && n.getIzq().getElem() == elem || n.getDer() != null && n.getDer().getElem() == elem) {
                res = n;
            } else {
                res = obtenerNodoPadre(n.getIzq(), elem);
                if (res == null) {
                    res = obtenerNodoPadre(n.getDer(), elem);
                }
            }
        }
        return res;
    }

}
