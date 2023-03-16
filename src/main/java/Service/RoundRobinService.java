package Service;

import DomainModels.Game;
import DomainModels.Player;
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
        int ratingWhite = whitePlayer.getCurrentRating();
        int ratingBlack = blackPlayer.getCurrentRating();
        int ratingDifference = (ratingWhite - ratingBlack);
        if (abs(ratingDifference) > 200)
                ratingDifference = 200;
        int minimumChange = 8;
        int ratingDifferenceUnits = (int)(ratingDifference/30);
        switch (game.getResult()){
            case WHITE:

                whitePlayer.setNumberOfPoints(whitePlayer.getNumberOfPoints()+1);
                whitePlayer.setBuchholtz(whitePlayer.getBuchholtz() + blackPlayer.getNumberOfPoints());
                //if white is better player
                // ratingPoints = minimumChange - Units;
                //else
                //reting point = + Units
                whitePlayer.setCurrentRating(whitePlayer.getCurrentRating()+minimumChange+abs(ratingDifferenceUnits));
                blackPlayer.setCurrentRating(blackPlayer.getCurrentRating()-minimumChange+abs(ratingDifferenceUnits));
                break;
            case BLACK:
                blackPlayer.setNumberOfPoints(blackPlayer.getNumberOfPoints()+1);
                blackPlayer.setBuchholtz(blackPlayer.getBuchholtz() + whitePlayer.getNumberOfPoints());
                blackPlayer.setCurrentRating(blackPlayer.getCurrentRating()+minimumChange+abs(ratingDifferenceUnits));
                whitePlayer.setCurrentRating(whitePlayer.getCurrentRating()+minimumChange-abs(ratingDifferenceUnits));
            case DRAW:
                whitePlayer.setNumberOfPoints(whitePlayer.getNumberOfPoints()+0.5);
                blackPlayer.setNumberOfPoints(blackPlayer.getNumberOfPoints()+0.5);
                blackPlayer.setBuchholtz(blackPlayer.getBuchholtz() + whitePlayer.getNumberOfPoints());
                whitePlayer.setBuchholtz(whitePlayer.getBuchholtz() + blackPlayer.getNumberOfPoints());
                if (ratingDifference > 0){
                    //albul este jucatorul mai puternic
                    whitePlayer.setCurrentRating(whitePlayer.getCurrentRating()-(minimumChange+abs(ratingDifferenceUnits))/2);
                }
                break;
        }
    }


}
