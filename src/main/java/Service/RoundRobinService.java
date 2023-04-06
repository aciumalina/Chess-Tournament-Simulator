package Service;

import DomainModels.Game;
import DomainModels.Player;
import Enums.Result;
import Repos.PlayerRepo;

import java.util.HashMap;
import java.util.Random;

public class RoundRobinService implements CommonMethodsForTournamentServices {
    PlayerRepo players = PlayerRepo.getInstance();
    public HashMap<Integer, Player> getPlayers(){
        return players.getPlayersFromRepo();
    }
    public Game createGame(int i, int j){
        Random rand = new Random();
        int random = rand.nextInt(2);
        if (random == 1)
            return new Game(i,j);
        else
            return new Game(j,i);
    }

    public Player getPlayer(int id){
        return players.getPlayerFromRepo(id);
    }
    public int getNumberOfPlayersFromRepo(){
        return players.getNumberOfPlayers();
    }

    public void updatePlayersStats(Game game){
        Player whitePlayer = getPlayers().get(game.getIdWhite());
        Player blackPlayer = getPlayers().get(game.getIdBlack());
        Result result = game.getResult();
        updatePlayersStatsImplementation(whitePlayer,blackPlayer,result);

    }
    public void reinitAfterTorunament(){
        players.reinitializeRepoAfterTournament(null);
    }



}
