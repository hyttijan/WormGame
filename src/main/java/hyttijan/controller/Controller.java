/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.controller;

import hyttijan.model.Model;
import hyttijan.model.Model.GameState;
import hyttijan.view.View;

/**
 *
 * @author hyttijan
 */
public class Controller{
    
    private View view;
    private Model model;
    private Thread gameThread;
    
    public Controller(View view,Model model){
       this.view = view;
       this.model = model;
    }
   
    public void changeGameState(GameState state){
        model.changeGameState(state);
        view.gameStateChanged(model.getGameState());
    }
    public Model getModel(){
        return this.model;
    }   

    public void turnWorm(int direction) {
        this.model.turnWorm(direction);
    }

    public void writeNewRecord(String name) {
        this.model.writeNewRecord(name);
        this.view.updateScores();
    }
}
