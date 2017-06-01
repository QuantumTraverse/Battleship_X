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
import javafx.scene.control.Button;

public class majorBoard extends Application {

    public static Stage mainWindow;
    public static HBox bottomFire = new HBox();
    public static HBox bottomMove = new HBox();
    public static HBox bottomMenu = new HBox();
    public static BorderPane borderPane = new BorderPane();

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

        HBox topMenu = new HBox();

        enemyBoard.setText(message);
        yourBoard.setText(messageDeux);
        topMenu.getChildren().addAll(enemyBoard, yourBoard);
        topMenu.setAlignment(Pos.CENTER);

        Button buttonM = new Button("MOVE");
        Button buttonF = new Button("FIRE");

        buttonM.setOnAction(e -> ShipSelection.display("Ship Selection", "What ship would you like to move?"));
        buttonF.setOnAction(e -> firingBoard.display());

        bottomFire.getChildren().add(buttonF);
        bottomFire.setAlignment(Pos.CENTER);

        bottomMove.getChildren().add(buttonM);
        bottomMove.setAlignment(Pos.CENTER);

        bottomMenu.getChildren().addAll(bottomFire, bottomMove);
        bottomMenu.setAlignment(Pos.CENTER);

        borderPane.setTop(topMenu);
        borderPane.setBottom(bottomMenu);
        
        int i = 0;
        Button turn = new Button("Turn " + i);

        VBox layout = new VBox();
        layout.getChildren().add(turn);
        layout.setAlignment(Pos.CENTER);

        Scene turnScene = new Scene(turn, 400, 400);

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

    public static void displayMove(String boat, String move) {
        Button buttonM = new Button();
        buttonM.setText(boat + move);

        bottomMove.getChildren().clear();
        bottomMove.getChildren().add(buttonM);
        bottomMove.setAlignment(Pos.CENTER);

        bottomMenu.getChildren().clear();
        bottomMenu.getChildren().addAll(bottomFire, bottomMove);
        bottomMenu.setAlignment(Pos.CENTER);
        borderPane.setBottom(bottomMenu);

        Scene sceneFire = new Scene(borderPane, 600, 250);
        mainWindow.setScene(sceneFire);
    }

    public static void displayFire(String gun, String coord) {
        Button buttonF = new Button();
        buttonF.setText(gun + " on " + coord + "!");

        bottomFire.getChildren().clear();
        bottomFire.getChildren().add(buttonF);
        bottomFire.setAlignment(Pos.CENTER);

        bottomMenu.getChildren().clear();
        bottomMenu.getChildren().addAll(bottomFire, bottomMove);
        bottomMenu.setAlignment(Pos.CENTER);
        borderPane.setBottom(bottomMenu);

        Scene sceneFire = new Scene(borderPane, 600, 250);
        mainWindow.setScene(sceneFire);
    }

}
