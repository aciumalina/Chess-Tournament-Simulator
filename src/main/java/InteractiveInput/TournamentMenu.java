package InteractiveInput;

import DomainModels.DtoPlayer;
import DomainModels.Game;
import DomainModels.Player;
import DomainModels.Tournaments.KickOut;
import DomainModels.Tournaments.RoundRobin;
import DomainModels.Tournaments.Tournament;
import DomainModels.Tournaments.TournamentRequest;
import Enums.Option;
import Enums.Result;
import Enums.TournamentOption;
import Errors.CustomError;
import Repos.PlayerRepo;
import Service.RoundRobinService;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TournamentMenu {
    Tournament tournament;
    PlayerRepo repo = PlayerRepo.getInstance();


    public TournamentMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Introdu tipul turneului (Round Robin/Kick Out Format)");
            System.out.println("Round Robin - optiunea 1");
            System.out.println("Kick Out - optiunea 2");
            int optiune = scanner.nextInt();
            if (optiune == 1)
            {
                System.out.println("Ati ales turneu de tip Round Robin");
                if(!evenNumber(repo.getNumberOfPlayers())){
                    System.out.println("Nu puteti incepe acest tip de turneu! ( trebuie ca numarul de jucatori sa fie par) ");
                    break;
                }
                TournamentRequest tournamentRequest = getTournamentDetails();
                this.tournament = new RoundRobin(tournamentRequest.getName(),tournamentRequest.getStartDate(),tournamentRequest.getEndDate(),tournamentRequest.getCity());
                break;
            }

            if (optiune == 2) {
                System.out.println("Ati ales turneu de tip Kick Out");
                if (!powerOfTwoBitwise(repo.getNumberOfPlayers())){
                    System.out.println("Nu puteti incepe acest tip de turneu! ( trebuie ca numarul de jucatori sa fie putere a lui 2 ");
                    break;
                }
                TournamentRequest tournamentRequest2 = getTournamentDetails();
                this.tournament = new KickOut(tournamentRequest2.getName(),tournamentRequest2.getStartDate(),tournamentRequest2.getEndDate(),tournamentRequest2.getCity());
                break;
            } else {
                System.out.println("Optiune invalida!");
            }
        }
    }

    public void showOptions(){
        System.out.println("0. Incheie simularea turneului");
        System.out.println("1. Incepeti runda");
        System.out.println("2. Arata clasamentul actual");
    }
     public void chooseOption(TournamentOption option){
        Scanner scanner = new Scanner(System.in);
        switch (option){
            case PAIR_PLAYERS:
                ArrayList<Game> games = tournament.pairPlayers().getGames();
                if ( games.size() == 0)
                {
                    System.out.println("Turneul s-a incheiat! Iata rezultatul final: \n \n");
                    chooseOption(TournamentOption.SHOW_STANDINGS);
                    break;
                }
                int i;
                //sleep 2 secunde pana sa ceara rezultatele
                for (i=0;i<games.size();i++)
                {
                    Result result = null;
                    shouPlayingPlayers(games.get(i));
                    while (true){

                        System.out.println("\n1 -- pentru victorie alb");
                        System.out.println("2 -- pentru remiza");
                        System.out.println("3 -- pentru victorie negru");
                        int option2 = scanner.nextInt();
                        try{
                            switch (option2){
                                case 1:
                                    result = Result.WHITE;
                                    break;
                                case 2:
                                    result = Result.DRAW;
                                    break;
                                case 3:
                                    result = Result.BLACK;
                                    break;
                                default:
                                    //System.out.println("Rezultat invalid!");
                                    throw new CustomError("Rezultat invalid");
                        }
                    }
                        catch (CustomError err){
                            System.out.println(err.getMessage());
                        }
                        if (result != null)
                            break;
                    }
                    tournament.inputResult(i, result);

                }
                tournament.updatePlayersStats();
                break;
            case SHOW_STANDINGS:
                ArrayList<DtoPlayer> playersToShow = tournament.showStandings();
                for ( int j=0; j<playersToShow.size();j++)
                {
                    System.out.println("Locul " + (j+1) + ". " + playersToShow.get(j));
                }
                break;




        }
    }
    private void shouPlayingPlayers(Game currentGame){
        Player white = repo.getPlayerFromRepo(currentGame.getIdWhite());
        Player black = repo.getPlayerFromRepo(currentGame.getIdBlack());
        System.out.println(white.getFirstName() + " " + white.getLastName() +"(alb) vs " + black.getFirstName() + " " + black.getLastName() +"(negru)");
    }
    private TournamentRequest getTournamentDetails() {
        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                System.out.println("Introdu numele turneului: ");
                String name = scanner.nextLine();
                System.out.println("Introdu data finalizarii (dd/mm/yyyy): ");
                String dataString = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                LocalDate data = LocalDate.parse(dataString, formatter);
                System.out.println("Introdu orasul care gazduieste turneul: ");
                String city = scanner.nextLine();
                return new TournamentRequest(name, LocalDate.now(), data, city);
            }
            catch (DateTimeException e){
                System.out.println("Datele introduse sunt invalide!");

            }

        }

    }

    private boolean powerOfTwoBitwise(int n)
    {
        return (n & n-1)==0;
    }

    private boolean evenNumber(int n){
        return (n%2) == 0;
    }


}
