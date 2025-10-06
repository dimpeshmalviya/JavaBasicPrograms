class RatInMaze {
    static int N;

    static void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(sol[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            sol[x][y] = 1;

            // Move Down
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            // Move Right
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            // Move Up
            if (solveMazeUtil(maze, x - 1, y, sol))
                return true;

            // Move Left
            if (solveMazeUtil(maze, x, y - 1, sol))
                return true;

            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    static boolean solveMaze(int[][] maze) {
        int[][] sol = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.println("No path found");
            return false;
        }

        printSolution(sol);
        return true;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        N = maze.length;
        solveMaze(maze);
    }
}
