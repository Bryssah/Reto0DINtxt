/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0dintxt.view;

/**
 * The factory class of the View implementation
 * @author Bryssa
 * @author Aingeru
 */
public class ViewFactory {
    /**
     * Returns a new implementation of the view
     * @return a new implementation
     */
    public View getView(){
        return new ViewImplementation();
        
    }
    
    public View getSwingView(){
        return new SwingViewImplementation();
    }
}
