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

    public Club getClub(int id){
        return repo.getClubFromRepo(id);
    }

    public int deleteClub(int id){
        return repo.deleteClubFromRepo(id);
    }

    public Club editClub(ClubRequest clubReq, int id){
        Club club = new Club(clubReq.getName(), clubReq.getCity(), clubReq.getFoundingYear());
        club.setId(id);
        return repo.editClubFromRepo(club, id);
    }

    public Map<Integer, Club> getClubs(){
        return repo.getClubsFromRepo();
    }
}
