import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class exe21 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private int index = 0;

    @Override
    public void start(Stage primaryStage) {
        Image[] image = new Image[25];
        ;
        for (int i = 0; i < 25; i++) {
            image[i] = new Image("image/slide" + i + ".jpg");
        }

        ImageView imageView = new ImageView(image[0]);

        StackPane pane = new StackPane();
        pane.getChildren().add(imageView);

        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(2000), e -> {
                    imageView.setImage(image[++index % 25]);
                }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        pane.setOnMouseClicked(e -> {
            if (animation.getStatus() == Animation.Status.PAUSED) {
                animation.play();
            } else {
                animation.pause();
            }
        });
    }

}
