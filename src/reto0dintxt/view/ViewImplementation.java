/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto0dintxt.view;

/**
 *  Implementation of the view that shows a text message
 * @author Bryssa
 * @author Aingeru
 */
public class ViewImplementation implements View {
    /**
     * Show a greeting in UI
     * @param greeting String containing the greeting
     */
    @Override
    public void showGreeting(String greeting){
        System.out.println(greeting);
    }
}
