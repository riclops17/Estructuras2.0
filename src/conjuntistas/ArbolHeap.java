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
    
   private final int TAM = 10;
   private  Comparable[] heap;
   private  int ultimo = 0;
   
   public ArbolHeap(){
       this.heap = new Comparable[TAM];
       this.ultimo = 0;
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
       Object temp = this.heap[posicion];
       boolean salir = false;
       while( !salir){
           hijoMenor = posicion * 2;
           if(hijoMenor <= this.ultimo){
               // temp tiene hijos(al menos uno)
               if(hijoMenor < this.ultimo){
                   // hijo menor tiene hermano derecho
                   if(this.heap[hijoMenor +1].compareTo(this.heap[hijoMenor])>0) {
                       hijoMenor++;
                   }
               }
               if(this.heap[hijoMenor].compareTo(temp)<0){
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
       this.heap[posicion].equals(temp); 
   }
   public boolean esVacio(){
       return this.ultimo == 0;
   }

}

