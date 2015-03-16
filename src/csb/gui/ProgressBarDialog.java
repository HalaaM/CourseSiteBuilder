/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csb.gui;
import csb.data.Course;
import csb.data.Lecture;
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
    Button button;
    Label processLabel;
    int numTasks = 0;
    ReentrantLock progressLock;

    
    public ProgressBarDialog (Stage primaryStage){
        progressLock = new ReentrantLock();
        VBox box = new VBox();

        HBox toolbar = new HBox();
        bar = new ProgressBar(0);      
        indicator = new ProgressIndicator(0);
        toolbar.getChildren().add(bar);
        toolbar.getChildren().add(indicator);
        
        button = new Button("Restart");
        processLabel = new Label();
        box.getChildren().add(toolbar);
        box.getChildren().add(button);
        box.getChildren().add(processLabel);
        
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        
}
    public void setProgress(double perc){
        bar.setProgress(perc);
        
    }
    
    public void setProgressIndicator(double perc){
        indicator.setProgress(perc);
    }
    
    public void setTextTask(String text){
        processLabel.setText(text);
        
    }
}
