/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.model;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author hyttijan
 */
public class Worm {

    private ArrayList<WormPiece> wormPieces;
    private int direction;
    public Worm() {
        this.wormPieces = new ArrayList<>();
        this.wormPieces.add(new WormPiece(80,60));
        this.wormPieces.add(new WormPiece(60,60));
        this.wormPieces.add(new WormPiece(40,60));
        this.wormPieces.add(new WormPiece(20,60));
    }

    public void move() {
        this.wormPieces.get(0).move();
        for(int i=1;i<this.wormPieces.size();i++){
            this.wormPieces.get(i).move();
            this.wormPieces.get(i).setDirection(this.wormPieces.get(i).getNextDirection());
            this.wormPieces.get(i).setNextDirection(this.wormPieces.get(i-1).getDirection());
        }
       
    }
    public boolean collissionToSelf() {
        WormPiece wormHead = this.wormPieces.get(0);
        for(int i=1;i<this.wormPieces.size();i++){
            if(wormHead.getX()==this.wormPieces.get(i).getX()&&wormHead.getY()==this.wormPieces.get(i).getY()){
                return true;
            }
        }
        return false;
    }
    public ArrayList<WormPiece> getWormPieces(){
        return this.wormPieces;
    }
    public boolean collissionToBoundaries() {
         WormPiece wormHead = this.wormPieces.get(0);
        if(wormHead.getX()<0||wormHead.getY()<0||wormHead.getX()>620||wormHead.getY()>420){
            return true;
        }
        return false;
    }

    public boolean ateFood(Food food) {
        WormPiece wormHead = this.wormPieces.get(0);
        if(wormHead.getX()==food.getX()&&wormHead.getY()==food.getY()){
            return true;
        }
        return false;
    }
    public void grow(){
        int x = this.wormPieces.get(0).getX();
        int y = this.wormPieces.get(0).getY();
        int direction = this.wormPieces.get(0).getDirection();
        WormPiece newHead = new WormPiece(x,y,direction);
        this.wormPieces.add(0,newHead);
        this.wormPieces.get(0).move();
        this.wormPieces.get(1).setNextDirection(direction);
    }
    
    
    public void paintWorm(Graphics g) {
        for(int i=0;i<this.wormPieces.size();i++){
            this.wormPieces.get(i).paintWormPiece(g);
        }
    }
    public void turn(int direction) {
        if((this.wormPieces.get(0).getDirection()-direction)%2!=0){
            this.wormPieces.get(0).setDirection(direction);
            this.wormPieces.get(1).setNextDirection(direction);
        }
      
    }

}
