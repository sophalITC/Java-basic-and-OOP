// package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class BanksSceneController implements Initializable {

    @FXML
    private TableColumn<BankModel, Double> colFirstInterest;

    @FXML
    private TableColumn<BankModel, Integer> colMaxLoan;

    @FXML
    private TableColumn<BankModel, Integer> colMinLoan;

    @FXML
    private TableColumn<BankModel, Double> colSecondInterest;

    @FXML
    private TableView<BankModel> bankTable;

    @FXML
    private Button btnAddNewBank;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnRefresh;

    @FXML
    private TableColumn<BankModel, Integer> colId;

    @FXML
    private TableColumn<BankModel, String> colName;

    @FXML
    private TextField textSearchBank;

    Connection conn;
    ResultSet rs;
    ObservableList<BankModel> bankList = FXCollections.observableArrayList();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            refreshData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void refreshData() throws SQLException {
        try{
            conn = DBConnector.getConnection();
            rs = conn.createStatement().executeQuery("SELECT * FROM banks");
            bankList.clear();
            while (rs.next()){
                bankList.add(new BankModel(rs.getInt("id"), rs.getString("name"), rs.getInt("loan_min"),rs.getInt("loan_max"), rs.getDouble("first_interest")/100,rs.getDouble("second_interest")/100));
            }

            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colMinLoan.setCellValueFactory(new PropertyValueFactory<>("minLoan"));
            colMaxLoan.setCellValueFactory(new PropertyValueFactory<>("maxLoan"));
            colFirstInterest.setCellValueFactory(new PropertyValueFactory<>("firstInterest"));
            colSecondInterest.setCellValueFactory(new PropertyValueFactory<>("secondInterest"));

            bankTable.setItems(bankList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addNewBank(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddNewBankScene.fxml")));
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
    void editBank(ActionEvent event) {
        BankModel bankModel = bankTable.getSelectionModel().getSelectedItem();
        if (bankModel == null){
            return;
        }
        System.out.println(bankModel.getId());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EditBankScene.fxml"));
            Parent parent = loader.load();
            EditBankSceneController controller = loader.getController();
            controller.fillTheForm(bankModel.getId());

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
    void goBackToSplitWay(ActionEvent event) {
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
    void onDeleteBank(ActionEvent event) throws SQLException {
        BankModel bankModel = bankTable.getSelectionModel().getSelectedItem();
        if (bankModel == null){
            return;
        }
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectionDb = databaseConnection.getConnection();
        String query = "DELETE from banks where banks.id = "+ bankModel.getId();
        System.out.println(query);
        Statement statement = connectionDb.createStatement();
        statement.executeUpdate(query);
        refreshData();
    }

    @FXML
    void onRefresh(ActionEvent event) throws SQLException {
        refreshData();
    }

    @FXML
    void searchBank(ActionEvent event) throws SQLException {
        String searchNameString = textSearchBank.getText();
        refreshDataWhenSearch(searchNameString);
    }
    void refreshDataWhenSearch(String searchKey) throws SQLException {
        conn = DBConnector.getConnection();
        if(Objects.equals(searchKey, "")){
            rs = conn.createStatement().executeQuery("SELECT * FROM banks");
        }else {
            rs = conn.createStatement().executeQuery("SELECT * FROM banks WHERE banks.name LIKE \'"+searchKey+"%\'");
        }
        bankList.clear();
        while (rs.next()){
            bankList.add(new BankModel(rs.getInt("id"), rs.getString("name"), rs.getInt("loan_min"),rs.getInt("loan_max"), rs.getDouble("first_interest")/100,rs.getDouble("second_interest")/100));
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colMinLoan.setCellValueFactory(new PropertyValueFactory<>("minLoan"));
        colMaxLoan.setCellValueFactory(new PropertyValueFactory<>("maxLoan"));
        colFirstInterest.setCellValueFactory(new PropertyValueFactory<>("firstInterest"));
        colSecondInterest.setCellValueFactory(new PropertyValueFactory<>("secondInterest"));
        bankTable.setItems(bankList);
    }

}
