package org.anil.game.model.player;

public class Player {
    private String name;
    private int score;
    private transient GameStatus currentStatus;

    public static final int STARTING_SCORE = 100;
    public static final int SCORE_DECREASE_AMOUNT = 10;

    public Player(String name, int score, GameStatus currentStatus) {
        this.name = name;
        this.score = score;
        this.currentStatus = currentStatus;
    }

    // Empty Constructor
    public Player(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void decreaseScore() {
        this.score -= SCORE_DECREASE_AMOUNT;
    }

    public void setScore() {
        this.score = STARTING_SCORE;
    }

    public GameStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(GameStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return "name= " + name + " - " + "score= "  + score;
    }
}
