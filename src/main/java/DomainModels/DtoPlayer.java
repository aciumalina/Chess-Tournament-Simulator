package DomainModels;

public class DtoPlayer {
    int id;

    int rating;
    String firstName;
    String lastName;

    public DtoPlayer(int id, String firstName, String lastName, int rating) {
        this.id = id;

        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + ", rating=" + rating +
                        "\n \n" ;
    }
}
