/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author rickybauch
 */
public class NodoAdy {
    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    
    public NodoAdy(NodoVert v , NodoAdy n){
        this.vertice = v;
        this.sigAdyacente = n;
    }
    public NodoVert getVertice(){
        return this.vertice;
    }
    public void setVertice(NodoVert v){
        this.vertice = v;
    }
    public NodoAdy getSigAdyacente(){
        return this.sigAdyacente;
    }
    public void  SetSigAdyacente(NodoAdy n){
        this.sigAdyacente = n;
    }
}
