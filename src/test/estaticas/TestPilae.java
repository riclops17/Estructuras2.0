/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.estaticas;
import lineales.estaticas.PilaInt;
/**
 *
 * @author rickybauch
 */
public class TestPilae {
    public static void main(String[] args) {
        boolean res1 = true;
        PilaInt pila = new PilaInt();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
         System.out.println(pila.toString());
        res1 = esCapicua(pila);
        if(res1){
            System.out.println("el numero es capicua");
        }else{
            System.out.println("no es capicua");
        }
        System.out.println(pila.toString());
      
    }
    public static boolean esCapicua (PilaInt pila){
        boolean res = true;
        PilaInt pilaAux = new PilaInt();
        PilaInt clon = new PilaInt();
        clon = pila.clonar();
        while(!pila.esVacia() ){
            pilaAux.apilar(pila.obtenerTope());
            pila.desapilar();
        }
        while(!pilaAux.esVacia() && res){
            if(pilaAux.obtenerTope() != clon.obtenerTope()){
              res = false;    
            }
            pilaAux.desapilar();
            clon.desapilar();
        }
        return res;
    }
}
