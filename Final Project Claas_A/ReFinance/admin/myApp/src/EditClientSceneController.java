// package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class EditClientSceneController {

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
    ClientModel clientModel;
    public void fillTheForm(int id) throws SQLException {
        System.out.println(id);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectionDb = databaseConnection.getConnection();
        String query = "SELECT * from clients where clients.id = "+id;
        System.out.println(query);
        Statement statement = connectionDb.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        System.out.println(resultSet.getString("username"));

        clientModel = new ClientModel(
                resultSet.getInt("id"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("job"),
                resultSet.getString("nationality"),
                resultSet.getInt("salary"),
                resultSet.getString("address"),
                resultSet.getString("tel"),
                resultSet.getString("dob")
        );

        username.setText(clientModel.getUsername());
        email.setText(clientModel.getEmail());
        firstName.setText(clientModel.getFirstName());
        lastName.setText(clientModel.getLastName());
        nationality.setText(clientModel.getNationality());
        job.setText(clientModel.getJob());
        salary.setText(String.valueOf(clientModel.getSalary()));
        address.setText(clientModel.getUsername());
        tel.setText(clientModel.getTel());
        if(clientModel.getDob() != null){
            String dateAsString = clientModel.getDob();
            LocalDate localDate = LocalDate.parse(dateAsString);
            dateOfBirdth.setValue(localDate);
        }else{
            dateOfBirdth.setValue(null);
        }
    }
    @FXML
    void submitEditAction(ActionEvent event) throws SQLException {
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

        query = "UPDATE `clients`" +
                " SET " +
                "`username` = "+usernameString+" , " + //username
                "`email` ="+emailString+" , " + //email
                "`first_name` ="+fnameString+" ," + //first name
                "`last_name` ="+lnameString+" ," +// last name
                "`nationality` ="+nationalityString+" ," +//nationality
                "`dob`="+dateOfBirthString+"  ," + // date of birth
                "`job`="+jobString+"  ," + // job
                "`salary`="+salaryInt+" ," + // salary
                "`address`="+addressString+" ," + // address
                "`tel`="+telephoneString+" " + // tel
                "WHERE clients.id = " + clientModel.getId();

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
