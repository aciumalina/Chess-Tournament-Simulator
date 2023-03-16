package DomainModels.Tournaments;

import DomainModels.DtoPlayer;


import java.time.LocalDate;

import DomainModels.Round;
import Service.KickOutService;

import java.util.ArrayList;

public class KickOut extends Tournament{
    KickOutService kickOutService = new KickOutService();

    public KickOut(String name, LocalDate startDate, LocalDate endDate, String city) {
        super(name, startDate, endDate, city);

    }

    @Override
    public ArrayList<Round> pairPlayers() {
        kickOutService.getPairing();
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
