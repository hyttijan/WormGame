/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.view;

import hyttijan.controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

/**
 *
 * @author hyttijan
 */
public class KeyStrokeListener{
    private Controller controller;
    private InputMap inputMap;
    private ActionMap actionMap;
    private KeyStroke[] keystrokes;
    private MoveAction moveAction;
    public KeyStrokeListener(GamePanel gamePanel){
        
        this.inputMap = gamePanel.getInputMap();
    
        this.actionMap = gamePanel.getActionMap();
        this.keystrokes = new KeyStroke[4];
        this.keystrokes[0] = KeyStroke.getKeyStroke("A");
        this.keystrokes[1] = KeyStroke.getKeyStroke("D");
        this.keystrokes[2] = KeyStroke.getKeyStroke("W");
        this.keystrokes[3] = KeyStroke.getKeyStroke("S");
        this.inputMap.put(keystrokes[0],"A");
        this.inputMap.put(keystrokes[1],"W");
        this.inputMap.put(keystrokes[2],"D");
        this.inputMap.put(keystrokes[3],"S");
        this.moveAction = new MoveAction();
        this.actionMap.put("A",this.moveAction);
        this.actionMap.put("W",this.moveAction);
        this.actionMap.put("D",this.moveAction);
        this.actionMap.put("S",this.moveAction);
      
    }
    public void registerController(Controller controller) {
        this.controller = controller;
        this.moveAction.registerController(controller);
      
    }
    public class MoveAction extends AbstractAction{
        private Controller controller;
        
        public void registerController(Controller controller){
            this.controller = controller;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getActionCommand().equals("a")){
                this.controller.turnWorm(2);
            }
            else if(ae.getActionCommand().equals("w")){
                this.controller.turnWorm(3);
            }
            else if(ae.getActionCommand().equals("d")){
                this.controller.turnWorm(0);
            }
            else if(ae.getActionCommand().equals("s")){
                this.controller.turnWorm(1);
            }
        
        }
        
    }

}
