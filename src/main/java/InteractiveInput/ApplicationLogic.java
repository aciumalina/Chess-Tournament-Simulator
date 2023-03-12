package InteractiveInput;

import Enums.Option;

import java.util.Scanner;

public class ApplicationLogic {
    public static void runApp(){
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        int option ;
        do {
            menu.showPrimaryOptions();
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
                case 3:
                    menu.chooseOption(Option.DeletePlayer);
                    break;
                case 4:
                    menu.chooseOption(Option.EditPlayer);
            }
        }while (option != 0 );
        menu.chooseOption(Option.TournamentMenu);
    }

}
