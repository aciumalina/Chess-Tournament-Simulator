package InteractiveInput;

import DomainModels.Club;
import DomainModels.Player;
import DomainModels.PlayerRequest;
import Enums.Gender;
import Enums.Option;
import Service.ClubService;
import Service.PlayerService;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    PlayerService playerService = new PlayerService();
    ClubService clubService = new ClubService();

    public void showPrimaryOptions(){
        System.out.println("Pagina principala :");
        System.out.println("0. Paraseste aplicatia");
        System.out.println("1. Adauga jucator");
        System.out.println("2. Afiseaza toti jucatorii");
        System.out.println("3. Sterge un jucator");
        System.out.println("4. Editeaza datele unui jucator");
    }
    public  void chooseOption(Option option){
        switch (option){
            case NewPlayer:
                System.out.println(playerService.createPlayer(getPlayerDetails()));
                break;
            case ShowPlayers:
                playerService.showPlayers();
                break;
            case EditPlayer:
                int id = idToEdit();
                if (playerService.getPlayer(id)==null){
                    System.out.println("Jucatorul cu id-ul introdus nu exista");
                }
                else{
                    System.out.println((playerService.getPlayer(id)));
                    playerService.editPlayer(getPlayerDetails(),id);
                    System.out.println("Jucatorul a fost editat cu succes");
                }
                break;

            case DeletePlayer:
                if (playerService.deletePlayer(idToDelete()) == 1){
                    System.out.println("Jucatorul a fost sters cu succes");

                }
                else{
                System.out.println("Jucatorul cu id-ul introdus nu exista");

            }
                break;

        }

    }
    private PlayerRequest getPlayerDetails() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        PlayerRequest playerRequest = new PlayerRequest();
        System.out.println("First Name = ");
        playerRequest.setFirstName(scanner.nextLine());
        System.out.println("Last Name = ");
        playerRequest.setLastName(scanner.nextLine());
        System.out.println("Age = ");
        playerRequest.setAge(scanner.nextInt());
        System.out.println("Current rating = ");
        playerRequest.setCurrentRating(scanner.nextInt());
        System.out.println("Gender M/F  ");


        do {
            char gender = scanner.next().charAt(0);
            if (gender == 'M' || gender == 'm') {
                playerRequest.setGender(Gender.Male);
                break;
            }
            if (gender == 'F' || gender == 'f') {
                playerRequest.setGender(Gender.Female);
                break;
            }
            System.out.println("Invalid input ");
            System.out.println("Gender M/F  ");

        } while (true);

        while (true){

            System.out.println("Introduceti id-ul clubului din lista urmatoare:");
            for (Map.Entry<Integer, Club> set : clubService.getClubs().entrySet()){
                System.out.println(set.getKey().toString() + ". " + set.getValue());
            }
            int inputId = scanner.nextInt();
            if (clubService.getClubs().get(inputId) != null){
                playerRequest.setClub(clubService.getClubs().get(inputId));
                break;
            }
            else{
                System.out.println("Id club invalid");
            }
        }
        return playerRequest;



    }
    private int idToDelete (){
        System.out.println("Introdu id-ul jucatorului pe care vrei sa il stergi:");
        Scanner obj = new Scanner(System.in);
        return  obj.nextInt();
    }

    private int idToEdit(){
        System.out.println("Introdu id-ul jucatorului pe care vrei sa il editezi:");
        Scanner obj = new Scanner(System.in);
        return obj.nextInt();
    }


}
