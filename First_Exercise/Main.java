package First_Exercise;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setFirst_name("Peter");
        s1.setLast_name("Parker");
        s1.setGender("M");
        s1.setFaculty("Computer Science");
        s1.setMajor("Cyber Security.");
        s1.setDob(LocalDate.of(1995, Month.APRIL, 13));
        System.out.println("Displaying student's Information: \n"+ s1.getFirst_name() + "\n" + s1.getGender() + "\n"
         + s1.getLast_name() + "\n" + s1.getFaculty() + "\n" + s1.getMajor() + "\n" + " \n" + s1.age_years());


        Staff s = new Staff();
        //s.setFirst_name("Peter");
        //s.setLast_name("Parker");
        s.setPosition("General");
        s.setOffice_location("Hogwarts");
        s.setGender("M");
        s.setDob(LocalDate.of(1990, Month.MAY, 3));
        System.out.println("Displaying staff's Information: \n" + s.getOffice_location() + "\n" + s.getPosition() + "\n" + s.age_years());
    }
}
