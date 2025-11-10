/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import src.PDFMaker;


public class Controller {

    @FXML
    private BorderPane rootPanel;
    
    @FXML
    private TextField pdfPathTF;

    List<File> imagesFile;
    
    @FXML
    //Select Image Function
    public void selectImages() {
        //Creating Images Chooser object using the "new" Constructor
        FileChooser imagesChooser = new FileChooser();
        
        //Set Title 
        imagesChooser.setTitle("Please select your images");
        
        //Open Explorer for Choosing File
        imagesFile = imagesChooser.showOpenMultipleDialog(rootPanel.getScene().getWindow());
        
        //Confirm if Image Null
        if (imagesFile == null) {
            System.out.println("Images are null");
            return;
        }
        
        //Get Image File Path
        for (File f : imagesFile)
            System.out.println(f.getAbsoluteFile());
            
    }

    @FXML
    //Choose Path Function
    private void choosePath() {
        //Creating pdfChooser object using the "new" Constructor
        FileChooser pdfChooser = new FileChooser();
        
        //Set Title
        pdfChooser.setTitle("Select the File Name and Path to Save to");
        
        //Open Explorer for Choosing Path
        File pdfFile = pdfChooser.showSaveDialog(rootPanel.getScene().getWindow());
        
        //Confirm if Path are Null
        if (pdfFile == null) {
            System.out.println("Path are Null");
            return;
        }
        
        //Get Absolute path
        pdfPathTF.setText(pdfFile.getAbsolutePath());
    }

    @FXML
    //Convert to PDF Function
    private void convertToPDF() {
        
        //Confirm if Images and Path are Null
        if (imagesFile == null || pdfPathTF.getText().equals("")) {
            System.out.println("Invalid Input");
            return; 
        }
        
        //Create PDFMaker object object using the "new" Constructor
        PDFMaker maker = new PDFMaker(pdfPathTF.getText(), imagesFile);
        
        //Test Function
        try {
            maker.createPDFFile();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
   
}
