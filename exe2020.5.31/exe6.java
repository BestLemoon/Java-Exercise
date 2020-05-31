import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javax.swing.*;

public class exe6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Ellipse ellipse = new Ellipse(100, 40, 50, 20);
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);
        Arc arc1 = new Arc(100, 140, 50, 20, 0, 180);
        arc1.setFill(Color.WHITE);
        arc1.setStroke(Color.BLACK);
        arc1.getStrokeDashArray().addAll(6.0, 21.0);
        Arc arc2 = new Arc(100, 140, 50, 20, 180, 180);
        arc2.setFill(Color.WHITE);
        arc2.setStroke(Color.BLACK);
        pane.getChildren().addAll(ellipse, arc1, arc2, new Line(50, 40, 50, 140), new Line(150, 40, 150, 140));
        Scene scene=new Scene(pane,300,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
