package DomainModels.Tournaments;

import DomainModels.DtoPlayer;
import DomainModels.Game;
import DomainModels.Player;
import DomainModels.Round;
import Service.RoundRobinService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class RoundRobin extends Tournament{

    RoundRobinService roundRobinService = new RoundRobinService();
    int noOfPlayers;

    private static int roundNumber = 0;

    int[][] pairingsTable;

    public RoundRobin(String name, LocalDate startDate, LocalDate endDate, String city) {
        super(name, startDate, endDate, city);

        noOfPlayers = roundRobinService.getNumberOfPlayersFromRepo();
        pairingsTable = new int[noOfPlayers+1][noOfPlayers+1]; // crearea matricei

        // initializarea matricei cu 0-uri si setarea valorii 1 pe diagonala principala
        for (int i = 0; i < noOfPlayers+1; i++) {
            for (int j = 0; j < noOfPlayers+1; j++) {
                if (i == j) {
                    pairingsTable[i][j] = 1;
                } else {
                    pairingsTable[i][j] = 0;
                }
            }
        }
    }

    @Override
    public Round pairPlayers() {
        incrementRoundNumber();
        ArrayList<Game> games = new ArrayList<Game>();
        int[] paired = new int[noOfPlayers+1];
        for (int i = 0; i < noOfPlayers+1; i++)
            paired[i] = 0;

        for(int i = 1; i < noOfPlayers+1; i ++)
        {
            if (paired[i] == 1)
                continue;
            for(int j = 1; j < noOfPlayers+1; j++){
                if(paired[j] == 1)
                    continue;
                if (pairingsTable[i][j] == 0)
                {
                    games.add(roundRobinService.createGame(i,j));
                    pairingsTable[i][j] = 1;
                    pairingsTable[j][i] = 1;
                    paired[i] = paired[j] = 1;
                    break;
                }
            }
        }

        Round currentRound = new Round(roundNumber, games);
        this.rounds.put(roundNumber, currentRound);
        return currentRound;
    }

    @Override
    public ArrayList<DtoPlayer> showStandings() {
        HashMap<Integer, Player> players = roundRobinService.getPlayers();
        ArrayList<Player> playerList = new ArrayList<Player>(players.values());
        Comparator<Player> byPointsThenBucholtz = Comparator.comparing(Player::getNumberOfPoints)
                                                            .reversed()
                                                            .thenComparing(Comparator.comparing(Player::getBuchholtz).reversed())
                                                            ;
        Collections.sort(playerList, byPointsThenBucholtz);

        ArrayList<DtoPlayer> dtoPlayers = new ArrayList<DtoPlayer>();
        for (Player player: playerList){
            dtoPlayers.add(new DtoPlayer(player.getId(), player.getFirstName(), player.getLastName(), player.getCurrentRating(), player.getNumberOfPoints(), player.getBuchholtz()));
        }
        return dtoPlayers;
    }

    @Override
    public void updatePlayersStats() {
        Round lastRound = rounds.get(rounds.size());
        for (Game game: lastRound.getGames()){
            roundRobinService.updatePlayersStats(game);
        }
    }

    @Override
    public void reinitializePlayersAfterTournament() {
        roundRobinService.reinitAfterTorunament();
    }

    private static void incrementRoundNumber(){
        roundNumber +=1;
    }


}
