package org.anil.game.logic.ports.input;

import org.anil.game.model.player.Player;
import org.anil.game.model.statistics.Scores;

public interface GetPlayerUseCase {
    Player getPlayer(String name, Scores scores);
}
