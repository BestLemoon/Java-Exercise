import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.util.StringConverter;

/*************************
 * Todo-List
 * ✔速度调节条
 * ✔Answer 改为 Stack
 * ✔显示路径
 * ✔加入按钮
 * ✔改路径动画
 * 把遍历的路径记录下来
 ************************/
public class app extends Application {


    public static void main(String[] args) {
        Application.launch();
    }

    int count = 0;//the count of nodes in the shortest path
    int Size = 50;// the true size of the map
    final int Range = 10;// the length of one node
    int VSize = (Size * 2 + 1) * Range;// the real size of the map    Initial VSize=930
    int[][] maze = new int[VSize][VSize];// maze array
    int[][] visited = new int[VSize][VSize];// visited nodes
    node[][] nodes = new node[VSize][VSize];
    int[][] dir = {{-Range, 0}, {Range, 0}, {0, -Range}, {0, Range}};// movements
    Rectangle MovingNode = new Rectangle(Range, Range, Range, Range);
    Canvas canvas;
    double speed = 16;
    Button bt1 = new Button("Generate");
    Button bt2 = new Button("Find Path");
    Button bt3 = new Button("Traverse");
    Button bt4 = new Button("Clear");
    Button bt5 = new Button("Quit Game");
    Pane MazePane = new Pane();
    BorderPane MainPane = new BorderPane();
    Insets insets = new Insets(20);
    Slider SpeedSlider;
    TextArea StackInfo;
    Stack<node> stack = new Stack<>();
    Stack<node> ans = new Stack<>();
    node[] TempStoredPath;
    int top = -1;

