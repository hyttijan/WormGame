/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.view;

import hyttijan.controller.Controller;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hyttijan
 */
public class HighscoresPanel extends JPanel{
    private JButton back;
    private JLabel[] scores;
    private ButtonListener buttonListener;
    private Controller controller;
    public HighscoresPanel(ButtonListener buttonListener){
        this.setLayout(new BoxLayout(this,Y_AXIS));
        this.scores = new JLabel[10];
        for(int i=0;i<this.scores.length;i++){
            this.scores[i] = new JLabel();
            this.add(scores[i]);
        }
       
        this.buttonListener = buttonListener;
        this.back = new JButton("Back");
        this.buttonListener.setBack(this.back);
        this.back.addActionListener(this.buttonListener);
        this.add(this.back);
    }
    public void registerController(Controller controller){
        this.controller = controller;
        this.updateScores();
    }
    public void updateScores(){
        ArrayList<String[]> players = this.controller.getModel().getHighscores().getPlayers();
        for(int i=0;i<this.controller.getModel().getHighscores().getPlayers().size();i++){
            this.scores[i].setText(players.get(i)[0]+" "+players.get(i)[1]);
        }
    }
}
