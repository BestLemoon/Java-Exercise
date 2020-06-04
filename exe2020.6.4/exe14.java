import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class exe14 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(40, 40, 50, 60);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);

        rectangle.setOnMouseDragged(e -> {
            if (rectangle.contains(e.getX(), e.getY())) {
                rectangle.setX(e.getX() - 50 / 2);
                rectangle.setY(e.getY() - 60 / 2);
            }
        });

        pane.getChildren().add(rectangle);

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
