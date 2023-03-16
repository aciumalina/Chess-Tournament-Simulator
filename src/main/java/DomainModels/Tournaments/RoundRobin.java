package DomainModels.Tournaments;

import DomainModels.DtoPlayer;
import DomainModels.Player;
import DomainModels.Round;
import Service.RoundRobinService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class RoundRobin extends Tournament{

    RoundRobinService roundRobinService = new RoundRobinService();

    public RoundRobin(String name, LocalDate startDate, LocalDate endDate, String city) {
        super(name, startDate, endDate, city);
    }

    @Override
    public ArrayList<Round> pairPlayers() {
        HashMap<Integer, Player> players = roundRobinService.getPlayers();
        ArrayList<Round> runde = new ArrayList<Round>();
        ArrayList<Game> allGames = new ArrayList<Game>();
        //players.forEach((id, player ) -> System.out.println(player.toStringWithoutAnimation()));
        for(int i = 0; i < players.size() - 1; i++)
            for(int j = i + 1; j < players.size(); j++)
                allGames.add(roundRobinService.createGame(i,j));



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