    public void start(Stage stage) {
        CreateMap();
        MazePane = Init();// Auto generate maze
        canvas = new Canvas(VSize, VSize);
        MazePane.getChildren().add(canvas);
        MainPane.setCenter(MazePane);
        BorderPane.setMargin(MazePane, insets);
        SetButton();
        VBox vbox = new VBox(20);
        vbox.setPrefWidth(100);
        bt1.setPrefWidth(vbox.getPrefWidth());
        bt2.setPrefWidth(vbox.getPrefWidth());
        bt3.setPrefWidth(vbox.getPrefWidth());
        bt4.setPrefWidth(vbox.getPrefWidth());
        bt5.setPrefWidth(vbox.getPrefWidth());
        bt1.setPrefHeight(50);
        bt2.setPrefHeight(50);
        bt3.setPrefHeight(50);
        bt4.setPrefHeight(50);
        bt5.setPrefHeight(50);
        Label SpeedLabel = new Label("Speed Controller");
        Label StackLabel = new Label("Nodes  in  Stack");
        StackLabel.setAlignment(Pos.CENTER);
        SpeedSlider = new Slider(8, 24, 16);
        SpeedSlider.setShowTickLabels(true);
        SpeedSlider.setShowTickMarks(true);
        SpeedSlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                return object.intValue() + "s";
            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });
        StackInfo = new TextArea();
        StackInfo.setEditable(false);
        vbox.getChildren().addAll(bt1, bt2, bt3, bt4, bt5, SpeedLabel, SpeedSlider, StackLabel, StackInfo);
        MainPane.setRight(vbox);
        BorderPane.setMargin(vbox, insets);
        Scene scene = new Scene(MainPane, VSize + 160, VSize + 40);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Maze Generate & Solver");
        stage.show();
    }

    public void SetButton() {
        bt1.setStyle("-fx-border-color: deepskyblue");
        bt2.setStyle("-fx-border-color: deepskyblue");
        bt3.setStyle("-fx-border-color: deepskyblue");
        bt4.setStyle("-fx-border-color: deepskyblue");
        bt5.setStyle("-fx-border-color: deepskyblue");
        bt1.setOnAction(e -> {
            CreateMap();
            MainPane.getChildren().remove(MazePane);
            ClearAll();
            MazePane = Init();
            canvas = new Canvas(VSize, VSize);
            MazePane.getChildren().add(canvas);
            MainPane.setCenter(MazePane);
            BorderPane.setMargin(MazePane, insets);
        });
        bt2.setOnAction(e -> ShowShortestPath());
        bt3.setOnAction(e -> Traverse());//Traverse
        bt4.setOnAction(e -> {
            MainPane.getChildren().remove(MazePane);
            ClearAll();
        });
        bt5.setOnAction(e -> System.exit(0));
    }

    public void Traverse() {
        FindAllPath(Range, Range, VSize - Range * 2, VSize - Range * 2);
        for (node node : TempStoredPath) {
            System.out.print("[" + (node.x + Range / 2.0) + "," + (node.y + Range / 2.0) + "]");
        }
        System.out.println();
        Path path = GetPath(TempStoredPath);
        Animation link = createPathAnimation(path, Duration.seconds(speed));
        SequentialTransition animation = new SequentialTransition();// Animation
        animation.setNode(MovingNode);
        animation.setNode(MovingNode);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(path);
        pathTransition.setDuration(Duration.seconds(speed));
        animation.getChildren().add(pathTransition);
        animation.play();
        link.play();
    }

    public void ClearAll() {
        visited = new int[VSize][VSize];
        nodes = new node[VSize][VSize];
        MovingNode = new Rectangle(Range, Range, Range, Range);
        count = 0;
        StackInfo.clear();
        stack.clear();
        ans.clear();
    }

    public void ShowShortestPath() {
        speed = SpeedSlider.getValue();
        Stack<node> shortestAns = CalShortestPath(new node(Range, Range));
        StackInfo.setMinHeight(count);
//        for (int i = count - 1; i > 0; i--) {
//            StackInfo.appendText("(" + shortestAns.get(i).x / 20 + "," + shortestAns.get(i).y / 20 + ")" + "\n");
//        }
        SequentialTransition animation = new SequentialTransition();// Animation
        animation.setNode(MovingNode);
        Path path = GetPath(shortestAns);
        Animation link = createPathAnimation(path, Duration.seconds(speed));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(path);
        pathTransition.setDuration(Duration.seconds(speed));
        animation.getChildren().add(pathTransition);
        animation.play();
        link.play();
    }

    public void StorePath(int top, node[] nodes) {
        TempStoredPath = new node[top];
        if (top >= 0) System.arraycopy(nodes, 0, TempStoredPath, 0, top);
    }

    public void FindAllPath(int xi, int yi, int xe, int ye) {
        node[] CurrentNode = new node[1000];
        int x, y, i1 = 0, j1 = 0, visited;
        boolean find;
        top++;
        CurrentNode[top] = new node(xi, yi);
        CurrentNode[top].visited = -1;
        maze[xi][yi] = -1;
        while (top > -1) {
            x = CurrentNode[top].x;
            y = CurrentNode[top].y;
            visited = CurrentNode[top].visited;
            if (x == xe && y == ye) {
                StorePath(top, CurrentNode);
                maze[x][y] = 1;
                top--;
                x = CurrentNode[top].x;
                y = CurrentNode[top].y;
                visited = CurrentNode[top].visited;
            }
            find = false;
            while (visited < 4 && !find) {
                visited++;
                switch (visited) {
                    case 0:
                        i1 = x - Range;
                        j1 = y;
                        break;
                    case 1:
                        i1 = x;
                        j1 = y + Range;
                        break;
                    case 2:
                        i1 = x + Range;
                        j1 = y;
                        break;
                    case 3:
                        i1 = x;
                        j1 = y - Range;
                        break;
                }
                if (maze[i1][j1] == 1)
                    find = true;
            }
            if (find) {
                CurrentNode[top].visited = visited;
                top++;
                CurrentNode[top] = new node(i1, j1);
                CurrentNode[top].visited = -1;
                maze[i1][j1] = -1;
            } else {
                maze[x][y] = 1;
                top--;
            }
        }
    }

    public Path GetPath(node[] ans) {
        Path path = new Path();
        path.getElements().add(new MoveTo(ans[0].x + Range / 2.0, ans[0].y + Range / 2.0));
        for (int i = 1; i < ans.length; i++) {
            path.getElements().add(new LineTo(ans[i].x + Range / 2.0, ans[i].y + Range / 2.0));
        }
        return path;
    }

    public Path GetPath(Stack<node> ans) {
        Path path = new Path();
        path.getElements().add(new MoveTo(ans.get(count - 1).x + Range / 2.0, ans.get(count - 1).y + Range / 2.0));
        for (int i = count - 1; i > 0; i--) {
            path.getElements().add(new LineTo(ans.get(i - 1).x + Range / 2.0, ans.get(i - 1).y + Range / 2.0));
        }
        return path;
    }

    public Animation createPathAnimation(Path path, Duration duration) {

        GraphicsContext gc = canvas.getGraphicsContext2D();

        // move a node along a path. we want its position
        Circle pen = new Circle(0, 0, 4);

        // create path transition
        PathTransition pathTransition = new PathTransition(duration, path, pen);
        pathTransition.currentTimeProperty().addListener(new ChangeListener<Duration>() {

            Location oldLocation = null;

            /**
             * Draw a line from the old location to the new location
             */
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {

                // skip starting at 0/0
                if (oldValue == Duration.ZERO)
                    return;

                // get current location
                double x = pen.getTranslateX();
                double y = pen.getTranslateY();

                // initialize the location
                if (oldLocation == null) {
                    oldLocation = new Location();
                    oldLocation.x = x;
                    oldLocation.y = y;
                    return;
                }

                // draw line
                gc.setStroke(Color.rgb(0, 255, 90));
                gc.setLineCap(StrokeLineCap.ROUND);
                gc.setLineWidth(Range);
                gc.strokeLine(oldLocation.x, oldLocation.y, x, y);

                // update old location with current one
                oldLocation.x = x;
                oldLocation.y = y;
            }
        });

        return pathTransition;
    }

    public static class Location {
        double x;
        double y;
    }

    public void CreateMap() {
        CreateMap createMap = new CreateMap(Size, Size);//Use CreateMap to automatically generate a maze with given size
        createMap.Init();// Generate Maze
        for (int i = 0; i < VSize; i += Range) {
            for (int j = 0; j < VSize; j += Range) {
                maze[i][j] = createMap.map[i / Range][j / Range];
            }
        }
    }

    public Pane Init() {
        Pane pane = new Pane();
        for (int i = 0; i < VSize; i += Range) {
            for (int j = 0; j < VSize; j += Range) {
                Rectangle rectangle = new Rectangle(i, j, Range, Range);
                if (maze[i][j] == 0) {
                    rectangle.setFill(Color.rgb(0, 255, 255));
                } else if (maze[i][j] == 1) {
                    rectangle.setFill(Color.WHITE);
                }
                if (i == VSize - Range && j == VSize - Range * 2) {
                    rectangle.setFill(Color.rgb(255, 255, 0));
                }
                pane.getChildren().add(rectangle);
            }
        }
        MovingNode.setFill(Color.rgb(255, 0, 0));
        pane.getChildren().add(MovingNode);// Add target node
        return pane;
    }

    public Stack<node> CalShortestPath(node e) {
        Queue<node> queue = new ArrayBlockingQueue<>(1000);
        int flag = 0;
        queue.add(e);
        visited[e.x][e.y] = 1;// visited nodes
        Stack<node> answers = new Stack<>();//Store shortest path nodes
        while (flag == 0) {// use BFS Algorithm to search the shortest path
            node CurrentNode = queue.remove();
            for (int i = 0; i < 4; i++) {
                int fx = CurrentNode.x + dir[i][0];
                int fy = CurrentNode.y + dir[i][1];
                if ((inside(fx, fy) && (visited[fx][fy] == 0) && maze[fx][fy] == 1)) {
                    visited[fx][fy] = 1;
                    nodes[fx][fy] = new node(CurrentNode.x, CurrentNode.y);
                    queue.add(new node(fx, fy));
                }
                if (fx == VSize - Range * 2 && fy == VSize - Range * 2) {// When a path was found then backtrack
                    int tmp1, tmp2;
                    answers.add(new node(fx, fy));
                    while (nodes[fx][fy].x != e.x || nodes[fx][fy].y != e.y) {// Get the shortest path by backtrack previous nodes
                        tmp1 = fx;
                        tmp2 = fy;
                        count++;
                        answers.add(new node(nodes[fx][fy].x, nodes[fx][fy].y));
                        fx = nodes[tmp1][tmp2].x;
                        fy = nodes[tmp1][tmp2].y;
                    }
                    answers.add(new node(0, 0));
                    count++;
                    flag = 1;
                    break;
                }
            }
        }

        return answers;
    }

    boolean inside(int fx, int fy) {
        return (fx >= Range && fx <= VSize - Range && fy >= Range && fy <= VSize - Range);
    }
}

class node {
    public int x, y, visited;

    node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}