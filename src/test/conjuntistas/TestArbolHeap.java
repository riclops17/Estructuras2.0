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
       a.insertar(10);
       a.insertar(12);
       a.insertar(15);
       a.insertar(21);
       a.insertar(45);
       a.insertar(19);
       a.insertar(8);
       a.eliminarCima();
       
        System.out.println(a.toString());
       
    }
}
