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
        a.insertar(56);
        a.insertar(34);
        a.insertar(78);
        a.insertar(23);
        a.insertar(63);
        a.insertar(89);
        a.insertar(22);
        
       
        System.out.println(a.toString());
    }
  
}
