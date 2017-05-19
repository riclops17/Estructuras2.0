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
       ArbolBB b = new ArbolBB();
       a.insertar(10);
       a.insertar(5);
       a.insertar(2);
       a.insertar(8);
       a.insertar(1);
       a.insertar(4);
       a.insertar(6);
      
       a.insertar(9);
       a.insertar(12);
       a.insertar(11);
       a.insertar(14);
       a.insertar(13);
       a.insertar(20);
       a.insertar(21);
       a.insertar(15);
       
       b.insertar(10);
       b.insertar(9);
       b.insertar(11);
       b.insertar(12);
       System.out.println(a.toString());
       ///a.eliminar(20);
        
      
        
        
       /* System.out.println(a.listar());
        System.out.println(a.listarRango(13, 50));
        System.out.println(a.minimoElem());
        System.out.println(a.maximoElem());*/
        //a.eliminarMinimoElem();
        //a.eliminar(11);
        System.out.println(a.listarRango(5, 10));
       
    }
    
}
