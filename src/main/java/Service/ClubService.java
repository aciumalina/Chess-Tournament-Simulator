package Service;

import DomainModels.Club;
import Repos.ClubRepo;

import java.util.HashMap;
import java.util.Map;

public class ClubService {
    ClubRepo repo = new ClubRepo();

    public Map<Integer, Club> getClubs(){
        return repo.getClubsFromRepo();
    }
}
