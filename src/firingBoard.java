import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class firingBoard
{
    static boolean answer;

    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("The Firing Board");

        HBox topMenu = new HBox();


        String[] letts = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
        for(int i =0; i < 10; i ++)
        {
            VBox rowOut = new VBox();
            for(int k = 0; k < 10; k++)
            {
                rowOut.getChildren().add(new Button(letts[i] + " " + k));
            }
            topMenu.getChildren().add(rowOut);
        }

        //StackPane layout = new StackPane();
        Scene scene = new Scene(topMenu, 400, 400);
        window.setScene(scene);
        window.show();

        //Need to add firing types still
    }
}

