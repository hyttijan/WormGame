/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.view;

import hyttijan.controller.Controller;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author hyttijan
 */
public class GamePanel extends JPanel {

    private GameLoop gameloop;
    private GameListener gameListener;
    private KeyStrokeListener keystrokeListener;
    private Controller controller;
   
    public GamePanel() {
        this.setBackground(Color.black);
        this.gameListener = new GameListener(this);
        this.keystrokeListener = new KeyStrokeListener(this);
        this.gameloop = new GameLoop(5,this.gameListener);
      
      
    }

    public void initGame() {
        this.gameloop.restart();
        this.requestFocusInWindow();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.controller.getModel().getWorm().paintWorm(g);
        this.controller.getModel().getFood().paintFood(g);
        g.setColor(Color.yellow);
        g.drawString("Points:"+String.valueOf(this.controller.getModel().getPoints()),550,440);
       
    }
    void registerController(Controller controller) {
        this.controller = controller;
        this.keystrokeListener.registerController(controller);
        this.gameListener.registerController(controller);
    }

}
