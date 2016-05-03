/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.view;

import hyttijan.controller.Controller;
import hyttijan.model.Model;
import hyttijan.model.Model.GameState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author hyttijan
 */
public class GameListener implements ActionListener{
        private Controller controller;
        private GamePanel gamePanel;
        public GameListener(GamePanel gamePanel){
            this.gamePanel = gamePanel;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
           if(this.controller.getModel().getGameState()==GameState.GAME){
               this.controller.getModel().gameLoop();
               this.gamePanel.repaint();
           }
           else{
               controller.changeGameState(this.controller.getModel().getGameState());
           }
        }
        
        public void registerController(Controller controller){
           this.controller = controller; 
        }
    
}