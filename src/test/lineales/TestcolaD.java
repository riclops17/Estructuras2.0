/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.ColaInt;
/**
 *
 * @author rickybauch
 */
public class TestcolaD {
    public static void main(String[] args) {
        ColaInt c =  new ColaInt();
        ColaInt clon = new ColaInt();
        c.poner(1);
        c.poner(2);
        c.poner(3);
        System.out.println(c.toString());
        c.sacar();
        System.out.println(c.toString());
        clon = c.clonar();
        System.out.println(clon.toString());
        System.out.println(c.obtenerFrente());
        
    }
}
