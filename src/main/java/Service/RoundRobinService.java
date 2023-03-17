package Service;

import DomainModels.Game;
import DomainModels.Player;
import Enums.BetterPlayer;
import Enums.Result;
import Repos.PlayerRepo;

import java.util.HashMap;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.floor;


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
    public int getNumberOfPlayersFromRepo(){
        return players.getNumberOfPlayers();
    }

    public void updatePlayersStats(Game game){
        Player whitePlayer = getPlayers().get(game.getIdWhite());
        Player blackPlayer = getPlayers().get(game.getIdBlack());
        int ratingDifference = getRatingDifference(whitePlayer,blackPlayer);
        int ratingDifferenceUnits = getRatingDifferenceUnits(ratingDifference);
        BetterPlayer betterPlayer = getBetterPlayer(ratingDifference);
        int minimumChange = 8;
        int ratingPoints;
        switch (game.getResult()){
            case WHITE:

                whitePlayer.setNumberOfPoints(whitePlayer.getNumberOfPoints()+1);
                whitePlayer.setBuchholtz(whitePlayer.getBuchholtz() + blackPlayer.getNumberOfPoints());
                if (betterPlayer == BetterPlayer.WHITE)
                    ratingPoints = minimumChange - ratingDifferenceUnits;
                else
                    ratingPoints = minimumChange + ratingDifferenceUnits;
                whitePlayer.setCurrentRating(whitePlayer.getCurrentRating()+ratingPoints);
                blackPlayer.setCurrentRating(blackPlayer.getCurrentRating()-ratingPoints);
                break;
            case BLACK:
                blackPlayer.setNumberOfPoints(blackPlayer.getNumberOfPoints()+1);
                blackPlayer.setBuchholtz(blackPlayer.getBuchholtz() + whitePlayer.getNumberOfPoints());
                if (betterPlayer == BetterPlayer.WHITE)
                    ratingPoints = minimumChange + ratingDifferenceUnits;
                else
                    ratingPoints = minimumChange - ratingDifferenceUnits;
                whitePlayer.setCurrentRating(whitePlayer.getCurrentRating()-ratingPoints);
                blackPlayer.setCurrentRating(blackPlayer.getCurrentRating()+ratingPoints);
                break;
            case DRAW:
                whitePlayer.setNumberOfPoints(whitePlayer.getNumberOfPoints()+0.5);
                blackPlayer.setNumberOfPoints(blackPlayer.getNumberOfPoints()+0.5);
                if (betterPlayer == BetterPlayer.WHITE) {
                    whitePlayer.setCurrentRating(whitePlayer.getCurrentRating() - ratingDifferenceUnits);
                    blackPlayer.setCurrentRating(blackPlayer.getCurrentRating() + ratingDifferenceUnits);
                }
                else
                {
                    whitePlayer.setCurrentRating(whitePlayer.getCurrentRating() + ratingDifferenceUnits);
                    blackPlayer.setCurrentRating(blackPlayer.getCurrentRating() - ratingDifferenceUnits);
                }
                break;

        }

    }
    private BetterPlayer getBetterPlayer(int ratingDifference ){
        if (ratingDifference > 0)
            return BetterPlayer.WHITE;
        return BetterPlayer.BLACK;

    }
    private int getRatingDifferenceUnits (int ratingDifference){
        if (abs(ratingDifference) > 200)
            ratingDifference = 200;
        return (int)(ratingDifference/30);

    }
    private int getRatingDifference(Player white, Player black){
        return white.getCurrentRating() - black.getCurrentRating();
    }



}
