package cy.olesiabokk.userflowapp.model.service.util;

import java.util.concurrent.atomic.AtomicLong;

public class Generator {
    private final Randomizer randomizer;
    private static final AtomicLong counter = new AtomicLong(0);

    public Generator(Randomizer randomizer){
        this.randomizer = randomizer;
    }

    public String generateAlphaNumString(){
        String initial = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] alphaNum = new char[randomizer.getRandomNumber(5, 20)];
        for (int i = 0; i < alphaNum.length; i++) {
            alphaNum[i] = initial.charAt(randomizer.getRandomNumber(0, initial.toCharArray().length));
        }
        return String.valueOf(alphaNum);
    }

    public Long generateUserID() {
        return counter.addAndGet(1);
    }

    public int generateUserAge() {
        return randomizer.getRandomNumber(1, 100);
    }

    public StringBuilder generateUserPassword(){
        return new StringBuilder(generateAlphaNumString());
    }

}
