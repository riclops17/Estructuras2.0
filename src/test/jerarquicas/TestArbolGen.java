/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;
import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;
/**
 *
 * @author rickybauch
 */
public class TestArbolGen {
    public static void main(String[] args) {
        ArbolGen a = new ArbolGen();
        ArbolGen b = new ArbolGen();
        ArbolGen c = new ArbolGen();
        Lista l1 = new Lista();
        a.insertar(1, 1);
        a.insertar(2, 1);
        a.insertar(3, 1);
        a.insertar(6, 1);
        a.insertar(5, 2);
        a.insertar(9, 5);
        
        l1.insertar(20, 1);
        l1.insertar(54, 2);
        l1.insertar(5, 3);
        
        
        b.insertar(20, 20);
        b.insertar(13, 20);
        b.insertar(54, 20);
        b.insertar(15, 13);
        b.insertar(12, 13);
        b.insertar(11, 54);
        b.insertar(27,54);
        b.insertar(4, 54);
        b.insertar(17, 27);
    
        
        
        
        c.insertar(20, 20);
        c.insertar(13, 20);
        c.insertar(15, 13);
        c.insertar(11, 20);
       
        
//        c= b.clonar();
//        c.insertar(7, 54);
        
        //System.out.println(c.toString());
   
        System.out.println(b.toString());
        System.out.println();
        System.out.println(b.toString());
       
       
       
        /*System.out.println(a.pertenece(8));
        System.out.println(a.entreNiveles(1, 2).toString());
        System.out.println(a.frontera());
        
        System.out.println(a.padre(6));
        System.out.println(a.nivel(2));
       */
        //a.eliminarEHijoIzq(4);
         
   
        
        
    }
}
