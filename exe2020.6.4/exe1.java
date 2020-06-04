import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class exe1 extends Application {
    private double angle=0;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane stackPane=new StackPane();
        Rectangle rectangle=new Rectangle(30,30,30,60);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        stackPane.getChildren().add(rectangle);
        Button button=new Button("Rotate");
        button.setOnAction(e->{
            angle+=15;
            rectangle.setRotate(angle);
        });

        BorderPane pane=new BorderPane();
        pane.setCenter(stackPane);
        pane.setBottom(button);
        BorderPane.setAlignment(button, Pos.TOP_CENTER);
        Scene scene=new Scene(pane,200,150);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
