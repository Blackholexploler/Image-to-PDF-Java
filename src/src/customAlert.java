/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author ADVAN
 */
public class customAlert {
     public void showCustomStage() { 
    Alert infoAlert = new Alert(AlertType.INFORMATION); 
    infoAlert.setTitle("Information"); 
    infoAlert.setHeaderText("ALERT!");
    infoAlert.setContentText("You need to select images and choose the path");
    infoAlert.showAndWait();
    }
}
