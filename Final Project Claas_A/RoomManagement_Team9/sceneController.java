import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import javax.swing.JOptionPane;

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

public class sceneController {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Stage stage;
    private Scene scene;
    private Parent root;

    //login page
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Label errorField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    

    //register page
    @FXML
    private Button loginButtonRegister;
    @FXML
    private Button finishRegister;
    @FXML
    private TextField nameRegister;
    @FXML
    private TextField emailRegister;
    @FXML
    private PasswordField passwordRegister;
    @FXML
    private Label registerLabel;

    String DB_URL = "jdbc:mysql://localhost:3306/itcroom";
    String USER = "root";
    String PASS = "happyams";

    Connection con;
    Statement statement;
    ResultSet result;
    PreparedStatement preStatement;
    
    public void validateLogin(ActionEvent event) throws NoSuchAlgorithmException, IOException{
    
        try{ 
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = con.createStatement();

            Encryptor encrypt = new Encryptor();
            preStatement = con.prepareStatement("SELECT COUNT(1) FROM USER_INFO WHERE EMAIL = ? AND PASSWORD = ?");
            preStatement.setString(1, emailTextField.getText());
            preStatement.setString(2, encrypt.encryptString(passwordTextField.getText()));
            result = preStatement.executeQuery();
            
            while(result.next()){  
                if (result.getInt(1) == 1){
                    String option = "Lab";

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("userLab.fxml"));
                    root = loader.load();

                    userSceneController userScene = loader.getController();
                    userScene.displayOption(option);

                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    errorField.setText("Login Fail!");
                }
            }
        }catch(SQLException error){
        }
    }
    public void loginPage(ActionEvent event)throws Exception{
    
        String password = passwordTextField.getText();
        String email = emailTextField.getText();
        
        if (password.isBlank() || email.isBlank()){
            errorField.setText("Please Enter your Email and Password!");
        }else if((password.toString().equals("ams") == true) && (email.toString().equals("admin@itc.kh") == true) ){
            Parent root = FXMLLoader.load(getClass().getResource("adminLab.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            validateLogin(event);
        }
    }
    public void registerSubmitBtn()throws Exception{
        SqlUser userData = new SqlUser();
        String password = passwordRegister.getText();
        String email = emailRegister.getText();
        String name = nameRegister.getText();

        System.out.println(password);
        System.out.println(email);
        System.out.println(name);

        if (password.isBlank() || email.isBlank() || name.isBlank()){
            registerLabel.setText("Please Fill in your Informations!");
        }else{
            userData.Insert(name, password, email);
            registerLabel.setText("Register Done!");
            JOptionPane.showMessageDialog(null, "Register Done! \nPlease Login Again...");

        }

    }
    public void loginRegisterPage(ActionEvent event)throws Exception{
    
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void register(ActionEvent event)throws Exception{
    
        Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loginUser(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("userLab.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
