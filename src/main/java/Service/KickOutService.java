package Service;

import DomainModels.Game;
import Repos.PlayerRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KickOutService {
    private static final PlayerRepo repo = PlayerRepo.getInstance();
    RandomService randomService = new RandomService();
    public ArrayList<Game> getGames(){
        ArrayList<Game> games = new ArrayList<>();
        List<Integer> randomArray = new ArrayList<>(repo.getPlayersFromRepo().keySet());
        Collections.shuffle(randomArray);
        int numberOfPLayers = repo.getNumberOfPlayers();
        int i;
        for (i=0; i<numberOfPLayers; i+=2)
        {
            games.add(createGame(randomArray.get(i), randomArray.get(i + 1)));
        }
        return games;
    }
    private Game createGame(int indexA, int indexB)
    {
        return new Game(indexA,indexB);
    }
}
