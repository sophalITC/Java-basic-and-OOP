package First_Exercise;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    String first_name, last_name, Gender;
    LocalDate dob; // year-month-day
    public int age_years(){
        Period p = Period.between(dob, LocalDate.now());
        return p.getYears();
        //return 2023 - dob.getYear(); <-- also valid

    }
    public Person(String first_name, String last_name,String Gender, LocalDate dob){
        this.setFirst_name(first_name);
        this.setLast_name(last_name);
        this.setDob(dob);
        this.setGender(Gender);
    }
    public Person(){

    }
    public void setGender(String Gender){
        this.Gender = Gender;
    }
    public String getGender(){
        return this.Gender; // or just return Gender
    }
    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }
    public void setDob(LocalDate dob){
        this.dob = dob;
    }
    public String getFirst_name(){
        return this.first_name;
    }
    public String getLast_name(){
        return this.last_name;
    }
    public LocalDate getDob(){
        return this.dob;
    }

}
