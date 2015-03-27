/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Gabo
 */
public class Cola<DatoAbstracto> {
    private Nodo _top;
    private Nodo _end;
    public Cola(){
        _top=_end=null;
    
    }
    public boolean estaVacia(){
        return _top==null;
    }
    public void enqueue(DatoAbstracto pDato){
        if(estaVacia()){
            Nodo nuevo= new Nodo(pDato);
            _top=nuevo;
            _end=nuevo;
        }
        else{
            Nodo nuevo= new Nodo(pDato);
            _end.setNext(nuevo);
            _end=nuevo;
        }
    }
    
    public Nodo isinqueue(DatoAbstracto pDato){
    	Nodo _tmp = new Nodo(_top);
    	/*for(int i; i= 0 ;i++){
    		
    	}*/
		return _end;
    	
    }
    public void dequeue(){   
        _top=_top.getNext();
    }
    public DatoAbstracto obtenerTop(){
        return (DatoAbstracto)_top.getDato();
    }
    public DatoAbstracto obtenerFin(){
        return (DatoAbstracto)_end.getDato();
    }
    public void imprimir(){
        Nodo temp=_top;
        String palabra= "[";
        while(temp!=_end){
            palabra+=temp.getDato()+",";
            temp=temp.getNext();
    }
        palabra+=temp.getDato();
        
        palabra+="]";
        System.out.println(palabra);
    
}
    
}
