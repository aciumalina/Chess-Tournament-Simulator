package InteractiveInput;

import DomainModels.Tournaments.Tournament;
import Enums.TournamentOption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationLogicTournament {


    public static void runTournament(){
        TournamentMenu menu = new TournamentMenu();
        Scanner scanner = new Scanner(System.in);

        int option = 11;
        if (menu.tournament == null)
            option = 0;
        while (option != 0){
            menu.showOptions();
            try{
                option = scanner.nextInt();
            }
            catch (InputMismatchException ignored)
            {
                scanner.next();
            }

            switch (option){
                case 0:
                    break;
                case 1:
                    menu.chooseOption(TournamentOption.PAIR_PLAYERS);
                    break;
                case 2:
                    menu.chooseOption(TournamentOption.SHOW_STANDINGS);
                    break;
                default:
                    System.out.println("Input invalid");
                    break;
            }

        }
    }
}
