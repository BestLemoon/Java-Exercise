import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class exe5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane pane=new GridPane();
        ImageView imageView1=new ImageView("5.png");
        ImageView imageView2=new ImageView("5.png");
        ImageView imageView3=new ImageView("5.png");
        ImageView imageView4=new ImageView("5.png");
        pane.add(imageView1,0,0);
        pane.add(imageView2,0,1);
        pane.add(imageView3,1,1);
        pane.add(imageView4,1,0);
        Scene scene=new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
