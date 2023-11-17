package org.anil.game.model.statistics;

import org.anil.game.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Scores {
    public static final String FILE_NAME = "scores.txt";
    private final List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }
}
