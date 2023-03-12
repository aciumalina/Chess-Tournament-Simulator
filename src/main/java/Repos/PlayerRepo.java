package Repos;

import DomainModels.Player;

import java.util.HashMap;
import java.util.Map;

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
    public void showPlayersFromRepo(){
        for (Map.Entry<Integer,Player> set : repo.entrySet()){
            System.out.println("Jucatorul " + set.getKey().toString() + ": \n" + set.getValue());
        }
    }
    private static void incrementId(){
        currentId += 1;
    }

}
