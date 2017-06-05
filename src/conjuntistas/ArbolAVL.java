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
                                NodoAVL aux = this.raiz.getIzq();
                                this.raiz = this.raiz.getDer();
                                this.raiz.setIzq(aux);
                            } else {
                                NodoAVL aux2 = this.raiz.getDer();
                                NodoAVL aux3 = this.raiz.getDer();
                                NodoAVL auxHijoIzq = this.raiz.getIzq();
                                NodoAVL auxHijoIzqDer = null;
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
            NodoAVL n = obtenerNodoPadre(this.raiz, elem);
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
    
    
     private NodoAVL obtenerNodoPadre(NodoAVL n, int elem) {
        NodoAVL res = null;
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
     private void eliminarPorLaIzquierda(NodoAVL n) {
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
                                    NodoAVL hijoIcand = n.getIzq().getIzq();
                                    NodoAVL hijoDcand = n.getIzq().getDer();
                                    n.setIzq(hijoDcand);
                                    hijoDcand.setIzq(hijoIcand);
                                } else {
                                    // caso particular 2   
                                    NodoAVL candidato = n.getIzq().getDer();
                                    NodoAVL hijoIzqOriginal = n.getIzq().getIzq();
                                    NodoAVL hijoDerOriginal = n.getIzq().getDer();
                                    NodoAVL hijoDerCandidato = null;
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
       private void eliminarPorLaDerecha(NodoAVL n) {
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
                                NodoAVL hijoICandidato = n.getDer().getIzq();
                                NodoAVL hijoDCandidato = n.getDer().getDer();
                                n.setDer(hijoDCandidato);
                                hijoDCandidato.setIzq(hijoICandidato);

                            } else {
                                // caso particular 2
                                NodoAVL candidato = n.getDer().getDer();
                                NodoAVL hijoIzqOriginal = n.getDer().getIzq();
                                NodoAVL hijoDerOriginal = n.getDer().getDer();
                                NodoAVL hijoDerCandidato = null;
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
}
     

