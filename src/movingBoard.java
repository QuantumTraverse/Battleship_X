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
    static String response = "";
    static Stage window;

    public static String display(int answer) {
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

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);

        Scene scene = new Scene(borderPane, 400, 300);
        window.setScene(scene);
        window.show();

        //Need to add firing types still
        return response;
    }
}

