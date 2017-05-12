/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;
import jerarquicas.ArbolGen;
/**
 *
 * @author rickybauch
 */
public class TestArbolGen {
    public static void main(String[] args) {
        ArbolGen a = new ArbolGen();
        ArbolGen b = new ArbolGen();
        ArbolGen c = new ArbolGen();
        a.insertar(1, 1);
        a.insertar(2, 1);
        a.insertar(3, 1);
        a.insertar('b', 1);
        a.insertar(5, 2);
        a.insertar('a', 5);
        
        b.insertar(1, 1);
        b.insertar(2, 1);
        b.insertar(3, 1);
        b.insertar(4, 1);
        b.insertar(5, 2);
       
        System.out.println(a.toString());
       
        System.out.println();
        /*System.out.println(a.pertenece(8));
        System.out.println(a.entreNiveles(1, 2).toString());
        System.out.println(a.frontera());
        
        System.out.println(a.padre(6));
        System.out.println(a.nivel(2));
       */
        //a.eliminarEHijoIzq(4);
         
   
        
        
    }
}
