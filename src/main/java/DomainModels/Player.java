package DomainModels;

import Enums.Gender;
import OutputDesign.StickmanBoyAndGirl;

public class Player implements StickmanBoyAndGirl {
    int id;
    int age;
    String firstName;
    String lastName;

    public int getCurrentRating() {
        return currentRating;
    }

    int currentRating;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

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

    public int getCurrentRating() {
        return currentRating;
    }

    public void setCurrentRating(int currentRating) {
        this.currentRating = currentRating;
    }

    public double getBuchholtz() {
        return buchholtz;
    }

    public void setBuchholtz(double buchholtz) {
        this.buchholtz = buchholtz;
    }

    public double getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(double numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
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
