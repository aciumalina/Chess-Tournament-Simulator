package InteractiveInput;

import DomainModels.Tournaments.RoundRobin;
import DomainModels.Tournaments.Tournament;
import Enums.Option;
import Enums.TournamentOption;
import Service.RoundRobinService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TournamentMenu {
    Tournament tournament;

    public void showOptions(){
        System.out.println("0. Incheie simularea turneului");
        System.out.println("1. Incepeti runda");
        System.out.println("2. Arata clasamentul actual");
    }

    public TournamentMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Introdu tipul turneului (Round Robin/Kick Out Format)");
            System.out.println("Round Robin - optiunea 1");
            System.out.println("Kick Out - optiunea 2");
            int optiune = scanner.nextInt();
            if (optiune == 1) {
                System.out.println("Ati ales turneu de tip Round Robin");
                System.out.println("Introdu numele turneului: ");
                scanner.next();
                String name = scanner.nextLine();
                System.out.println("Introdu data finalizarii: ");
                String dataString = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
                LocalDate data = LocalDate.parse(dataString, formatter);
                System.out.println("Introdu orasul care gazduieste turneul: ");
                String city = scanner.nextLine();
                this.tournament = new RoundRobin(name, LocalDate.now(), data, city);
                break;
            }
            if (optiune == 2) {
                System.out.println("Ati ales turneu de tip Kick Out");
                break;
            } else {
                System.out.println("Optiune invalida!");
            }
        }
    }
    public void chooseOption(TournamentOption option){
        switch (option){
            case PAIR_PLAYERS:
                tournament.pairPlayers();
                break;
            case SHOW_STANDINGS:

                break;
        }
    }

}
