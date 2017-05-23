import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import java.lang.String;


public class movingBoard
{
    static int response = 0;
    static Stage window;

    public static int display(int answer) {
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

        top.getChildren().add(up);
        middle.getChildren().addAll(left, right);
        bottom.getChildren().add(down);

        VBox layout = new VBox();
        layout.getChildren().addAll(top, middle, bottom);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();

        left.setOnAction(e -> {response = 1; window.close();});
        left.setOnAction(e -> {response = 2; window.close();});
        left.setOnAction(e -> {response = 3; window.close();});
        left.setOnAction(e -> {response = 4; window.close();});

        //Need to add firing types still
        return response;
    }
}

