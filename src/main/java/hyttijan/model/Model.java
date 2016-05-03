/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyttijan.model;

/**
 *
 * @author hyttijan
 */
public class Model {

    public enum GameState {

        MENU,NEWHIGHSCORE,HIGHSCORES, GAME
    }
    private int points;
    private GameState state;
    private Worm worm;
    private Food food;
    private Highscores highscores;

    public Model() {
        this.state = GameState.MENU;
        this.highscores = new Highscores();
    }

    public void initGame() {
        this.points = 0;
        this.worm = new Worm();
        this.food = new Food(worm);

    }
    public Highscores getHighscores(){
        return this.highscores;
    }
    public void writeNewRecord(String name) {
        this.highscores.writeToFile(name, this.points);
    }
    public int getPoints() {
        return this.points;
    }

    public void gameLoop() {
        if (this.worm.ateFood(food)) {
            this.points++;
            this.food.generateNewPosition(this.worm);
            this.worm.grow();
        }
        else{
            this.worm.move();
        }
        if (this.worm.collissionToSelf() || this.worm.collissionToBoundaries()) {
            if(this.newRecord()){
                this.state = GameState.NEWHIGHSCORE;
            }
            else{
                this.state = GameState.MENU;
            }   
        }
       
    }
    public boolean newRecord(){
        
        if(this.highscores.getPlayers().size()<10){
            return true;
        }
        else{
        for(int i=0;i<this.highscores.getPlayers().size();i++){
            int highscorelistPoints= Integer.parseInt(this.highscores.getPlayers().get(i)[1]);
            if(this.getPoints()>highscorelistPoints){
                return true;
            }
        }
        return false;
        }
    }
    public Worm getWorm() {
        return this.worm;
    }

    public Food getFood() {
        return this.food;
    }

    public void changeGameState(GameState state) {
        this.state = state;
    }

    public GameState getGameState() {
        return this.state;
    }

    public void turnWorm(int direction) {
        this.worm.turn(direction);
    }
}
