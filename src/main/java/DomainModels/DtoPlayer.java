package DomainModels;

public class DtoPlayer {
    int id;

    int rating;
    String firstName;
    String lastName;

    double noOfPoints;
    double buchholtz;

    public DtoPlayer(int id, String firstName, String lastName, int rating) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
    }

    public DtoPlayer(int id, String firstName, String lastName, int rating, double noOfPoints, double buchholtz) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.noOfPoints = noOfPoints;
        this.buchholtz = buchholtz;
    }


    @Override
    public String toString() {
        return
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + ", rating=" + rating +
                ", points= " + noOfPoints +
                ", bucholtz= " + buchholtz +
                        "\n \n" ;
    }
}
