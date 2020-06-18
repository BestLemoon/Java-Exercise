import java.util.Random;

public class CreateMap {
    //initialize the Map
    // row means blank nodes and the size is (2row+1) * (2column+1)

    private int row;
    private int column;

    public int[][] map;//Maze Array
    private int r;
    private int c;

    CreateMap(int r0, int c0) {
        row = r0;
        column = c0;
        r = 2 * row + 1;
        c = 2 * column + 1;
        map = new int[r][c];
    }

    public void Init() {

        for (int i = 0; i < r; i++) // All nodes is wall
            for (int j = 0; j < c; j++)
                map[i][j] = 0;// 0 is wall,1 is path

        // center node 1
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                map[2 * i + 1][2 * j + 1] = 1;// 0 is wall,1 is path

        // Use Prime Algorithm to create maze
        Prime();
    }

    // Use Prime to process the maze array and return the Maze
    // Tips:
    // visit the nearest point randomly(visit all points once util visit all path)
    // After visit all points in the Maze,it will generate a path(Random),when it visit next point randomly,It will break the wall between nodes
    public void Prime() {
        // visited stores visited nodes
        // unvisited stores unvisited nodes
        int[] visited, unvisited;
        int count = row * column;
        int visitedcount = 0;// 记录访问过点的数量

        visited = new int[count];
        unvisited = new int[count];
        // row上各方向的偏移 column各方向的偏移 0左 1右 3上 2下
        int[] offR = { -1, 1, 0, 0 };
        int[] offC = { 0, 0, 1, -1 };
        // Off in four directions,Up Down Right Left
        int[] offS = { -1, 1, row, -row }; // Move Up and Down all means move a row
        // 初始化 acc中0代表未访问,noacc中0代表未访问
        // Initialization
        // 0 means unvisited
        for (int i = 0; i < count; i++) {
            visited[i] = 0;
            unvisited[i] = 0;
        }

        // Start
        Random random = new Random();
        visited[0] = random.nextInt(count);// Starting Point
        int pos = visited[0];
        // Store the first point
        unvisited[pos] = 1;
        while (visitedcount < count) {
            // 取出现在的点
            int x = pos % row;
            int y = pos / row;// 该点的坐标
            int offpos = -1;// 用于记录偏移量
            int w = 0;
            // 四个方向都尝试一遍 直到挖通为止
            while (++w < 5) {
                // 随机访问最近的点
                int point = random.nextInt(4); // 0-3
                int repos;
                int move_x, move_y;
                // 计算出移动方位
                repos = pos + offS[point];// 移动后的下标
                move_x = x + offR[point];// 移动后的方位
                move_y = y + offC[point];
                // 判断移动是否合法
                if (move_y >= 0 && move_x >= 0 && move_x < row && move_y < column && repos >= 0 && repos < count
                        && unvisited[repos] != 1) {
                    unvisited[repos] = 1;// 把该点标记为已访问
                    visited[++visitedcount] = repos;// ++accsize代表第几个已经访问的点,repos代表该点的下标
                    pos = repos;// 把该点作为起点
                    offpos = point;
                    // 相邻的格子中间的位置放1

                    map[2 * x + 1 + offR[point]][2 * y + 1 + offC[point]] = 1;
                    break;
                } else {
                    if (visitedcount == count - 1)
                        return;
                    continue;
                }
            }
            if (offpos < 0) {// 周边没有找到能走的路了 从走过的路里重新找个起点
                pos = visited[random.nextInt(visitedcount + 1)];}
        }
    }
}

