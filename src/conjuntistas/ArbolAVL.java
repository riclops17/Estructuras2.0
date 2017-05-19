/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author rickybauch
 */
public class ArbolAVL {
    private NodoAVL raiz;
    
    public ArbolAVL(){
        this.raiz = null;
    }
    public NodoAVL rotarIzquierda(NodoAVL r){
        NodoAVL h;
        NodoAVL temp;
        h = r.getDer();
        temp = r.getIzq();
        h.setIzq(r);
        r.setDer(temp);
        // actualizo las alturas
        r.recalcularAltura();
        h.recalcularAltura();
        
        return h;  
    }
    public NodoAVL rotarDerecha(NodoAVL r){
        NodoAVL h;
        NodoAVL temp;
        h = r.getIzq();
        temp = r.getDer();
        h.setDer(r);
        r.setIzq(temp);
        r.recalcularAltura();
        h.recalcularAltura();
        
        return h;
    }
   
    public boolean insertar(int elem) {
        boolean res = true;
        if (this.raiz == null) {
            this.raiz = new NodoAVL(elem);
        } else {
            res = insertarAux(this.raiz, elem);
        }
        return res;
    }

    private boolean insertarAux(NodoAVL n, int elem) {
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
                    n.setIzq(new NodoAVL(elem));
                }
            } else {
                // elemento mayor que n.getElem
                // si tiene Hijo derecho baja a la derecha , sino agrega el elemento
                if (n.getDer() != null) {
                    res = insertarAux(n.getDer(), elem);
                } else {
                    n.setDer(new NodoAVL(elem));
                }

            }
        }
        return res;
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

    private String stringAux(NodoAVL n) {
        String s = "["+ n.getAltura()+"] " + n.getElem();
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
}
