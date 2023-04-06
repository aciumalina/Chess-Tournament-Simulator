package Repos;

import DomainModels.Club;
import DomainModels.Player;

import java.util.HashMap;
import java.util.Map;

public class ClubRepo {
    public static int currentId = 0;
    Map<Integer, Club> repo = new HashMap<Integer, Club>();

    public Club addClubToRepo(Club club) {
        incrementId();
        club.setId(currentId);
        repo.put(currentId,club);
        return club;
    }
    public ClubRepo(){
        repo.put(incrementId(), new Club("Clubul Central de Sah", "Bucuresti", 2004));
        repo.put(incrementId(), new Club( "Clubul Sportiv Universitar", "Iasi", 2012));
        repo.put(incrementId(), new Club( "Clubul Sportiv Scolar Nr. 2", "Galati", 2015));
        repo.put(incrementId(), new Club( "Clubul Municipal de Sah", "Arad", 2003));
        repo.put(incrementId(), new Club("Clubul Sportiv Studentesc", "Timisoara", 1999));
        repo.put(incrementId(), new Club("Clubul Sportiv Municipal", "Iasi", 2012));
        repo.put(incrementId(), new Club("Clubul Sportiv Scolar Nr. 5", "Constanta", 2008));
    }
    public Map<Integer, Club> getClubsFromRepo(){
        return repo;
    }

    public Club getClubFromRepo(int id){
        return repo.get(id);
    }

    public int deleteClubFromRepo(int id){
        if (repo.remove(id) != null)
            return  1;
        else
            return 0;
    }

    public Club editClubFromRepo(Club club, int id) {
        return repo.replace(id, club);
    }
    private static int incrementId(){
        currentId += 1;
        return currentId;
    }
}
