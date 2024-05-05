package cy.olesiabokk.userflowapp.model.service.util;

import java.util.Random;

public class Randomizer {
    private final Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt();
    }

    public int getRandomNumber(int from, int to) {
        int randomNum = getRandomNumber();
        if (randomNum < from || randomNum > to) {
            randomNum = (from + random.nextInt(to - from));
        }
        return randomNum;
    }
}
