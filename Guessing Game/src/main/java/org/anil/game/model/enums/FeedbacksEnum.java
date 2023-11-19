package org.anil.game.model.enums;

public enum FeedbacksEnum {
    TOO_HIGH("Given number is too high!"),
    TOO_LOW("Given number is too low!"),
    SUCCESS("You have found the number. Congrats!"),
    FAIL("Cannot find number in 10 attempts. Game failed."),
    SCORE_NOT_FOUND("Scores not found. Press [S] to continue the game"),
    NUMBER_VALIDATION("Only numbers allowed!"),
    NUMBER_GUESS_QUESTION("Guess the number: "),
    WRONG_INPUT("Wrong input"),
    GAME_INFO("See Scores [I] | Quit [Q] | Start Game [S]");

    private final String feedBack;

    FeedbacksEnum(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getFeedBack() {return feedBack;}
}
