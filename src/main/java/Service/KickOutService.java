package Service;

import DomainModels.*;
import Enums.Result;
import Enums.Winner;
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
            if (deleteLosingPlayerFromRepo(currentGame) == Winner.NO)
            {
                currentGame.setResult(playArmagedon(currentGame));
                deleteLosingPlayerFromRepo(currentGame);
            }
        }
        return repo.getPlayersFromRepo();


    }
    private Result playArmagedon(Game game){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Care a fost rezultatul armagedonului dintre " + game.getIdWhite()+ " si " + game.getIdBlack()+ "?");
        System.out.println("\n1 -- a castigat alb");
        System.out.println("2 -- a fost remiza sau a castigat negru");

        Result result = null;
        int option2 = scanner.nextInt();
        switch (option2){
            case 1:
                result = Result.WHITE;
                break;
            case 2:
                result = Result.BLACK;
                break;
        }
        return result;

    }
    private Winner deleteLosingPlayerFromRepo(Game game ){
        if (game.getResult() == Result.BLACK)
        {
            repo.deletePlayerFromRepo(game.getIdWhite());
            return Winner.YES;
        }

        if (game.getResult() == Result.WHITE)
        {
            repo.deletePlayerFromRepo(game.getIdBlack());
            return Winner.YES;
        }
            return Winner.NO;
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
