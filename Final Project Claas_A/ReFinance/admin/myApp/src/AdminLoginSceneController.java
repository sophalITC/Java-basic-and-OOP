// package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class AdminLoginSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField emailInput;
    @FXML
    private PasswordField passInput;
    @FXML
    private Button btnLogin;
    @FXML
    private Label errorMsg;

    String email;
    String password;
    public void switchToSplitWayScene(ActionEvent event) throws IOException {
        // get data from input
        email = emailInput.getText();
        password = passInput.getText();

        System.out.println(email);
        System.out.println(password);

        // find data in database
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectionDb = databaseConnection.getConnection();
        String query = "SELECT * from users where users.email = \'" + email + "\' and users.password = \'"+password+"\';";
        System.out.println(query);
        try{
            Statement statement = connectionDb.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()){
                i++;
            }
            if(i == 0){
                //username or password is incorrect
                errorMsg.setText("User name or password is incorrect");
            } else if (i == 1) {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("split_way_scene.fxml")));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                stage.setTitle("Choose a Portal");
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
