import java.util.ArrayList;

class Pos {
    int x;
    int y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Maze {

    public void DFS(int[][] myMaze) {
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        ArrayList<Pos> path = new ArrayList<>();

    }

    public static void main(String[] args) {
        Maze maze = new Maze();

        int[][] myMaze = {
                {0, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
    }
}
