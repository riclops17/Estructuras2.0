/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.conjuntistas;
import conjuntistas.ArbolAVL;
/**
 *
 * @author rickybauch
 */
public class TestArbolAVL {
    public static void main(String[] args) {
        ArbolAVL a = new ArbolAVL();
        a.insertar(12);
        a.insertar(5);
        a.insertar(23);
        a.insertar(3);
        a.insertar(8);
        a.insertar(10);
     
        
        
       
        System.out.println(a.toString());
    }
  
}
