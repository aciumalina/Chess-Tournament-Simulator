package DomainModels.Tournaments;

import DomainModels.DtoPlayer;
import DomainModels.Game;
import DomainModels.Round;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

    void inputResults(){
        //TODO
    }

    public abstract ArrayList<Game> pairPlayers();
    public abstract ArrayList<DtoPlayer> showStandings();
    public abstract void updatePlayersStats();
}
