package org.anil.game.infra.persistance.util;

import org.anil.game.model.player.Player;

public class ScoresMapper {
    public Player toPlayer(String line) {
        String[] splittedLine = line.split(" ");
        return new Player(splittedLine[0], Integer.parseInt(splittedLine[1]), null);
    }
}
