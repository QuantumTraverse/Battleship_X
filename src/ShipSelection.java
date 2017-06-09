import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import java.lang.String;

public class ShipSelection {

    static String boat = "";
    static String move = "";

    public static String[] display(String title, String message) {

        Stage window = new Stage();

        Button carrier = new Button("Aircraft Carrier");
        Button destroyer = new Button("Destroyer");
        Button patrol = new Button("Patrol Boat");
        Button sub = new Button("Submarine");
        Button battle = new Button("Battleship");

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button cancel = new Button("cancel");
        cancel.setOnAction(e -> window.close());

        carrier.setOnAction(e -> {boat = "Aircraft Carrier, "; window.close(); move = movingBoard.display(boat);});
        destroyer.setOnAction(e -> {boat = "Destroyer, "; window.close(); move = movingBoard.display(boat);});
        patrol.setOnAction(e -> {boat = "Patrol Boat, "; window.close(); move = movingBoard.display(boat);});
        sub.setOnAction(e -> {boat = "Submarine, "; window.close(); move = movingBoard.display(boat);});
        battle.setOnAction(e -> {boat = "Battleship, "; window.close(); move = movingBoard.display(boat);});

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, carrier, destroyer, patrol, sub, battle);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.showAndWait();

        String[] things = {boat, move};
        return things;
    }

}
