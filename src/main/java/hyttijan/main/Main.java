/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.main;

import hyttijan.controller.Controller;
import hyttijan.model.Model;
import hyttijan.view.View;
import javax.swing.SwingUtilities;

/**
 *
 * @author hyttijan
 */
public class Main implements Runnable{
    
    private View view;
    private Model model;
    private Controller controller;
    
    @Override
    public void run() {
        
        this.view = new View();
        this.model = new Model();
        this.controller = new Controller(view,model);
        this.view.registerController(this.controller);
        
    }
    public static void main(String args[]){
        Main main = new Main();
        SwingUtilities.invokeLater(main);
    }
    
}
