import javafx.geometry.Pos;
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
                });
            }
            topMenu.getChildren().add(rowOut);
        }
        topMenu.setAlignment(Pos.CENTER);

        HBox bottomMenu = new HBox();
        Button buttonF1 = buttonizer("Normal");
        Button buttonF2 = buttonizer("Flare");
        Button buttonF3 = buttonizer("Nuke");
        Button buttonF4 = buttonizer("FlaK");
        Button buttonF5 = buttonizer("QuadGun");
        Button buttonF6 = buttonizer("Aircraft");
        bottomMenu.getChildren().addAll(buttonF1, buttonF2, buttonF3, buttonF4, buttonF5, buttonF6);
        bottomMenu.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setBottom(bottomMenu);

        Scene scene = new Scene(borderPane, 400, 300);
        window.setScene(scene);
        window.show();

        //Need to add firing types still
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
}
