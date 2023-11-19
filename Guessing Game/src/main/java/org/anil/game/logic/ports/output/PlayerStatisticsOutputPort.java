package org.anil.game.logic.ports.output;

import org.anil.game.model.player.Player;
import org.anil.game.model.statistics.Scores;
import java.util.Optional;


public interface PlayerStatisticsOutputPort {
    void saveScore(Player player);
    Optional<Scores> getScoresFile(String fileName);
    void createScoresFile();
    Player getPlayerByName(String name, Scores scores);
}
