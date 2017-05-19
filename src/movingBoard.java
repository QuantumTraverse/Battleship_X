import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;


public class movingBoard
{
    static String answer;
    static Stage window;

    public static String display() {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("The Moving Board");

        HBox topMenu = new HBox();
        Button buttonH1 = buttonizerNoClose("LEFT");
        Button buttonH2 = buttonizerNoClose("RIGHT");
        Button buttonH3 = buttonizerNoClose("FORWARD");
        Button buttonH4 = buttonizerNoClose("BACKWARDS");
        topMenu.getChildren().addAll(buttonH1, buttonH2, buttonH3, buttonH4);
        topMenu.setAlignment(Pos.CENTER);

        HBox bottomMenu = new HBox();
        Button buttonF1 = buttonizer("Patrol Boat");
        Button buttonF2 = buttonizer("Submarine");
        Button buttonF3 = buttonizer("Destroyer");
        Button buttonF4 = buttonizer("Battleship");
        Button buttonF5 = buttonizer("Aircraft Carrier");
        bottomMenu.getChildren().addAll(buttonF1, buttonF2, buttonF3, buttonF4, buttonF5);
        bottomMenu.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setBottom(bottomMenu);

        Scene scene = new Scene(borderPane, 400, 300);
        window.setScene(scene);
        window.show();

        return answer;
    }
    public static Button buttonizer(String name) {
        Button butyawn = new Button(name);
        butyawn.setOnAction(e -> {
            answer +=  " " + name;
            window.close();
        });
        return butyawn;
    }
    public static Button buttonizerNoClose(String name) {
        Button butyawn = new Button(name);
        butyawn.setOnAction(e -> {
            answer +=  " " + name;
        });
        return butyawn;
    }
}

