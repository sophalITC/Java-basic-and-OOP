// package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class AddNewBankSceneController {

    @FXML
    private Button btnClearForm;

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
    @FXML
    void clearFormAction(ActionEvent event) {
        clearInput();
    }

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

        query = "INSERT INTO `banks` (`name`, `loan_min`,`loan_max`,`first_interest`,`second_interest`) " +
                "VALUE(" +
                name+"," +  //name
                minLoan+"," + //loan_min
                maxLoan+"," + // loan_max
                firstInterest+"," + // first_interest
                secondInterest+")";  // second_interest
        System.out.println(query);
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        System.out.println("Insert to bank Success");

        clearInput();
    }

    void clearInput(){
        nameField.clear();
        minLoanField.clear();
        maxLoanField.clear();
        firstInterestField.clear();
        secondInterestField.clear();
    }

}
