package org.anil.game.logic;

import org.anil.game.logic.ports.input.NumberGuessUseCase;
import org.anil.game.model.player.GameStatus;
import org.anil.game.model.player.Player;

public class GuessController implements NumberGuessUseCase {
    @Override
    public void compareNumbers(int guessedNumber, int actualNumber, Player player) {
        GameStatus gameStatus = new GameStatus();
        player.setCurrentStatus(gameStatus);
        if (guessedNumber > actualNumber) {
            player.getCurrentStatus().setTooHigh(true);
            player.getCurrentStatus().setTooLow(false);
        } else if (guessedNumber < actualNumber) {
            player.getCurrentStatus().setTooHigh(false);
            player.getCurrentStatus().setTooLow(true);
        } else {
            player.getCurrentStatus().setTooHigh(false);
            player.getCurrentStatus().setTooLow(false);
            player.getCurrentStatus().setNumberFound(true);
        }
    }

}
