/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.ListaInt;
import lineales.dinamicas.PilaInt;
import lineales.dinamicas.ColaInt;
/**
 *
 * @author rickybauch
 */
public class Testlista {
    public static void main(String[] args) {
        ListaInt l1 = new ListaInt();
        ListaInt l2 = new ListaInt();
        l1.insertar(1, 1);
        l1.insertar(2, 2);
        l1.insertar(3, 3);
        l1.insertar(4, 4);
        l1.insertar(5, 5);
        l1.insertar(6, 6);
        l1.insertar(7, 7);
        l1.insertar(8, 8);
        l1.insertar(9, 9);
        
         
        
        
       
       
        
        //System.out.println(l1.toString());
        // System.out.println(l2.toString());
        //System.out.println(esCapicua(l1));
        //System.out.println(esCapicua(l2));
        //System.out.println(invertir(l2).toString());
        //System.out.println(comprobar(l1));
        //System.out.println(contarR(l1,0,1));
       /* System.out.println(l1.toString());
         l1.eliminarPares();
         System.out.println(l1.toString());
        */
        //l1.insertarPromedio();
        System.out.println(l1.toString());
        l1.eliminarPrimos();
        System.out.println(l1.toString());
    }
    public static ListaInt intercalar(ListaInt l1, ListaInt l2){
        ListaInt l3 = new ListaInt();
        if(l1.esVacia() ){
            l3 = l2;
        }else{
            if(l2.esVacia()){
                l3 = l1;
            }else{
                int i = 1;
                while( i <= l2.longitud()){
                    if(i <= l1.longitud()){
                        l3.insertar(l2.recuperar(i), i);
                    }
                }
            }
        }
        return l3;
    }
    public static int contar(ListaInt l1 , int elem){
        int cant = 0 ;
        for(int i = 1 ; i<= l1.longitud() ; i++){
            if(l1.recuperar(i) == elem){
                cant++;
            }
            
        }
        return cant;
    }
    public static boolean esCapicua(ListaInt l1){
        PilaInt pilaAux = new PilaInt();
        boolean res = true;
        int i = 1;
        int j = 1 ;
        while(i <= l1.longitud()){
            pilaAux.apilar(l1.recuperar(i));
            i++;
        }
        while(j <= l1.longitud() && res){
            if(l1.recuperar(j) != pilaAux.obtenerTope()){
                res = false;
            }
            j++;
            pilaAux.desapilar();
            
        }
        return res;
        
    }
    public static ListaInt invertir(ListaInt l1){
        ListaInt l2 = new ListaInt();
        PilaInt p = new PilaInt();
        int i = 1;
        int j = 1;
        while( i <= l1.longitud()){
            p.apilar(l1.localizar(i));
            i++;
        }
        while(!p.esVacia()){
            l2.insertar(p.obtenerTope(), j);
            j++;
            p.desapilar();
        }
        return l2;
        
    }
    public static boolean comprobar(ListaInt l1){
         boolean res = true;
         PilaInt p = new PilaInt();
         ColaInt c = new ColaInt();
         int i = 1;
         while(l1.recuperar(i) != 0 && i <= l1.longitud()){
             p.apilar(l1.recuperar(i));
             c.poner(l1.recuperar(i));
             i++;
         }
         if( i ==  l1.longitud() ){
             res = false;
         }
         int j = i+1;
         while(!c.esVacia()&& l1.recuperar(j)!= 0 && res && j <= l1.longitud()){
             if(c.obtenerFrente() == l1.recuperar(j)){
                 res = true;
             }else{
                 res = false;
             }
             c.sacar();
             j++;
         }
         if(j == l1.longitud() ){
             res = false;
         }
         int k = j+1;
         while(  !p.esVacia() && res  ){
             if(p.obtenerTope() == l1.recuperar(k)){
                 res = true;
             }else {
                 res = false;
             }
             p.desapilar();
             k++;
         }
         if( p.esVacia() && l1.longitud() == k){
              res = false;
         }
         return res;
        
    }
    public static int contarR(ListaInt l1 , int elem , int i){
        int cant = 0 ; 
        if( i <= l1.longitud()  ){
            if( l1.recuperar(i) == elem){
                cant = contarR(l1 , elem , i + 1) + 1;
            }else{
                cant = contarR(l1 , elem , i + 1);
            }
        }
        return cant;
    }
    
}
