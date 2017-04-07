/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.ColaInt;
import lineales.dinamicas.PilaInt;
/**
 *
 * @author rickybauch
 */
public class Practica1Parcial {
    public static void main(String[] args) {
        ColaInt c1 = new ColaInt();
        PilaInt p1 = new PilaInt();
        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);
        p1.apilar(4);
        p1.apilar(5);
        p1.apilar(4);
        p1.apilar(3);
        p1.apilar(2);
        p1.apilar(1);
        System.out.println(esSimetrica(p1,5));
        c1.poner(1);
        c1.poner(2);
        c1.poner(0);
        c1.poner(3);
        c1.poner(0);
        c1.poner(4);
        c1.poner(5);
        c1.poner(6);
       // System.out.println(generar(c1).toString());
    }
    public static ColaInt generar(ColaInt c1){
        ColaInt c3 = new ColaInt();
        ColaInt c2 = new ColaInt();
        PilaInt p = new PilaInt();
        
    while(!c1.esVacia()) {
           
      while(!c1.esVacia() && c1.obtenerFrente() != 0){
            p.apilar(c1.obtenerFrente());
            c3.poner(c1.obtenerFrente());
            c2.poner(c1.obtenerFrente());
            c1.sacar();
            
        }
      while(!p.esVacia()){
          c2.poner(p.obtenerTope());
          p.desapilar();
                  
      }
      while(!c3.esVacia()){
          c2.poner(c3.obtenerFrente());
          c3.sacar();
      }
      c1.sacar();
      c2.poner(0);
    }
       
     return c2;   
    }
    public static boolean esSimetrica(PilaInt p1 , int elem){
        PilaInt pAux = new PilaInt();
        boolean res = true ;
        
        while(!p1.esVacia() && p1.obtenerTope()!= elem){
            pAux.apilar(p1.obtenerTope());
            p1.desapilar();
            
    
        }
        if(p1.esVacia()){
            res = false;
        }
        if(res){
        p1.desapilar();
        
            while(!p1.esVacia() && res){
                if(p1.obtenerTope() == pAux.obtenerTope()){
                    res = true;
                }else{
                    res = false;
                }
                p1.desapilar();
                pAux.desapilar();
            }
        }
        
        return res;
    }
}
