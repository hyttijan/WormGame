/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.view;

import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author hyttijan
 */
public class GameLoop extends Timer{
    public GameLoop(int delay,ActionListener gameListener){
        super(100,gameListener);
    }
}
