package DomainModels;

import Enums.Result;

public class Game {
    int idWhite;
    int idBlack;
    Result result;

    public Game(int idWhite, int idBlack){
        this.idWhite = idWhite;
        this.idBlack = idBlack;
    }


    public Result getResult() {
        return result;
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
