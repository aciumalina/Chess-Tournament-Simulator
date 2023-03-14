package DomainModels.Tournaments;

import DomainModels.DtoPlayer;
import DomainModels.Game;
import DomainModels.Round;
import Service.RoundRobinService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class RoundRobin extends Tournament{

    RoundRobinService roundRobinService = new RoundRobinService();

    public RoundRobin(String name, LocalDateTime startDate, LocalDateTime endDate, String city, Map<Integer, Round> rounds) {
        super(name, startDate, endDate, city, rounds);
    }

    @Override
    ArrayList<Game> pairPlayers() {
        return null;
    }

    @Override
    ArrayList<DtoPlayer> showStandings() {
        return null;
    }

    @Override
    void updatePlayersStats() {

    }


}
