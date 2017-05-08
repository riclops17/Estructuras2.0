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
       a.insertar(10);
       a.insertar(5);
       a.insertar(2);
       a.insertar(8);
       a.insertar(1);
       a.insertar(4);
       a.insertar(6);
       a.insertar(9);
       a.insertar(7);
        System.out.println(a.toString());
       /* System.out.println(a.listar());
        System.out.println(a.listarRango(13, 50));
        System.out.println(a.minimoElem());
        System.out.println(a.maximoElem());*/
        //a.eliminarMinimoElem();
        a.eliminar(2);
        System.out.println(a.toString());
       
    }
    
}
