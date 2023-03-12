package InteractiveInput;

import DomainModels.PlayerRequest;
import Enums.Gender;
import Enums.Option;
import Service.MenuService;

import java.util.Scanner;

public class Menu {

    MenuService menuService = new MenuService();

    public void showPrimaryOptions(){
        System.out.println("Pagina principala :");
        System.out.println("0. Paraseste aplicatia");
        System.out.println("1. Adauga jucator");
        System.out.println("2. Afiseaza toti jucatorii");
    }
    public  void chooseOption(Option option){
        switch (option){
            case NewPlayer:
                System.out.println(menuService.createPlayer(getPlayerDetails()));

                break;
            case ShowPlayers:
                menuService.showPlayers();
                break;



        }

    }
    private PlayerRequest getPlayerDetails() {
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
        return playerRequest;

    }



}
