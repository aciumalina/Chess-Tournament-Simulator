package Service;

import DomainModels.Game;
import Repos.PlayerRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KickOutService {
    private static final PlayerRepo repo = PlayerRepo.getInstance();
    RandomService randomService = new RandomService();
    public ArrayList<Game> getPairing(){
        List<Integer> randomArray = new ArrayList<>(repo.getPlayersFromRepo().keySet());
        Collections.shuffle(randomArray);
        System.out.println(randomArray);
        return null;
    }

}
