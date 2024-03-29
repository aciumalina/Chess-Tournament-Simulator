package Repos;

import DomainModels.Club;
import DomainModels.Player;
import Enums.Gender;


import java.util.HashMap;
import java.util.Map;


public class PlayerRepo {

    private static PlayerRepo singleInstance = null;
    public static int currentId = 0;
    Map<Integer, Player> repo = new HashMap<Integer, Player>();

    private PlayerRepo(){
        addPlayerToRepo(new Player("Popescu", "Ion", 18, 1756, Gender.Male, "", new Club("Clubul Central de Sah", "Bucuresti", 2009)));
        addPlayerToRepo(new Player("Ionescu", "Maria", 24, 2280, Gender.Female, "WIM",new Club( "Clubul Sportiv Universitar", "Iasi", 2012)));
        addPlayerToRepo(new Player("Badea", "Teodora", 14, 1567, Gender.Female, "", new Club( "Clubul Sportiv Scolar Nr. 2", "Galati", 2015)));
        addPlayerToRepo(new Player("Ardeleanu", "Ionut", 29, 2123, Gender.Male, "FM", new Club( "Clubul Municipal de Sah", "Arad", 2003)));
        addPlayerToRepo(new Player("Dumitru", "Andrei", 13, 1712, Gender.Male, "", new Club("Clubul Central de Sah", "Bucuresti", 2009)));
        addPlayerToRepo(new Player("Marin", "Bogdan", 33, 2434, Gender.Male, "IM", new Club("Clubul Sportiv Studentesc", "Timisoara", 1999)));
        addPlayerToRepo(new Player("Mincu", "Andreea", 16, 2023, Gender.Female, "WFM", new Club("Clubul Sportiv Municipal", "Iasi", 2012)));
        addPlayerToRepo(new Player("Pop", "Rares", 22, 2170, Gender.Male, "FM", new Club("Clubul Sportiv Scolar Nr. 5", "Constanta", 2008)));
    }
    public static  synchronized PlayerRepo getInstance(){
        if (singleInstance == null)
            singleInstance = new PlayerRepo();

        return singleInstance;
    }
    public void reinitializeRepoAfterTournament(HashMap<Integer,Player> newHashMap){
        if (newHashMap != null){
            newHashMap.forEach(repo::putIfAbsent);
        }
        resetBucholtzAndPoints();
    }
    private void resetBucholtzAndPoints(){
        for (Map.Entry<Integer, Player> set : repo.entrySet()){
            set.getValue().setBuchholtz(0);
            set.getValue().setNumberOfPoints(0);
        }
    }

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

    public int getNumberOfPlayers()
    {
        return  repo.size();
    }
}
