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
    static ArrayList<Pos> path = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public void DFS(int[][] myMaze, int x, int y) {
        if (x == 7 && y == 7) {
            for (Pos pos : path) {
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
        System.out.println("미로의 시작지점(0, 0) 에서 탈출지점(7, 7)까지 가는 경로를 출력하세요.");
        for (int i = 0; i < myMaze.length; i++) {
            for (int j = 0; j < myMaze[0].length; j++) {
                if (myMaze[i][j] == 0) System.out.print("  ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        path.add(new Pos(0, 0));
        maze.DFS(myMaze, 0, 0);
    }
}
