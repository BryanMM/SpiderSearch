/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spiderbot;

/**
 *
 * @author Gabo
 */
public class URL {
    private int _indice=0;
    private int _cantidadApariciones;
    private String _link;
    private int Thrustworthy=1000;
    
    public URL(String pDireccion, int pIndice){
            this._link=pDireccion;
            this._indice = pIndice;
            }
    public int getIndice() {
        return _indice;
    }

    public void setIndice(int _indice) {
        this._indice = _indice;
    }

    public int getCantidadApariciones() {
        return _cantidadApariciones;
    }

    public void setCantidadApariciones(int _cantidadApariciones) {
        this._cantidadApariciones = _cantidadApariciones;
    }

    public String getLink() {
        return _link;
    }

    public void setLink(String _link) {
        this._link = _link;
    }
    
}
