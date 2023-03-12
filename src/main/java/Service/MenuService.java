package Service;

import DomainModels.Player;
import DomainModels.PlayerRequest;
import Repos.PlayerRepo;

public class MenuService {
    PlayerRepo repository = new PlayerRepo();
    public Player createPlayer(PlayerRequest playerRequest){
        Player player = new Player(playerRequest.getFirstName(),playerRequest.getLastName(),playerRequest.getAge(), playerRequest.getCurrentRating(), playerRequest.getGender());
        return repository.addPlayerToRepo(player);
    }
    public void showPlayers(){
        repository.showPlayersFromRepo();

    }

}
