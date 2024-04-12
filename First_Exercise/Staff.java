package First_Exercise;

import java.time.LocalDate;

public class Staff extends Person {
    String office_location, position;

    /*public Staff(String first_name, String last_name, String Gender, LocalDate dob, String office_location, String position) {
        super(first_name, last_name, Gender, dob);
        this.office_location = office_location;
        this.position = position;
    }*/

    public Staff(String office_location, String position) {
        this.office_location = office_location;
        this.position = position;
    }
    public Staff(){

    }

    public String getOffice_location() {
        return office_location;
    }

    public void setOffice_location(String office_location) {
        this.office_location = office_location;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
