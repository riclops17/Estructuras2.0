/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

/**
 *
 * @author rickybauch
 */
public class FuncionesHash {

    /**
     * Función hash para números enteros:
     * Eleva al cuadrado la clave y luego retorna los dígitos centrales
     * 
     * @param k clave
     * @return dígitos centrales del cuadrado de la clave
     */
    public static int fCuadrado(int k) {
        String numero, digitosCentrales;
        int medio, duplicar;
        
        duplicar = k*k;
        
        while (duplicar / 10 == 0) {
            duplicar *= k;
        }

        numero = Integer.toString(duplicar);

        medio = numero.length() / 2;
        digitosCentrales = numero.substring(medio - 1, medio + 1);

        return Integer.parseInt(digitosCentrales);
    }
    
    /**
     * Suma los valores ASCII de cada caracter
     * 
     * @param s una cadena
     * @return suma entera de cada caracter
     */
    public static int fCadena(String s) {
        int suma = 0;
        
        for (int i = 0; i < s.length(); i++) {
            suma += (int) s.charAt(i);
        }
        
        
        return suma;
    }
    
    public static int hash(int elemento) {
        return elemento % 10;
    }
    
    public static int rehash(int elemento) {
        return elemento / 10;
    }
}
