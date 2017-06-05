/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.Lista;

/**
 *
 * @author rickybauch
 */
public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elem, Object elemPadre) {
        boolean res = true;
        if (this.raiz == null) {
            this.raiz = new NodoGen(elem);
        } else {
            NodoGen padre = obtenerNodo(this.raiz, elemPadre);
            if (padre != null) {
                padre.setEIzq(new NodoGen(elem, null, padre.getEIzq()));
            } else {
                res = false;
            }

        }
        return res;
    }

    private NodoGen obtenerNodo(NodoGen n, Object elem) {
        NodoGen res = null;
        if (n != null) {
            if (n.getElem().equals(elem)) {
                res = n;
            } else {
                NodoGen aux = n.getEIzq();
                while (aux != null && res == null) {
                    res = obtenerNodo(aux, elem);
                    aux = aux.getHDer();
                }
            }
        }
        return res;
    }

    public boolean pertenece(Object elem) {
        return perteneceAux(this.raiz, elem);
    }

    private boolean perteneceAux(NodoGen n, Object elem) {
        boolean res = false;
        if (n != null) {
            if (n.getElem().equals(elem)) {
                res = true;
            } else {
                NodoGen hijo = n.getEIzq();
                while (hijo != null && res == false) {
                    res = perteneceAux(hijo, elem);
                    hijo = hijo.getHDer();
                }
            }
        }
        return res;
    }

    public Object padre(Object elem) {
        return padreAux(this.raiz, elem);
    }

    private Object padreAux(NodoGen n, Object elem) {
        Object res = -1;
        if (n != null) {
            if (n.getEIzq() != null && n.getEIzq().getElem().equals(elem)) {
                res = n.getElem();
            } else {
                NodoGen hijo = n.getEIzq();
                while (hijo != null && res.equals(-1)) {
                    res = padreAux(hijo, elem);
                    hijo = hijo.getHDer();
                }
            }
        }
        return res;
    }

    public Object nivel(Object elem) {
        return nivelAux(this.raiz, elem, 0);
    }

    private Object nivelAux(NodoGen n, Object elem, int piso) {
        Object res = -1;
        if (n != null) {
            if (n.getElem() == elem) {
                res = piso;
            } else {
                NodoGen hijo = n.getEIzq();
                while (hijo != null && res.equals(-1)) {
                    res = nivelAux(hijo, elem, piso + 1);
                    hijo = hijo.getHDer();
                }
            }
        }
        return res;
    }

    public int altura() {
        return alturaAux(this.raiz);
    }

    private int alturaAux(NodoGen n) {
        int res = -1;
        if (n.getEIzq() == null) {
            res = 0;
        } else {
            NodoGen hijo = n.getEIzq();
            res = alturaAux(hijo) + 1;
            while (hijo != null && res == -1) {
                res = alturaAux(hijo);
                hijo = hijo.getHDer();
            }
        }
        return res;
    }

    public Lista listarPreorden() {
        Lista l1 = new Lista();
        listarPreordenAux(this.raiz, l1);
        return l1;
    }

    private void listarPreordenAux(NodoGen n, Lista l1) {
        if (n != null) {
            l1.insertar(n.getElem(), l1.longitud() + 1);
            NodoGen aux = n.getEIzq();
            while (aux != null) {
                listarPreordenAux(aux, l1);
                aux = aux.getHDer();

            }
        }
    }

    public Lista listarInorden() {
        Lista l1 = new Lista();
        listarInordenAux(this.raiz, l1);
        return l1;
    }

    private void listarInordenAux(NodoGen n, Lista l1) {
        if (n != null) {
            NodoGen aux = n.getEIzq();
            if (aux != null) {
                listarInordenAux(aux, l1);
            }
            l1.insertar(n.getElem(), l1.longitud() + 1);
            while (aux != null) {
                aux = aux.getHDer();
                listarInordenAux(aux, l1);
            }
        }
    }

    public Lista listarPosorden() {
        Lista l1 = new Lista();
        listarPosordenAux(this.raiz, l1);
        return l1;
    }

    private void listarPosordenAux(NodoGen n, Lista l1) {
        if (n != null) {
            NodoGen hijo = n.getEIzq();
            while (hijo != null) {
                listarPosordenAux(hijo, l1);
                hijo = hijo.getHDer();
            }
            l1.insertar(n.getElem(), l1.longitud() + 1);
        }
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null) {
            s += n.getElem() + " -> ";
            NodoGen hijo = n.getEIzq();
            while (hijo != null) {
                s += hijo.getElem() + ", ";
                hijo = hijo.getHDer();
            }
            hijo = n.getEIzq();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHDer();
            }
        }
        return s;
    }

    public Lista frontera() {
        Lista l1 = new Lista();
        fronteraAux(this.raiz, l1);
        return l1;
    }

    private void fronteraAux(NodoGen n, Lista l1) {
        if (n != null) {
            if (n.getEIzq() == null) {
                l1.insertar(n.getElem(), l1.longitud() + 1);

            }
            NodoGen hijo = n.getEIzq();
            while (hijo != null) {
                fronteraAux(hijo, l1);
                hijo = hijo.getHDer();
            }
        }
    }

    public Lista entreNiveles(int min, int max) {
        Lista l1 = new Lista();
        entreNivelesAux(this.raiz, min, max, l1, 0);
        return l1;
    }

    private void entreNivelesAux(NodoGen n, int min, int max, Lista l1, int piso) {
        if (n != null && piso <= max) {
            NodoGen hijo = n.getEIzq();
            if (hijo != null) {
                entreNivelesAux(hijo, min, max, l1, piso + 1);
            }
            if (min <= piso && max >= piso) {
                l1.insertar(n.getElem(), l1.longitud() + 1);
            }

            while (hijo != null) {
                hijo = hijo.getHDer();
                entreNivelesAux(hijo, min, max, l1, piso + 1);
            }
        }
    }

    public void eliminarEHijoIzq(int elem) {
        NodoGen n = obtenerNodoPadre(this.raiz, elem);

    }

    private NodoGen obtenerNodoPadre(NodoGen n, Object elem) {
        NodoGen res = null;
        if (n != null) {
            if (n.getEIzq() != null && n.getEIzq().getElem().equals(elem)) {
                res = n;
            } else {
                NodoGen hijo = n.getEIzq();
                while (hijo != null && res == null) {
                    res = obtenerNodoPadre(hijo, elem);
                    hijo = hijo.getHDer();
                }
            }
        }
        return res;
    }

    public Lista ancestros(Object elem) {
        Lista l1 = new Lista();
        listarAncestrosAux(this.raiz, l1, elem);
        return l1;
    }

    private void listarAncestrosAux(NodoGen n, Lista l1, Object elem) {
        if (n != null) {
            if (n.getElem().equals(elem)) {
                l1.insertar(n.getElem(), l1.longitud() + 1);
            } else {
                NodoGen hijo = n.getEIzq();
                while (hijo != null && l1.esVacia()) {
                    listarAncestrosAux(hijo, l1, elem);
                    hijo = hijo.getHDer();
                }
                if (!l1.esVacia()) {
                    l1.insertar(n.getElem(), l1.longitud() + 1);
                }
            }
        }
    }

    public Lista listarCaminoMasLargo() {
        Lista visitados = new Lista();
        Lista caminoLargo = new Lista();
        return listarCaminoMasLargoAux(this.raiz, visitados, caminoLargo);
    }

    private Lista listarCaminoMasLargoAux(NodoGen n, Lista visitados, Lista l1) {
        if (n != null) {
            visitados.insertar(n.getElem(), visitados.longitud() + 1);
            if (n.getEIzq() == null && visitados.longitud() > l1.longitud()) {
                l1 = visitados.clonar();
            }
            NodoGen hijo = n.getEIzq();
            while (hijo != null) {
                l1 = listarCaminoMasLargoAux(hijo, visitados, l1);
                hijo = hijo.getHDer();

            }
            visitados.eliminar(visitados.longitud());

        }
        return l1;
    }

    public ArbolGen clonar() {
        ArbolGen c = new ArbolGen();
        c.raiz = clonarAux(this.raiz);
        return c;
    }

    private NodoGen clonarAux(NodoGen n) {
        NodoGen nodoClon = null;
        if (n != null) {
            nodoClon = new NodoGen(n.getElem());
            nodoClon.setEIzq(clonarAux(n.getEIzq()));
            nodoClon.setHDer(clonarAux(n.getHDer()));

        }
        return nodoClon;
    }

    public boolean verificarPatron(Lista l1) {
        return verificarPatronAux2(this.raiz, l1);
    }

    private boolean verificarPatronAux(NodoGen n, Lista l1) {
        boolean res = true;
        if (n != null) {
            NodoGen hijo = n.getEIzq();
            if (hijo != null) {
                res = verificarPatronAux2(hijo, l1);
            }

            if (!l1.esVacia() && n.getElem().equals(l1.recuperar(1)) && res) {
                l1.eliminar(1);
                while (hijo != null && res) {
                    res = verificarPatronAux(hijo, l1);
                    hijo = hijo.getHDer();

                }
            } else {
                res = false;
            }
        }
        return res;
    }

    private boolean verificarPatronAux2(NodoGen n, Lista l1) {
        boolean res = false;
        if (n != null) {
            if (l1.longitud() == 1 && n.getEIzq() == null && n.getElem().equals(l1.localizar(1))) {
                res = true;
            } else {
                if (n.getElem().equals(l1.localizar(1))) {
                    res = true;
                    NodoGen hijo = n.getEIzq();
                    l1.eliminar(1);
                    while (hijo != null && res == true) {
                        res = verificarPatronAux2(hijo, l1);
                        hijo = hijo.getHDer();

                    }
                   
                }
            }
        }
        return res;
    }

    public boolean equals(ArbolGen otro) {
        return equalsAux(this.raiz, otro.raiz);
    }

    private boolean equalsAux(NodoGen n, NodoGen n2) {
        boolean res = false;
        if (n != null && n2 != null) {
            if (n.getEIzq() == null && n2.getEIzq() == null ) {
                if(n.getElem().equals(n2.getElem())){
                    res = true;
                }else{
                    res = false;
                }
                
            } else {
                NodoGen hijo = n.getEIzq();
                NodoGen hijo2 = n2.getEIzq();
                if (n.getElem().equals(n2.getElem())) {
                    res = true;

                    while (hijo != null && hijo2 != null && res == true) {
                        res = equalsAux(hijo, hijo2);
                        hijo = hijo.getHDer();
                        hijo2 = hijo2.getHDer();
                    }
                }
                    
                
            }

        }
        return res;
    }
    public boolean verificarListaInorden(Lista ls) {
	Lista copia = ls.clonar();
	boolean res = verificarListaInordenAux(raiz, copia);

	if (!copia.esVacia()) {
		res = false;
	}

	return res;
}

private boolean verificarListaInordenAux(NodoGen n, Lista ls) {
	boolean res = true;

	if (n != null) {
		NodoGen hijo = n.getEIzq();

		if (hijo != null) {
			res = verificarListaInordenAux(hijo, ls);
		}

		if (!ls.esVacia() && n.getElem().equals(ls.recuperar(1)) && res) {
			ls.eliminar(1);
			while (hijo != null && res) {
				res = verificarListaInordenAux(hijo.getHDer(), ls);
				hijo = hijo.getHDer();
			}
		} else {
			res = false;
		}
	}

	return res;
}
}
