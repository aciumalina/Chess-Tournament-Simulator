package DomainModels.Tournaments;

import DomainModels.DtoPlayer;


import java.time.LocalDate;

import DomainModels.Game;
import DomainModels.Round;
import Service.KickOutService;

import java.util.ArrayList;

public class KickOut extends Tournament{
    KickOutService kickOutService = new KickOutService();
    private static int roundNumber = 0 ;

    public KickOut(String name, LocalDate startDate, LocalDate endDate, String city) {
        super(name, startDate, endDate, city);

    }

    @Override
    public Round pairPlayers() {
        ArrayList<Game> games = kickOutService.getGames();
        if (games == null)
            return new Round(roundNumber, new ArrayList<>());
        incrementRoundNumber();
        Round curentRound = new Round(roundNumber, games);
        this.rounds.put(roundNumber,curentRound);
        return curentRound;
    }

    @Override
    public ArrayList<DtoPlayer> showStandings() {
        return kickOutService.getRemainingPlayers();
    }

    @Override
    public void updatePlayersStats() {
        kickOutService.deleteLosingPlayersAndGetRemainingOnes(this.rounds.get(rounds.size()));

    }

    @Override
    public void reinitializePlayersAfterTournament() {
        kickOutService.reinitTournament();
    }


    private static void incrementRoundNumber(){
        roundNumber +=1;
    }

}
