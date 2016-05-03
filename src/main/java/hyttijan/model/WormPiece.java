/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.model;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author hyttijan
 */
public class WormPiece {
     private int x, y;
     private int height,width;
     private Color color;
     private int direction;
     private int nextDirection;
     public WormPiece(int x,int y){
         this.x = x;
         this.y = y;
         this.width = 20;
         this.height = 20;
         this.color = Color.red;
         this.direction = 0;
     }
     public WormPiece(int x,int y,int direction){
         this.x = x;
         this.y = y;
         this.width = 20;
         this.height = 20;
         this.color = Color.red;
         this.direction = direction;
     }
     

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paintWormPiece(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.x,this.y,this.width,this.height);
    }
     public void move() {
        if(direction==0){
            this.moveX(20);
        }
        else if(direction==1){
            this.moveY(20);
        }
        else if(direction==2){
            this.moveX(-20);
        }
        else if(direction==3){
            this.moveY(-20);
        }
    }
    public int getNextDirection(){
        return this.nextDirection;
    }
    public void setNextDirection(int nextDirection){
        this.nextDirection = nextDirection;
    }
    public void setDirection(int direction){
        this.direction = direction;
    }
    public int getDirection(){
        return this.direction;
    }
    public void moveY(int y) {
        this.y += y;
    }
    public void moveX(int x) {
        this.x += x;
    }
}
