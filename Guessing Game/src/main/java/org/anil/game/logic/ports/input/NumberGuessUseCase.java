package org.anil.game.logic.ports.input;

import org.anil.game.model.player.Player;

public interface NumberGuessUseCase {
    void compareNumbers(int guessedNumber, int actualNumber, Player player);
}
