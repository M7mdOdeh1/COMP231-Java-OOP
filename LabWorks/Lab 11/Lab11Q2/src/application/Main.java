package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			HBox hbox = new HBox(5);
			hbox.setAlignment(Pos.CENTER);
			hbox.setPadding(new Insets(10,0,20,0));
			
			Label lbl= new Label("Text Field: ");
			TextField txt= new TextField();
			HBox hbox2= new HBox(5);
			hbox2.setAlignment(Pos.CENTER);
			hbox2.setPadding(new Insets(10,0,20,0));
			
			
			RadioButton right = new RadioButton("Right");
			RadioButton left = new RadioButton("Left");
			RadioButton center = new RadioButton("Center");
			
			ToggleGroup tg= new ToggleGroup();
			right.setToggleGroup(tg);
			left.setToggleGroup(tg);
			center.setToggleGroup(tg);

			
			
			Label lbl2= new Label("Column Size: ");
			TextField txt2= new TextField();
			txt2.setPrefColumnCount(2);
			
			hbox.getChildren().addAll(lbl,txt);
			
			hbox2.getChildren().addAll(left, center, right, lbl2,txt2);
			
			root.getChildren().addAll(hbox,hbox2);
			
			left.setOnAction(e -> {

				if (left.isSelected()) {

					txt.setAlignment(Pos.CENTER_LEFT);

				}

			});

			center.setOnAction(e -> {

				if (center.isSelected()) {

					txt.setAlignment(Pos.BOTTOM_CENTER);

				}

			});

			right.setOnAction(e -> {

				if (right.isSelected()) {

					txt.setAlignment(Pos.BOTTOM_RIGHT);

				}

			});

			txt2.setOnKeyPressed(e -> {

				if (e.getCode() == KeyCode.ENTER) {

					txt.setPrefColumnCount(Integer.parseInt(

							txt2.getText()));

				}

			});

			
			
			
			Scene scene = new Scene(root,400,200);
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
