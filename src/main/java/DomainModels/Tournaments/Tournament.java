package DomainModels.Tournaments;

import DomainModels.DtoPlayer;
import DomainModels.Game;
import DomainModels.Round;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Tournament {
    String name;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String city;
    Map<Integer, Round> rounds;

    public Tournament(String name, LocalDateTime startDate, LocalDateTime endDate, String city, Map<Integer, Round> rounds) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.city = city;
        this.rounds = rounds;
    }

    void inputResults(){
        //TODO
    }

    abstract ArrayList<Game> pairPlayers();
    abstract ArrayList<DtoPlayer> showStandings();
    abstract void updatePlayersStats();
}
