// package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class AddNewClientSceneController {

    @FXML
    private TextArea address;

    @FXML
    private Button btnClearForm;

    @FXML
    private Button btnSubmitAdd;

    @FXML
    private DatePicker dateOfBirdth;

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField job;

    @FXML
    private TextField lastName;

    @FXML
    private TextField nationality;

    @FXML
    private TextField salary;

    @FXML
    private TextField tel;

    @FXML
    private TextField username;


    String query;
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet rs;
    @FXML
    void clearFormAction(ActionEvent event) {
        clearInput();
    }

    @FXML
    void submitAddAction(ActionEvent event) throws SQLException {
        connection = DBConnector.getConnection();
        String usernameString = Objects.equals(username.getText(), "") ? null: "'"+username.getText()+"'";
        String emailString =Objects.equals(email.getText(), "") ? null: "'"+email.getText()+"'";
        String fnameString =Objects.equals(firstName.getText(), "") ? null: "'"+firstName.getText()+"'";
        String lnameString =Objects.equals(lastName.getText(), "") ? null: "'"+lastName.getText()+"'";
        String nationalityString =Objects.equals(nationality.getText(), "") ? null: "'"+nationality.getText()+"'";
        String dateOfBirthString = dateOfBirdth.getValue() == null ? null :"'"+ dateOfBirdth.getValue().toString()+"'";
        String jobString =Objects.equals(job.getText(), "") ? null: "'"+job.getText()+"'";
        int salaryInt = Integer.parseInt(Objects.equals(salary.getText(), "") ? "0" : salary.getText());
        String addressString =Objects.equals(address.getText(), "") ? null: "'"+address.getText()+"'";
        String telephoneString =Objects.equals(tel.getText(), "") ? null: "'"+tel.getText()+"'";
/*        System.out.println(dateOfBirthString);
        System.out.println(salaryInt);*/

        query = "INSERT INTO `clients` (`username`, `email`,`first_name`,`last_name`,`nationality`,`dob`,`job`,`salary`,`address`,`tel`) " +
                "VALUE(" +
                 usernameString+"," +  //username
                emailString+"," + //email
                fnameString+"," + // first name
                lnameString+"," + // last name
                nationalityString+"," + // nationality
                dateOfBirthString+"," + // date of birth
                jobString+"," + // job
                salaryInt+"," + // salary
                addressString+"," +// addressf
                telephoneString+")"; // tel
        System.out.println(query);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("Insert Success");

        clearInput();
    }
    void clearInput(){
        username.clear();
        email.clear();
        firstName.clear();
        lastName.clear();
        nationality.clear();
        dateOfBirdth.setValue(null);
        job.clear();
        salary.clear();
        address.clear();
        tel.clear();
    }

}
