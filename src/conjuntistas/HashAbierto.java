/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;
import utiles.FuncionesHash;
/**
 *
 * @author rickybauch
 */
public class HashAbierto {
   private final int TAM = 20;
   private  NodoHash[] tabla;
   private  int cant = 0;
   
   public HashAbierto(){
       tabla = new NodoHash[TAM];
       cant = 0;
   }
   public boolean insertar(int elem){
       int pos = FuncionesHash.fCuadrado(elem) % this.TAM;
       // primero verifica si el elemento ya esta cargado
       boolean encontrado = this.pertenece(elem);
       //si no lo encuentra , lo pone adelante del resto
       if(!encontrado){
           this.tabla[pos] = new NodoHash(elem,this.tabla[pos]);
           this.cant++;
       }
       return !encontrado;
   }
       public boolean pertenece(int elem) {
        boolean res = false;

        int pos = FuncionesHash.fCuadrado(elem) % TAM;
        NodoHash aux = tabla[pos];

        while (aux != null && !res) {
            if (aux.getElem() == elem) {
                res = true;
            } else {
                aux = aux.getEnlace();
            }
        }

        return res;
    }          
}
