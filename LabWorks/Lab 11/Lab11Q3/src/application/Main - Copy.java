package application;
	

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.stage.Stage;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.HBox;


public class Main extends Application {
		
	String avg;
	
	@Override
	public void start(Stage primaryStage) {
		try {
		
			
			 
			
			 TextField studentID = new TextField();

			 TextField studentName = new TextField();

			 TextField depName = new TextField();
			
			
			Button add = new Button("add");

			add.setPrefSize(50, 20);

			add.setAlignment(Pos.CENTER);


			RadioButton excellent = new RadioButton("Excellent");
			RadioButton veryGood = new RadioButton("Very Good");
			RadioButton good = new RadioButton("Good");

			HBox average = new HBox(excellent, veryGood, good);


			ToggleGroup gpa = new ToggleGroup();

			excellent.setToggleGroup(gpa);
			veryGood.setToggleGroup(gpa);
			good.setToggleGroup(gpa);


			GridPane gp = new GridPane();

			gp.setHgap(5);

			gp.setVgap(5);

			gp.setPadding(new Insets(15, 15, 15, 15));

			gp.add(new Label("Student ID"), 0, 0);

			gp.add(studentID, 1, 0);

			gp.add(new Label("Student Name"), 0, 1);

			gp.add(studentName, 1, 1);

			gp.add(new Label("Average"), 0, 2);

			gp.add(average, 1, 2);

			gp.add(new Label("Deprtment Name"), 0, 3);

			gp.add(depName, 1, 3);

			gp.add(add, 1, 4);

			
			

			excellent.setOnAction(e -> {

				if (excellent.isSelected()) {

					avg = "Excellent";

				}

			});

			veryGood.setOnAction(e -> {

				if (veryGood.isSelected()) {

				 avg = "Very Good";

				}

			});

			good.setOnAction(e -> {

				if (good.isSelected()) {

					 avg = "Good";

				}

			});

			add.setOnAction(e -> {


				int stuID = Integer.parseInt(studentID.getText());

				String stuName = studentName.getText();

				String DepName = depName.getText();

				try {

					FileWriter writer = new FileWriter(new File("studentInfo.txt"),true);

					writer.write(stuID + " " + stuName + " " + avg + " " + DepName+ "\n");

					writer.close();


				} catch (IOException ex) {

					ex.printStackTrace();

				}
			});
						
			Scene scene = new Scene(gp);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
