package DomainModels.Tournaments;

import DomainModels.DtoPlayer;
import DomainModels.Game;
import DomainModels.Round;
import java.time.LocalDate;
import Service.KickOutService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class KickOut extends Tournament{
    KickOutService kickOutService = new KickOutService();
    public KickOut(String name, LocalDate startDate, LocalDate endDate, String city) {
        super(name, startDate, endDate, city);
    }

    @Override
    public ArrayList<Game> pairPlayers() {
        return null;
    }

    @Override
    public ArrayList<DtoPlayer> showStandings() {
        return null;
    }

    @Override
    public void updatePlayersStats() {

    }
}
