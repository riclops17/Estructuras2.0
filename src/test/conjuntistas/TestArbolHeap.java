/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.conjuntistas;
import conjuntistas.ArbolHeap;
/**
 *
 * @author rickybauch
 */
public class TestArbolHeap {
    public static void main(String[] args) {
       ArbolHeap a = new ArbolHeap();
       a.insertar(1);
       a.insertar(2);
       a.insertar(5);
       a.insertar(9);
       a.insertar(3);
       a.insertar(6);
       a.insertar(7);
       a.insertar(10);
       a.insertar(16);
       a.insertar(8);
       a.insertar(13);
       a.insertar(14);
      
       
       
       System.out.println(a.toString());
       
    }
}
