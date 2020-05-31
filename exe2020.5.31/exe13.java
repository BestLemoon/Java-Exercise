import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class exe13 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Arc arc = new Arc(60, 240, 40, 20, 0, 180); // Draw the base
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);
        Line line1 = new Line(20 + 40, 220, 20 + 40, 20);
        Line line2 = new Line(20 + 40, 20, 20 + 40 + 100, 20);
        Line line3 = new Line(20 + 40 + 100, 20, 20 + 40 + 100, 40);
        int radius = 20;
        Circle circle = new Circle(20 + 40 + 100, 40 + radius, radius); // Draw the hanger
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Line line4 = new Line(20 + 40 + 100 - radius * Math.cos(Math.toRadians(45)),
                40 + radius + radius * Math.sin(Math.toRadians(45)),
                20 + 40 + 100 - 60, 40 + radius + 60);
        Line line5 = new Line(20 + 40 + 100 + radius * Math.cos(Math.toRadians(45)),
                40 + radius + radius * Math.sin(Math.toRadians(45)),
                20 + 40 + 100 + 60, 40 + radius + 60);
        Line line6 = new Line(20 + 40 + 100, 40 + 2 * radius,
                20 + 40 + 100, 40 + radius + 80);
        Line line7 = new Line(20 + 40 + 100, 40 + radius + 80, 20 + 40 + 100 - 40, 40 + radius + 80 + 40);
        Line line8 = new Line(20 + 40 + 100, 40 + radius + 80, 20 + 40 + 100 + 40, 40 + radius + 80 + 40);
        pane.getChildren().addAll(arc, line1, line2, line3, circle, line4, line5, line6, line7, line8);
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Exercise14_17");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
