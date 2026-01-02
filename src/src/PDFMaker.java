/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.*;

/**
 *
 * @author ADVAN
 */

public class PDFMaker {
    private PDDocument document;
    private String pdfFilePath;
    private List<File> imagesFiles;
    
    //Class container
    public PDFMaker(String pdfFilePath , List<File> imagesFiles) {
        this.pdfFilePath = pdfFilePath;
        this.imagesFiles = imagesFiles;
        document = new PDDocument();
   
    }
    
    //Create Page Function
    private PDPage createPageFromImage(File imageFile) {
        try {
            //Create Objects
            PDPage page = new PDPage();
            PDPageContentStream contentStream = new PDPageContentStream(this.document, page);
            PDImageXObject image = PDImageXObject.createFromFileByContent(imageFile, document);
            
            //Adjusting Image
            float pageWidth = PDRectangle.A4.getWidth();
            float pageHeight = PDRectangle.A4.getHeight();
            float imageWidth = image.getWidth();
            float imageHeight = image.getHeight();

            float scale = Math.max(pageWidth / imageWidth, pageHeight / imageHeight);
            float scaledWidth = imageWidth * scale;
            float scaledHeight = imageHeight * scale;
            

            float x = (pageWidth - scaledWidth) / 2;
            float y = (pageHeight - scaledHeight) / 2;
            
            //Draw Image
            contentStream.drawImage(image, x, y, scaledWidth, scaledHeight);
            
            //Confirmation
            System.out.println("Page Created!");
            //Close Content Stream
            contentStream.close();

            return page;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;  
    } 
    
    //Create PDF File Function
    public void createPDFFile() throws IOException {
        for (File f : imagesFiles) {
            PDPage page = createPageFromImage(f);
            
            if (page != null) {
                document.addPage(page); 
            }
        }
            File tempFile = new File(this.pdfFilePath);
            document.save(tempFile);
            document.close();

            Files.move(tempFile.toPath(), new File(this.pdfFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
   
            System.out.println("Document Created!");
    } 
}
