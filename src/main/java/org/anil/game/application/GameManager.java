package org.anil.game.application;

import org.anil.game.logic.ports.input.CreatePlayerUseCase;
import org.anil.game.logic.ports.input.GenerateNumberUseCase;
import org.anil.game.logic.ports.input.NumberGuessUseCase;
import org.anil.game.logic.ports.output.PlayerStatisticsOutputPort;
import org.anil.game.model.enums.FeedbacksEnum;
import org.anil.game.model.player.Player;
import org.anil.game.model.randomizer.Randomizer;
import org.anil.game.model.statistics.Scores;

import java.util.Objects;
import java.util.Scanner;

public class GameManager {

    private final PlayerStatisticsOutputPort playerStatisticsOutputPort;
    private final CreatePlayerUseCase createPlayerUseCase;
    private final GenerateNumberUseCase generateNumberUseCase;
    private final NumberGuessUseCase numberGuessUseCase;

    public GameManager(PlayerStatisticsOutputPort playerStatisticsOutputPort,
                       CreatePlayerUseCase createPlayerUseCase,
                       GenerateNumberUseCase generateNumberUseCase, NumberGuessUseCase numberGuessUseCase) {
        this.playerStatisticsOutputPort = playerStatisticsOutputPort;
        this.createPlayerUseCase = createPlayerUseCase;
        this.generateNumberUseCase = generateNumberUseCase;
        this.numberGuessUseCase = numberGuessUseCase;
    }

    public void startGame() {
        Scores scoresFile = getScoresFile();

        showGameInfo(scoresFile);

        if (Objects.isNull(scoresFile)) {
            playerStatisticsOutputPort.createScoresFile();
        }

        Player player = createPlayerUseCase.createPlayer();

        int numberToGuess = generateNumberUseCase.generateNumber(new Randomizer());

        int numberInput;
        while (true) {
            if (gameFailed(player)) {
                System.out.println(FeedbacksEnum.FAIL.getFeedBack());
                break;
            }
            System.out.println(FeedbacksEnum.NUMBER_GUESS_QUESTION.getFeedBack());
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext("^\\d+$")) {
                numberInput = scanner.nextInt();
                numberGuessUseCase.compareNumbers(numberInput, numberToGuess, player);
                if (player.getCurrentStatus().isNumberFound()) {
                    System.out.println(FeedbacksEnum.SUCCESS);
                    break;
                } else {
                    player.decreaseScore();
                    giveStatusFeedback(player);
                }
            } else {
                System.out.println(FeedbacksEnum.NUMBER_VALIDATION.getFeedBack());
            }
        }
        saveScore(player);
    }

    private Scores getScoresFile() {
        return playerStatisticsOutputPort.getScoresFile(Scores.FILE_NAME).orElse(null);
    }

    private void giveStatusFeedback(Player player) {
        if (player.getCurrentStatus().isTooLow()) {
            System.out.println(FeedbacksEnum.TOO_LOW.getFeedBack());
            return;
        }

        if (player.getCurrentStatus().isTooHigh()) {
            System.out.println(FeedbacksEnum.TOO_HIGH.getFeedBack());
        }
    }

    private void showScores(Scores scores) {
        if (null == scores.getPlayers() || scores.getPlayers().isEmpty()) {
            System.out.println(FeedbacksEnum.SCORE_NOT_FOUND.getFeedBack());
        } else {
            scores.getPlayers().forEach(System.out::println);
        }
    }

    private void saveScore(Player player) {
        playerStatisticsOutputPort.saveScore(player);
    }

    private void showGameInfo(Scores scoresFile) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(FeedbacksEnum.GAME_INFO.getFeedBack());
            String input = scanner.next();
            if (input.equalsIgnoreCase("i")) {
                showScores(scoresFile);
            } else if (input.equalsIgnoreCase("q")) {
                System.exit(0);
            } else if (input.equalsIgnoreCase("s")) {
                break;
            } else {
                System.out.println(FeedbacksEnum.WRONG_INPUT.getFeedBack());
            }
        }
    }

    private boolean gameFailed(Player player) {
        return player.getScore() <= 0;
    }
}
