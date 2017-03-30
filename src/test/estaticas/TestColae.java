/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.estaticas;
import lineales.estaticas.ColaInt;
/**
 *
 * @author rickybauch
 */
public class TestColae {
    public static void main(String[] args) {
        ColaInt c = new ColaInt();
        c.poner(1);
        c.poner(2);
        c.poner(3);
        
        System.out.println(c.toString());
        c.sacar();
        c.poner(1);
        System.out.println(c.obtenerFrente());
        System.out.println(c.toString());
        
        
    }
}
