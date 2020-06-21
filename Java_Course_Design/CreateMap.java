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
    // visit the nearest node randomly(visit all nodes once util visit all path)
    // After visit all nodes in the Maze,it will generate a path(Random),when it visit next node randomly,It will break the wall between nodes
    public void Prime() {
        // visited stores visited nodes
        // unvisited stores unvisited nodes
        int[] visited, unvisited;
        int count = row * column;
        int visitedcount = 0;// count visited nodes

        visited = new int[count];
        unvisited = new int[count];
        // R and C means offsite in row and column and the index 0 means left,1 means right, 3 means up, 2 means down
        int[] offR = { -1, 1, 0, 0 };
        int[] offC = { 0, 0, 1, -1 };
        // Off in four directions,Up Down Right Left
        int[] offS = { -1, 1, row, -row }; // Move Up and Down all means move a row
        // Initialization
        // all the 0 means unvisited
        for (int i = 0; i < count; i++) {
            visited[i] = 0;
            unvisited[i] = 0;
        }

        // Start
        Random random = new Random();
        visited[0] = random.nextInt(count);// Starting node
        int pos = visited[0];
        // Store the first node
        unvisited[pos] = 1;
        while (visitedcount < count) {
            // get current node
            int x = pos % row;
            int y = pos / row;
            // the position of current node
            int offpos = -1;// record the offsite
            int w = 0;
            // try all directions util it works
            while (++w < 5) {
                //visit nearest node randomly
                int point = random.nextInt(4); // generate 0-3 randomly and 0 means left,1 means right, 3 means up, 2 means down
                int repos;
                int move_x, move_y;
                // calculate moved position
                repos = pos + offS[point];
                // the index of moved node
                move_x = x + offR[point];
                move_y = y + offC[point];
                // the position of moved node
                // judge the movement is legal or illegal
                if (move_y >= 0 && move_x >= 0 && move_x < row && move_y < column && repos >= 0 && repos < count
                        && unvisited[repos] != 1) {
                    unvisited[repos] = 1;// mark the node visited
                    visited[++visitedcount] = repos;// ++accsize means the count of visited node,repos means the index of this node
                    pos = repos;// change this node to starting node
                    offpos = point;
                    // place 1 between the two nodes
                    map[2 * x + 1 + offR[point]][2 * y + 1 + offC[point]] = 1;
                    break;
                } else {
                    if (visitedcount == count - 1)
                        return;
                }
            }
            if (offpos < 0) {// if there's no node to continue,select one visited node randomly and set this node as starting node
                pos = visited[random.nextInt(visitedcount + 1)];}
        }
    }
}