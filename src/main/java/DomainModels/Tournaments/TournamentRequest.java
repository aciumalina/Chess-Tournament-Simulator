package DomainModels.Tournaments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class TournamentRequest {
    String name;
    LocalDate startDate;
    LocalDate endDate;
    String city;

}
