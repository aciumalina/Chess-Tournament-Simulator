package Service;

import DomainModels.Player;
import Repos.PlayerRepo;

import java.util.HashMap;

public class RoundRobinService {
    PlayerRepo players = PlayerRepo.getInstance();


    public HashMap<Integer, Player> getPlayers(){
        return  players.getPlayersFromRepo();
    }
}
