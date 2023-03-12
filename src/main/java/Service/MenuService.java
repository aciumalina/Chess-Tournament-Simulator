package Service;

import DomainModels.Player;
import DomainModels.PlayerRequest;
import Repos.PlayerRepo;

public class MenuService {
    PlayerRepo repository = new PlayerRepo();

    private Player convertPlayerReqToPlayer(PlayerRequest playerRequest){
        return new Player(playerRequest.getFirstName(),playerRequest.getLastName(),playerRequest.getAge(), playerRequest.getCurrentRating(), playerRequest.getGender());
    }
    public Player createPlayer(PlayerRequest playerRequest){
        Player player = convertPlayerReqToPlayer(playerRequest);
        return repository.addPlayerToRepo(player);
    }

    public void showPlayers(){
        repository.showPlayersFromRepo();

    }
    public Player getPlayer(int id){
        return repository.getPlayerFromRepo(id);
    }

    public int deletePlayer(int id){
        return repository.deletePlayerFromRepo(id);
    }

    public Player editPlayer(PlayerRequest playerRequest, int id){
        Player player = convertPlayerReqToPlayer(playerRequest);
        player.setId(id);
        return repository.editPlayerFromRepo(player, id);
    }

}
