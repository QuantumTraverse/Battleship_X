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
    static String answer;
    static Stage window;
    static String cannonType;
    static Scene scene1;
    static Scene scene2;

    public static String display() {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("The Firing Board");

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
                buton.setOnAction(e -> {
                    answer = coord;
                    window.close();
                });
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


        HBox Menu2 = new HBox();
        Button buttonF1 = buttonizerDeux("Normal");
        Button buttonF2 = buttonizerDeux("Flare");
        Button buttonF3 = buttonizerDeux("Nuke");
        Button buttonF4 = buttonizerDeux("FlaK");
        Button buttonF5 = buttonizerDeux("QuadGun");
        Button buttonF6 = buttonizerDeux("Aircraft");
        Menu2.getChildren().addAll(buttonF1, buttonF2, buttonF3, buttonF4, buttonF5, buttonF6);
        Menu2.setAlignment(Pos.CENTER);
        getLabeled.setText(cannonType);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setBottom(bottomMenu);

        scene1 = new Scene(borderPane, 400, 300);
        Scene scene2 = new Scene(Menu2, 400, 300);
        window.setScene(scene2);
        window.show();

        return answer;
    }
    public static Button buttonizerDeux(String name) {
        Button butyawn = new Button(name);
        butyawn.setOnAction(e -> {
            cannonType = name;
            window.setScene(scene1);
        });
        return butyawn;
    }
}

