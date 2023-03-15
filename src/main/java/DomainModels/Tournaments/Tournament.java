package DomainModels.Tournaments;

import DomainModels.DtoPlayer;
import DomainModels.Game;
import DomainModels.Round;
import Enums.Result;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public abstract class Tournament {
    String name;
    LocalDate startDate;
    LocalDate endDate;
    String city;
    Map<Integer, Round> rounds;

    public Tournament(String name, LocalDate startDate, LocalDate endDate, String city) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.city = city;
    }

    public void inputResult(int gameId, Result result){
        //luam ultima runda din rounds si adaugam resultatul meciului
    }

    public abstract Round pairPlayers();
    public abstract ArrayList<DtoPlayer> showStandings();
    public abstract void updatePlayersStats();

}
