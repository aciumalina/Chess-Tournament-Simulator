package Service;

import DomainModels.Club;
import DomainModels.ClubRequest;
import DomainModels.Player;
import DomainModels.PlayerRequest;
import Repos.ClubRepo;

import java.util.HashMap;
import java.util.Map;

public class ClubService {
    ClubRepo repo = new ClubRepo();

    private Club convertClubReqToClub(ClubRequest clubRequest){
        return new Club(clubRequest.getName(), clubRequest.getCity(), clubRequest.getFoundingYear());
    }
    public Club createClub(ClubRequest clubRequest){
        Club club = convertClubReqToClub(clubRequest);
        return repo.addClubToRepo(club);
    }

    public Map<Integer, Club> getClubs(){
        return repo.getClubsFromRepo();
    }
}
