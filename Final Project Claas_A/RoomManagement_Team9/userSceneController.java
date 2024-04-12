
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class userSceneController implements Initializable{
    @FXML
    private Label userLabel;
    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane userPane;

    //, "BUILDING", "DAY", "TIME", "ROOM", "GROUP", "AVAILABLE");

    @FXML
    private TableColumn<Room, String> labBuilding;

    @FXML
    private TableColumn<Room, String> labDay;

    @FXML
    private TableColumn<Room, Integer> labRoom;

    @FXML
    private TableColumn<Room, String> labTime;

    @FXML
    private TableView<Room> labView;

    @FXML
    private Button bookButton;

    @FXML
    private Button studyRoombtn;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button labRoomBtn;

    ObservableList <Room> labTableObserve = FXCollections.observableArrayList();
    
    Stage stage;
    String DB_URL = "jdbc:mysql://localhost:3306/itcroom";
        String USER = "root";
        String PASS = "happyams";

        Connection con;
        Statement statement;
        ResultSet result;
        PreparedStatement preStatement;

    // we do override here just so that when we run this fxml 
    // it will run this initialize method
    @Override
    public void initialize(URL location, ResourceBundle resources){
        labRoomBtn();
        
    }
    public void searchData(){
        FilteredList <Room> filteredData = new FilteredList<>(labTableObserve, b -> true);
            
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(labRoomlist -> {

                // If no search value then display all records 
                // or whatever records it currently have no changes
                if(newValue.isEmpty() || newValue.isBlank() || newValue == null){
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                if (labRoomlist.getBuilding().toLowerCase().indexOf(searchKeyword) > -1){
                    return true;
                }
                else if(labRoomlist.getDayOfWeek().toLowerCase().indexOf(searchKeyword) > -1){
                    return true;
                }
                else if(labRoomlist.getTime().toLowerCase().indexOf(searchKeyword) > -1){
                    return true;
                }
                else if(labRoomlist.getRoom().toString().indexOf(searchKeyword) > -1){
                    return true;
                }
                else{
                    return false;
                }
            });
        });

        SortedList<Room> sortedRoom = new SortedList<>(filteredData);

        //bind sorted result with Table View
        sortedRoom.comparatorProperty().bind(labView.comparatorProperty());

        labView.setItems(sortedRoom);
    }

    public void displayOption(String option){
        userLabel.setText(option + " Room");
    }

    public void logout(ActionEvent event){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("LogOut");
        alert.setHeaderText("You're about to LOGOUT!!");
        alert.setContentText("Do you want to LOGOUT ?");

        if(alert.showAndWait().get() == ButtonType.OK){
            
            stage =(Stage) userPane.getScene().getWindow();
            System.out.println("LOGOUT SUCCESS");
            stage.close();
        }
    }
    
    public void bookBtn() throws Exception {
        SqlLab labSql = new SqlLab();
        sqlStudyRoom studyRoomSql = new sqlStudyRoom();
        

        Room room = labView.getSelectionModel().getSelectedItem();
        labSql.Update(
            "NO", room.getDayOfWeek(), room.getTime(), room.getRoom(), room.getBuilding());
        studyRoomSql.Update(
            "NO", room.getDayOfWeek(), room.getTime(), room.getRoom(), room.getBuilding()
        );

        JOptionPane.showMessageDialog(null, "Book Success!");  
    }

    public void studyRoomBtn(){
        displayOption("Study");
        try{
            labTableObserve.clear();
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = con.createStatement();

            preStatement = con.prepareStatement("SELECT * FROM STUDY_ROOM WHERE AVAILABLE_ = ?");
            preStatement.setString(1, "YES");
            result = preStatement.executeQuery();
            while(result.next()){  
                
                labTableObserve.add(new Room(
                    result.getString(2),result.getString(3),result.getString(4),result.getInt(5)));
                
            }
            // The table column is the one you anootate above.
            labBuilding.setCellValueFactory(new PropertyValueFactory<>("building"));
            labDay.setCellValueFactory(new PropertyValueFactory<>("dayOfWeek"));
            labTime.setCellValueFactory(new PropertyValueFactory<>("time"));
            labRoom.setCellValueFactory(new PropertyValueFactory<>("room"));

            labView.setItems(labTableObserve);

            searchData();

        }catch(SQLException error){
           
        }
    }

    public void labRoomBtn(){
        displayOption("Lab");
        try{
            labTableObserve.clear();
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = con.createStatement();

            preStatement = con.prepareStatement("SELECT * FROM LAB WHERE AVAILABLE_ = ?");
            preStatement.setString(1, "YES");
            result = preStatement.executeQuery();
            while(result.next()){  
                
                labTableObserve.add(new Room(
                    result.getString(2),result.getString(3),result.getString(4),result.getInt(5)));
                
            }
            // The table column is the one you anootate above.
            labBuilding.setCellValueFactory(new PropertyValueFactory<>("building"));
            labDay.setCellValueFactory(new PropertyValueFactory<>("dayOfWeek"));
            labTime.setCellValueFactory(new PropertyValueFactory<>("time"));
            labRoom.setCellValueFactory(new PropertyValueFactory<>("room"));

            labView.setItems(labTableObserve);

            searchData();

        }catch(SQLException error){
           
        }
    }

    
    

}
