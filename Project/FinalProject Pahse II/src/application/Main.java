package application;
	


import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import javax.management.openmbean.KeyAlreadyExistsException;

import finalproject.*;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Main extends Application {
	
	Rectangle rec= new Rectangle(0,0,100,100);
	MediaRental mr= new MediaRental();

	Stage stage= new Stage();
		
	@Override
	public void start(Stage primaryStage) {
		try {		
			
			readInfoFromFile();
			
			Scene scene= new Scene(mainPage());
			
			stage.setMaximized(true);
			
			stage.setScene(scene);	
			stage.setTitle("Rental Media Manage");
			stage.setIconified(true);
			stage.getIcons().add(new Image("a.png"));
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public BorderPane mainPage() {
		BorderPane root=new BorderPane();
		fade(root, 1100, 0, 1);

		ImageView img1=new ImageView("h.png");
		ImageView img2=new ImageView("a.png");
;
		rec.setArcHeight(50);
		rec.setArcWidth(20);

		StackPane sp=new StackPane();
		sp.setPadding(new Insets(40,0,0,0));
		Text text=new Text(500,100,"Rental Media System");
		text.setFont(Font.font("Comic Sans MS",FontWeight.BOLD,65));
		text.setFill(Color.WHITE);
		text.setStroke(Color.BLACK);
		text.setStrokeWidth(2);
		sp.getChildren().add(text);
		sp.setAlignment(Pos.CENTER);
		
		VBox vbox1=new VBox(20);
		Button btn1=new Button("Customer");
		btn1.setPrefSize(400, 110);
	    btn1.setShape(rec);
	    btn1.setFont(Font.font("arial", FontWeight.BOLD, 30));
	    btn1.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    Button btn2=new Button("Media");
		btn2.setPrefSize(400, 110);
	    btn2.setShape(rec);
	    btn2.setFont(Font.font("arial", FontWeight.BOLD, 30));
	    btn2.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    Button btn3=new Button("Rent");
		btn3.setPrefSize(400, 110);
	    btn3.setShape(rec);
	    btn3.setFont(Font.font("arial", FontWeight.BOLD, 30));
	    btn3.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	   
	    Button btn4 = new Button ("   Save Data", new ImageView("save.png"));
	    btn4.setPrefSize(400, 110);
	    btn4.setTextFill(Color.WHITE);
	    btn4.setFont(Font.font("arial", FontWeight.BOLD, 30));
	    btn4.setFont(Font.font(30));
	    btn4.setStyle("-fx-background-color:transparent");
	    
	    
	    btn4.setOnAction(e->{   //save data to File
	    	printInfoToFile();
	    });
	 
	    vbox1.getChildren().addAll(btn1,btn2,btn3,btn4);
	    vbox1.setAlignment(Pos.CENTER); 
	    
	    root.setPadding(new Insets(0,20,20,20));
    	root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
			+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto;-fx-decorator-color:blue;");
 		root.setTop(sp);
		root.setCenter(vbox1);
		root.setRight(img1);
		root.setLeft(img2);
		
		CheckBox ch= new CheckBox("Full Screen");
		ch.setFont(Font.font("arial", FontWeight.BOLD, 12));
		root.setBottom(ch);
		ch.setOnAction(e->{
			if(ch.isSelected())
				stage.setFullScreen(true);
			else
				stage.setFullScreen(false);
		});
		
		
		btn1.setOnAction(e->{  //customer button
			stage.getScene().setRoot(customerPage());
		});
		
		btn2.setOnAction(e->{  //media button
			stage.getScene().setRoot(mediaPage());
		});
		
		btn3.setOnAction(e->{  //rent button
			stage.getScene().setRoot(rentPage());
		});
		
		return root;
	}
	
	
	public BorderPane customerPage() {
		BorderPane root=new BorderPane();
		VBox vbox1=new VBox(20);
		Button btn1=new Button("Add new Customer");
		btn1.setPrefSize(600, 110);
	    btn1.setShape(rec);
	    btn1.setFont(Font.font(30));
	    btn1.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn1.setOnAction(e->{  //add customer button
			stage.getScene().setRoot(addCustomer());
		});
	    
	    Button btn2=new Button("Delete Customer");
		btn2.setPrefSize(600, 110);
	    btn2.setShape(rec);
	    btn2.setFont(Font.font(30));
	    btn2.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn2.setOnAction(e->{  //delete customer button
			stage.getScene().setRoot(deleteCustomer());
		});
	    
	    Button btn3=new Button("Update Information about Cutomer");
		btn3.setPrefSize(600, 110);
	    btn3.setShape(rec);
	    btn3.setFont(Font.font(30));
	    btn3.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn3.setOnAction(e->{  //update customer button
			stage.getScene().setRoot(updateCustomer());
		});
	    
	    Button btn4=new Button("Search a Customer");
		btn4.setPrefSize(600, 110);
	    btn4.setShape(rec);
	    btn4.setFont(Font.font(30));
	    btn4.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn4.setOnAction(e->{  //search a customer button
			stage.getScene().setRoot(searchCustomer());
		});
	    
	    Button btn5=new Button("Return to main page");
		btn5.setPrefSize(600, 110);
	    btn5.setShape(rec);
	    btn5.setFont(Font.font(30));
	    btn5.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    BorderPane.setAlignment(btn5, Pos.CENTER);
	    
	    btn5.setOnAction(e->{  //return to main page button
			stage.getScene().setRoot(mainPage());
		});
	
	    vbox1.getChildren().addAll(btn1,btn2,btn3,btn4);
	    vbox1.setAlignment(Pos.CENTER); 

	    root.setPadding(new Insets(0,0,40,0));
	    root.setCenter(vbox1);
	    root.setBottom(btn5);
	    root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");
		
	    //fade effect 
	    fade(root, 1100, 0, 1);
	    
        return root;		
	}
	
	
	public BorderPane addCustomer() {
		
		
		BorderPane root=new BorderPane();
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");	
		
		GridPane gp=new GridPane();
		gp.setHgap(70);
		gp.setVgap(50);
		gp.setAlignment(Pos.CENTER);

		//cutomer id
		Label lb1=new Label("Customer ID: ");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		
		lb1.setScaleX(2);
		lb1.setScaleY(2);
		
		TextField txt1= new TextField();
		txt1.setPrefColumnCount(30);
		

		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);
		
		//customer name
		Label lb2=new Label("Customer Name: ");
		lb2.setScaleX(2);
		lb2.setScaleY(2);
		lb2.setTextFill(Color.WHITE);
		lb2.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		
		TextField txt2= new TextField();
		txt2.setPrefColumnCount(30);

		gp.add(lb2, 0, 2);
		gp.add(txt2, 1, 2);
		
		//Customer Address
		Label lb3=new Label("Customer Address: ");
		lb3.setTextFill(Color.WHITE);
		lb3.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		lb3.setScaleX(2);
		lb3.setScaleY(2);	
		TextField txt3= new TextField();
		txt3.setPrefColumnCount(30);

		gp.add(lb3, 0, 3);
		gp.add(txt3, 1, 3);
		
		//Customer Plan
		Label lb4=new Label("Customer Plan: ");
		lb4.setTextFill(Color.WHITE);
		lb4.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb4.setScaleX(2);
		lb4.setScaleY(2);
		
		HBox hbox1 = new HBox(30);
		ToggleGroup tg= new ToggleGroup();
		
		RadioButton rb1 = new RadioButton("Limited");
		rb1.setFont(Font.font("arial", FontWeight.BOLD,25));
		rb1.setTextFill(Color.SILVER);
		RadioButton rb2 = new RadioButton("Unlimited");
		rb2.setFont(Font.font("arial", FontWeight.BOLD,25));
		rb2.setTextFill(Color.GOLD);


		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		hbox1.getChildren().addAll(rb1,rb2);

		gp.add(lb4, 0, 4);
		gp.add(hbox1, 1, 4);
		
		//customer mobile
		Label lb5=new Label("Customer Mobile: ");
		lb5.setTextFill(Color.WHITE);
		lb5.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb5.setScaleX(2);
		lb5.setScaleY(2);
		
		TextField txt5= new TextField();
		txt5.setPrefColumnCount(30);

		gp.add(lb5, 0, 5);
		gp.add(txt5, 1, 5);
		
		root.setCenter(gp);
		
		txt2.setDisable(true);
		txt3.setDisable(true);
		rb1.setDisable(true);
		rb2.setDisable(true);
		txt5.setDisable(true);

		
		txt1.setOnKeyReleased(e->{
			txt2.setDisable(false);
		});
		
		txt2.setOnKeyReleased(e->{
			txt3.setDisable(false);
		});
		
		txt3.setOnKeyReleased(e->{
			rb1.setDisable(false);
			rb2.setDisable(false);
			});
		
		rb1.setOnAction(e->{
			txt5.setDisable(false);
		});
		
		rb2.setOnAction(e->{
			txt5.setDisable(false);
		});
		
		HBox hbox=new HBox(100);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(0,0,40,0));
		
		Button btn1=new Button("Add", new ImageView("adduser.png"));
		btn1.setFont(Font.font(30));
		btn1.setStyle("-fx-background-color:transparent");
		btn1.setTextFill(Color.WHITE);
		btn1.setContentDisplay(ContentDisplay.RIGHT);
		
		
		btn1.setOnAction(e->{  // "Add" button
			String plan;
			if(rb1.isSelected())
				 plan = "Limited" ;
			else 
				 plan = "Unlimited";
				
			Label notes=new Label();
			notes.setFont(Font.font("arial", FontWeight.BOLD, 40));
			notes.setTextFill(Color.RED);
			notes.setPadding(new Insets(0,100,0,0));
			notes.setTextAlignment(TextAlignment.CENTER);
			BorderPane.setAlignment(notes, Pos.CENTER);
			notes.setVisible(false);
			root.setRight(notes);

			//fade out
			fade(notes, 4000, 1, 0);
			
			if(txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt5.getText().equals("")
					|| (!rb1.isSelected() && !rb2.isSelected())) {
				notes.setVisible(true);
				notes.setText("Please Fill all fields");
			}
				
			else {
				try {
					mr.addCustomer(txt1.getText(), txt2.getText(), txt3.getText(), plan, txt5.getText());
					notes.setVisible(true);
					notes.setTextFill(Color.LIME);
					notes.setText("Customer Added");
				} catch (KeyAlreadyExistsException ex) {
					notes.setVisible(true);
					notes.setTextFill(Color.RED);
					notes.setText("This id is \nalready exist");
					System.out.println(ex.getMessage());
				}
				
			}
			
			
		});
		
		Button btn2=new Button("Back", new ImageView("back.png"));
		btn2.setFont(Font.font(30));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		
		btn2.setOnAction(e->{  //back button
			stage.getScene().setRoot(customerPage());
		});
		
		hbox.getChildren().addAll(btn1,btn2);
		root.setBottom(hbox);

		//fade effect
		fade(root, 1100, 0, 1);
		
		return root;
	}
	
	
	public BorderPane deleteCustomer() {
		BorderPane root=new BorderPane();
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");	
		
		GridPane gp=new GridPane();
		gp.setHgap(70);
		gp.setVgap(50);
		gp.setAlignment(Pos.CENTER);

		//customer id
		Label lb1=new Label("Customer ID: ");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		
		lb1.setScaleX(2);
		lb1.setScaleY(2);
		
		TextField txt1= new TextField();
		txt1.setPrefColumnCount(30);
		

		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);
		
		//customer name
		Label lb2=new Label("Customer Name: ");
		lb2.setScaleX(2);
		lb2.setScaleY(2);
		lb2.setTextFill(Color.WHITE);
		lb2.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		
		TextField txt2= new TextField();
		txt2.setPrefColumnCount(30);
		
		gp.add(lb2, 0, 2);
		gp.add(txt2, 1, 2);
		
		//Customer Address
		Label lb3=new Label("Customer Address: ");
		lb3.setTextFill(Color.WHITE);
		lb3.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		lb3.setScaleX(2);
		lb3.setScaleY(2);	
		TextField txt3= new TextField();
		txt3.setPrefColumnCount(30);

		gp.add(lb3, 0, 3);
		gp.add(txt3, 1, 3);
		
		//Customer Plan
		Label lb4=new Label("Customer Plan: ");
		lb4.setTextFill(Color.WHITE);
		lb4.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb4.setScaleX(2);
		lb4.setScaleY(2);
		
		TextField txt4= new TextField();
		txt4.setPrefColumnCount(30);

		gp.add(lb4, 0, 4);
		gp.add(txt4, 1, 4);
		
		//customer mobile
		Label lb5=new Label("Customer Mobile: ");
		lb5.setTextFill(Color.WHITE);
		lb5.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb5.setScaleX(2);
		lb5.setScaleY(2);
		
		TextField txt5= new TextField();
		txt5.setPrefColumnCount(30);

		gp.add(lb5, 0, 5);
		gp.add(txt5, 1, 5);
		
		txt2.setEditable(false);
		txt3.setEditable(false);
		txt4.setEditable(false);
		txt5.setEditable(false);


		
		root.setCenter(gp);
		
		Label notes=new Label();
		notes.setFont(Font.font("arial", FontWeight.BOLD, 40));
		notes.setTextFill(Color.RED);
		notes.setPadding(new Insets(0,100,0,0));
		BorderPane.setAlignment(notes, Pos.CENTER);
		notes.setVisible(false);
		root.setRight(notes);
		
		HBox hbox=new HBox(100);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(0,0,40,0));
		
		Button btn1=new Button("Delete ", new ImageView("delete.png"));
		btn1.setStyle("-fx-background-color:transparent");
		btn1.setTextFill(Color.WHITE);
		btn1.setFont(Font.font(30));
		btn1.setContentDisplay(ContentDisplay.RIGHT);
		btn1.setDisable(true);
		
		btn1.setOnAction(e->{ //Delete Button
			
			fade(notes, 4000, 1, 0);
			
			if(mr.deleteCustomer(txt1.getText())) { //return true if delete is done and false if customer not exist
				notes.setVisible(true);
				notes.setTextFill(Color.LIME);
				notes.setText("Customer Deleted");
			}
			else {
				notes.setVisible(true);
				notes.setTextFill(Color.RED);
				notes.setText("Customer Not Found");
			}	
		});
		
		Button btn2=new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font(30));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		
		btn2.setOnAction(e->{  //back button
			stage.getScene().setRoot(customerPage());
		});
		
		Button btn3=new Button("Find ", new ImageView("search.png"));
		btn3.setStyle("-fx-background-color:transparent");
		btn3.setTextFill(Color.WHITE);
		btn3.setFont(Font.font(30));
		btn3.setContentDisplay(ContentDisplay.RIGHT);
			
		btn3.setOnAction(e->{ //search button
			btn1.setDisable(false);
			
			fade(notes, 4000, 1, 0);
			
			int index = mr.searchCustomerById(txt1.getText());	
			if(index<0) {
				notes.setVisible(true);
				notes.setTextFill(Color.RED);
				notes.setText("Customer Not Found");
			}
			else {
				notes.setVisible(false);
				Customer c = mr.getCustomer().get(index);
				txt2.setText(c.getName());
				txt3.setText(c.getAddress());
				txt4.setText(c.getPlan());
				txt5.setText(c.getMobile());
			}			
		});
		
		hbox.getChildren().addAll(btn3,btn1,btn2);
		root.setBottom(hbox);
		
		fade(root, 1100, 0, 1);
		
		return root;
	}
	
	
	public BorderPane updateCustomer() {
		BorderPane root=new BorderPane();
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");	
		
		GridPane gp=new GridPane();
		gp.setHgap(70);
		gp.setVgap(50);
		gp.setAlignment(Pos.CENTER);

		//customer id
		Label lb1=new Label("Customer ID: ");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		
		lb1.setScaleX(2);
		lb1.setScaleY(2);
		
		TextField txt1= new TextField();
		txt1.setPrefColumnCount(30);
		

		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);
		
		//customer name
		Label lb2=new Label("Customer Name: ");
		lb2.setScaleX(2);
		lb2.setScaleY(2);
		lb2.setTextFill(Color.WHITE);
		lb2.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		
		TextField txt2= new TextField();
		txt2.setPrefColumnCount(30);

		gp.add(lb2, 0, 2);
		gp.add(txt2, 1, 2);
		
		//Customer Address
		Label lb3=new Label("Customer Address: ");
		lb3.setTextFill(Color.WHITE);
		lb3.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		lb3.setScaleX(2);
		lb3.setScaleY(2);	
		TextField txt3= new TextField();
		txt3.setPrefColumnCount(30);

		gp.add(lb3, 0, 3);
		gp.add(txt3, 1, 3);
		
		//Customer Plan
		Label lb4=new Label("Customer Plan: ");
		lb4.setTextFill(Color.WHITE);
		lb4.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb4.setScaleX(2);
		lb4.setScaleY(2);
		
		HBox hbox1 = new HBox(30);
		ToggleGroup tg= new ToggleGroup();
		
		RadioButton rb1 = new RadioButton("Limited");
		rb1.setFont(Font.font("arial", FontWeight.BOLD,25));
		rb1.setTextFill(Color.SILVER);
		RadioButton rb2 = new RadioButton("Unlimited");
		rb2.setFont(Font.font("arial", FontWeight.BOLD,25));
		rb2.setTextFill(Color.GOLD);


		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		hbox1.getChildren().addAll(rb1,rb2);

		gp.add(lb4, 0, 4);
		gp.add(hbox1, 1, 4);
		
		//customer mobile
		Label lb5=new Label("Customer Mobile: ");
		lb5.setTextFill(Color.WHITE);
		lb5.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb5.setScaleX(2);
		lb5.setScaleY(2);
		
		TextField txt5= new TextField();
		txt5.setPrefColumnCount(30);

		gp.add(lb5, 0, 5);
		gp.add(txt5, 1, 5);
		
		root.setCenter(gp);
		
		Label notes=new Label();
		notes.setFont(Font.font("arial", FontWeight.BOLD, 40));
		notes.setTextFill(Color.RED);
		notes.setPadding(new Insets(0,100,0,0));
		BorderPane.setAlignment(notes, Pos.CENTER);
		notes.setVisible(false);
		root.setRight(notes);
		
		HBox hbox=new HBox(100);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(0,0,40,0));
		
		Button btn1=new Button("Update ", new ImageView("update.png"));
		btn1.setStyle("-fx-background-color:transparent");
		btn1.setTextFill(Color.WHITE);
		btn1.setFont(Font.font(30));
		btn1.setContentDisplay(ContentDisplay.RIGHT);
		btn1.setDisable(true);
		
		btn1.setOnAction(e->{
			fade(notes, 4000, 1, 0);
			
			int index = mr.searchCustomerById(txt1.getText());	
			if(index<0) {
				notes.setVisible(true);
				notes.setText("Customer Not Found");
			}
			else {
				notes.setVisible(true);
				notes.setTextFill(Color.LIME);
				notes.setText("Customer Updated");
				
				Customer c= mr.getCustomer().get(index);
				c.setName(txt2.getText());
				c.setAddress(txt3.getText());
				if(rb1.isSelected()) {
					c.setPlan("LIMITED");
				}
				else {
					c.setPlan("UNLIMITED");
				}
				c.setMobile(txt5.getText());
			}
			
			
		});
		
		
		Button btn2=new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font(30));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		
		btn2.setOnAction(e->{  //back button
			stage.getScene().setRoot(customerPage());
		});
		
		Button btn3=new Button("Find ", new ImageView("search.png"));
		btn3.setStyle("-fx-background-color:transparent");
		btn3.setTextFill(Color.WHITE);
		btn3.setFont(Font.font(30));
		btn3.setContentDisplay(ContentDisplay.RIGHT);
		

		btn3.setOnAction(e->{ //search button
			btn1.setDisable(false);
			
			fade(notes, 4000, 1, 0);
			
			int index = mr.searchCustomerById(txt1.getText());	
			if(index<0) {
				notes.setVisible(true);
				notes.setText("Customer Not Found");
			}
			else {
				notes.setVisible(false);
				Customer c = mr.getCustomer().get(index);
				txt2.setText(c.getName());
				txt3.setText(c.getAddress());
				if(c.getPlan().equalsIgnoreCase("limited")){
					rb1.setSelected(true);
				}
				else {
					rb2.setSelected(true);
				}
				txt5.setText(c.getMobile());
				

			}			
		});
		
		hbox.getChildren().addAll(btn3,btn1,btn2);
		root.setBottom(hbox);
		
		fade(root, 1100, 0, 1);
		
		return root;
	}
	
	
	public BorderPane searchCustomer() {
		BorderPane root=new BorderPane();
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");	
		fade(root, 1100, 0, 1);

		GridPane gp=new GridPane();
		gp.setHgap(70);
		gp.setVgap(50);
		gp.setAlignment(Pos.CENTER);

		//cutomer id
		Label lb1=new Label("Customer ID: ");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		
		lb1.setScaleX(2);
		lb1.setScaleY(2);
		
		TextField txt1= new TextField();
		txt1.setPrefColumnCount(30);
		

		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);
		
		//customer name
		Label lb2=new Label("Customer Name: ");
		lb2.setScaleX(2);
		lb2.setScaleY(2);
		lb2.setTextFill(Color.WHITE);
		lb2.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		
		TextField txt2= new TextField();
		txt2.setPrefColumnCount(30);

		gp.add(lb2, 0, 2);
		gp.add(txt2, 1, 2);
		
		//Customer Address
		Label lb3=new Label("Customer Address: ");
		lb3.setTextFill(Color.WHITE);
		lb3.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		lb3.setScaleX(2);
		lb3.setScaleY(2);	
		TextField txt3= new TextField();
		txt3.setPrefColumnCount(30);

		gp.add(lb3, 0, 3);
		gp.add(txt3, 1, 3);
		
		//Customer Plan
		Label lb4=new Label("Customer Plan: ");
		lb4.setTextFill(Color.WHITE);
		lb4.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb4.setScaleX(2);
		lb4.setScaleY(2);
		
		TextField txt4= new TextField();
		txt4.setPrefColumnCount(30);

		gp.add(lb4, 0, 4);
		gp.add(txt4, 1, 4);
		
		//customer mobile
		Label lb5=new Label("Customer Mobile: ");
		lb5.setTextFill(Color.WHITE);
		lb5.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb5.setScaleX(2);
		lb5.setScaleY(2);
		
		TextField txt5= new TextField();
		txt5.setPrefColumnCount(30);

		gp.add(lb5, 0, 5);
		gp.add(txt5, 1, 5);
		
		root.setCenter(gp);
		
		txt2.setEditable(false);
		txt3.setEditable(false);
		txt4.setEditable(false);
		txt5.setEditable(false);		
		
		Label notes=new Label();
		notes.setFont(Font.font("arial", FontWeight.BOLD, 40));
		notes.setTextFill(Color.RED);
		notes.setPadding(new Insets(0,100,0,0));
		BorderPane.setAlignment(notes, Pos.CENTER);
		notes.setVisible(false);
		root.setRight(notes);
		
		HBox hbox=new HBox(100);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(0,0,40,0));
		
		Button btn2=new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font(30));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		
		btn2.setOnAction(e->{  //back button
			stage.getScene().setRoot(customerPage());
		});
		
		Button btn3=new Button("Find ", new ImageView("search.png"));
		btn3.setStyle("-fx-background-color:transparent");
		btn3.setTextFill(Color.WHITE);
		btn3.setFont(Font.font(30));
		btn3.setContentDisplay(ContentDisplay.RIGHT);

		btn3.setOnAction(e->{ //search button
	
			fade(notes, 5000, 1, 0);
			
			int index = mr.searchCustomerById(txt1.getText());	
			if(index<0) {
				notes.setVisible(true);
				notes.setText("Customer Not Found");
			}
			else {
				Customer c = mr.getCustomer().get(index);
				notes.setVisible(false);
				txt2.setText(c.getName());
				txt3.setText(c.getAddress());
				txt4.setText(c.getPlan());
				txt5.setText(c.getMobile());
			}			
		});
		
		hbox.getChildren().addAll(btn3,btn2);
		root.setBottom(hbox);
		return root;
	}
	
	
	public BorderPane mediaPage() {
		BorderPane root=new BorderPane();
	    root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
					+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");
		fade(root, 1100, 0, 1);

		VBox vbox1=new VBox(20);
		Button btn1=new Button("Add new Media");
		btn1.setPrefSize(600, 110);
	    btn1.setShape(rec);
	    btn1.setFont(Font.font(30));
	    btn1.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn1.setOnAction(e->{  //add new media button
			stage.getScene().setRoot(addMedia());
		});
	    
	    Button btn2=new Button("Delete Media");
		btn2.setPrefSize(600, 110);
	    btn2.setShape(rec);
	    btn2.setFont(Font.font(30));
	    btn2.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn2.setOnAction(e->{  //Delete Media button
			stage.getScene().setRoot(deleteMedia());
		});
	    
	    Button btn3=new Button("Update Information about Media");
		btn3.setPrefSize(600, 110);
	    btn3.setShape(rec);
	    btn3.setFont(Font.font(30));
	    btn3.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn3.setOnAction(e->{  //Update Media button
			stage.getScene().setRoot(updateMedia());
		});
	    
	    Button btn4=new Button("Search a Media");
		btn4.setPrefSize(600, 110);
	    btn4.setShape(rec);
	    btn4.setFont(Font.font(30));
	    btn4.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn4.setOnAction(e->{  //Search Media button
			stage.getScene().setRoot(searchMedia());
		});
	    
	    Button btn5=new Button("Print All Media information");
		btn5.setPrefSize(600, 110);
	    btn5.setShape(rec);
	    btn5.setFont(Font.font(30));
	    btn5.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn5.setOnAction(e->{  //print all Media info button
			stage.getScene().setRoot(printMediaInfo());
		});
	    
	    Button btn6=new Button("Return to main page");
		btn6.setPrefSize(600, 110);
	    btn6.setShape(rec);
	    btn6.setFont(Font.font(30));
	    btn6.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    BorderPane.setAlignment(btn6, Pos.CENTER);
	    
	    btn6.setOnAction(e->{  //back button
			stage.getScene().setRoot(mainPage());
		});
	
	    vbox1.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
	    vbox1.setAlignment(Pos.CENTER); 

	    root.setPadding(new Insets(0,0,10,0));
	    root.setCenter(vbox1);
	    root.setBottom(btn6);
	
		
        return root;		
	}
	
	public BorderPane addMedia() {
		
		BorderPane root=new BorderPane();
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");	
		fade(root, 1100, 0, 1);

		GridPane gp=new GridPane();
		gp.setHgap(70);
		gp.setVgap(50);
		gp.setAlignment(Pos.CENTER);

		HBox hbox=new HBox(50);
		
		Label lb=new Label("Select Media: ");
		lb.setTextFill(Color.WHITE);
		lb.setScaleX(2);
		lb.setScaleY(2);
		lb.setFont(Font.font(null,FontWeight.BOLD,lb.getFont().getSize()));
		
		ComboBox<String> cb= new ComboBox<>();
		cb.setStyle("-fx-font-size:20px");
		cb.getItems().addAll("Album", "Movie", "Game");
		cb.setPrefSize(200, 40);
		
		hbox.getChildren().addAll(lb,cb);
		root.setTop(hbox);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(40,0,0,0));

		//media code
		Label lb1=new Label("Media Code: ");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));		
		lb1.setScaleX(2);
		lb1.setScaleY(2);
		
		TextField txt1= new TextField();
		txt1.setPrefColumnCount(30);
				
		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);
		
		//media title
		Label lb2=new Label("Media title: ");
		lb2.setScaleX(2);
		lb2.setScaleY(2);
		lb2.setTextFill(Color.WHITE);
		lb2.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		
		TextField txt2= new TextField();
		txt2.setPrefColumnCount(30);

		gp.add(lb2, 0, 2);
		gp.add(txt2, 1, 2);
		
		//Copies Available
		Label lb3=new Label("Copies Available: ");
		lb3.setTextFill(Color.WHITE);
		lb3.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		lb3.setScaleX(2);
		lb3.setScaleY(2);	
		TextField txt3= new TextField();
		txt3.setPrefColumnCount(30);

		gp.add(lb3, 0, 3);
		gp.add(txt3, 1, 3);
		
		//number of copies
		Label lb4=new Label("");
		lb4.setTextFill(Color.WHITE);
		lb4.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb4.setScaleX(2);
		lb4.setScaleY(2);
		
		TextField txt4= new TextField();
		txt4.setPrefColumnCount(30);

		gp.add(lb4, 0, 4);
		
		//customer mobile
		Label lb5=new Label("");
		lb5.setTextFill(Color.WHITE);
		lb5.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb5.setScaleX(2);
		lb5.setScaleY(2);
		
		TextField txt5= new TextField();
		txt5.setPrefColumnCount(30);

		gp.add(lb5, 0, 5);
		gp.add(txt5, 1, 5);
		
		root.setCenter(gp);
		
		HBox hbox1=new HBox(100);
		
		RadioButton rb1 = new RadioButton("DR");
		rb1.setFont(Font.font("arial", FontWeight.BOLD,25));
		rb1.setTextFill(Color.GOLD);
		
		RadioButton rb2 = new RadioButton("HR");
		rb2.setFont(Font.font("arial", FontWeight.BOLD,25));
		rb2.setTextFill(Color.GOLD);
		
		RadioButton rb3 = new RadioButton("AC");
		rb3.setFont(Font.font("arial", FontWeight.BOLD,25));
		rb3.setTextFill(Color.GOLD);
 
        ToggleGroup tg = new ToggleGroup();
		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);
		rb3.setToggleGroup(tg);
		
		hbox1.getChildren().addAll(rb1,rb2,rb3);
		
		Label notes=new Label();
		notes.setFont(Font.font("arial", FontWeight.BOLD, 40));
		notes.setTextFill(Color.RED);
		notes.setPadding(new Insets(0,100,0,0));
		BorderPane.setAlignment(notes, Pos.CENTER);
		notes.setTextAlignment(TextAlignment.CENTER);
		notes.setVisible(false);
		root.setRight(notes);
		
		txt1.setDisable(true);
		txt2.setDisable(true);
		txt3.setDisable(true);
		txt5.setVisible(false);
		lb4.setVisible(false);
		lb5.setVisible(false);
		hbox1.setVisible(false);
		
		//combo box event
		cb.setOnAction(e->{   
			txt1.clear();
			txt2.clear();
			txt3.clear();
			txt4.clear();
			txt5.clear();
			rb1.setSelected(false);
			rb2.setSelected(false);
			rb3.setSelected(false);
			
			txt1.setDisable(false);
			txt2.setDisable(false);
			txt3.setDisable(false);
			if(cb.getSelectionModel().isSelected(0)) { //if album selected
				gp.getChildren().removeAll(hbox1,txt4);

				gp.add(txt4, 1, 4);
				lb4.setVisible(true);
				lb4.setText("Artist: ");
				txt4.setVisible(true);
		    	txt5.setVisible(true);
			    lb5.setVisible(true);
				lb5.setText("Songs: ");
				
			}
			
			else if(cb.getSelectionModel().isSelected(1)) { //if movie selected	
				gp.getChildren().removeAll(txt4,hbox1);
				gp.add(hbox1, 1, 4);
				txt4.setVisible(false);
				lb4.setVisible(true);
				hbox1.setVisible(true);
				txt5.setVisible(false);
				lb5.setVisible(false);
				lb4.setText("Rating: ");
			}
			else if(cb.getSelectionModel().isSelected(2)) { //if game selected
				gp.getChildren().removeAll(hbox1,txt4);
				gp.add(txt4, 1, 4);
				
				hbox1.setVisible(false);
				txt4.setVisible(true);
				lb4.setVisible(true);
				txt5.setVisible(false);
				lb5.setVisible(false);
				lb4.setText("Weight: ");
			}

				
		});
			
		HBox hbox2=new HBox(100);
		hbox2.setAlignment(Pos.CENTER);
		hbox2.setPadding(new Insets(0,0,40,0));
		
		Button btn2=new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font(30));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		
		btn2.setOnAction(e->{  //back button
			stage.getScene().setRoot(mediaPage());
		});
		
		Button btn1=new Button("Add", new ImageView("addmed.png"));
		btn1.setFont(Font.font(30));
		btn1.setStyle("-fx-background-color:transparent");
		btn1.setTextFill(Color.WHITE);
		btn1.setContentDisplay(ContentDisplay.RIGHT);
		
		btn1.setOnAction(e->{
			fade(notes, 5000, 1, 0);
			if (cb.getSelectionModel().isSelected(0)) { // add album

				//check if all field are written
				if (txt1.getText().equals("") && txt2.getText().equals("") && txt3.getText().equals("") 
						&& txt4.getText().equals("") && txt5.getText().equals("")) {
					notes.setVisible(true);
					notes.setTextFill(Color.RED);
					notes.setText("Please fill\nall Fields");
				} else {

					try {
						mr.addAlbum(txt1.getText(), txt2.getText(), Integer.parseInt(txt3.getText()), txt4.getText(),
								txt5.getText());
						notes.setVisible(true);
						notes.setTextFill(Color.LIME);
						notes.setText("Album added");
					} catch (NumberFormatException e2) { // throw exception if no_of_copies not an integer
						notes.setVisible(true);
						notes.setTextFill(Color.RED);
						notes.setText("Please Enter an\ninteger only\nfor copies available");
					} catch (KeyAlreadyExistsException ex) { // if media code is already taken
						notes.setVisible(true);
						notes.setTextFill(Color.RED);
						notes.setText("Media Code is\n already taken");
					}

				}

			}

			else if (cb.getSelectionModel().isSelected(1)) { // add movie
				
				//check if all field are written
				if (txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("")
						|| (!rb1.isSelected() && !rb2.isSelected() && !rb3.isSelected())) {
					notes.setVisible(true);
					notes.setTextFill(Color.RED);
					notes.setText("Please fill\nall Fields");
				} else {
					
					String rate;
					if (rb1.isSelected())
						rate = "DR";
					else if (rb2.isSelected())
						rate = "HR";
					else
						rate = "AC";

					try {
						mr.addMovie(txt1.getText(), txt2.getText(), Integer.parseInt(txt3.getText()), rate);
						notes.setVisible(true);
						notes.setTextFill(Color.LIME);
						notes.setText("Movie added");
					} catch (NumberFormatException e2) { // throw exception if no_of_copies not an integer
						notes.setVisible(true);
						notes.setTextFill(Color.RED);
						notes.setText("Please Enter an\ninteger only\nfor copies available");
					} catch (KeyAlreadyExistsException ex) { // if media code is already taken
						notes.setVisible(true);
						notes.setTextFill(Color.RED);
						notes.setText("Media Code is\n already taken");
					}
				}

			}
			else if(cb.getSelectionModel().isSelected(2)) { //add game
				
				try {
					mr.addGame(txt1.getText(), txt2.getText(), Integer.parseInt(txt3.getText()), Double.parseDouble(txt4.getText()));
					notes.setVisible(true);
					notes.setTextFill(Color.LIME);
					notes.setText("Game added");
				} catch (NumberFormatException  e2) { //throw exception if no_of_copies not an integer or weight not a double
					notes.setTextFill(Color.RED);
					notes.setVisible(true);
					notes.setText("Please enter the correct\nformat in the fields");
				}catch (KeyAlreadyExistsException ex) { //if media code is already taken
					notes.setVisible(true);
					notes.setTextFill(Color.RED);
					notes.setText("Media Code is\n already taken");
				}
			}
			
		});
		
		hbox2.getChildren().addAll(btn1,btn2);
		root.setBottom(hbox2);
		return root;
	}
	
	public BorderPane deleteMedia() {
		

		BorderPane root=new BorderPane();
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");	
		fade(root, 1100, 0, 1);

		GridPane gp=new GridPane();
		gp.setHgap(70);
		gp.setVgap(50);
		gp.setAlignment(Pos.CENTER);
		
		//media code
		Label lb1=new Label("Media Code: ");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));		
		lb1.setScaleX(2);
		lb1.setScaleY(2);
		
		TextField txt1= new TextField();
		txt1.setPrefColumnCount(30);
				
		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);
		
		//media title
		Label lb2=new Label("Media title: ");
		lb2.setScaleX(2);
		lb2.setScaleY(2);
		lb2.setTextFill(Color.WHITE);
		lb2.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		
		TextField txt2= new TextField();
		txt2.setPrefColumnCount(30);

		gp.add(lb2, 0, 2);
		gp.add(txt2, 1, 2);
		
		//Copies Available
		Label lb3=new Label("Copies Available: ");
		lb3.setTextFill(Color.WHITE);
		lb3.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		lb3.setScaleX(2);
		lb3.setScaleY(2);	
		TextField txt3= new TextField();
		txt3.setPrefColumnCount(30);

		gp.add(lb3, 0, 3);
		gp.add(txt3, 1, 3);
		
		//number of copies
		Label lb4=new Label();
		lb4.setTextFill(Color.WHITE);
		lb4.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb4.setScaleX(2);
		lb4.setScaleY(2);
		
		TextField txt4= new TextField();
		txt4.setPrefColumnCount(30);

		gp.add(lb4, 0, 4);
		gp.add(txt4, 1, 4);
		
		//customer mobile
		Label lb5=new Label();
		lb5.setTextFill(Color.WHITE);
		lb5.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb5.setScaleX(2);
		lb5.setScaleY(2);
		
		TextField txt5= new TextField();
		txt5.setPrefColumnCount(30);

		gp.add(lb5, 0, 5);
		gp.add(txt5, 1, 5);
		
		root.setCenter(gp);
		
		HBox hbox1=new HBox(100);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setPadding(new Insets(0,0,40,0));
		
		Label notes= new Label();
		notes.setTextFill(Color.RED);
		notes.setFont(Font.font(null,FontWeight.BOLD,40));
		notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:red; -fx-background-color:white");
		gp.add(notes, 1, 6);

		txt2.setEditable(false);
		txt3.setEditable(false);
		txt4.setEditable(false);
		txt5.setEditable(false);
		
		lb2.setVisible(false);
		lb3.setVisible(false);
		
		notes.setVisible(false);				
		txt2.setVisible(false);
		txt3.setVisible(false);
		txt4.setVisible(false);
		txt5.setVisible(false);

			
		
		Button btn2=new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font(30));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		
		btn2.setOnAction(e->{  //back button
			stage.getScene().setRoot(mediaPage());
		});
		
		
		
		Button btn1=new Button("Delete", new ImageView("removemed.png"));
		btn1.setFont(Font.font(30));
		btn1.setStyle("-fx-background-color:transparent");
		btn1.setTextFill(Color.WHITE);
		btn1.setContentDisplay(ContentDisplay.RIGHT);
		btn1.setDisable(true);
		
		btn1.setOnAction(e->{
		fade(notes, 5000, 1, 0);
		  if( mr.deleteMedia(txt1.getText())) { //return true if delete done and false if media not exist
			  notes.setVisible(true);
			  notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:lime; -fx-background-color:white");
			  notes.setTextFill(Color.LIME);
			  notes.setText("Media Deleted");
		  }
		  else {
			  notes.setVisible(true);
			  notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:red; -fx-background-color:white");
			  notes.setTextFill(Color.RED);
			  notes.setText("Media Not Found");
		  }
					 
			
			btn1.setDisable(true);
		});
		
		Button btn3=new Button("Find ", new ImageView("search.png"));
		btn3.setStyle("-fx-background-color:transparent");
		btn3.setTextFill(Color.WHITE);
		btn3.setFont(Font.font(30));
		btn3.setContentDisplay(ContentDisplay.RIGHT);
		
		btn3.setOnAction(e->{
			fade(notes, 5000, 1, 0);
			
		    int index =	mr.searchMediaByCode(txt1.getText());
			if(index>-1) {   //check if the media code exist
				btn1.setDisable(false);
				
				lb2.setVisible(false);
				lb3.setVisible(false);

				txt2.setVisible(true);
				txt3.setVisible(true);

			    Media m= mr.getMedia().get(index);
			
				txt2.setText(m.getTitle());
				txt3.setText(""+m.getNo_of_copies());

				if(m instanceof Album) {
					Album album = (Album)m;
					
					txt4.setVisible(true);
					txt5.setVisible(true);					
					
					lb4.setText("Artist: ");
					lb5.setText("Songs: ");
					txt4.setText(album.getArtist());
					txt5.setText(album.getSongs());

				}
				else if(m instanceof Movie) {
					Movie movie = (Movie)m;
					
					txt4.setVisible(true);
					txt5.setVisible(false);		
					lb5.setVisible(false);
					lb4.setText("Rating: ");
					txt4.setText(movie.getRating());
				}
				else if(m instanceof Game) {
					Game game = (Game)m;
					
					txt4.setVisible(true);
					txt5.setVisible(false);	
					lb5.setVisible(false);	
					lb4.setText("Rating: ");
					txt4.setText(""+game.getWeight());
				}
			}
			else {  //if media not found
				notes.setVisible(true);		
				notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:red; -fx-background-color:white");
				notes.setText("Media Not Found");
			}
				
		});
		
		hbox1.getChildren().addAll(btn3, btn1, btn2);
		root.setBottom(hbox1);
		return root;
	}
	
	public BorderPane updateMedia() {
		
		BorderPane root=new BorderPane();
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");	
		fade(root, 1100, 0, 1);

		GridPane gp=new GridPane();
		gp.setHgap(70);
		gp.setVgap(50);
		gp.setAlignment(Pos.CENTER);
		
		//media code
		Label lb1=new Label("Media Code: ");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));		
		lb1.setScaleX(2);
		lb1.setScaleY(2);
		
		TextField txt1= new TextField();
		txt1.setPrefColumnCount(30);
				
		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);
		
		//media title
		Label lb2=new Label("Media title: ");
		lb2.setScaleX(2);
		lb2.setScaleY(2);
		lb2.setTextFill(Color.WHITE);
		lb2.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		
		TextField txt2= new TextField();
		txt2.setPrefColumnCount(30);

		gp.add(lb2, 0, 2);
		gp.add(txt2, 1, 2);
		
		//Copies Available
		Label lb3=new Label("Copies Available: ");
		lb3.setTextFill(Color.WHITE);
		lb3.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		lb3.setScaleX(2);
		lb3.setScaleY(2);	
		TextField txt3= new TextField();
		txt3.setPrefColumnCount(30);

		gp.add(lb3, 0, 3);
		gp.add(txt3, 1, 3);
		
		//number of copies
		Label lb4=new Label();
		lb4.setTextFill(Color.WHITE);
		lb4.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb4.setScaleX(2);
		lb4.setScaleY(2);
		
		TextField txt4= new TextField();
		txt4.setPrefColumnCount(30);

		gp.add(lb4, 0, 4);
		gp.add(txt4, 1, 4);
		
		//customer mobile
		Label lb5=new Label();
		lb5.setTextFill(Color.WHITE);
		lb5.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb5.setScaleX(2);
		lb5.setScaleY(2);
		
		TextField txt5= new TextField();
		txt5.setPrefColumnCount(30);

		gp.add(lb5, 0, 5);
		gp.add(txt5, 1, 5);
		
		root.setCenter(gp);
		
		HBox hbox1=new HBox(100);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setPadding(new Insets(0,0,40,0));
		
		Label notes= new Label();
		notes.setTextFill(Color.RED);
		notes.setFont(Font.font(null,FontWeight.BOLD,50));
		notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:red; -fx-background-color:white");
		gp.add(notes, 1, 6);

		notes.setVisible(false);
		txt2.setVisible(false);
		txt3.setVisible(false);
		txt4.setVisible(false);
		txt5.setVisible(false);
		lb2.setVisible(false);
		lb3.setVisible(false);
		lb4.setVisible(false);
		lb5.setVisible(false);
		
	
		Button btn2=new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font(30));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		
		btn2.setOnAction(e->{  //back button
			stage.getScene().setRoot(mediaPage());
		});
		
		Button btn1=new Button("Update", new ImageView("update.png"));
		btn1.setFont(Font.font(30));
		btn1.setStyle("-fx-background-color:transparent");
		btn1.setTextFill(Color.WHITE);
		btn1.setContentDisplay(ContentDisplay.RIGHT);
		btn1.setDisable(true);

		btn1.setOnAction(e->{
			 fade(notes, 5000, 1, 0);

			 int index = mr.searchMediaByCode(txt1.getText());
				if(index>-1) {   //check if the media code exist
					Media m= mr.getMedia().get(index);
					notes.setVisible(false);
					
					try {
						m.setTitle(txt2.getText());
						m.setNo_of_copies(Integer.parseInt(txt3.getText()));
						
						if(m instanceof Album) {
							Album album = (Album)m;
							
							album.setArtist(txt4.getText());
							album.setSongs(txt5.getText());
							
							 notes.setVisible(true);
					         notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:lime; -fx-background-color:white");
							 notes.setTextFill(Color.LIME);
							 notes.setText("Album Updated");
							
						}
						else if(m instanceof Movie) {
							Movie movie = (Movie)m;
							movie.setRating(txt4.getText());
							
							 notes.setVisible(true);
							 notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:lime; -fx-background-color:white");
							 notes.setTextFill(Color.LIME);
							 notes.setText("Movie Updated");
						}
						else if(m instanceof Game) {
							Game game = (Game)m;
							game.setWeight(Double.parseDouble(txt4.getText()));
							
							 notes.setVisible(true);
							 notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:lime; -fx-background-color:white");
							 notes.setTextFill(Color.LIME);
							 notes.setText("Movie Updated");
						}

					} catch (NumberFormatException ex) { // throw exception if copies available not integer
						notes.setVisible(true);
						notes.setTextFill(Color.RED);
						notes.setText("Please enter appropriate format");
					}					
					
				}
				else {  //if media not found
					notes.setVisible(true);
					notes.setText("Media Not Found");
				}
			
			btn1.setDisable(true);
		});
		
		Button btn3=new Button("Find ", new ImageView("search.png"));
		btn3.setStyle("-fx-background-color:transparent");
		btn3.setTextFill(Color.WHITE);
		btn3.setFont(Font.font(30));
		btn3.setContentDisplay(ContentDisplay.RIGHT);
		
		btn3.setOnAction(e->{
			 fade(notes, 5000, 1, 0);
			
		    int index =	mr.searchMediaByCode(txt1.getText());
			if(index>-1) {   //check if the media code exist
				btn1.setDisable(false);
				
				 Media m= mr.getMedia().get(index);
				notes.setVisible(false);
				txt2.setVisible(true);   
				txt3.setVisible(true);
				lb2.setVisible(true);
				lb3.setVisible(true);
				txt2.setText(m.getTitle());
				txt3.setText(""+m.getNo_of_copies());
				txt4.setVisible(true);

				if(m instanceof Album) {
					Album album = (Album)m;
					txt5.setVisible(true);
					lb4.setVisible(true);
					lb5.setVisible(true);
								
					lb4.setText("Artist: ");
					lb5.setText("Songs: ");
					txt4.setText(album.getArtist());
					txt5.setText(album.getSongs());
				}
				else if(m instanceof Movie) {
					Movie movie = (Movie)m;
					
					lb4.setVisible(true);
					lb5.setVisible(true);			
					lb4.setText("Rating: ");
					txt4.setText(movie.getRating());
				}
				else if(m instanceof Movie) {
					Game game = (Game)m;
					
					lb4.setVisible(true);
					lb5.setVisible(true);			
					lb4.setText("Rating: ");
					txt4.setText(""+game.getWeight());
				}
			}
			else {  //if media not found
				notes.setVisible(true);
				notes.setText("Media Not Found");
			}
				
		});
				
		hbox1.getChildren().addAll(btn3, btn1, btn2);
		root.setBottom(hbox1);
		return root;
		
	}
	
	public BorderPane searchMedia() {
		BorderPane root=new BorderPane();
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");	
		fade(root, 1100, 0, 1);

		GridPane gp=new GridPane();
		gp.setHgap(70);
		gp.setVgap(50);
		gp.setAlignment(Pos.CENTER);
		
		//media code
		Label lb1=new Label("Media Code: ");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));		
		lb1.setScaleX(2);
		lb1.setScaleY(2);
		
		TextField txt1= new TextField();
		txt1.setPrefColumnCount(30);
				
		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);
		
		//media title
		Label lb2=new Label("Media title: ");
		lb2.setScaleX(2);
		lb2.setScaleY(2);
		lb2.setTextFill(Color.WHITE);
		lb2.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		
		TextField txt2= new TextField();
		txt2.setPrefColumnCount(30);

		gp.add(lb2, 0, 2);
		gp.add(txt2, 1, 2);
		
		//Copies Available
		Label lb3=new Label("Copies Available: ");
		lb3.setTextFill(Color.WHITE);
		lb3.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));
		lb3.setScaleX(2);
		lb3.setScaleY(2);	
		TextField txt3= new TextField();
		txt3.setPrefColumnCount(30);

		gp.add(lb3, 0, 3);
		gp.add(txt3, 1, 3);
		
		//number of copies
		Label lb4=new Label("");
		lb4.setTextFill(Color.WHITE);
		lb4.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb4.setScaleX(2);
		lb4.setScaleY(2);
		
		TextField txt4= new TextField();
		txt4.setPrefColumnCount(30);

		gp.add(lb4, 0, 4);
		gp.add(txt4, 1, 4);
		
		//customer mobile
		Label lb5=new Label("");
		lb5.setTextFill(Color.WHITE);
		lb5.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));

		lb5.setScaleX(2);
		lb5.setScaleY(2);
		
		TextField txt5= new TextField();
		txt5.setPrefColumnCount(30);

		gp.add(lb5, 0, 5);
		gp.add(txt5, 1, 5);
		
		root.setCenter(gp);
		
		HBox hbox1=new HBox(100);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.setPadding(new Insets(0,0,40,0));
		
		Label notes= new Label();
		notes.setTextFill(Color.RED);
		notes.setText("Media Not Found");
		notes.setFont(Font.font(null,FontWeight.BOLD,50));
		notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:red; -fx-background-color:white");
		gp.add(notes, 1, 6);

		notes.setVisible(false);
		txt2.setVisible(false);
		txt3.setVisible(false);
		txt4.setVisible(false);
		txt5.setVisible(false);
		lb2.setVisible(false);
		lb3.setVisible(false);
		lb4.setVisible(false);
		lb5.setVisible(false);	
		
		Button btn2=new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font(30));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		
		btn2.setOnAction(e->{  //back button
			stage.getScene().setRoot(mediaPage());
		});
		
		Button btn3=new Button("Find ", new ImageView("search.png"));
		btn3.setStyle("-fx-background-color:transparent");
		btn3.setTextFill(Color.WHITE);
		btn3.setFont(Font.font(30));
		btn3.setContentDisplay(ContentDisplay.RIGHT);
		
		btn3.setOnAction(e->{
			 fade(notes, 5000, 1, 0);
			
		    int index =	mr.searchMediaByCode(txt1.getText());
			if(index>-1) {   //check if the media code exist
				
				 Media m= mr.getMedia().get(index);
				notes.setVisible(false);
				txt2.setVisible(true);   
				txt3.setVisible(true);
				lb2.setVisible(true);
				lb3.setVisible(true);
				txt2.setText(m.getTitle());
				txt3.setText(""+m.getNo_of_copies());
				txt4.setVisible(true);

				if(m instanceof Album) {
					Album album = (Album)m;
					txt5.setVisible(true);
					lb4.setVisible(true);
					lb5.setVisible(true);
								
					lb4.setText("Artist: ");
					lb5.setText("Songs: ");
					txt4.setText(album.getArtist());
					txt5.setText(album.getSongs());
				}
				else if(m instanceof Movie) {
					Movie movie = (Movie)m;
					
					lb4.setVisible(true);
					lb5.setVisible(true);			
					lb4.setText("Rating: ");
					txt4.setText(movie.getRating());
				}
				else if(m instanceof Movie) {
					Game game = (Game)m;
					
					lb4.setVisible(true);
					lb5.setVisible(true);			
					lb4.setText("Rating: ");
					txt4.setText(""+game.getWeight());
				}
			}
			else {  //if media not found
				notes.setVisible(true);
				notes.setText("Media Not Found");
			}
				
		});
		
		hbox1.getChildren().addAll(btn3, btn2);
		root.setBottom(hbox1);
		return root;
		
	}
	
	public BorderPane printMediaInfo() {
		
		BorderPane root= new BorderPane();
		root.setPadding(new Insets(50,100,30,100));
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");	
		fade(root, 1100, 0, 1);
		
		Text text=new Text("All Media Information");
		text.setFill(Color.WHITE);
		text.setStrokeWidth(2);
		text.setStroke(Color.BLACK);
		text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));
		
		BorderPane.setAlignment(text, Pos.CENTER);

		root.setTop(text);
		
		TextArea txt=new TextArea();
		txt.setEditable(false);
		txt.setPadding(new Insets(30,10,30,10));
		txt.setStyle("-fx-border-style:solid;-fx-border-width:2;-fx-border-color:black;");
		txt.setPrefSize(50, 50);
		txt.setFont(Font.font(25));
		
		if(mr.getAllMediaInfo().equals("")) {
			txt.setText("No Media Available");
		}
		else {
			txt.setText(mr.getAllMediaInfo());
		}
		root.setCenter(txt);
		BorderPane.setAlignment(txt, Pos.CENTER);
		
		Button btn2=new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font("Comic Sans MS",FontWeight.BOLD,45));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		BorderPane.setAlignment(btn2, Pos.CENTER);
		root.setBottom(btn2);
		
		btn2.setOnAction(e->{  //back button
			stage.getScene().setRoot(mediaPage());
		});
		
		return root;		
		
		
	}
	

	public BorderPane rentPage() {
		BorderPane root=new BorderPane();
		VBox vbox1=new VBox(20);
		Button btn1=new Button("Rent Form");
		btn1.setPrefSize(600, 110);
	    btn1.setShape(rec);
	    btn1.setFont(Font.font(30));
	    btn1.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn1.setOnAction(e->{  
			stage.getScene().setRoot(rentForm());
		});
	    
	    Button btn2=new Button("Requested Media");
		btn2.setPrefSize(600, 110);
	    btn2.setShape(rec);
	    btn2.setFont(Font.font(30));
	    btn2.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn2.setOnAction(e->{  
			stage.getScene().setRoot(requestedMedia());
		});
	    
	    Button btn3=new Button("Rented Media");
		btn3.setPrefSize(600, 110);
	    btn3.setShape(rec);
	    btn3.setFont(Font.font(30));
	    btn3.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn3.setOnAction(e->{  
			stage.getScene().setRoot(rentedMedia());
		});
	    
	    Button btn4=new Button("Reutrn Media");
		btn4.setPrefSize(600, 110);
	    btn4.setShape(rec);
	    btn4.setFont(Font.font(30));
	    btn4.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    
	    btn4.setOnAction(e->{  
			stage.getScene().setRoot(returnMedia());
		});
	    
	    Button btn5=new Button("Return To Main Page");
		btn5.setPrefSize(600, 110);
	    btn5.setShape(rec);
	    btn5.setFont(Font.font(30));
	    btn5.setStyle("-fx-border-style:solid; -fx-border-width:2");
	    BorderPane.setAlignment(btn5, Pos.CENTER);
	    
	    btn5.setOnAction(e->{  
			stage.getScene().setRoot(mainPage());
		});
	
	    vbox1.getChildren().addAll(btn1,btn2,btn3,btn4);
	    vbox1.setAlignment(Pos.CENTER); 

	    root.setPadding(new Insets(0,0,40,0));
	    root.setCenter(vbox1);
	    root.setBottom(btn5);
	    root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");
		
	    //fade effect 
	    fade(root, 1100, 0, 1);
	    
        return root;		
	}
	
	public BorderPane rentForm() {
		BorderPane root= new BorderPane();
		root.setPadding(new Insets(20,100,10,100));
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");	
		fade(root, 1100, 0, 1);

		GridPane gp=new GridPane();
		gp.setHgap(50);
		gp.setVgap(20);
		gp.setPadding(new Insets(0,0,50,0));
		gp.setAlignment(Pos.CENTER);
		
		root.setCenter(gp);
		
		Label lb1=new Label("Customer ID: ");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));		
		lb1.setScaleX(2);
		lb1.setScaleY(2);
		
		TextField txt1= new TextField();
		txt1.setPrefColumnCount(30);
		txt1.setFont(Font.font(20));
				
		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);
		
		TextArea text1 = new TextArea();
		text1.setEditable(false);
		gp.add(text1, 1, 2);
		text1.setFont(Font.font(20));
		
		Label lb2=new Label("Media Code: ");
		lb2.setTextFill(Color.WHITE);
		lb2.setFont(Font.font(null,FontWeight.BOLD,lb2.getFont().getSize()));		
		lb2.setScaleX(2);
		lb2.setScaleY(2);
		
		TextField txt2= new TextField();		
		txt2.setPrefColumnCount(30);
		txt2.setFont(Font.font(20));
				
		gp.add(lb2, 0, 3);
		gp.add(txt2, 1, 3);
		
		TextArea text2 = new TextArea();
		text2.setEditable(false);
		gp.add(text2, 1, 4);
		text2.setFont(Font.font(20));
		
		Label lb3=new Label("Rented Date: ");
		lb3.setTextFill(Color.WHITE);
		lb3.setFont(Font.font(null,FontWeight.BOLD,lb3.getFont().getSize()));		
		lb3.setScaleX(2);
		lb3.setScaleY(2);
		
		TextField txt3= new TextField();
		txt3.setPrefColumnCount(30);
		txt3.setFont(Font.font(20));
				
		gp.add(lb3, 0, 5);
		gp.add(txt3, 1, 5);
		
		Label notes= new Label();
		notes.setTextFill(Color.RED);
		notes.setFont(Font.font(null,FontWeight.BOLD,25));
		notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:red; -fx-background-color:white");
		root.setRight(notes);
		BorderPane.setAlignment(notes, Pos.CENTER);
		notes.setVisible(false);
		
		txt1.setOnKeyReleased(e->{
		    int index =	mr.searchCustomerById(txt1.getText());
			if(index>-1) {   //check if the customer exist
				 Customer c= mr.getCustomer().get(index);
				text1.setText("Name: "+c.getName() + "\nPlan: "+c.getPlan() + "\nRequested media in the cart: "+ c.getCart().toString()+"\n"
						+ "Rented media: " + c.getRented().toString());
			}
			else
				text1.setText("Customer Not Found!!!");
		});
		
		txt2.setOnKeyReleased(e->{
		    int index =	mr.searchMediaByCode(txt2.getText());
			if(index>-1) {   //check if the media code exist
				 Media m= mr.getMedia().get(index);
				text2.setText("Media Title: "+m.getTitle() + "\nCopies Available: "+m.getNo_of_copies()+"\n");
		
				if(m instanceof Album) {
					Album album = (Album)m;
					text2.appendText("Aritst: "+album.getArtist()+"\nSongs: "+album.getSongs());
				}
				else if(m instanceof Movie) {
					Movie movie = (Movie)m;
					text2.appendText("Rating: "+movie.getRating());
		
				
				}else if(m instanceof Game) {
					Game game = (Game)m;
					text2.appendText("Weight: "+game.getWeight());
				}
			}
			else 
				text2.setText("Media Not Found!!!");
		});
		
		HBox hbox1=new HBox(100);
		hbox1.setAlignment(Pos.CENTER);
		
		Button btn2=new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font("Comic Sans MS",FontWeight.BOLD,35));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		BorderPane.setAlignment(btn2, Pos.CENTER);
		
		btn2.setOnAction(e->{  //Back Button
			stage.getScene().setRoot(rentPage());
		});
		
		Button btn3=new Button("Add to cart ", new ImageView("cart.png"));
		btn3.setStyle("-fx-background-color:transparent");
		btn3.setTextFill(Color.WHITE);
		btn3.setFont(Font.font("Comic Sans MS",FontWeight.BOLD,35));
		btn3.setContentDisplay(ContentDisplay.RIGHT);
		BorderPane.setAlignment(btn2, Pos.CENTER);
		
		btn3.setOnAction(e->{
			notes.setVisible(true);
			fade(notes, 5000, 1, 0);
			if(mr.addToCart(txt1.getText(), txt2.getText())) {
				notes.setTextFill(Color.GREEN);
				notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:green; -fx-background-color:white");
				notes.setText("Added to cart");
			}	
			else {
				notes.setTextFill(Color.RED);
				notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:red; -fx-background-color:white");
				notes.setText("Fail to add\nTo cart");
			}
		});
		
		Button btn4=new Button("Process Cart ", new ImageView("process.png"));
		btn4.setStyle("-fx-background-color:transparent");
		btn4.setTextFill(Color.WHITE);
		btn4.setFont(Font.font("Comic Sans MS",FontWeight.BOLD,35));
		btn4.setContentDisplay(ContentDisplay.RIGHT);
		BorderPane.setAlignment(btn2, Pos.CENTER);
		
		btn4.setOnAction(e->{
			notes.setVisible(true);
			fade(notes, 10000, 1, 0);
			notes.setTextFill(Color.BLACK);
			
			String processMessage = mr.processRequests(txt1.getText());
			
			if(!processMessage.equals("")) {
				notes.setText(processMessage);
			}
			else{
				notes.setTextFill(Color.RED);
				notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:red; -fx-background-color:white");
				notes.setText("There is no Requests\nto process it");
			}
			
			txt3.setText(new Date().toString());
		});		
		
		hbox1.getChildren().addAll(btn3,btn4, btn2);
		root.setBottom(hbox1);
		return root;
		
	}
	
	public BorderPane requestedMedia() {

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(50, 100, 30, 100));
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");
		fade(root, 1100, 0, 1);

		Text text = new Text("Requested Media");
		text.setFill(Color.WHITE);
		text.setStrokeWidth(2);
		text.setStroke(Color.BLACK);
		text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));

		BorderPane.setAlignment(text, Pos.CENTER);

		root.setTop(text);

		GridPane gp = new GridPane();
		gp.setHgap(70);
		gp.setVgap(50);
		gp.setAlignment(Pos.CENTER);

		// media code
		Label lb1 = new Label("Customer ID: ");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null, FontWeight.BOLD, lb1.getFont().getSize()));
		lb1.setScaleX(2);
		lb1.setScaleY(2);

		TextField txt1 = new TextField();
		txt1.setPrefColumnCount(30);

		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);

		TextArea txt = new TextArea();
		txt.setEditable(false);
		txt.setPadding(new Insets(10, 10, 10, 10));
		txt.setStyle("-fx-border-style:solid;-fx-border-width:2;-fx-border-color:black;");
		txt.setPrefSize(700, 250);
		txt.setFont(Font.font(25));
		gp.add(txt, 1, 2);

		root.setCenter(gp);
		// BorderPane.setAlignment(txt, null);
		BorderPane.setAlignment(txt, Pos.CENTER);
		BorderPane.setAlignment(gp, Pos.CENTER);

		HBox hbox = new HBox(100);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(0, 0, 40, 0));

		Button btn2 = new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 45));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		BorderPane.setAlignment(btn2, Pos.CENTER);

		btn2.setOnAction(e -> { // back button
			stage.getScene().setRoot(rentPage());
		});

		Button btn3 = new Button("Find ", new ImageView("search.png"));
		btn3.setStyle("-fx-background-color:transparent");
		btn3.setTextFill(Color.WHITE);
		btn3.setFont(Font.font(30));
		btn3.setContentDisplay(ContentDisplay.RIGHT);

		btn3.setOnAction(e -> { // search button

			int index = mr.searchCustomerById(txt1.getText());
			if (index < 0) {

				txt.setText("Customer Not Found");
			} else {
				if(mr.getCustomer().get(index).getCart().isEmpty()) {
					txt.setText("No Requested Media to this Customer");
				}
				else {
					txt.setText(mr.getCustomer().get(index).getCart().toString());

				}

			}
		});

		hbox.getChildren().addAll(btn3, btn2);
		root.setBottom(hbox);

		return root;

	}
	
	public BorderPane rentedMedia() {

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(50, 100, 30, 100));
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");
		fade(root, 1100, 0, 1);

		Text text = new Text("Rented Media");
		text.setFill(Color.WHITE);
		text.setStrokeWidth(2);
		text.setStroke(Color.BLACK);
		text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 50));

		BorderPane.setAlignment(text, Pos.CENTER);

		root.setTop(text);

		GridPane gp = new GridPane();
		gp.setHgap(70);
		gp.setVgap(50);
		gp.setAlignment(Pos.CENTER);

		// media code
		Label lb1 = new Label("Customer ID");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null, FontWeight.BOLD, lb1.getFont().getSize()));
		lb1.setScaleX(2);
		lb1.setScaleY(2);

		TextField txt1 = new TextField();
		txt1.setPrefColumnCount(30);

		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);

		TextArea txt = new TextArea();
		txt.setEditable(false);
		txt.setPadding(new Insets(10, 10, 10, 10));
		txt.setStyle("-fx-border-style:solid;-fx-border-width:2;-fx-border-color:black;");
		txt.setPrefSize(700, 250);
		txt.setFont(Font.font(25));
		gp.add(txt, 1, 2);

		root.setCenter(gp);
		// BorderPane.setAlignment(txt, null);
		BorderPane.setAlignment(txt, Pos.CENTER);
		BorderPane.setAlignment(gp, Pos.CENTER);

		HBox hbox = new HBox(100);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(0, 0, 40, 0));

		Button btn2 = new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 45));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		BorderPane.setAlignment(btn2, Pos.CENTER);

		btn2.setOnAction(e -> { // back button
			stage.getScene().setRoot(rentPage());
		});

		Button btn3 = new Button("Find ", new ImageView("search.png"));
		btn3.setStyle("-fx-background-color:transparent");
		btn3.setTextFill(Color.WHITE);
		btn3.setFont(Font.font(30));
		btn3.setContentDisplay(ContentDisplay.RIGHT);

		btn3.setOnAction(e -> { // search button

			int index = mr.searchCustomerById(txt1.getText());
			if (index < 0) {

				txt.setText("Customer Not Found");
			} else {
				if(mr.getCustomer().get(index).getRented().isEmpty()) {
					txt.setText("No Rented Media to this Customer");
				}
				else {
					txt.setText(mr.getCustomer().get(index).getRented().toString());

				}

			}
		});

		hbox.getChildren().addAll(btn3, btn2);
		root.setBottom(hbox);

		return root;

	}
	
	public BorderPane returnMedia() {
		BorderPane root= new BorderPane();
		root.setPadding(new Insets(20,100,10,100));
		root.setStyle("-fx-background-image:url('https://c4.wallpaperflare.com/wallpaper/53/403/659/wood-screen-ba"
				+ "ckgrounds-wallpaper-preview.jpg'); -fx-background-size:cover,auto");	
		fade(root, 1100, 0, 1);

		GridPane gp=new GridPane();
		gp.setHgap(50);
		gp.setVgap(50);
		gp.setPadding(new Insets(0,0,50,0));
		gp.setAlignment(Pos.CENTER);
		
		root.setCenter(gp);
	
		Label lb1=new Label("Customer ID: ");
		lb1.setTextFill(Color.WHITE);
		lb1.setFont(Font.font(null,FontWeight.BOLD,lb1.getFont().getSize()));		
		lb1.setScaleX(2);
		lb1.setScaleY(2);
		
		TextField txt1= new TextField();
		txt1.setPrefColumnCount(30);
		txt1.setFont(Font.font(20));
				
		gp.add(lb1, 0, 1);
		gp.add(txt1, 1, 1);
		
		TextArea text1 = new TextArea();
		gp.add(text1, 1, 2);
		text1.setFont(Font.font(20));
		
		Label lb2=new Label("Media Code: ");
		lb2.setTextFill(Color.WHITE);
		lb2.setFont(Font.font(null,FontWeight.BOLD,lb2.getFont().getSize()));		
		lb2.setScaleX(2);
		lb2.setScaleY(2);
		
		TextField txt2= new TextField();
		txt2.setPrefColumnCount(30);
		txt2.setFont(Font.font(20));
				
		gp.add(lb2, 0, 3);
		gp.add(txt2, 1, 3);

		TextArea text2 = new TextArea();
		gp.add(text2, 1, 4);
		text2.setFont(Font.font(20));
		
		Label notes= new Label();
		notes.setTextFill(Color.RED);
		notes.setFont(Font.font(null,FontWeight.BOLD,40));
		notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:red; -fx-background-color:white");
		root.setRight(notes);
		BorderPane.setAlignment(notes, Pos.CENTER);
		notes.setVisible(false);
		
		txt1.setOnKeyReleased(e->{
		    int index =	mr.searchCustomerById(txt1.getText());
			if(index>-1) {   //check if the customer exist
				 Customer c= mr.getCustomer().get(index);
				text1.setText("Name: "+ c.getName() + "\nRequested media in the cart: "+ c.getCart().toString()+"\n"
						+ "Rented media: " + c.getRented().toString());
			}
			else
				text1.setText("Customer Not Found!!!");
		});

		txt2.setOnKeyReleased(e->{
			
		    int index =	mr.searchMediaByCode(txt2.getText());
			if(index > -1) {   //check if the media code exist
				 Media m= mr.getMedia().get(index);
				text2.setText("Media Title: "+m.getTitle() + "\nCopies Available: "+m.getNo_of_copies()+"\n");
		
				if(m instanceof Album) {
					Album album = (Album)m;
					text2.appendText("Aritst: "+album.getArtist()+"\nSongs: "+album.getSongs());
				}
				else if(m instanceof Movie) {
					Movie movie = (Movie)m;
					text2.appendText("Rating: "+movie.getRating());
		
				
				}else if(m instanceof Movie) {
					Game game = (Game)m;
					text2.appendText("Weight: "+game.getWeight());
				}
			}
			else 
				text2.setText("Media Not Found!!!");
		});
		
		HBox hbox1=new HBox(100);
		hbox1.setAlignment(Pos.CENTER);
		
		Button btn2=new Button("Back ", new ImageView("back.png"));
		btn2.setStyle("-fx-background-color:transparent");
		btn2.setTextFill(Color.WHITE);
		btn2.setFont(Font.font("Comic Sans MS",FontWeight.BOLD,30));
		btn2.setContentDisplay(ContentDisplay.RIGHT);
		BorderPane.setAlignment(btn2, Pos.CENTER);
		
		btn2.setOnAction(e->{  //Back Button
			stage.getScene().setRoot(rentPage());
		});
		
		Button btn3=new Button("Return Media ", new ImageView("return.png"));
		btn3.setStyle("-fx-background-color:transparent");
		btn3.setTextFill(Color.WHITE);
		btn3.setFont(Font.font("Comic Sans MS",FontWeight.BOLD,30));
		btn3.setContentDisplay(ContentDisplay.RIGHT);
		BorderPane.setAlignment(btn2, Pos.CENTER);
		
		btn3.setOnAction(e->{
			fade(notes, 5000, 1, 0);
			notes.setVisible(true);

			if(mr.returnMedia(txt1.getText(), txt2.getText())) {
			notes.setTextFill(Color.LIME);
			notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:lime; -fx-background-color:white");
			notes.setText("Media Returned");
			}
			else {
				notes.setTextFill(Color.RED);
				notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:red; -fx-background-color:white");
				notes.setText("Failed");
			}
			

		});
		
		Button btn4=new Button("Remove From Cart ", new ImageView("remove.png"));
		btn4.setStyle("-fx-background-color:transparent");
		btn4.setTextFill(Color.WHITE);
		btn4.setFont(Font.font("Comic Sans MS",FontWeight.BOLD,30));
		btn4.setContentDisplay(ContentDisplay.RIGHT);
		BorderPane.setAlignment(btn2, Pos.CENTER);
		
		btn4.setOnAction(e->{
			fade(notes, 5000, 1, 0);
			notes.setVisible(true);
			
			if(mr.removeFromCart(txt1.getText(), txt2.getText())) {
				notes.setTextFill(Color.LIME);
				notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:lime; -fx-background-color:white");
				notes.setText("Media Removed \nFrom Cart");
			}
			else {
				notes.setTextFill(Color.RED);
				notes.setStyle("-fx-border-style:solid;-fx-border-width:5;-fx-border-color:red; -fx-background-color:white");
				notes.setText("Failed");
			}
		});
		
		
		hbox1.getChildren().addAll(btn4,btn3, btn2);
		root.setBottom(hbox1);
		return root;
	}
	
	private void printInfoToFile() {
		
		FileWriter customer, media;

		try {
			customer = new FileWriter("customer.txt");
			media = new FileWriter("media.txt");
		
			customer.write(mr.getAllCustomersInfo());  //print all customers info in the file
			media.write(mr.getAllMediaInfo());    //print all media info in the file

			customer.close();
			media.close();
		} catch (IOException ex) {
			System.out.println(ex);						
		}
			
	}

	private void readInfoFromFile() { //to read the info from the last execution from the file
		                                                          //and restore the same inventory contents
		File customerFile = new File("customer.txt");
		File mediaFile = new File("media.txt"); 
		
		if(customerFile.exists()) {  //if the file doesn't exist it will skip reading customers from file
			try {
				Scanner customerReader = new Scanner(customerFile);
				while(customerReader.hasNextLine()){  //each line represent info about one customer
					String s = customerReader.nextLine();  
					
					String[] customer= new String[7];  //indices 0:id for customer 1: name 2:address, 3:plan, 4:mobile, 5:cart, 6:rented
					
					for (int i = 0; i < customer.length-1; i++) {
						customer[i] = s.substring(s.indexOf('=')+1, s.indexOf(',')); 
						s = s.substring(s.indexOf('=')+customer[i].length()+3);	
					}
					customer[5]= customer[5].substring(1, customer[5].indexOf(']')); //cart items
					customer[6]= s.substring(s.indexOf('=')+2, s.indexOf(']'));	    //rented items			 
	
					ArrayList<String> cart= new ArrayList<String>();
					ArrayList<String> rented=new ArrayList<String>();
					
					String[] cartItems= customer[5].split(", ");
					for (int i = 0; i < cartItems.length; i++) {
						if(!cartItems[i].equals(""))
							cart.add(cartItems[i]);
					}
					
					String [] rentedItems = customer[6].split(", ");
					for (int i = 0; i < rentedItems.length; i++) {
						if(!rentedItems[i].equals(""))
							rented.add(rentedItems[i]);
					}
				
					if(mr.searchCustomerById(customer[0]) < 0) {
						mr.getCustomer().add(new Customer(customer[0], customer[1], customer[2],customer[3],customer[4], cart, rented));
					}
					else {
						System.out.println("Error!!! id is alraedy taken");
					}
				}
				customerReader.close();
						
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}		
		}
	      
	
	      
	      if (mediaFile.exists()) {   //if the file doesn't exist it will skip reading media from file
				try {
					Scanner mediaReader = new Scanner(mediaFile);
					while (mediaReader.hasNextLine()) {
						String s = mediaReader.nextLine();
						
						  String[] album= new String[5];
				          String[] movie = new String[4];
				          String[] game = new String[4];
				          
						if (s.substring(0, 5).equals("Album")) { // if the media is Album
							for (int i = 0; i < album.length-1; i++) {
								album[i] = s.substring(s.indexOf('=')+1, s.indexOf(','));
								s = s.substring(s.indexOf(',')+1);
							}
							album[4]= s.substring(s.indexOf('=')+1, s.indexOf(']'));
							mr.getMedia().add(new Album(album[0], album[1], Integer.parseInt(album[2]), album[3], album[4]));
						} else if (s.substring(0, 5).equals("Movie")) { // if the media is Album
							for (int i = 0; i < movie.length-1; i++) {
								movie[i] = s.substring(s.indexOf('=')+1, s.indexOf(','));
								s = s.substring(s.indexOf(',') + 1);
							}
							movie[3]= s.substring(s.indexOf('=')+1, s.indexOf(']'));
							mr.getMedia().add(new Movie(movie[0], movie[1], Integer.parseInt(movie[2]), movie[3]));
	
						} else if (s.substring(0, 4).equals("Game")) { // if the media is Album
							for (int i = 0; i < game.length-1; i++) {
								game[i] = s.substring(s.indexOf('=')+1, s.indexOf(','));
								s = s.substring(s.indexOf(',') + 1);
							}
							game[3]= s.substring(s.indexOf('=')+1, s.indexOf(']'));
							mr.getMedia().add(new Game(game[0], game[1], Integer.parseInt(game[2]), Double.parseDouble(game[3])));
						}
					}
					
					mediaReader.close();
	
	    	  }catch(IOException ex) {
	    		  System.out.println(ex.getMessage());
	    	  }
	    	  
	      }
	
	}


	private void fade(Node node, long time, int start, int end) {
		FadeTransition ft = new FadeTransition(Duration.millis(time), node);
		ft.setFromValue(start);
		ft.setToValue(end);
		ft.play();
	}


	public static void main(String[] args) {
		launch(args);
	}
}
 
