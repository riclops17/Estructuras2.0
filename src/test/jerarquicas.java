/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import lineales.dinamicas.ListaInt;
import jerarquicas.ArbolBinInt;

/**
 *
 * @author rickybauch
 */
public class jerarquicas {

    public static void main(String[] args) {
        ArbolBinInt a = new ArbolBinInt();
        ArbolBinInt b = new ArbolBinInt();
        b.insertar(1, 0, 'I');
        ListaInt l1 = new ListaInt();
        l1.insertar(1, 1);
        l1.insertar(2, 2);
        l1.insertar(3, 3);
        l1.insertar(5, 4);
        l1.insertar(1, 5);
        a.insertar(1, 1, 'I');
        a.insertar(2, 1, 'I');
        a.insertar(3, 1, 'D');
        a.insertar(4, 3, 'I');
        a.insertar(5, 3, 'D');
        a.insertar(1, 5, 'I');
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
        a.eliminarHojas();
        System.out.println(a.toString());
    }
}
