import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class exe3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        double WIDTH = 200;
        double HEIGHT = 200;
        for (int i = 0; i < 8; i++) {
            boolean b = i % 2 == 0;
            for (int j = 0; j < 8; j++) {
                Rectangle rectangle = new Rectangle(i * WIDTH / 8, j * HEIGHT / 8, WIDTH / 8, HEIGHT / 8);
                rectangle.setStroke(Color.BLACK);
                if (b) {
                    rectangle.setFill(Color.WHITE);
                } else {
                    rectangle.setFill(Color.BLACK);
                }
                b = !b;
                pane.getChildren().add(rectangle);
            }
        }
        Scene scene=new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
