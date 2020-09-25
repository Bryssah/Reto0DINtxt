/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0dintxt.model;

import java.util.ResourceBundle;

/**
 * Implementation of the model that gets a text message
 * @author Aingeru
 */
public class ModelImplementation implements Model{
    /**
     * Gets a greeting message
     * @return the greeting in a String
     */
    @Override
    public String getGreeting(){
        return ResourceBundle.getBundle("reto0dintxt.model.ModelFile")
                .getString("greeting");
    }
}
