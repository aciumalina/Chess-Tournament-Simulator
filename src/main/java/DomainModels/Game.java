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

    public int getIdWhite() {
        return idWhite;
    }

    public void setIdWhite(int idWhite) {
        this.idWhite = idWhite;
    }

    public int getIdBlack() {
        return idBlack;
    }

    public void setIdBlack(int idBlack) {
        this.idBlack = idBlack;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
