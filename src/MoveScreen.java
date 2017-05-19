import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.*;

public class MoveScreen extends Application
{
    Stage window;
    Scene startScene, moveScene, fireScene;

    public static void main(String[]args)
    {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        Label label1 = new Label("What would you like to do?");
        Button buttonMove = new Button("Move");
        Button buttonFire = new Button("Fire");
        Button button2 = new Button("Go to new screen.");

        buttonMove.setOnAction(e -> window.setScene(moveScene));
        buttonFire.setOnAction(e -> window.setScene(fireScene));


        Label label2 = new Label("Where would you like to move?");
        Label label3 = new Label("Select your targeting options.");

        VBox layoutStart = new VBox(10);
        layoutStart.getChildren().addAll(label1, buttonMove, buttonFire);

        StackPane layoutMove = new StackPane();
        layoutMove.getChildren().addAll(label2);

        HBox layoutFire = new HBox(10);
        layoutFire.getChildren().addAll(label3, button2);

        layoutMove.setAlignment(Pos.CENTER);
        layoutFire.setAlignment(Pos.CENTER);

        button2.setOnAction(e -> PracticePopUp.display("Advanced Firing Window", "What kind of missle will you fire?"));

        startScene = new Scene(layoutStart, 1000, 1000);
        moveScene = new Scene(layoutMove, 600, 300);
        fireScene = new Scene(layoutFire, 600, 300);

        window.setScene(startScene);
        window.setTitle("Battleship!");
        window.show();
    }
}