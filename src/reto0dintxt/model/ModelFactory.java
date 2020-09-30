/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0dintxt.model;

/**
 * The factory  class of the Model Implementation
 * @author Aingeru
 * @author Bryssa
 */
public class ModelFactory {
    /**
     * Returns a new implementation of the model
     * @return a new implementation
     */
    public Model getModel(){
        return new ModelImplementation();
    }
}
