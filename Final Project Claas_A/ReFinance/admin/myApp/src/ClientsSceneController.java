// package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

//import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ClientsSceneController implements Initializable {

    @FXML
    private Button btnAddNewClient;

    @FXML
    private Button btnRefresh;

    @FXML
    private TableColumn<ClientModel, String> clientEmail;

    @FXML
    private TableColumn<ClientModel, String> clientFname;

    @FXML
    private TableColumn<ClientModel, String > clientId;

    @FXML
    private TableView<ClientModel> clientList;

    @FXML
    private TableColumn<ClientModel,String> clientLname;

    @FXML
    private TableColumn<ClientModel, String> clientUsername;
    @FXML
    private TextField textSearchClient;
    ObservableList<ClientModel> clientModelList = FXCollections.observableArrayList();
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;

    ClientModel clientObj = null ;
    int id;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void onAddNewClient(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddNewClientScene.fxml")));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void onRefresh(ActionEvent event) throws SQLException {
        refreshData();
    }
    public void refreshData() throws SQLException {
        try{
            conn = DBConnector.getConnection();
            rs = conn.createStatement().executeQuery("SELECT * FROM clients");
            clientModelList.clear();
            while (rs.next()){
                clientModelList.add(new ClientModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),rs.getString("first_name"), rs.getString("last_name")));
            }

            clientId.setCellValueFactory(new PropertyValueFactory<>("id"));
            clientUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
            clientEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            clientFname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            clientLname.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            clientList.setItems(clientModelList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            refreshData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void searchClientActions(ActionEvent event) throws SQLException {
        String searchEmailString = textSearchClient.getText();
        refreshDataWhenSearch(searchEmailString);
    }
    void refreshDataWhenSearch(String searchKey) throws SQLException {
        conn = DBConnector.getConnection();
        if(Objects.equals(searchKey, "")){
            rs = conn.createStatement().executeQuery("SELECT * FROM clients");
        }else {
            rs = conn.createStatement().executeQuery("SELECT * FROM clients WHERE clients.email LIKE \'"+searchKey+"%\'");
        }
        clientModelList.clear();
        while (rs.next()){
            clientModelList.add(new ClientModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),rs.getString("first_name"), rs.getString("last_name")));
        }

        clientId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        clientEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        clientFname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        clientLname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        clientList.setItems(clientModelList);
//        clientList.getColumns().addAll(clientId, clientUsername, clientEmail, clientFname, clientLname);
    }
    @FXML
    private void goBackToSplitWay(ActionEvent event){
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("split_way_scene.fxml")));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Client list");
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void onEditAction(ActionEvent event){
        ClientModel clientModel = clientList.getSelectionModel().getSelectedItem();
        if (clientModel == null){
            return;
        }
        System.out.println(clientModel.getId());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EditClientScene.fxml"));
            Parent parent = loader.load();
            EditClientSceneController controller = loader.getController();
            controller.fillTheForm(clientModel.getId());

            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void onDeleteClient(ActionEvent event) throws SQLException {
        ClientModel clientModel = clientList.getSelectionModel().getSelectedItem();
        if (clientModel == null){
            return;
        }
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectionDb = databaseConnection.getConnection();
        String query = "DELETE from clients where clients.id = "+ clientModel.getId();
        System.out.println(query);
        Statement statement = connectionDb.createStatement();
        statement.executeUpdate(query);
        refreshData();
    }

}
