// package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class SplitWayOptionController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void goToBankAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("banks_scene.fxml")));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Bank list");
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void goToClientAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("clients_scene.fxml")));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Client list");
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
