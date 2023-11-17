package org.anil.game.model.player;

public class GameStatus {
    private boolean isTooLow;
    private boolean isTooHigh;
    private boolean numberFound;

    public GameStatus(){}
    public GameStatus(boolean isTooHigh, boolean isTooLow, boolean numberFound) {
        this.isTooHigh = isTooHigh;
        this.isTooLow = isTooLow;
        this.numberFound = numberFound;
    }

    public boolean isTooHigh() {
        return isTooHigh;
    }

    public void setTooHigh(boolean tooHigh) {
        isTooHigh = tooHigh;
    }

    public boolean isTooLow() {
        return isTooLow;
    }

    public void setTooLow(boolean tooLow) {
        isTooLow = tooLow;
    }

    public boolean isNumberFound() {
        return numberFound;
    }

    public void setNumberFound(boolean numberFound) {
        this.numberFound = numberFound;
    }
}
