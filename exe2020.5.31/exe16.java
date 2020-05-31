import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class exe16 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        double paneWidth = 300;
        double paneHeight = 250;
        double x1 = Math.random() * (paneWidth - 12);
        double y1 = Math.random() * (paneHeight - 12);
        double x2 = Math.random() * (paneWidth - 12);
        double y2 = Math.random() * (paneHeight - 12);
        drawArrowLine(x1, y1, x2, y2, pane);
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Exercise14_20");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void drawArrowLine(double x1, double y1, double x2, double y2, Pane pane) {
        pane.getChildren().add(new Line(x1, y1, x2, y2));
        double slope = ((((double) y1) - (double) y2))
                / (((double) x1) - (((double) x2)));
        double arctan = Math.atan(slope);
        double set45 = 1.57 / 2;
        if (x1 < x2) {
            set45 = -1.57 * 1.5;
        }
        int arrlen = 15;
        pane.getChildren().add(new Line(x2, y2, (x2 + (Math.cos(arctan + set45) * arrlen)),
                ((y2)) + (Math.sin(arctan + set45) * arrlen)));

        pane.getChildren().add(new Line(x2, y2, (x2 + (Math.cos(arctan - set45) * arrlen)),
                ((y2)) + (Math.sin(arctan - set45) * arrlen)));
    }
}
