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

    public void DFS(int[][] myMaze, int x, int y) {
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        ArrayList<Pos> path = new ArrayList<>();

        if (x == 7 && y == 7) {
            Pos[] pathPos = path.toArray(new Pos[0]);
            for (Pos pos : pathPos) {
                System.out.print("(" + pos.x + ", " + pos.y + ") ");
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx <= 7 && ny >= 0 && ny <= 7 && myMaze[nx][ny] == 0) {
                    myMaze[nx][ny] = 1;
                    path.add(new Pos(nx, ny));
                    DFS(myMaze, nx, ny);
                    myMaze[nx][ny] = 0;
                    path.removeLast();
                }
            }
        }
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

        maze.DFS(myMaze, 0, 0);
    }
}
