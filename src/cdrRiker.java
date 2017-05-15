import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class cdrRiker extends Application {

	Stage window;
	Scene scene1, scene2;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		Label label1 = new Label("Welcome to the first scene");
		Button button1 = new Button("Click Me");
		button1.setOnAction(e -> {
			System.out.println(ltData.display("Title of Window", "Are you sure, Dr. Strangelove?"));
		});
		//button1.setOnAction(e -> window.setScene(scene2));

		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout1, 200, 350);

		//Button button2 = new Button("This sucks, go back to scene 1");
		//button2.setOnAction(e -> window.setScene(scene1));

		//StackPane layout2 = new StackPane();
		//layout2.getChildren().add(button2);
		//scene2 = new Scene(layout2, 600, 300);

		window.setScene(scene1);
		window.setTitle("Title of the Window");
		window.show();
	}
}