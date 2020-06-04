import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class exe10 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(100 - 50, 60 - 20, 100, 40);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        Text text = new Text();
        pane.getChildren().addAll(rectangle, text);

        pane.setOnMouseMoved(e -> {
            if (rectangle.contains(e.getX(), e.getY())) {
                text.setText("Mouse point is inside the rectangle");
            }
            else {
                text.setText("Mouse point is outside the rectangle");
            }

            text.setX(e.getX());
            text.setY(e.getY());
        });

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
