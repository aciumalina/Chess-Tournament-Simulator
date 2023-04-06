package DomainModels;

import Enums.Result;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    int idWhite;
    int idBlack;
    Result result;

    public Game(int idWhite, int idBlack){
        this.idWhite = idWhite;
        this.idBlack = idBlack;
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
