import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class majorBoard extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Main Screen");

        HBox topMenu = new HBox();

        Label enemyBoard = new Label();
        String message = "\t Enemy Board \n";

        for(int row=0 ; row < 10 ; row++ ){
            for(int column=0 ; column < 10 ; column++ ){
                message += "\t"+"~";
            }
            message += "\n";
        }
        Label yourBoard = new Label();
        String messageDeux = "\t Your Board \n";

        for(int row=0 ; row < 10 ; row++ ){
            for(int column=0 ; column < 10 ; column++ ){
                messageDeux += "\t"+"~";
            }
            messageDeux += "\n";
        }

        enemyBoard.setText(message);
        yourBoard.setText(messageDeux);
        topMenu.getChildren().addAll(enemyBoard, yourBoard);

        HBox bottomMenu = new HBox();
        Button buttonM = new Button("MOVE");
        Button buttonF = new Button("FIRE");
        buttonF.setOnAction(e -> veryBored.display());
        bottomMenu.getChildren().addAll(buttonM, buttonF);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setBottom(bottomMenu);

        Scene scene = new Scene(borderPane, 800, 250);
        window.setScene(scene);
        window.show();
    }
}
