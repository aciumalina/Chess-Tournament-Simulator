package DomainModels;

import Enums.Gender;

public class PlayerRequest {
    int age;
    String firstName;
    String lastName;
    int currentRating;

    @Override
    public String toString() {
        return "PlayerRequest{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", currentRating=" + currentRating +
                ", gender=" + gender +
                '}';
    }

    Gender gender;

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCurrentRating(int currentRating) {
        this.currentRating = currentRating;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCurrentRating() {
        return currentRating;
    }

    public Gender getGender() {
        return gender;
    }
}
