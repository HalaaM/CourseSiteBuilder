/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csb.gui;
import csb.data.Course;
import csb.data.Lecture;
import static csb.gui.AssignmentDialog.CANCEL;
import static csb.gui.AssignmentDialog.COMPLETE;
import static csb.gui.CSB_GUI.CLASS_HEADING_LABEL;
import static csb.gui.CSB_GUI.CLASS_PROMPT_LABEL;
import static csb.gui.CSB_GUI.PRIMARY_STYLE_SHEET;
import java.awt.Font;
import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.locks.ReentrantLock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author halaamenasy
 */
public class ProgressBarDialog extends Stage{
    
    ProgressBar bar;
    ProgressIndicator indicator;
    Button completeButton;
    Button cancelButton;
    Label processLabel;
    int numTasks = 0;
    ReentrantLock progressLock;
    GridPane gridPane;
    Scene dialogScene;
    
    public ProgressBarDialog (Stage primaryStage, Course course){
        
        initModality(Modality.WINDOW_MODAL);
        //initOwner(primaryStage);
        
        // FIRST OUR CONTAINER
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 20, 20,20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        progressLock = new ReentrantLock();
        bar = new ProgressBar(0);      
        indicator = new ProgressIndicator(0);      
        processLabel = new Label();
        
       
        gridPane.add(processLabel, 0, 0, 2, 1);
        gridPane.add(bar, 0, 1, 1, 1);
        gridPane.add(indicator, 1, 1, 1, 1);
         
        dialogScene = new Scene(gridPane);
        dialogScene.getStylesheets().add(PRIMARY_STYLE_SHEET);
        this.setScene(dialogScene);
        
      
    }
       
    public void setProgress(double perc){
        bar.setProgress(perc);
        
    }

    public ProgressBar getBar() {
        return bar;
    }

    public ProgressIndicator getIndicator() {
        return indicator;
    }
    
    public void setProgressIndicator(double perc){
        indicator.setProgress(perc);
    }
    
    public void setTextTask(String text){
       processLabel.setText(text);
        
    }
}
