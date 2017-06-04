import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.lang.String;
import javafx.scene.text.Font;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class majorBoard extends Application {

    public static int i = 1;
    public static Stage mainWindow;
    public static HBox rightFire = new HBox();
    public static HBox leftMove = new HBox();
    public static VBox options = new VBox(5);
    public static VBox screen = new VBox(20);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Media openingTheme = new Media("File:///C:/Battleship_X/src/Music/openingTheme.mp3");
        MediaPlayer opening = new MediaPlayer(openingTheme);
        opening.setCycleCount(MediaPlayer.INDEFINITE);
        Media battleTheme = new Media("File:///C:/Battleship_X/src/Music/battleTheme.mp3");
        MediaPlayer battle = new MediaPlayer((battleTheme));
        battle.setCycleCount(MediaPlayer.INDEFINITE);

        opening.play();

        mainWindow = primaryStage;
        mainWindow.setTitle("Main Screen");

        Label enemyBoard = new Label();
        String message = "\t Enemy Board \n";
        message += buildBoard();

        Label yourBoard = new Label();
        String messageDeux = "\t Your Board \n";
        messageDeux += buildBoard();

        HBox menu = new HBox(40);

        enemyBoard.setText(message);
        yourBoard.setText(messageDeux);
        menu.getChildren().addAll(enemyBoard, yourBoard);
        menu.setAlignment(Pos.CENTER);

        Button buttonM = new Button("MOVE");
        Button buttonF = new Button("FIRE");

        buttonM.setOnAction(e -> ShipSelection.display("Ship Selection", "What ship would you like to move?"));
        buttonF.setOnAction(e -> firingBoard.display());

        rightFire.getChildren().add(buttonF);
        rightFire.setAlignment(Pos.CENTER);

        leftMove.getChildren().add(buttonM);
        leftMove.setAlignment(Pos.CENTER);

        Label objective = new Label("Move a ship and fire:");
        objective.setFont(Font.font ("Verdana", 18));
        objective.setAlignment(Pos.CENTER);

        options.setAlignment(Pos.CENTER);
        options.getChildren().addAll(leftMove, rightFire);

        screen.setAlignment(Pos.CENTER);
        screen.getChildren().addAll(objective, menu, options);

        Scene scene = new Scene(screen, 800, 500);

        Label battleship = new Label("BATTLESHIP");
        Label credit = new Label("With Music by Ben Prunty");
        battleship.setFont(Font.font ("Verdana", 40));
        Button begin = new Button("Click to Begin");

        VBox first = new VBox();
        first.getChildren().addAll(battleship, credit);
        first.setAlignment(Pos.CENTER);
        VBox titleV = new VBox(20);
        titleV.getChildren().addAll(first, begin);
        titleV.setAlignment(Pos.CENTER);

        Label turnCount = new Label("Turn " + i);
        turnCount.setAlignment(Pos.CENTER);
        turnCount.setFont(Font.font("Verdana", 40));
        Scene turn = new Scene(turnCount, 600, 400);
        PauseTransition time = new PauseTransition(Duration.seconds(3));
        time.setOnFinished(e -> mainWindow.setScene(scene));

        begin.setOnAction(e -> {opening.stop(); battle.play(); mainWindow.setScene(turn); time.play();});

        Scene startScene = new Scene(titleV, 600, 400);
        mainWindow.setScene(startScene);
        mainWindow.show();
    }

    public static String buildBoard() {
        String message = "";
        for(int row=0 ; row < 10 ; row++ ){
            for(int column=0 ; column < 10 ; column++ ){
                message += "~"+"\t";
            }
            message += "\n";
        }
        return message;
    }

    public static void endTurn() {

    }

    public static void displayMove(String boat, String move) {
        Label sayMove = new Label(boat + move);

        leftMove.getChildren().clear();
        leftMove.getChildren().add(sayMove);
        leftMove.setAlignment(Pos.CENTER);

        options.getChildren().clear();
        options.getChildren().addAll(leftMove, rightFire);

        Scene sceneMove = new Scene(screen, 800, 500);
        mainWindow.setScene(sceneMove);
    }

    public static void displayFire(String gun, String coord) {
        Label sayFire = new Label(gun + " on " + coord + "!");

        rightFire.getChildren().clear();
        rightFire.getChildren().add(sayFire);
        rightFire.setAlignment(Pos.CENTER);

        options.getChildren().clear();
        options.getChildren().addAll(leftMove, rightFire);

        Scene sceneFire = new Scene(screen, 800, 500);
        mainWindow.setScene(sceneFire);
    }

}
