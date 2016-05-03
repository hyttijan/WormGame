/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hyttijan
 */

public class Highscores {
    private File file;
    private ArrayList<String[]> players;
    public Highscores(){
        
        this.file = new File("./highscores.dat");
        this.players = new ArrayList<String[]>();
        this.readFile();
    }
    public ArrayList<String[]> getPlayers(){
        return this.players;
    }
    public void  insertIntoFullList(String name,int points){
        for(int i=0;i<10;i++){
            if(points>Integer.parseInt(this.players.get(i)[1])){
                String player[] = new String[2];
                player[0] = name;
                player[1] = String.valueOf(points);
                this.players.add(i,player); 
                break;
            }
        }
        this.players.remove(10);
    }
    public void insertIntoList(String name,int points){
        String player[] = new String[2];
        player[0] = name;
        player[1] = String.valueOf(points);
        for(int i=0;i<this.players.size();i++){
            if(points>Integer.parseInt(this.players.get(i)[1])){
                this.players.add(i,player); 
                return;
            }
        }
       
        this.players.add(player);
        
    }
    public void writeToFile(String name,int points){
        try {
            if(this.players.size()==10){
               this.insertIntoFullList(name, points);  
            }
            else{
            this.insertIntoList(name, points);
            }
            PrintWriter writer = new PrintWriter(this.file);
            for (String[] player : this.players) {
                writer.println(player[0] + " " + player[1]);
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            
        }
    }
    public void readFile(){
        try {
            Scanner reader = new Scanner(this.file);
            int i=0;
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                int split = line.lastIndexOf(' ');
                String name = line.substring(0,split);
                String points = line.substring(split+1);
                this.players.add(new String[2]);
                this.players.get(i)[0] = name;
                this.players.get(i)[1] = points;
                i++;
            }
                    
        } catch (FileNotFoundException ex) {
            
        }
    }
    
    
}
