package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			String str="-fx-border-style:solid;-fx-border-width:3";
			BorderPane root= new BorderPane();
			Rectangle r= new Rectangle(100, 50,20,20);
			r.setFill(Color.TRANSPARENT);
			r.setStroke(Color.BLACK);
			r.setStrokeWidth(10);
			
			root.setPadding(new Insets(50,50,50,50));
			
			
			Circle c1= new Circle(125,50,30);
			c1.setFill(Color.WHITE);
			c1.setStroke(Color.BLACK);
			
			Circle c2= new Circle(125,50,30);
			c2.setFill(Color.WHITE);
			c2.setStroke(Color.BLACK);

			
			Circle c3= new Circle(125,50,30);
			c3.setFill(Color.WHITE);
			c3.setStroke(Color.BLACK);
			
			VBox traffic= new VBox(15);
			traffic.setStyle(str);
			
			traffic.setAlignment(Pos.CENTER);
			traffic.getChildren().addAll(c1,c2,c3);

			
			HBox button= new HBox(5);
			button.setAlignment(Pos.CENTER);
			RadioButton rRb= new RadioButton("Red");	
			RadioButton yRb= new RadioButton("Yellow");
			RadioButton gRb= new RadioButton("Green");
			button.setScaleX(1);
			button.setScaleY(1);
			button.getChildren().addAll(rRb,yRb,gRb);
			button.setSpacing(20);
			
			button.setPadding(new Insets(40,0,0,0));
			  ToggleGroup tg= new ToggleGroup();
			  
			  rRb.setToggleGroup(tg);
			  yRb.setToggleGroup(tg);
			  gRb.setToggleGroup(tg);
			  rRb.setSelected(true);
		
			  rRb.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						if (rRb.isSelected()) {
							c1.setFill(Color.RED);
							c2.setFill(Color.WHITE);
							c3.setFill(Color.WHITE);
						}
					}

				});
			  
			  yRb.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
					//	if (yRb.isSelected()) {
							c1.setFill(Color.WHITE);
							c2.setFill(Color.YELLOW);
							c3.setFill(Color.WHITE);
					//	}
						
					}

				});

				gRb.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						if (gRb.isSelected()) {
							c1.setFill(Color.WHITE);
							c2.setFill(Color.WHITE);
							c3.setFill(Color.GREEN);
						}
					}

				});
			  root.setCenter(traffic);
			  traffic.setAlignment(Pos.CENTER);
			  root.setBottom(button);
			 
				
				
				 

			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Traffic sign");
			primaryStage.setScene(scene);
		//	primaryStage.setMaximized(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
