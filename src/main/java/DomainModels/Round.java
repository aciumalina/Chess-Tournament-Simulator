package DomainModels;

import java.util.ArrayList;

public class Round {
    int roundNumber;
    ArrayList<Game> games;

    public Round(int roundNumber, ArrayList<Game> games) {
        this.roundNumber = roundNumber;
        this.games = games;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
}
