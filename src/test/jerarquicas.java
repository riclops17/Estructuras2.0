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
        a.insertar(1, 1, 'I');
        a.insertar(2, 1, 'I');
        a.insertar(3, 1, 'D');
        a.insertar(4, 3, 'I');
        a.insertar(5, 3, 'D');
        /*System.out.println(a.listarPreorden().toString());
        System.out.println(a.listarInorden().toString());
        System.out.println(a.listarPosorden().toString());
        System.out.println(a.frontera().toString());
        System.out.println(a.padre(4));
        System.out.println(a.nivel(5));
        //System.out.println(a.altura());
        System.out.println(a.pertenece(8));*/
        a.sumarRamas();
        System.out.println(a.toString());
    }
}
