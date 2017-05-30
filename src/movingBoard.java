import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import java.lang.String;


public class movingBoard
{
    static String response = "";
    static Stage window;

    public static void display(String answer) {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("The Moving Board");

        Button left = new Button("LEFT");
        Button right = new Button("RIGHT");
        Button up = new Button("UP");
        Button down = new Button("DOWN");

        VBox top = new VBox();
        VBox bottom = new VBox();
        HBox middle = new HBox();

        top.setAlignment(Pos.CENTER);
        middle.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);

        top.getChildren().add(up);
        middle.getChildren().addAll(left, right);
        bottom.getChildren().add(down);

        VBox layout = new VBox();
        layout.getChildren().addAll(top, middle, bottom);

        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 250, 250);
        window.setScene(scene);
        window.show();

        left.setOnAction(e -> {response = "Left"; window.close(); majorBoard.displayAgain(answer, response);});
        right.setOnAction(e -> {response = "Right"; window.close(); majorBoard.displayAgain(answer, response);});
        up.setOnAction(e -> {response = "Up"; window.close(); majorBoard.displayAgain(answer, response);});
        down.setOnAction(e -> {response = "Down"; window.close(); majorBoard.displayAgain(answer, response);});
    }
}
