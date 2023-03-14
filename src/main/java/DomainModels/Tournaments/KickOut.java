package DomainModels.Tournaments;

import DomainModels.DtoPlayer;
import DomainModels.Game;
import DomainModels.Round;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class KickOut extends Tournament{
    public KickOut(String name, LocalDateTime startDate, LocalDateTime endDate, String city, Map<Integer, Round> rounds) {
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
