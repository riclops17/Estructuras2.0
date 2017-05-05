/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.jerarquicas;

import jerarquicas.ArbolBinInt;
import lineales.dinamicas.ListaInt;

/**
 *
 * @author rickybauch
 */
public class TestArbolbin {
    
    public static void main(String[] args) {
        ArbolBinInt a = new ArbolBinInt();
        ArbolBinInt b = new ArbolBinInt();
        
        ListaInt l1 = new ListaInt();
        
        l1.insertar(4, 1);
        l1.insertar(3, 2);
        l1.insertar(2, 3);
        l1.insertar(1, 4);
     
        a.insertar(1, 1, 'I');
        a.insertar(2, 1, 'I');
        a.insertar(3, 1, 'D');
        a.insertar(4, 2, 'I');
        a.insertar(7, 2, 'D');
        a.insertar(6, 3, 'I');
        a.insertar(7, 3, 'D');
        
           
        b.insertar(1, 1, 'I');
        b.insertar(2, 1, 'I');
        b.insertar(3, 1, 'D');
        b.insertar(4, 2, 'I');
        b.insertar(5, 2, 'D');
        b.insertar(6, 3, 'I');
        b.insertar(7, 3, 'D');
        
        
        /*System.out.println(a.listarPreorden().toString());
        System.out.println(a.listarInorden().toString());
        System.out.println(a.listarPosorden().toString());
        System.out.println(a.frontera().toString());
        System.out.println(a.padre(4));
        System.out.println(a.nivel(5));
        System.out.println(a.altura());
        System.out.println(a.pertenece(8));*/
        //a.sumarRamas();
        /* System.out.println(a.toString());
        System.out.println(a.listarAncestros(5));
        System.out.println(a.verificarPatron(l1));*/
       /* System.out.println(a.toString());
        ArbolBinInt c = new ArbolBinInt();
        System.out.println(a.toString());
        System.out.println(c.toString());
        System.out.println(a.altura2());     
        System.out.println(a.PorNivel().toString());*/
        //System.out.println(a.entreNivelesAux(2, 3).toString());
        //a.eliminarHojas();
       /* System.out.println(a.toString());
        System.out.println(a.listarCaminoMasLargo().toString());
        System.out.println(a.verificarPatron(l1));
        a.eliminarHijoIzq(3);
        System.out.println(a.toString());
        */
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(a.equals(b));
    }
}


