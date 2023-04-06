package Service;


import DomainModels.Player;
import Enums.BetterPlayer;
import Enums.Result;

import static java.lang.Math.abs;

public interface CommonMethodsForTournamentServices {
    default void updatePlayersStatsImplementation(Player whitePlayer, Player blackPlayer, Result result){

        int ratingDifference = getRatingDifference(whitePlayer,blackPlayer);
        int ratingDifferenceUnits = getRatingDifferenceUnits(ratingDifference);
        BetterPlayer betterPlayer = getBetterPlayer(ratingDifference);
        int minimumChange = 8;
        int ratingPoints;
        switch (result){
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
        return ratingDifference/30;

    }
    private int getRatingDifference(Player white, Player black){
        return white.getCurrentRating() - black.getCurrentRating();
    }
}
