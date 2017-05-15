import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class veryBored extends Application
{
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("The Board");

        VBox[] rowOut = new VBox[12];
        HBox topMenu = new HBox();


        String[] letts = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
        Button[][] buttArray = new Button[12][12];
        for(int i =0; i < buttArray.length; i ++)
        {
            for(int k =0; k < buttArray[i].length; k ++)
            {
                String num = letts[i]+ (k+1);
                buttArray[i][k] = new Button(num);
                rowOut[i].getChildren().add
                        (buttArray[i][k]);
            }
            topMenu.getChildren().addAll(rowOut[i]);
        }

        //StackPane layout = new StackPane();
        Scene scene = new Scene(topMenu, 600, 600);
        window.setScene(scene);
        window.show();
    }
}

