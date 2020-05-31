import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class exe2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox();
        pane.setAlignment(Pos.CENTER);

        Font font = Font.font("Times New Roman", FontWeight.BOLD,
                FontPosture.ITALIC, 22);

        for (int i = 0; i < 5; i++) {
            Text txt = new Text("Java");
            txt.setRotate(90);
            txt.setFont(font);
            txt.setFill(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
            pane.getChildren().add(txt);
        }
        Scene scene = new Scene(pane, 200, 100);
        primaryStage.setTitle("Exercise14_04");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

