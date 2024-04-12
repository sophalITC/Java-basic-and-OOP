package First_Exercise;

import java.time.LocalDate;

public class Student extends Person{
    String faculty, major;

    public Student(String first_name, String last_name, String Gender, LocalDate dob, String faculty, String major) {
        super(first_name, last_name, Gender, dob);
        this.faculty = faculty;
        this.major = major;
    }


    public Student(String faculty, String major) {
        this.faculty = faculty;
        this.major = major;
    }
    public Student(){

    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
