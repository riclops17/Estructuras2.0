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
        listarRangoAux2(this.raiz, elemMinimo, elemMaximo, l1);
        return l1;
    }

    private void listarRangoAux2(NodoArbol n, int elemMinimo, int elemMaximo, ListaInt l1) {
        if(n !=null){
            
        if (n.getElem() > elemMinimo) {
            listarRangoAux2(n.getIzq(), elemMinimo, elemMaximo, l1);
        }
        if (n.getElem() >= elemMinimo && n.getElem() <= elemMaximo) {
            l1.insertar(n.getElem(), l1.longitud() + 1);
        }
        if (n.getElem() < elemMaximo) {
            listarRangoAux2(n.getDer(), elemMinimo, elemMaximo, l1);
        }
        
        }

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
        int res = -1;
        if (n != null) {
            while (n.getIzq() != null) {
                n = n.getIzq();
            }
            res = n.getElem();
        }
        return  res;
    }

    public int maximoElem() {
        return maximoElemAux(this.raiz);
    }

    private int maximoElemAux(NodoArbol n) {
        int res = -1;
        if (n != null) {
            while (n.getDer() != null) {
                n = n.getDer();
            }
            res = n.getElem();
        }
        return res;
    }

    public void eliminarMinimoElem() {
        eliminarMinimoElemAux(this.raiz);
    }

    private void eliminarMinimoElemAux(NodoArbol n) {
        NodoArbol aux = null;
        if (n != null) {
            while (n.getIzq().getIzq() != null) {
                n = n.getIzq();
            }
            if (n.getIzq().getDer() != null) {
                aux = n.getIzq().getDer();
            }
            n.setIzq(aux);
        }
    }

    public void eliminar(int elem) {
        if (this.raiz.getElem() == elem) {
            if (this.raiz.getIzq() == null && this.raiz.getDer() == null) {
                this.raiz = null;
            } else {
                if (this.raiz.getDer() == null) {
                    this.raiz = this.raiz.getIzq();
                } else {
                    if (this.raiz.getIzq() == null) {
                        this.raiz = this.raiz.getDer();
                    } else {
                        if (this.raiz.getIzq() != null && this.raiz.getDer() != null) {
                            if (this.raiz.getDer().getIzq() == null) {
                                NodoArbol aux = this.raiz.getIzq();
                                this.raiz = this.raiz.getDer();
                                this.raiz.setIzq(aux);
                            } else {
                                NodoArbol aux2 = this.raiz.getDer();
                                NodoArbol aux3 = this.raiz.getDer();
                                NodoArbol auxHijoIzq = this.raiz.getIzq();
                                NodoArbol auxHijoIzqDer = null;
                                while (aux2.getIzq() != null) {
                                    aux2 = aux2.getIzq();
                                }
                                if (aux2.getDer() != null) {
                                    auxHijoIzqDer = aux2.getDer();
                                }
                                this.raiz = aux2;
                                aux2.setDer(aux3);
                                aux2.setIzq(auxHijoIzq);
                                aux2.getDer().setIzq(auxHijoIzqDer);

                            }
                        }

                    }
                }

            }
        } else {
            NodoArbol n = obtenerNodoPadre(this.raiz, elem);
            if (n != null) {
                if (n.getIzq() != null && n.getIzq().getElem() == elem) {
                    eliminarPorLaIzquierda(n);
                } else {
                    if (n.getDer() != null && n.getDer().getElem() == elem) {
                        eliminarPorLaDerecha(n);
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

    private void eliminarPorLaIzquierda(NodoArbol n) {
        if (n != null) {
            // si esta en el izquierda
            //caso1
            if (n.getIzq().getIzq() == null && n.getIzq().getDer() == null) {
                n.setIzq(null);
            } else {
                if (n.getIzq().getIzq() != null && n.getIzq().getDer() == null) {
                    n.setIzq(n.getIzq().getIzq());
                } else {
                    if (n.getIzq().getDer() != null && n.getIzq().getIzq() == null) {
                        n.setIzq(n.getIzq().getDer());
                    } else {
                        if (n.getIzq().getDer() != null && n.getIzq().getIzq() == null) {
                            n.setIzq(n.getIzq().getDer());
                        } else {
                            if (n.getIzq().getIzq() != null && n.getIzq().getDer() != null) {
                                // caso particular  1           
                                if (n.getIzq().getIzq().getIzq() == null && n.getIzq().getDer().getDer() == null) {
                                    NodoArbol hijoIcand = n.getIzq().getIzq();
                                    NodoArbol hijoDcand = n.getIzq().getDer();
                                    n.setIzq(hijoDcand);
                                    hijoDcand.setIzq(hijoIcand);
                                } else {
                                    // caso particular 2   
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
                    }
                }
                // caso 2 

                // caso 3
            }

        }
    }

    private void eliminarPorLaDerecha(NodoArbol n) {
        if (n != null) {
            if (n.getDer().getIzq() == null && n.getDer().getDer() == null) {
                n.setDer(null);
            } else {
                //caso2
                if (n.getDer().getIzq() != null && n.getDer().getDer() == null) {
                    n.setDer(n.getDer().getIzq());
                } else {
                    if (n.getDer().getIzq() == null && n.getDer().getDer() != null) {
                        n.setDer(n.getDer().getDer());
                    } else {
                        if (n.getDer().getIzq() != null && n.getDer().getDer() != null) {
                            // caso particular 1
                            if (n.getDer().getDer().getIzq() == null && n.getDer().getDer().getDer() == null) {
                                NodoArbol hijoICandidato = n.getDer().getIzq();
                                NodoArbol hijoDCandidato = n.getDer().getDer();
                                n.setDer(hijoDCandidato);
                                hijoDCandidato.setIzq(hijoICandidato);

                            } else {
                                // caso particular 2
                                NodoArbol candidato = n.getDer().getDer();
                                NodoArbol hijoIzqOriginal = n.getDer().getIzq();
                                NodoArbol hijoDerOriginal = n.getDer().getDer();
                                NodoArbol hijoDerCandidato = null;
                                while (candidato.getIzq() != null) {
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
            // caso 2

            // caso 3
        }
    }

    public boolean pertenece(int elem) {
        boolean res = false;
        NodoArbol aux = this.raiz;
        while (aux != null && res == false) {
            if (aux.getElem() == elem) {
                res = true;
            } else {
                if (aux.getElem() < elem) {
                    aux = aux.getDer();
                } else {
                    aux = aux.getIzq();
                }
            }
        }
        return res;
    }
    public ArbolBB clonarParteInvertida(int elem){
        ArbolBB c = new ArbolBB();
        c.raiz = clonarInvertidoAux(obtenerNodo(this.raiz,elem));
        return c;
    }
    private NodoArbol clonarInvertidoAux(NodoArbol n){
        NodoArbol nClon = null;
        if(n != null){
            
                nClon = new NodoArbol(n.getElem());
                nClon.setIzq(clonarInvertidoAux(n.getDer()));
                nClon.setDer(clonarInvertidoAux(n.getIzq()));
            }
        
        return nClon;
    }
    private NodoArbol obtenerNodo(NodoArbol n,int elem){
        NodoArbol res = null;
        if(n != null){
            if(n.getElem() == elem){
                res = n;
            }else{
                res = obtenerNodo(n.getIzq(),elem);
                if(res == null){
                    res = obtenerNodo(n.getDer(),elem);
                }
            }
        }
        return res;
    }

}
