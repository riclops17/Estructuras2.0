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
    
    public ArbolBB(){
        this.raiz = null;
    }
    
    public boolean insertar(int elem){
        boolean res = true;
        if(this.raiz == null ){
            this.raiz = new NodoArbol(elem); 
        }else{
            res = insertarAux(this.raiz,elem);
        }
        return res;
    }
    private boolean insertarAux(NodoArbol n, int elem){
        // precondicion: n no es nulo
        boolean res = true;
        if((n.getElem() == elem)){
            // elemento repetido
            res = false;
        }else{
            if(n.getElem() > elem){
              // elemento es menor a n.getElem
             // si tiene hijo izquierdo baja a la izq , sino agrega el elemento
                if(n.getIzq() != null){
                    res = insertarAux(n.getIzq(),elem);
                }else{
                    n.setIzq(new NodoArbol(elem));
                }
            }else{
             // elemento mayor que n.getElem
            // si tiene Hijo derecho baja a la derecha , sino agrega el elemento
             if(n.getDer() != null){
                 res = insertarAux(n.getDer(),elem);
             }else{
                 n.setDer(new NodoArbol(elem));
              }
             
            }
        }
        return res;
    }
    public ListaInt listar(){
      ListaInt l1 = new ListaInt();
      listarAux(this.raiz,l1);
      return l1;
    }
    public void listarAux(NodoArbol n,ListaInt l1){
        if(n!= null){
            listarAux(n.getIzq(),l1);
            l1.insertar(n.getElem(), l1.longitud() +1);
            listarAux(n.getDer(),l1);
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
            s += stringAux(n.getIzq() );
        }
        if (n.getDer() != null) {
            s += stringAux(n.getDer());

        }
        return s;
    }
    
    
}
