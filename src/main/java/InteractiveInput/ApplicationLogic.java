package InteractiveInput;

import Enums.Option;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationLogic {
    public static void runApp(){
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        int option = 11;
        do {
            menu.showPrimaryOptions();
            try {
                option = scanner.nextInt();
            }
            catch (InputMismatchException ignored)
            {
                scanner.next();
            }

            switch (option){
                case 0:
                    System.out.println("O zi frumoasa!");
                    break;
                case 1:
                    try {
                        menu.chooseOption(Option.NewPlayer);
                    }catch (InputMismatchException e){
                        System.out.println("Adaugare jucator esuata (aveti grija ca datele introduse sa fie corecte) !");
                    }
                    break;
                case 2:
                    menu.chooseOption(Option.ShowPlayers);
                    break;
                case 3:
                    menu.chooseOption(Option.DeletePlayer);
                    break;
                case 4:
                    try{
                        menu.chooseOption(Option.EditPlayer);
                    }
                    catch (InputMismatchException e){
                        System.out.println("Editare jucator esuata (aveti grija ca datele introduse sa fie corecte) !");
                    }
                    break;
                case 5:
                    try{
                        menu.chooseOption(Option.NewClub);
                    }
                    catch (InputMismatchException e){
                        System.out.println("Adaugare club esuata (aveti grija ca datele introduse sa fie corecte) !");
                    }
                    break;
                case 6:
                        menu.chooseOption(Option.ShowClubs);
                        break;
                case 7:
                    menu.chooseOption(Option.DeleteClub);
                    break;
                case 8:
                    try{
                        menu.chooseOption(Option.EditClub);
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Editare club esuata (aveti grija ca datele introduse sa fie corecte) !");
                    }
                    break;
                case 9:
                    ApplicationLogicTournament.runTournament();
                    break;
                default:
                    System.out.println("Input invalid");
                    break;
            }
        }while (option != 0 );
        menu.chooseOption(Option.TournamentMenu);
    }

}
