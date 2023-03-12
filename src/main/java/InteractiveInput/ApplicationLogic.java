package InteractiveInput;

import Enums.Option;

import java.util.Scanner;

public class ApplicationLogic {
    public static void runApp(){
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        menu.showPrimaryOptions();
        int option ;
        do {
            option = scanner.nextInt();
            switch (option){
                case 0:
                    System.out.println("O zi frumoasa!");
                    break;
                case 1:
                    menu.chooseOption(Option.NewPlayer);
                    break;
                case 2:
                    menu.chooseOption(Option.ShowPlayers);
                    break;
            }
        }while (option != 0 );
        menu.chooseOption(Option.TournamentMenu);
    }

}
