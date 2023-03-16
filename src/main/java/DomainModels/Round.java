package DomainModels;

import java.util.ArrayList;

public class Round {
    int roundNumber;
    ArrayList<Game> games;

    public Round(int roundNumber, ArrayList<Game> games) {
        this.roundNumber = roundNumber;
        this.games = games;
    }
}
