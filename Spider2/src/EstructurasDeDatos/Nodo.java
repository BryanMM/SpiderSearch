/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 * Utilizacion de Generics para el manejo de datos
 * @param <DatoAbstracto> Es el dato que se va a introducir en el nodo
 * @author Gabo
 */
public class Nodo<DatoAbstracto> {
    private Nodo _padre;
    private Nodo _hijo;
    private DatoAbstracto _datos;
    private String _id;


   
    

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }
    
    
    /**
     *No generico vacio sin referencia
     */
    public Nodo(){
        _padre = null;
        _hijo = null;
    }
    /**
     *Nodo con un dato interno pero sin referencias
     * @param pdatos dato que se desea encapsular en este nodo
     */
    public Nodo(DatoAbstracto pdatos){
        _datos = pdatos;
        _padre = null;
        _hijo = null;
        
        _id=null;
        
    }
    
    /**
     *Metodo que asigna un nodo como siguiente
     * @param pnext Parametro con el nodo al que se le va a referenciar
     */
    public void setNext(Nodo pnext){
        _padre = pnext;
    }
    
     /**
     *Metodo que asigna un nodo como anterior
     * @param pprev Parametro con el nodo al que se le va a referenciar
     */
    public void setPrev(Nodo pprev){
        _hijo = pprev;
    }
     
     /**
     *Retorna siguiente nodo
     * @return retorna el nodo siguiente a este
     */
    public Nodo getNext(){
        return this._padre;
    }
     
    /**
     *Retorna al nodo anterior
     * @return Nodo anterior
     */
    public Nodo getPrev(){
        return this._hijo;
    }  
    
    /**
     * Metodo que asigna un valor a los datos
     * @param pdatos dato que introducimos
     */
    public void setDato(DatoAbstracto pdatos){
        _datos = pdatos;
    }
    
    /**
     *Metodo que devuelve el valor del nodo
     * @return Objeto Contenido
     */
    public DatoAbstracto getDato(){
        return _datos;
    }
}

