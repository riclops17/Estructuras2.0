/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author rickybauch
 */
public class ArbolHeap {
    
   private final int TAM = 20;
   private  int[] heap;
   private  int ultimo = 0;
   
   public ArbolHeap(){
       this.heap = new int[TAM];
       this.ultimo = 0;
   }
   public boolean insertar(int elem) {
        boolean res = false;
        int a;
        ultimo++;
        if (ultimo < TAM) {
            heap[ultimo] = elem;
            int aux = ultimo;
            while (heap[aux] < heap[aux / 2]) {
                a = heap[aux];
                heap[aux] = heap[aux / 2];
                heap[aux / 2] = a;
                aux = aux / 2;
            }
            res = true;
        } 
        
        return res;
    }
   public boolean eliminarCima(){
       boolean res;
      if(this.ultimo == 0){
          // estructura vacia
          res = false;
      }else{
          // saca la raiz y pone la ultima hoja en su lugar
          this.heap[1] = this.heap[ultimo];
          this.ultimo--;
          // reestablece la propiedad de heap minimo
          hacerBajar(1);
          res = true;
      }
      return res;
   }
   private void hacerBajar(int posicion){
       int hijoMenor;
       int temp = this.heap[posicion];
       boolean salir = false;
       while( !salir){
           hijoMenor = posicion * 2;
           if(hijoMenor <= this.ultimo){
               // temp tiene hijos(al menos uno)
               if(hijoMenor < this.ultimo){
                   // hijo menor tiene hermano derecho
                   if(this.heap[hijoMenor +1] < this.heap[hijoMenor]) {
                       hijoMenor++;
                   }
               }
               if(this.heap[hijoMenor] < temp){
                   this.heap[posicion] = this.heap[hijoMenor];
                   posicion = hijoMenor;
               }else{
                   // el padre es menor que sus hijos 
                   salir = true;
               }
           }else{
             // hijo menor es hoja
             salir = true;
           }
       }
       this.heap[posicion] = temp; 
   }
   public boolean esVacio(){
       return this.ultimo == 0;
   }
   public String toString() {
        String res = "[";
        int i = 1;
          while(i <= this.ultimo){
            if (i < this.ultimo) {
                res = res + this.heap[i] + " ,";
            } else {
                res = res + this.heap[i] + "]";
            }
            
            i++;
        }
        return res;
    }

}

