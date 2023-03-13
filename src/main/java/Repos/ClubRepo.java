package Repos;

import DomainModels.Club;
import DomainModels.Player;

import java.util.HashMap;
import java.util.Map;

public class ClubRepo {
    public static int currentId = 0;
    Map<Integer, Club> repo = new HashMap<Integer, Club>();

    public ClubRepo(){
        repo.put(incrementId(), new Club("Clubul Central de Sah", "Bucuresti", 2004));
        repo.put(incrementId(), new Club("Clubul Sportiv Universitar", "Iasi", 2012));
        repo.put(incrementId(), new Club("Clubul Sportiv Scolar Nr. 2", "Galati", 2015));
        repo.put(incrementId(), new Club("Clubul Municipal de Sah", "Arad", 2003));
    }
    public Map<Integer, Club> getClubsFromRepo(){
        return repo;
    }
    private static int incrementId(){
        currentId += 1;
        return currentId;
    }
}
