/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0dintxt;


import reto0dintxt.controller.Controller;
import reto0dintxt.model.ModelFactory;
import reto0dintxt.view.ViewFactory;

/**
 * Application class
 * This application gets a greeting from a file and shows it trought command line
 * @author Bryssa
 * @author Aingeru
 */
public class Application {

    
   
    /**
     * Main class of application
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          ModelFactory model = new ModelFactory();
        ViewFactory view = new ViewFactory();
        Controller con = new Controller();
        con.run(view.getView(),model.getModel());
         
        // GRAPHIC MODE
         /** ModelFactory model = new ModelFactory();
        ViewFactory view = new ViewFactory();
        Controller con = new Controller();
        con.run(view.getSwingView(),model.getModel());
       **/
    }
    
}