package Service;

import java.util.Random;

public class RandomService {

    public int getRandomNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
