import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class exe11 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(40.0, 20.0, 70.0, 40.0,
                60.0, 80.0, 45.0, 45.0, 20.0, 60.0);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        Text text = new Text();
        pane.getChildren().addAll(polygon, text);

        pane.setOnMouseMoved(e -> {
            if (polygon.contains(e.getX(), e.getY())) {
                text.setText("Mouse point is inside the polygon");
            }
            else {
                text.setText("Mouse point is outside the polygon");
            }

            text.setX(e.getX());
            text.setY(e.getY());
        });

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
