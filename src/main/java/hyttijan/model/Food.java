/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author hyttijan
 */
public class Food {
    private int x, y;
    private int width,height;
    private Color color;
    
    public Food(Worm worm){
      this.generateNewPosition(worm);
      this.width = 20;
      this.height= 20;
      this.color = Color.blue;
    }
    public void paintFood(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.x,this.y,this.width,this.height);
        
    }
    public void generateNewPosition(Worm worm){
        boolean onWorm;
        Random random = new Random();
        do{
            onWorm =false;
            this.x =random.nextInt(31)*20;
            this.y =random.nextInt(22)*20;
            for(int i=0;i<worm.getWormPieces().size();i++){
                if(this.x==worm.getWormPieces().get(i).getX()&&this.y==worm.getWormPieces().get(i).getY()){
                    onWorm = true;
                    break;
                }
            }
        }while(onWorm); 
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
