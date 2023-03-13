package DomainModels;

public class Club {
    int id;
    String Name;
    String City;
    int FoundingYear;

    public Club(String Name, String City, int FoundingYear){
        this.Name = Name;
        this.City = City;
        this.FoundingYear = FoundingYear;
    }
    @Override
    public String toString(){
        return   this.Name +
                ", " + this.City +
                ", fondat in anul " + this.FoundingYear;
    }
}
