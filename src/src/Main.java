/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Get FXML file
        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/MainFX.fxml"));
        //Set Title
        stage.setTitle("RaccoonPDF");
        //Create Scene Object
        Scene scene = new Scene(root);
        //Set Scene
        stage.setScene(scene);
        //Get StylSheet
        scene.getStylesheets().add(getClass().getResource("/Style/mainfx.css").toExternalForm());
        //Load Font
        //Font.loadFont(getClass().getResource("/Font/poppins-extrabold.otf").toExternalForm(), 0);
        //Set Icon
        stage.getIcons().add(new Image("/Assets/RacIcon.png"));
        //Ensure the GUI not Resizable
        stage.setResizable(false);
        //Show GUI
        stage.show();
        
    }
    
    
    public static void main(String[] args){
 
        launch(args);
    }
    
}
