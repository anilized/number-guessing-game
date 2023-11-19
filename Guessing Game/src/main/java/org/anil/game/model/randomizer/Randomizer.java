package org.anil.game.model.randomizer;

import java.util.Random;

public class Randomizer {
    public static final int MIN_NUM = 0;
    public static final int MAX_NUM = 100;
    final Random random;

    public Randomizer() {
        random = new Random();
    }

    public int getRandomNumber() {
        return random.nextInt(MAX_NUM - MIN_NUM) + MIN_NUM;
    }

}
