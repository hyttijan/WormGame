/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.view;

import hyttijan.controller.Controller;
import hyttijan.model.Model.GameState;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import javax.swing.JPanel;

/**
 *
 * @author hyttijan
 */
public class View {

    private JFrame frame;
    private JPanel mainPanel;
    private GamePanel gamePanel;
    private HighscoresPanel highscoresPanel;
    private MenuPanel menuPanel;
    private ButtonListener buttonListener;
    private Dimension dimension;
    private Controller controller;

    public View() {
        this.frame = new JFrame();
        this.mainPanel = new JPanel(new CardLayout());
        this.buttonListener = new ButtonListener();

        this.menuPanel = new MenuPanel(this.buttonListener);
        this.highscoresPanel = new HighscoresPanel(this.buttonListener);
        this.gamePanel = new GamePanel();
        this.frame.add(this.mainPanel);
        this.mainPanel.add(this.menuPanel,"menu");
        this.mainPanel.add(this.highscoresPanel,"highscores");
        this.mainPanel.add(this.gamePanel,"game");
        this.dimension = new Dimension(640, 480);
        this.frame.setTitle("WormGame");
        this.frame.setSize(this.dimension);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);

    }

    public void gameStateChanged(GameState state) {
        CardLayout cl = (CardLayout) (this.mainPanel.getLayout());
        if(state==GameState.GAME){
            this.controller.getModel().initGame();
            cl.show(this.mainPanel,"game");
            this.gamePanel.initGame();
            
        }
        else if(state==GameState.NEWHIGHSCORE){
            
            String name = JOptionPane.showInputDialog(mainPanel,"Anna nimimerkkisi:","Uusi ennätys",PLAIN_MESSAGE);
         
            controller.writeNewRecord(name);
            controller.changeGameState(GameState.HIGHSCORES);
        }
        else if(state==GameState.HIGHSCORES){
            cl.show(this.mainPanel,"highscores");
        }
        else if(state==GameState.MENU){
            cl.show(this.mainPanel,"menu");
        }
    }
    
    public void registerController(Controller controller) {
        this.controller = controller;
        this.buttonListener.registerController(this.controller);
        this.gamePanel.registerController(this.controller);
        this.highscoresPanel.registerController(this.controller);
    }

    public void updateScores() {
        this.highscoresPanel.updateScores();
    }
}
