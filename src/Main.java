import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import resources.DBConnection;
import javafx.scene.control.Button;

import java.util.Scanner;


public class Main extends Application {
    static DBConnection dbConn = new DBConnection();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("logIn.fxml"));
        Button loginBtn = (Button) root.lookup("#loginBtn");
        TextField uField = (TextField) root.lookup("#usernameField");
        TextField pField = (TextField) root.lookup("#passwordField");

        //Presenting login scene
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setResizable(false);
        primaryStage.show();


        //Creating ability to switch to another scene
        Scene scene2 = new Scene(FXMLLoader.load(getClass().getResource("home.fxml")),400,300);
        loginBtn.setOnAction(actionEvent ->  {
            if(dbConn.authenticate(uField.getText(),pField.getText())){
                primaryStage.setTitle("Home");
                primaryStage.setScene(scene2);
            }

        });
    }


    public static void main(String[] args) {
        System.out.println("Right now I am connecting my database.");
        dbConn.getRows();
        launch(args); //Program stops here
        
    }
}
