/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;
import jerarquicas.ArbolGenInt;
/**
 *
 * @author rickybauch
 */
public class TestArbolGen {
    public static void main(String[] args) {
        ArbolGenInt a = new ArbolGenInt();
        ArbolGenInt b = new ArbolGenInt();
        ArbolGenInt c = new ArbolGenInt();
        a.insertar(1, 1);
        a.insertar(2, 1);
        a.insertar(3, 1);
        a.insertar(4, 1);
        a.insertar(5, 2);
        
        b.insertar(1, 1);
        b.insertar(2, 1);
        b.insertar(3, 1);
        b.insertar(4, 1);
        b.insertar(5, 2);
       
        System.out.println(a.toString());
        
        /*System.out.println(a.pertenece(8));
        System.out.println(a.entreNiveles(1, 2).toString());
        System.out.println(a.frontera());
        
        System.out.println(a.padre(6));
        System.out.println(a.nivel(2));
       */
        //a.eliminarEHijoIzq(4);
         
   
        System.out.println("");
        System.out.println(b.toString());
        System.out.println(a.equals(b));
        
    }
}
