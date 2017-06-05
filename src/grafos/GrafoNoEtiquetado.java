/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;
import lineales.dinamicas.Lista;
/**
 *
 * @author rickybauch
 */
public class GrafoNoEtiquetado {
    private NodoVert inicio = null;
    
    public GrafoNoEtiquetado(){
        this.inicio = null;
    }
    public boolean insertarVertice(Object nuevoVertice){
        boolean exito = false;
        NodoVert aux = this.ubicarVertice(nuevoVertice);
        if(aux == null){
            this.inicio = new NodoVert(nuevoVertice,this.inicio);
            exito = true;
        }
        return exito;
    }
    private NodoVert ubicarVertice(Object buscado){
        NodoVert aux = this.inicio;
        while(aux != null && !aux.getElem().equals(buscado)){
            aux = aux.getSigVertice();
        }
        return aux;
    }
    public Lista listarEnProfundidad(){
        Lista visitados = new Lista();
        // define un vetice donde comenzar a recorrer
        NodoVert aux = this.inicio;
        while( aux != null){
            if(visitados.localizar(aux.getElem())< 0){
                // si el vertice no fue visitado aun , avanza en profundidad
                listarEnProfundidadAux(aux,visitados);
            }
            aux = aux.getSigVertice();
        }
    
    return visitados;
}
    private void listarEnProfundidadAux(NodoVert n , Lista vis){
        if( n != null){
            // marca al vertice n como visitado
            vis.insertar(n.getElem(), vis.longitud() +1);
            NodoAdy ady = n.getPrimerAdy();
            while(ady != null){
                // visita en profundidad los adyacetntes de n aun no visitados;
                if(vis.localizar(ady.getVertice().getElem())<0){
                    listarEnProfundidadAux(ady.getVertice(),vis);
                }
                ady = ady.getSigAdyacente();
            }
            
        }
    }
    public boolean existeCamino(Object origen ,Object destino){
        boolean exito = false;
        // verifica si ambos vertices existen 
        NodoVert auxO = ubicarVertice(origen);
        NodoVert auxD = ubicarVertice(destino);
        if(auxO != null && auxD != null){
            // si ambos verticesexisten busca si existe camino entre ambos
            Lista  visitados = new Lista();
            exito = existeCaminoAux(auxO,destino,visitados);
            
        }
        return exito;
    }
    private boolean existeCaminoAux(NodoVert n,Object dest, Lista vis){
        boolean exito = false;
        if(n != null){
            // si vertice n es el destino: hay camino
            if(n.getElem().equals(dest)){
                exito = true;
            }else{
                // si no es el destino verifica si hay camino entre n y el destino
                vis.insertar(n.getElem(),vis.longitud() +1);
                NodoAdy ady = n.getPrimerAdy();
                while(!exito && ady != null){
                    if(vis.localizar(ady.getVertice().getElem())< 0){
                        exito = existeCaminoAux(ady.getVertice(),dest,vis);
                    }
                    ady = ady.getSigAdyacente();
                }
            }
        }
        return exito;
    }
}
