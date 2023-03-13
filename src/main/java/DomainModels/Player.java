package DomainModels;

import Enums.Gender;
import OutputDesign.StickmanBoyAndGirl;

public class Player implements StickmanBoyAndGirl {
    int id;
    int age;
    String firstName;
    String lastName;

    int currentRating;
    Gender gender;

    Club club;

    public void setId(int id) {
        this.id = id;
    }

    double numberOfPoints = 0;

    public int getId() {
        return id;
    }

    public Player(String firstName, String lastName, int age, int currentRating, Gender gender, Club club) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentRating = currentRating;
        this.gender = gender;
        this.club = club;
    }

    @Override
    public String toString() {
        if (gender == Gender.Male){ return "\n" + STICKMAN_BOY + "\n" + "Player{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", currentRating=" + currentRating +
                ", gender=" + gender +
                ", numberOfPoints=" + numberOfPoints +
                ", club= " + club +
                '}';}



    else{
        return STICKMAN_GIRL + "\n" + "Player{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", currentRating=" + currentRating +
                ", gender=" + gender +
                ", numberOfPoints=" + numberOfPoints +
                ", club= " + club +
                '}'+ "\n";}
    }
}
