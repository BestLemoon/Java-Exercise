import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class exe8 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    StringBuilder builder = new StringBuilder();
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Text text = new Text("To be replaced");
        pane.getChildren().add(text);

        pane.setFocusTraversable(true);
        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                text.setText(builder.toString());
            }
            else {
                builder.append(e.getText());
            }
        });

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
        pane.requestFocus();
    }
}
