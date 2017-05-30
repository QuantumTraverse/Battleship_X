import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;

public class firingBoard
{
    static String gun;
    static Stage window;
    static String answer;

    public static void display() {

        HBox topMenu = new HBox();

        String[] letts = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
        for(int i =0; i < 10; i ++)
        {
            VBox rowOut = new VBox();
            for(int k = 0; k < 10; k++)
            {
                String coord = letts[i] + " " + k;
                Button buton = new Button(coord);
                rowOut.getChildren().add(buton);
                buton.setOnAction(e -> {answer = coord; window.close();});
            }
            topMenu.getChildren().add(rowOut);
        }
        topMenu.setAlignment(Pos.CENTER);

        Label getLabeled = new Label();
        //cannonType = "ERROR";
        HBox bottomMenu = new HBox();
        Button buttonF = new Button("Firing Type: ");
        bottomMenu.getChildren().addAll(buttonF, getLabeled);
        bottomMenu.setAlignment(Pos.CENTER);

        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("The Firing Board");

        Label label = new Label();
        label.setText("What type of missle would you like to fire?");

        HBox weapons1 = new HBox();
        HBox weapons2 = new HBox();
        VBox trueMenu = new VBox(30);
        VBox truerMenu = new VBox();

        Button normal = new Button("Normal Missle");
        Button flare = new Button("Flare");
        Button nuke = new Button("Nuke");
        Button flak = new Button("FlaK Cannon");
        Button quad = new Button("QuadGun");
        Button aircraft = new Button("Aircraft Barrage");

        weapons1.getChildren().addAll(normal, flare, nuke);
        weapons2.getChildren().addAll(flak, quad, aircraft);
        label.setAlignment(Pos.CENTER);
        weapons1.setAlignment(Pos.CENTER);
        weapons2.setAlignment(Pos.CENTER);

        trueMenu.getChildren().addAll(label, weapons1);
        trueMenu.setAlignment(Pos.CENTER);
        truerMenu.getChildren().addAll(trueMenu, weapons2);
        truerMenu.setAlignment(Pos.CENTER);

        normal.setOnAction(e -> {window.close(); gun = "Normal Missle";});
        flare.setOnAction(e -> {window.close(); gun = "Flare";});
        nuke.setOnAction(e -> {window.close(); gun = "Nuke";});
        flak.setOnAction(e -> {window.close(); gun = "FlaK Cannon";});
        quad.setOnAction(e -> {window.close(); gun = "QuadGun";});
        aircraft.setOnAction(e -> {window.close(); gun = "Aircraft barrage";});

        Scene scene = new Scene(truerMenu, 400, 200);
        window.setScene(scene);
        window.show();
    }
}
