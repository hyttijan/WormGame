/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.view;

import hyttijan.controller.Controller;
import hyttijan.model.Model.GameState;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author hyttijan
 */
public class ButtonListener implements ActionListener{
    
    private JButton startGame,highscores,quit,back;
    private Controller controller;
    
    public ButtonListener(){
      
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==this.startGame){
           controller.changeGameState(GameState.GAME);
       }
       else if(e.getSource()==this.highscores){
           controller.changeGameState(GameState.HIGHSCORES);
       }
       else if(e.getSource()==this.back){
           controller.changeGameState(GameState.MENU);
       }
       else if(e.getSource()==this.quit){
           System.exit(0);
       }
       
    }
    public void registerController(Controller controller){
        this.controller = controller;
    }

    public void setStartGame(JButton startGame) {
        this.startGame = startGame;
    }

    public void setHighscores(JButton highscores) {
        this.highscores = highscores;
    }

    public void setQuit(JButton quit) {
        this.quit = quit;
    }
    public void setBack(JButton back){
        this.back = back;
    }
    
}
