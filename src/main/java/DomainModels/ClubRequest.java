package DomainModels;

public class ClubRequest {
    String Name;
    String City;
    int FoundingYear;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getFoundingYear() {
        return FoundingYear;
    }

    public void setFoundingYear(int foundingYear) {
        FoundingYear = foundingYear;
    }
}
