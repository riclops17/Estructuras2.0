/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.ColaInt;
import lineales.dinamicas.PilaInt;
import lineales.dinamicas.ListaInt;
/**
 *
 * @author rickybauch
 */
public class Practica1Parcial {
    public static void main(String[] args) {
        ColaInt c1 = new ColaInt();
        PilaInt p1 = new PilaInt();
        PilaInt p2 = new PilaInt();
        ListaInt l1 = new ListaInt();
        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);
        p1.apilar(4);
        p1.apilar(5);
        p1.apilar(4);
        p1.apilar(3);
        p1.apilar(2);
        p1.apilar(1);
        //System.out.println(esSimetrica(p2,5));
        c1.poner(1);
        c1.poner(2);
        c1.poner(3);
        c1.poner(4);
        c1.poner(5);
        c1.poner(6);
        c1.poner(8);
        c1.poner(9);
        
        System.out.println(generar2(c1,3).toString());
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
        
        
        return res;
    }
    public static ListaInt generar2(ColaInt q , int k){
        ListaInt l1 = new ListaInt();
        ColaInt c2 = new ColaInt();
        PilaInt p = new PilaInt();
        int i = 1;
        while( !q.esVacia()){
            i = 1;
            while(i <= k && !q.esVacia()){
               l1.insertar(q.obtenerFrente(), l1.longitud() +1);
                c2.poner(q.obtenerFrente());
                p.apilar(q.obtenerFrente());
                q.sacar();
                i++;
            }
            while(!c2.esVacia()){
                
                l1.insertar(c2.obtenerFrente(), l1.longitud() + 1);
                c2.sacar();
            }
            while(!p.esVacia()){
                l1.insertar(p.obtenerTope(), l1.longitud() + 1);
                p.desapilar();
            }
            l1.insertar(0, l1.longitud() +1);
            
        }
        return l1;
        
    }
}
