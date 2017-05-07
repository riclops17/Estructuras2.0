/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.conjuntistas;
import conjuntistas.ArbolBB;
/**
 *
 * @author rickybauch
 */
public class TestArbolBB {
    public static void main(String[] args) {
       ArbolBB a = new ArbolBB();
       a.insertar(45);
       a.insertar(96);
       a.insertar(55);
       a.insertar(34);
       a.insertar(65);
       a.insertar(73);
       a.insertar(13);
        System.out.println(a.toString());
        System.out.println(a.listar());
        System.out.println(a.listarRango(13, 50));
        System.out.println(a.minimoElem());
        System.out.println(a.maximoElem());
        a.eliminarMinimoElem();
        System.out.println(a.toString());
    }
    
}
