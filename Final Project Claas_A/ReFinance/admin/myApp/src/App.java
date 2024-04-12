// ################## Source Code ####################
// ******** Please replace "......" by the correct character  ************
// ################################################
import java.util.Objects;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
    private Parent root;
    @Override
    public void start(Stage stage) {
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin_login_scene.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
 
 public static void main(String[] args) {
        launch(args);
    }
}