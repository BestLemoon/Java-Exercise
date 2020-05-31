import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class exe4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane pane=new GridPane();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                TextField textField=new TextField();
                textField.setText(Integer.toString((int)(Math.random()*2)));
                pane.add(textField,j,i);
            }
        }
        Scene scene=new Scene(pane,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
