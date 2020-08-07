package javafiles.controllers;
//Login controller

import javafiles.service.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    static DBConnection dbConn = new DBConnection();



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../resources/view/logIn.fxml"));
        Button loginBtn = (Button) root.lookup("#loginBtn");//CHANGE ME BACK
        TextField uField = (TextField) root.lookup("#usernameField");
        TextField pField = (TextField) root.lookup("#passwordField");


        //Presenting login scene
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setResizable(false);
        primaryStage.show();


        //Creating ability to switch to another scene
        Scene homeScene = new Scene(FXMLLoader.load(getClass().getResource("../../resources/view/home.fxml")),400,300);
        loginBtn.setOnAction(actionEvent ->  {
            if(dbConn.authenticate(uField.getText(),pField.getText())){
                primaryStage.setTitle("Home");
                primaryStage.setScene(homeScene);
                //TODO:: FIX ME

                //Created a greeting for user
                Text hText = (Text) homeScene.lookup("#homeText");
                String helloSign = hText.getText();
                helloSign = helloSign + dbConn.getCurrUser();
                hText.setText(helloSign);
            }

        });

        //Menu buttons


    }


    public static void main(String[] args) {
        System.out.println("Right now I am connecting my database.");
        dbConn.getRows();
        launch(args); //Program stops here

    }
}