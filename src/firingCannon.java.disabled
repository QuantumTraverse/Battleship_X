import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;

public class firingCannon
{
    static String answer;
    static Stage window;

    public static String display() {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("The Firing Weapon Selector");

        HBox bottomMenu = new HBox();
        Button buttonF1 = buttonizer("Normal");
        Button buttonF2 = buttonizer("Flare");
        Button buttonF3 = buttonizer("Nuke");
        Button buttonF4 = buttonizer("FlaK");
        Button buttonF5 = buttonizer("QuadGun");
        Button buttonF6 = buttonizer("Aircraft");
        bottomMenu.getChildren().addAll(buttonF1, buttonF2, buttonF3, buttonF4, buttonF5, buttonF6);
        bottomMenu.setAlignment(Pos.CENTER);

        Scene scene = new Scene(bottomMenu, 400, 300);
        window.setScene(scene);
        window.show();

        return answer;
    }
    public static Button buttonizer(String name) {
        Button butyawn = new Button(name);
        butyawn.setOnAction(e -> {
            answer = name;
            window.close();
        });
        return butyawn;
    }
}

