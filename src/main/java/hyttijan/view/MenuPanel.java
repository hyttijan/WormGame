/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author hyttijan
 */
public class MenuPanel extends JPanel{
    private JButton startGame,highscores,quit;
    private Dimension dimension;
    private ButtonListener buttonListener;
    
    public MenuPanel(ButtonListener buttonListener){
        
      
        this.startGame = new JButton("start game");
        this.highscores = new JButton("highscores");
        this.quit = new JButton("quit");
        this.buttonListener = buttonListener;
        this.buttonListener.setStartGame(this.startGame);
        this.buttonListener.setHighscores(this.highscores);
        this.buttonListener.setQuit(this.quit);
        this.add(this.startGame);
        this.add(this.highscores);
        this.add(this.quit);
        this.startGame.addActionListener(this.buttonListener);
        this.highscores.addActionListener(this.buttonListener);
        this.quit.addActionListener(this.buttonListener);
    }
    
}
