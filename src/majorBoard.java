import javafx.application.Application;
import javafx.geometry.Pos;
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
    //Positioner [][] boardArray;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("The Main Screen of Awesomeness");

        HBox topMenu = new HBox();

        Label enemyBoard = new Label();
        String message = "\t Enemy Board \n";
        message += buildBoard();

        Label yourBoard = new Label();
        String messageDeux = "\t Your Board \n";
        messageDeux += buildBoard();

        enemyBoard.setText(message);
        yourBoard.setText(messageDeux);
        topMenu.getChildren().addAll(enemyBoard, yourBoard);
        topMenu.setAlignment(Pos.CENTER);

        HBox bottomMenu = new HBox();
        Button buttonM = new Button("MOVE");
        Button buttonF = new Button("FIRE");
        buttonM.setOnAction(e -> movingBoard.display());
        buttonF.setOnAction(e -> System.out.println(firingBoard.display()));
        bottomMenu.getChildren().addAll(buttonM, buttonF);
        bottomMenu.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setBottom(bottomMenu);

        Scene scene = new Scene(borderPane, 600, 250);
        window.setScene(scene);
        window.show();
    }
    public static String buildBoard(){
        String message = "";
        for(int row=0 ; row < 10 ; row++ ){
            for(int column=0 ; column < 10 ; column++ ){
                message += "\t"+"~";
            }
            message += "\n";
        }
        return message;
    }
}
