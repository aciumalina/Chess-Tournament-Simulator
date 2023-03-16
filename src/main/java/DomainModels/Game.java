package DomainModels;

import Enums.Result;

public class Game {
    int idWhite;

    public Game(int idWhite, int idBlack) {
        this.idWhite = idWhite;
        this.idBlack = idBlack;
    }

    int idBlack;
    Result result;

    public Result getResult() {
        return result;
    }

    public int getIdWhite() {
        return idWhite;
    }

    public int getIdBlack() {
        return idBlack;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    public void showPlayingPlayers()
    {
        System.out.println("Jucatorul " + idWhite + "(piesele albe) vs " + " Jucatorul " + idBlack + "(piesele negre)");
    }
    @Override
    public String toString() {
        return "Game{" +
                "idWhite=" + idWhite +
                ", idBlack=" + idBlack +
                ", result=" + result +
                '}';
    }
}
