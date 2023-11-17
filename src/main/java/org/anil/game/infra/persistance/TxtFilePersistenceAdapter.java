package org.anil.game.infra.persistance;

import org.anil.game.infra.persistance.util.ScoresMapper;
import org.anil.game.logic.ports.output.PlayerStatisticsOutputPort;
import org.anil.game.model.player.Player;
import org.anil.game.model.statistics.Scores;

import java.io.*;
import java.util.Optional;

public class TxtFilePersistenceAdapter implements PlayerStatisticsOutputPort {
    private final ScoresMapper scoresMapper;

    public TxtFilePersistenceAdapter(ScoresMapper scoresMapper) {
        this.scoresMapper = scoresMapper;
    }

    // Save score to txt file
    @Override
    public void saveScore(Player player) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Scores.FILE_NAME));

            BufferedWriter writer = new BufferedWriter(new FileWriter(Scores.FILE_NAME, true));

            if (reader.readLine() != null) {
                writer.newLine();
            }
            writer.write(player.getName() + " " + player.getScore());
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Cannot saved score");
            ioe.printStackTrace();
        }
    }

    // Get saved scores in txt file to show info to play
    @Override
    public Optional<Scores> getScoresFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            Scores scores = new Scores();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                Player player = scoresMapper.toPlayer(currentLine);
                scores.getPlayers().add(player);
            }
            return Optional.of(scores);
        } catch (IOException e) {
            System.out.println("Something wrong happened");
        }
        return Optional.empty();
    }

    // Create an empty file to store scores
    @Override
    public void createScoresFile() {
        try {
            File file = new File(Scores.FILE_NAME);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Cannot create file");
            e.printStackTrace();
        }
    }

    // Get current player if exists
    @Override
    public Player getPlayerByName(String name, Scores scores) {
        if (scores.getPlayers().isEmpty()) {
            return null;
        }
        return scores.getPlayers().stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
