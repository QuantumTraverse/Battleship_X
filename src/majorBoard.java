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
import java.lang.String;

public class majorBoard extends Application {

    public static Stage mainWindow;
    public static String boat;
    public static String move;
    public static Button buttonM = new Button("MOVE");
    public static Button buttonF = new Button("FIRE");
    public static HBox topMenu = new HBox();
    public static BorderPane borderPane = new BorderPane();
    public static BorderPane borderPane2 = new BorderPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        mainWindow.setTitle("The Main Screen of Awesomeness");

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

        buttonM.setOnAction(e -> ShipSelection.display("Ship Selection", "What ship would you like to move?"));
        buttonF.setOnAction(e -> firingBoard.display());
        bottomMenu.getChildren().addAll(buttonM, buttonF);
        bottomMenu.setAlignment(Pos.CENTER);

        borderPane.setTop(topMenu);
        borderPane.setBottom(bottomMenu);

        Scene scene = new Scene(borderPane, 600, 250);
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public static String buildBoard(){
        String message = "";
        for(int row=0 ; row < 10 ; row++ ){
            for(int column=0 ; column < 10 ; column++ ){
                message += "~"+"\t";
            }
            message += "\n";
        }
        return message;
    }

    public static void displayAgain(String boat, String move) {
        mainWindow.close();
        Button shipType = new Button(boat);
        Button direction = new Button(move);

        VBox newInfo = new VBox();
        newInfo.getChildren().addAll(shipType, direction);

        HBox bottomMenu2 = new HBox(15);
        bottomMenu2.getChildren().addAll(buttonF, newInfo);

        borderPane2.setTop(topMenu);
        borderPane2.setBottom(bottomMenu2);

        Scene scene2 = new Scene(borderPane, 600, 250);
        mainWindow.setScene(scene2);
        mainWindow.show();
    }

}
