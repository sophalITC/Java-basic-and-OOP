import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
 
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("application.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setTitle("Room Management System");
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> {
                event.consume();
                closed(stage);
            });

        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    public void closed(Stage stage){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("LogOut");
        alert.setHeaderText("You're about to Close !!");
        alert.setContentText("Do you want to Close ?");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }

        
    }
}