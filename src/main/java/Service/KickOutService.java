package Service;

import DomainModels.*;
import Enums.Result;
import Repos.PlayerRepo;

import java.util.*;

public class KickOutService {
    private static final PlayerRepo repo = PlayerRepo.getInstance();
    RandomService randomService = new RandomService();
    public ArrayList<Game> getGames(){
        ArrayList<Game> games = new ArrayList<>();
        List<Integer> randomArray = new ArrayList<>(repo.getPlayersFromRepo().keySet());
        if (randomArray.size() == 1)
            return null;
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

    public HashMap<Integer, Player> deleteLosingPlayersAndGetRemainingOnes(Round round){
        ArrayList<Game> games = round.getGames();
        int i;
        Game currentGame;
        for (i=0;i<games.size();i++)
        {
            currentGame = games.get(i);
            deleteLosingPlayerFromRepo(currentGame);
        }
        return repo.getPlayersFromRepo();


    }
    private void deleteLosingPlayerFromRepo(Game game ){
        if (game.getResult() == Result.BLACK)
            repo.deletePlayerFromRepo(game.getIdWhite());
        if (game.getResult() == Result.WHITE)
            repo.deletePlayerFromRepo(game.getIdBlack());
    }
    public ArrayList<DtoPlayer> getRemainingPlayers(){

        ArrayList<DtoPlayer> dtoPlayers = new ArrayList<>();
        for ( Map.Entry<Integer,Player> set : repo.getPlayersFromRepo().entrySet()) {
            dtoPlayers.add(convertPlayerToDtoPlayer(set.getValue()));

        }

        return  dtoPlayers;

    }
    private DtoPlayer convertPlayerToDtoPlayer (Player player){
        return new DtoPlayer(player.getId(), player.getFirstName(), player.getLastName() ,player.getCurrentRating());
    }

}
