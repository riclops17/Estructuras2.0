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
        temp = h.getIzq();
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
        temp = h.getDer();
        h.setDer(r);
        r.setIzq(temp);
        r.recalcularAltura();
        h.recalcularAltura();
        
        return h;
    }
    private int balance( NodoAVL n){
        int res;
        if(n.getIzq() != null && n.getDer() != null){
            res = n.getIzq().getAltura() - n.getDer().getAltura();
        }else{
            if(n.getIzq() == null ){
                res = -1 - n.getDer().getAltura();
            }else{
                res = n.getIzq().getAltura() +1;
            }
        }
      return  res;
    }
   
    public boolean insertar(int elem) {
        boolean res = true;
        if (this.raiz == null) {
            this.raiz = new NodoAVL(elem);
        } else {
            res = insertarAux(this.raiz, elem , null);
        }
        return res;
    }

    private boolean insertarAux(NodoAVL n, int elem, NodoAVL padre) {
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
                    
                    res = insertarAux(n.getIzq(), elem,padre);
                    n.recalcularAltura();
                   
                } else {
                    n.setIzq(new NodoAVL(elem));
                    n.recalcularAltura();
                }
            } else {
                // elemento mayor que n.getElem
                // si tiene Hijo derecho baja a la derecha , sino agrega el elemento
                if (n.getDer() != null) {
                    res = insertarAux(n.getDer(), elem,padre);
                    n.recalcularAltura();
                    
                } else {
                    n.setDer(new NodoAVL(elem));
                    n.recalcularAltura();
                }

            }
            balancear(n,padre);
        }
        return res;
    }
    private boolean balancear(NodoAVL n, NodoAVL padre) {
        boolean res = false;
        if (n != null) {
            int bn = balance(n);
            if (bn == 2) {
                int bi = balance(n.getIzq());
                if (bi >= 0) {
                    System.out.println("rotacion simple a derecha");
                    if (padre == null) {
                        this.raiz = rotarDerecha(n);
                    } else {
                        if (padre.getIzq() == n) {
                            padre.setIzq(rotarDerecha(n));
                        } else {
                            if (padre.getDer() == n) {
                                padre.setDer(rotarDerecha(n));
                            }
                        }
                    }
                } else {
                    if (bi == -1) {
                        System.out.println("rotacion doble izquierda - derecha");
                        n.setIzq(rotarIzquierda(n.getIzq()));
                        if (padre == null) {
                            this.raiz = rotarDerecha(n);
                        } else {
                            padre.setIzq(rotarDerecha(n));
                        }
                    }
                }
            } else {
                if (bn == -2) {
                    int bd = balance(n.getDer());
                    if (bd <= 0) {
                        System.out.println("rotacion simple a izquierda");
                        if (padre == null) {
                            this.raiz = rotarIzquierda(n);
                        } else {
                            if (padre.getIzq() == n) {
                                padre.setIzq(rotarIzquierda(n));
                            } else {
                                if (padre.getDer() == n) {
                                    padre.setDer(rotarIzquierda(n));
                                }
                            }
                        }
                    } else {
                        if (bd == 1) {
                            System.out.println("rotacion doble derecha -izquierda");
                            n.setDer(rotarDerecha(n.getDer()));
                            if (padre == null) {
                                this.raiz = rotarIzquierda(n);
                            } else {
                                padre.setDer(rotarIzquierda(n));
                            }
                        }
                    }
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
