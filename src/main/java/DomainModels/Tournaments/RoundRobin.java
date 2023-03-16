package DomainModels.Tournaments;

import DomainModels.DtoPlayer;
import DomainModels.Game;
import DomainModels.Player;
import DomainModels.Round;
import Service.RoundRobinService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class RoundRobin extends Tournament{

    RoundRobinService roundRobinService = new RoundRobinService();

    private static int roundNumber = 0 ;
    HashMap<Integer, Player> players = roundRobinService.getPlayers();
    ArrayList<Integer> playersId = new ArrayList<>(players.keySet());

    public RoundRobin(String name, LocalDate startDate, LocalDate endDate, String city) {
        super(name, startDate, endDate, city);
    }

    @Override
    public Round pairPlayers() {
        incrementRoundNumber();
        ArrayList<Game> games = new ArrayList<Game>();
        //players.forEach((id, player ) -> System.out.println(player.toStringWithoutAnimation()));
//        for(int i = 0; i < players.size() - 1; i++)
//            for(int j = i + 1; j < players.size(); j++)
//                allGames.add(roundRobinService.createGame(i,j));

        int n = players.size();
        for(int i = 0; i < n-1; i++){
            for (int j = 0; j < n / 2; j++) {
                int k = (n - 1) - j; // calculăm indexul pentru a doua pereche

                // Afisam perechea de numere
                games.add(roundRobinService.createGame(j,k));
                System.out.println("(" + playersId.get(j)+ "," + playersId.get(k) + ")");
            }
            int temp = playersId.get(n-1);
            for (int j = n - 1; j > 1; j--)
                playersId.set(j, playersId.get(j-2));
            playersId.set(1,temp);
            break;
        }
        Round currentRound = new Round(roundNumber, games);
        this.rounds.put(roundNumber,currentRound);
        return currentRound;
    }

    @Override
    public ArrayList<DtoPlayer> showStandings() {
        return null;
    }

    @Override
    public void updatePlayersStats() {

    }

    private static void incrementRoundNumber(){
        roundNumber +=1;
    }


}
