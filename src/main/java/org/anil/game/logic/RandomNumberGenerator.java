package org.anil.game.logic;

import org.anil.game.logic.ports.input.GenerateNumberUseCase;
import org.anil.game.model.randomizer.Randomizer;
public class RandomNumberGenerator implements GenerateNumberUseCase {

    @Override
    public int generateNumber(Randomizer randomizer) {
        return randomizer.getRandomNumber();
    }
}
