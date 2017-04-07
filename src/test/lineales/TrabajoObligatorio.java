/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.lineales;
import lineales.dinamicas.ListaInt;
import lineales.dinamicas.PilaInt;
import lineales.estaticas.ColaInt;
/**
 *
 * @author rickybauch
 */
public class TrabajoObligatorio {
    public static void main(String[] args) {
      ListaInt l1 = new ListaInt();
        l1.insertar(1, 1);
        l1.insertar(2, 2);
        l1.insertar(3, 3);
        l1.insertar(4, 4);
        l1.insertar(5, 5);
        l1.insertar(6, 6);
        l1.insertar(7, 7);
        l1.insertar(8, 8);
        l1.insertar(9, 9);
        l1.insertar(10, 10);
        l1.insertar(11, 11);
        l1.insertar(12, 12);
        l1.insertar(13, 13);
        l1.insertar(14 ,14);
        l1.insertar(15, 15);
        l1.insertar(16, 16);
       
       
        System.out.println(l1.toString());
        
        System.out.println(revolverElementos(l1,3).toString());
        
    }
    public static ColaInt revolverElementos(ListaInt lista, int k){
        int n = 1;
        ListaInt l1 = lista.clonar();
        int cant = l1.longitud() / k;
        PilaInt pilaAux = new PilaInt();
        ColaInt c = new ColaInt();
        while(n <= cant){
            if(n % 2 == 0){
                for(  int i =1 ; i<= k;i++){
                    pilaAux.apilar(l1.recuperar(i));
                    
                }
                while(!pilaAux.esVacia()){
                    c.poner(pilaAux.obtenerTope());
                    pilaAux.desapilar();
                }
                for(int r = 1 ; r <= k;r++){
                    l1.eliminar(1);
                }
         }else{
                for(int j = 1; j<= k; j++){
                    c.poner(l1.recuperar(j));
                }
               for(int q = 1 ; q <= k;q++){
                    l1.eliminar(1);
                }
           } 
          n++;
        }
        if(!l1.esVacia()){
            
         
        }
        
        return c;
    }
}
    
