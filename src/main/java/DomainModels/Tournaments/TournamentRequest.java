package DomainModels.Tournaments;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TournamentRequest {

    String name;

    LocalDate startDate;
    LocalDate endDate;

    public TournamentRequest(String name, LocalDate startDate, LocalDate endDate, String city) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.city = city;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    String city;

}
