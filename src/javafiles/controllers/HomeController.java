package javafiles.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomeController {
    public Main myMain = new Main();
    public Scene homeScene = myMain.getScene();

    public void initialize() throws IOException {

        System.out.println("You home brother!");
        //TODO:: Will not work becuse it is a nullpointer
        if(homeScene != null) {
            System.out.println("NOT NULL");
            Button newNoteBtn = (Button) homeScene.lookup("#newNoteMI");
            Button printBtn = (Button) homeScene.lookup("#printMI");
            newNoteBtn.setOnAction(actionEvent ->  {
                System.out.println("Clicking New Note Button!");
            });

            printBtn.setOnAction(actionEvent ->  {
                System.out.println("Clicking PRINT Button!");
            });
        }

    }


}
