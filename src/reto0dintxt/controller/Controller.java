/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0dintxt.controller;

import reto0dintxt.model.Model;
import reto0dintxt.view.View;

/**
 * Controller class of the application
 * @author Aingeru
 * @author Bryssa
 */
public class Controller {
    /**
     * Run the view with the model
     * @param view Interface
     * @param model Interface
     */
    public void run(View view, Model model){
        view.showGreeting(model.getGreeting());
    }
}
