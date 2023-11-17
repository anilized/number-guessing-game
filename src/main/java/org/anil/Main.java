package org.anil;

import org.anil.game.application.GameManager;
import org.anil.game.infra.persistance.TxtFilePersistenceAdapter;
import org.anil.game.infra.persistance.util.ScoresMapper;
import org.anil.game.logic.GuessController;
import org.anil.game.logic.PlayerGenerator;
import org.anil.game.logic.RandomNumberGenerator;
import org.anil.game.logic.ports.input.CreatePlayerUseCase;
import org.anil.game.logic.ports.input.GenerateNumberUseCase;
import org.anil.game.logic.ports.input.NumberGuessUseCase;
import org.anil.game.logic.ports.output.PlayerStatisticsOutputPort;

public class Main {

    public static void main(String[] args) {
        ScoresMapper scoresMapper = new ScoresMapper();
        PlayerStatisticsOutputPort playerStatisticsOutputPort = new TxtFilePersistenceAdapter(scoresMapper);
        CreatePlayerUseCase createPlayerUseCase = new PlayerGenerator(playerStatisticsOutputPort);
        GenerateNumberUseCase generateNumberUseCase = new RandomNumberGenerator();
        NumberGuessUseCase numberGuessUseCase = new GuessController();

        GameManager gameManager = new GameManager(playerStatisticsOutputPort, createPlayerUseCase, generateNumberUseCase, numberGuessUseCase);
        gameManager.startGame();
    }
}