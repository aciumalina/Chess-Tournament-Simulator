package Repos;

import DomainModels.Player;
import DomainModels.PlayerRequest;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayerRepo {
    public static int currentId = 0;
    Map<Integer, Player> repo = new HashMap<Integer, Player>();
    public Player addPlayerToRepo;

    public Player addPlayerToRepo(Player player) {
        incrementId();
        player.setId(currentId);
        repo.put(currentId,player);
        return player;
    }
    public HashMap<Integer,Player> getPlayersFromRepo(){
        return (HashMap<Integer, Player>) repo;
    }

    public int deletePlayerFromRepo(int id )
    {
        if (repo.remove(id) != null)
            return  1;
        else
            return 0;
    }


    private static void incrementId(){
        currentId += 1;
    }

    public Player editPlayerFromRepo(Player player, int id) {
        return repo.replace(id, player);
    }

    public Player getPlayerFromRepo(int id){
        return repo.get(id);
    }
}
