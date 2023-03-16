package Service;

import DomainModels.Game;
import DomainModels.Player;
import DomainModels.Round;
import Repos.PlayerRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class RoundRobinService {
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

    public ArrayList<Round> createRounds(ArrayList<Game> games){
        int noOfRounds = this.getPlayers().size()-1;
        Map<Integer, Integer> occurances = new HashMap<Integer, Integer>();
        for (Game game: games){

        }
    }
}
