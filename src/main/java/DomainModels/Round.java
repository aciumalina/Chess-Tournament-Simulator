package DomainModels;

import java.util.ArrayList;

public class Round {
    int roundNumber;
    ArrayList<Game> games;

    public Round(int roundNumber, ArrayList<Game> games) {
        this.roundNumber = roundNumber;
        this.games = games;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    @Override
    public String toString() {
        return "Round{" +
                "roundNumber=" + roundNumber +
                ", games=" + games +
                '}';
    }
}
