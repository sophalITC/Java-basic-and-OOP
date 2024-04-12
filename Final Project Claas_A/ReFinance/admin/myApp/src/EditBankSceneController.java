// package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;

public class EditBankSceneController {

    @FXML
    private Button btnSubmitAdd;

    @FXML
    private TextField firstInterestField;

    @FXML
    private TextField maxLoanField;

    @FXML
    private TextField minLoanField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField secondInterestField;
    String query;
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet rs;
    BankModel bankModel;
    @FXML
    void submitAddAction(ActionEvent event) throws SQLException {
        connection = DBConnector.getConnection();
        String name = Objects.equals(nameField.getText(), "") ? null: "'"+nameField.getText()+"'";
        int minLoan = Integer.parseInt(Objects.equals(minLoanField.getText(), "") ? "0" : minLoanField.getText());
        int maxLoan = Integer.parseInt(Objects.equals(maxLoanField.getText(), "") ? "0" : maxLoanField.getText());
        int firstInterest = (int) (Double.parseDouble(Objects.equals(firstInterestField.getText(), "") ? "0" : firstInterestField.getText()) * 100);
        int secondInterest = (int) (Double.parseDouble(Objects.equals(secondInterestField.getText(), "") ? "0" : secondInterestField.getText()) * 100);
/*        System.out.println(dateOfBirthString);
        System.out.println(salaryInt);*/

        query = "UPDATE `banks`" +
                " SET " +
                "`name` = "+name+" , " + //name
                "`loan_min` ="+minLoan+" , " + //loan_min
                "`loan_max` ="+maxLoan+" ," + //loan_max
                "`first_interest` ="+firstInterest+" ," +// first_interest
                "`second_interest` ="+secondInterest+" " +//second_interest
                "WHERE banks.id = " + bankModel.getId();

        System.out.println(query);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("Update Success");

        clearInput();
    }
    public void fillTheForm(int id) throws SQLException {
        System.out.println(id);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectionDb = databaseConnection.getConnection();
        String query = "SELECT * from banks where banks.id = "+id;
        System.out.println(query);
        Statement statement = connectionDb.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        System.out.println(resultSet.getString("name"));

        bankModel = new BankModel(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("loan_min"),
                resultSet.getInt("loan_min"),
                resultSet.getInt("first_interest")/100.0,
                resultSet.getDouble("second_interest")/100.0
        );

        nameField.setText(bankModel.getName());
        minLoanField.setText(String.valueOf(bankModel.getMinLoan()));
        maxLoanField.setText(String.valueOf(bankModel.getMaxLoan()));
        firstInterestField.setText(String.valueOf(bankModel.getFirstInterest()));
        secondInterestField.setText(String.valueOf(bankModel.getSecondInterest()));
    }
    void clearInput(){
        nameField.clear();
        minLoanField.clear();
        maxLoanField.clear();
        firstInterestField.clear();
        secondInterestField.clear();
    }


}
