package Service;

import DomainModels.Player;
import DomainModels.PlayerRequest;
import Repos.PlayerRepo;

public class PlayerService {
    PlayerRepo repo = new PlayerRepo();

    private Player convertPlayerReqToPlayer(PlayerRequest playerRequest){
        return new Player(playerRequest.getFirstName(),playerRequest.getLastName(),playerRequest.getAge(), playerRequest.getCurrentRating(), playerRequest.getGender(), playerRequest.getClub());
    }
    public Player createPlayer(PlayerRequest playerRequest){
        Player player = convertPlayerReqToPlayer(playerRequest);
        return repo.addPlayerToRepo(player);
    }

    public void showPlayers(){
        repo.showPlayersFromRepo();
    }
    public Player getPlayer(int id){
        return repo.getPlayerFromRepo(id);
    }

    public int deletePlayer(int id){
        return repo.deletePlayerFromRepo(id);
    }

    public Player editPlayer(PlayerRequest playerRequest, int id){
        Player player = convertPlayerReqToPlayer(playerRequest);
        player.setId(id);
        return repo.editPlayerFromRepo(player, id);
    }

}
