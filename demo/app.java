import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

class node {
    public int x, y;

    node() {
    }

    node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class app extends Application {
    public int Size = 15;// the true size of the map
    public static final int Range = 30;// the length of one node
    public int VSize = (Size * 2 + 1) * Range;// the real size of the map 
    public int maze[][] = new int[VSize][VSize];// maze array
    public int vis[][] = new int[VSize][VSize];// visited nodes
    public node f[][] = new node[VSize][VSize];
    public int[][] dir = {{-Range, 0}, {Range, 0}, {0, -Range}, {0, Range}};// movements
    public CreateMap c = new CreateMap(Size, Size);//Use CreateMap to automatically generate a maze with given size
    Rectangle rec = new Rectangle(Range, Range, Range, Range);
    private int recX = 30, recY = 30;

    public void start(Stage stage) throws Exception {

        CreateMap();
        Pane pane = Init();// Auto generate maze
        node e = new node();
        e.set(recX, recY);
        autoMove(e);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Maze");
        stage.show();

    }

//     public void move(int tx, int ty) {
//         SequentialTransition link = new SequentialTransition();// list of animation
//         link.setNode(rec);
//         TranslateTransition tt = new TranslateTransition();

//         tt.setFromX(recX - 30);
//         tt.setToX(tx - 30);
//         tt.setFromY(recY - 30);
//         tt.setToY(ty - 30);

//         // System.out.println(recX+" "+recY+" "+tx+" "+ty);
//         link.getChildren().add(tt);
//         link.play();
//     }

    public void CreateMap() {
        c.Init();// Generate Maze
        for (int i = 0; i < VSize; i += Range) {
            for (int j = 0; j < VSize; j += Range) {
                maze[i][j] = c.map[i / Range][j / Range];
            }
        } // 迷宫映射
    }

    public Pane Init() {

        Pane pane = new Pane();
        for (int i = 0; i < VSize; i += Range) {
            for (int j = 0; j < VSize; j += Range) {
                Rectangle r = new Rectangle(i, j, Range, Range);
                if (maze[i][j] == 0) {
                    r.setFill(Color.PINK);
                } else if (maze[i][j] == 1) {
                    r.setFill(Color.YELLOW);
                }
                if (i == VSize - Range && j == VSize - Range * 2) {
                    r.setFill(Color.RED);
                }
                pane.getChildren().add(r);
            }
        }
        rec.setFill(Color.BLACK);
        pane.getChildren().add(rec);// 显示目标块
        return pane;
    }

    public void autoMove(node e) {
        SequentialTransition link = new SequentialTransition();// 动画列表
        link.setNode(rec);
        Queue<node> queue = new ArrayBlockingQueue<node>(1000);
        int flag = 0;
        System.out.println(e.x + " " + e.y);
        queue.add(e);
        vis[e.x][e.y] = 1;// 已访问
        while (flag == 0) {// 广度优先遍历,寻找最短路径
            node now = queue.remove();
            for (int i = 0; i < 4; i++) {
                int fx = now.x + dir[i][0];
                int fy = now.y + dir[i][1];
                if ((inside(fx, fy) && (vis[fx][fy] == 0) && maze[fx][fy] == 1)) {
                    vis[fx][fy] = 1;
                    f[fx][fy] = new node(now.x, now.y);
                    queue.add(new node(fx, fy));
                }
                if (fx == VSize - Range * 2 && fy == VSize - Range * 2) {// 当有一路到达终点时开始回溯

                    node ans[] = new node[1000];
                    int cnt = 0;
                    int t1, t2;
                    ans[cnt] = new node(fx, fy);
                    while (f[fx][fy].x != e.x || f[fx][fy].y != e.y) {// 按照点记录的前一点坐标进行回溯即可得到到达点的最短路径。
                        t1 = fx;
                        t2 = fy;
                        cnt++;
                        ans[cnt] = new node(f[fx][fy].x, f[fx][fy].y);
                        fx = f[t1][t2].x;
                        fy = f[t1][t2].y;
                    }

                    ans[++cnt] = new node(0, 0);

                    for (int l = cnt - 1; l > 0; l--) {
                        TranslateTransition tt = new TranslateTransition();
                        tt.setFromX(ans[l].x - 30);
                        tt.setToX(ans[l - 1].x - 30);
                        tt.setFromY(ans[l].y - 30);
                        tt.setToY(ans[l - 1].y - 30);
                        link.getChildren().add(tt);
                    }
                    flag = 1;
                    break;

                }
            }
        }
        link.play();

    }

    boolean inside(int fx, int fy) {
        return (fx >= Range && fx <= VSize - Range && fy >= Range && fy <= VSize - Range);
    }

    public static void main(String[] args) {
        Application.launch();
    }
}

