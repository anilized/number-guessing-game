package org.anil.game.logic;

import org.anil.game.logic.ports.input.CreatePlayerUseCase;
import org.anil.game.logic.ports.input.GetPlayerUseCase;
import org.anil.game.logic.ports.output.PlayerStatisticsOutputPort;
import org.anil.game.model.player.Player;
import org.anil.game.model.statistics.Scores;

import java.util.Scanner;

public class PlayerGenerator implements CreatePlayerUseCase, GetPlayerUseCase {
    private final PlayerStatisticsOutputPort playerStatisticsOutputPort;

    public PlayerGenerator(PlayerStatisticsOutputPort playerStatisticsOutputPort) {
        this.playerStatisticsOutputPort = playerStatisticsOutputPort;
    }

    @Override
    public Player createPlayer() {
        System.out.println("Enter name to create a player");
        Scanner scanner = new Scanner(System.in);
        String nameInput;

        while (true) {
            nameInput = scanner.nextLine();

            if (nameInput.matches("^[a-zA-Z ]+$")) {
                break; //
            } else {
                System.out.println("Invalid input. Only strings allowed (letters and spaces).");
            }
        }

        Player player = new Player();
        player.setName(nameInput);
        player.setScore();
        return player;
    }

    @Override
    public Player getPlayer(String name, Scores scores) {
        return playerStatisticsOutputPort.getPlayerByName(name, scores);
    }
}
