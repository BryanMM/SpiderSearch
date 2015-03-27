/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDeDatos;

/**
 *
 * @author Gabo
 * @param <DatoAbstracto>
 */
public class ListaCircularDoble<DatoAbstracto> {
    private Nodo _head;
    private Nodo _tail;
    private int _cantidadElementos=0;
    public ListaCircularDoble(){
        _head=null;
        _tail=null;
        
    }

    public Nodo getHead() {
        return _head;
    }

    public void setHead(Nodo _head) {
        this._head = _head;
    }

    public Nodo getTail() {
        return _tail;
    }

    public void setTail(Nodo _tail) {
        this._tail = _tail;
    }

    public int getCantidadElementos() {
        return _cantidadElementos;
    }

    public void setCantidadElementos(int _cantidadElementos) {
        this._cantidadElementos = _cantidadElementos;
    }
    
    public boolean estaVacia(){
        return _head==null;
    }
   
   public void insertarInicio(DatoAbstracto pDato){
       if(_head==null){
           Nodo nuevo = new Nodo(pDato);
           _head=nuevo;
           _head.setNext(nuevo);
           _head.setPrev(nuevo);
           _tail=nuevo;
           _tail.setNext(nuevo);
           _tail.setPrev(nuevo);
           
           
           _cantidadElementos++;
           
       }
       else {
          Nodo nuevo = new Nodo(pDato);
          nuevo.setNext(_tail.getNext());
          _tail.getNext().setPrev(nuevo);
          _tail.setNext(nuevo);
          nuevo.setPrev(_tail);
          _head=nuevo;
          _cantidadElementos++;
       }
      
   }
   public void insertarFinal(DatoAbstracto pDato){
       if(_head==null){
           Nodo nuevo = new Nodo(pDato);
           _head.setNext(nuevo);
           _head.setPrev(nuevo);
           _head=nuevo;
           _tail=nuevo;
           _cantidadElementos++;
           
       }
       else {
          Nodo nuevo = new Nodo(pDato);
          _tail.setNext(nuevo);
          _head.setPrev(nuevo);
          nuevo.setPrev(_tail);
          nuevo.setNext(_head);
          
          _tail=nuevo;
          
          _cantidadElementos++;
       }
       
   }
   
   public void insertarIndice(DatoAbstracto pDato,int pIndice){
       if(pIndice>_cantidadElementos){
           System.out.println("Indice Incorrecto");
           
       }
       else if(pIndice==0){insertarInicio(pDato);}
       else if(pIndice==_cantidadElementos-1){insertarFinal(pDato);}
       else {
           Nodo temp=_head;
           Nodo nuevo=new Nodo(pDato);
          for(int i =0;i<pIndice;i++){
              temp=temp.getNext();
           }
          nuevo.setPrev(temp);
          nuevo.setNext(temp.getNext());
          temp.setNext(nuevo);
          temp.getNext().setPrev(nuevo);
          
          _cantidadElementos++;
          
       }
       
   }
   
           
    /**
     * Metodo para eliminar el primer elemento de la lista
     */
    public void borrarInicio(){
        // cambios de referencia y decremento de contador de elementos
        if(estaVacia()){
            System.out.println("La lista esta vacia");
        }
        else{
        _head.getPrev().setNext(_head.getNext());
        _head.getNext().setPrev(_head.getPrev());
        _tail=_head.getPrev();
        _head=_head.getNext();
        _cantidadElementos--;}
        
    }
    /**
     * Metodo para eliminar el ultimo elemento de la lista
     */
    public void borrarFinal(){
         // cambios de referencia y decremento de contador de elementos
         _head.setPrev(_tail.getPrev());
         _tail.getPrev().setNext(_head);
         _tail=_head.getPrev();
         _cantidadElementos--;
    }
    
    /**
     * Metodo para borrar un elemento en una posicion especifica
     * @param pIndice
     */
    public void borradoIndice(int pIndice){
        if(pIndice==0){
            borrarInicio();
                                       }
        else if(pIndice==_cantidadElementos-1){
            borrarFinal(); }
        else if(pIndice>=_cantidadElementos){
            System.out.println("Indice Incorrecto fuera de rango");
        }
        
        else{
                if (estaVacia()){
                System.out.println("La lista esta Vacia");
                }
                else{

                             Nodo temp= _head;
                                for(int i=0;i<pIndice;i++){
                                 temp=temp.getNext();
                             }
                                _cantidadElementos--;
                             temp.setNext(temp.getNext().getNext());
                             temp.getNext().getNext().setPrev(temp);
                             
                             
                                                           
                             }
        
             }
       
              
        
    }
    
    
    /**
     * Metodo para devolver el valor que tiene un indice respectivo
     * @param indice
     * @return
     */
    public DatoAbstracto datoIndice(int indice){
        if(_cantidadElementos !=0){
        if (indice<_cantidadElementos){
                     if(indice==_cantidadElementos-1){
                         return (DatoAbstracto)_tail.getDato();
                     }
                     else  if(indice==0){
                         return (DatoAbstracto)_head.getDato();
                     }
                     else {
                         Nodo temp= this._head;
                        for(int i=0;i<indice;i++){
                         temp=temp.getNext();
                     }
                     return (DatoAbstracto)temp.getDato();
                                                   
                     }}
        else{
            
            System.out.println("Indice Fuera de Rango: "+ indice +" Maximo: " + _cantidadElementos);
                }
            }
        else{
            System.out.println("La lista esta Vacia");;
                         
            }
        return null;}
    /**
     *
     * @param dato
     * @return int indice con el dato
     */
    public int IndiceDato(DatoAbstracto dato){
        if(!estaVacia()){
        
                         Nodo temp= this._head;
                         for(int i=0;i<_cantidadElementos;i++){
                             if(temp.getDato().equals(dato)){
                                 return i;
                             }
                             temp=temp.getNext();
                        }
                        return -1;
                                                   
                     }
       
        else{
            System.out.println("La lista esta Vacia");;
                         
            }
        return -1;
        
    }
    public void imprimir(){
        Nodo temp=_head;
        String palabra= "[";
        for(int i=0;i<_cantidadElementos;i++){
            palabra+=temp.getDato()+",";
            temp=temp.getNext();
         }
        palabra=palabra.substring(0,palabra.length()-1);
        palabra+="]";
        System.out.println(palabra);
    
}
    
    
}
