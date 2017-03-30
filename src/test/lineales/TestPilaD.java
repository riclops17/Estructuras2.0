/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.PilaInt;
/**
 *
 * @author rickybauch
 */
public class TestPilaD {
    public static void main(String[] args) {
        PilaInt p = new PilaInt();
        p.apilar(1);
        p.apilar(2);
        p.apilar(3);
        System.out.println(p.toString());
        p.desapilar();
        System.out.println(p.toString());
        System.out.println(p.esVacia());
        p.vaciar();
        p.desapilar();
        p.apilar(1);
        p.apilar(2);
        System.out.println(p.obtenerTope());
        System.out.println(p.toString());
        p.vaciar();
        System.out.println(p.obtenerTope());
    }
}
