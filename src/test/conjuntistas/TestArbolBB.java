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
       a.insertar(56);
       a.insertar(13);
       a.insertar(78);
       a.insertar(7);
       a.insertar(24);
       a.insertar(100);
       a.insertar(15);
       a.insertar(50);
      
       b.insertar(1);
       b.insertar(7);
       b.insertar(10);
       b.insertar(20);
       b.eliminarMinimoElem();
       System.out.println(a.toString());
       System.out.println(a.listarMayorIgual(24));
        //System.out.println(a.clonarParteInvertida(13));
       ///a.eliminar(20);
        
      
        
        
       /* System.out.println(a.listar());
        System.out.println(a.listarRango(13, 50));
        System.out.println(a.minimoElem());
        System.out.println(a.maximoElem());*/
        //a.eliminarMinimoElem();
        //a.eliminar(11);
       // System.out.println(a.listarRango(5, 56));
       
    }
    
}
