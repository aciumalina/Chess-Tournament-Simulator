package DomainModels;

import Enums.Gender;
import OutputDesign.StickmanBoyAndGirl;

public class Player implements StickmanBoyAndGirl {
    int id;
    int age;
    String firstName;
    String lastName;
    int currentRating;
    String title;
    Gender gender;
    Club club;
    double buchholtz = 0;

    public void setId(int id) {
        this.id = id;
    }

    double numberOfPoints = 0;

    public int getId() {
        return id;
    }

    public Player(String firstName, String lastName, int age, int currentRating, Gender gender, String title, Club club) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentRating = currentRating;
        this.gender = gender;
        this.club = club;
        this.title = title;
    }

    @Override
    public String toString() {
        if (gender == Gender.Male){ return "\n" + STICKMAN_BOY + "\n" + "Player{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title=" + title +
                ", currentRating=" + currentRating +
                ", gender=" + gender +
                ", numberOfPoints=" + numberOfPoints +
                ", bucholtz=" + buchholtz +
                ", club= " + club +
                '}';}



    else{
        return STICKMAN_GIRL + "\n" + "Player{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title=" + title +
                ", currentRating=" + currentRating +
                ", gender=" + gender +
                ", numberOfPoints=" + numberOfPoints +
                ", bucholtz=" + buchholtz +
                ", club= " + club +
                '}'+ "\n";}
    }
    public String toStringWithoutAnimation()
    {

        return   "Player{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title=" + title +
                ", currentRating=" + currentRating +
                ", gender=" + gender +
                ", numberOfPoints=" + numberOfPoints +
                ", bucholtz=" + buchholtz +
                ", club= " + club +
                '}'+ "\n";}

}
