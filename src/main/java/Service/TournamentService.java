package Service;

import DomainModels.Player;
import Repos.PlayerRepo;

import java.security.KeyStore;

public class TournamentService {
    PlayerRepo players = PlayerRepo.getInstance();
    private int getNumberOfPlayersFromRepo(){
        return players.getNumberOfPlayers();
    }
    public boolean canStartRoundRobinTournament(){
        return getNumberOfPlayersFromRepo() % 2 == 0;
    }
    public boolean canStartKickOutTournament(){
        var n = getNumberOfPlayersFromRepo();
        return (n & n-1)==0;
    }
    public Player getPlayerFromRepo(int id){
        return players.getPlayerFromRepo(id);
    }



}
