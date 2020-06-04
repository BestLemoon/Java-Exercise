import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.SecureCacheResponse;

public class exe2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle circle = new Circle(40, 50, 20);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);
        HBox hBox = new HBox(5);
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.TOP_CENTER);

        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setScene(scene);
        primaryStage.show();

        btLeft.setOnAction(e -> {
            circle.setCenterX(circle.getCenterX() > 0 ? circle.getCenterX() - 2 : 0);
        });

        btRight.setOnAction(e -> {
            circle.setCenterX(circle.getCenterX() < scene.getWidth() ? circle.getCenterX() + 2 : 0);
        });

        btUp.setOnAction(e -> {
            circle.setCenterY(circle.getCenterY() > 0 ? circle.getCenterY() - 2 : 0);
        });

        btDown.setOnAction(e -> {
            circle.setCenterY(circle.getCenterY() < scene.getHeight() ? circle.getCenterY() + 2 : 0);
        });
    }
}
