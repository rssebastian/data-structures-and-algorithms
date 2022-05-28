import java.lang.Math;
public class Grid {
    private static int[][] grid;
    private static int ROWS;
    private static int COLS;

    public Grid(int n){
        ROWS = n;
        COLS = n;
        grid = new int[ROWS][COLS];
    }
    public Grid(int m, int n){
        ROWS = m;
        COLS = n;
        grid = new int[m][n];
    }

    public Grid(int[][] matrix){
        ROWS = matrix.length;
        grid = new int[ROWS][];
        for(int i = 0; i < ROWS; i++)
        {
            int[] aMatrix = matrix[i];
            int   aLength = aMatrix.length;
            grid[i] = new int[aLength];
            System.arraycopy(aMatrix, 0, grid[i], 0, aLength);
        }
        COLS = grid[0].length;
    }

    public static void gridFill(int flipTo){
        int randRow = randInt(ROWS);
        int randCol = randInt(COLS);
        while (grid[randRow][randCol] == flipTo){
            randRow = randInt(ROWS);
            randCol = randInt(COLS);
        }
        System.out.println("Flip Source: " + randRow + " " + randCol);
        gridFill(randRow, randCol, flipTo);
    }

    public static void gridFill(int row, int col, int flipTo){
        if (row < 0 || col < 0 || row >= ROWS || col >= COLS) return;
        if (grid[row][col] == flipTo) return;
        grid[row][col] = flipTo;
        gridFill(row-1, col, flipTo); // flip top neighbor
        gridFill(row+1, col, flipTo); // flip bottom neighbor
        gridFill(row, col-1, flipTo); // flip left neighbor
        gridFill(row, col+1, flipTo); // flip right neighbor
    }

    // Generates random int between 0 and max(exclusive)
    private static int randInt(int max){
        return (int) Math.floor(Math.random() * max);
    }

    public String toString(){
        String gridStr = "";
        for (int[] row : grid){
            for (int el : row){
                gridStr += el + " ";
            }
            gridStr += "\n";
        }
        return gridStr;
    }

    public static void main(String[] args) {
        int[][] testCase = {
                {1,0,0,1,0,0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,1,1,1,1,1,0,1,1,1,1,0},
                {0,0,1,1,0,1,1,0,0,1,0,0,0,1,0},
                {0,0,0,0,0,1,1,0,0,1,0,1,1,1,0},
                {0,0,0,0,0,1,0,0,0,1,0,1,0,0,0},
                {0,0,1,1,1,1,0,0,0,1,0,1,0,0,0},
                {0,0,1,0,1,0,0,0,1,1,0,1,0,0,0},
                {0,0,1,0,1,1,1,1,0,0,0,1,0,0,0},
                {0,0,1,0,0,1,0,0,0,0,0,1,1,0,0},
                {0,0,1,0,0,0,0,0,1,1,1,1,0,1,0},
                {0,0,1,1,1,1,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0}
        };
        Grid grid = new Grid(testCase);
        System.out.println("Test Grid:\n" + grid);
        gridFill(0);
        System.out.println(grid);
    }
}

// TEST CASE OUTPUT
// Starting Grid
// 0 0 0 1 0 0 0 0 1 0 0 0 0 0 0
// 0 0 1 0 0 0 0 1 0 0 0 0 0 0 0
// 0 0 1 0 1 1 1 1 1 0 1 1 1 1 0
// 0 0 1 1 0 1 1 0 0 1 0 0 0 1 0
// 0 0 0 0 0 1 1 0 0 1 0 1 1 1 0
// 0 0 0 0 0 1 0 0 0 1 0 1 0 0 0
// 0 0 1 1 1 1 0 0 0 1 0 1 0 0 0
// 0 0 1 0 1 0 0 0 1 1 0 1 0 0 0
// 0 0 1 0 1 1 1 1 0 0 0 1 0 0 0
// 0 0 1 0 0 1 0 0 0 0 0 1 1 0 0
// 0 0 1 0 0 0 0 0 1 1 1 1 0 1 0
// 0 0 1 1 1 1 1 1 1 0 0 0 0 1 0
// 0 0 0 0 0 0 1 0 0 0 0 0 0 0 1
// 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0

// Flipping [7,1] to 1 like in example
// Flip Source: 7 1
// 1 1 1 1 0 0 0 0 1 0 0 0 0 0 0
// 1 1 1 1 0 0 0 0 1 0 0 0 0 0 0
// 1 1 1 0 0 0 0 1 0 0 0 0 0 0 0
// 1 1 1 0 1 1 1 1 1 0 1 1 1 1 0
// 1 1 1 1 1 1 1 0 0 1 0 0 0 1 0
// 1 1 1 1 1 1 1 0 0 1 0 1 1 1 0
// 1 1 1 1 1 1 0 0 0 1 0 1 0 0 0
// 1 1 1 1 1 1 0 0 0 1 0 1 0 0 0
// 1 1 1 0 1 0 0 0 1 1 0 1 0 0 0
// 1 1 1 0 1 1 1 1 0 0 0 1 0 0 0
// 1 1 1 0 0 1 0 0 0 0 0 1 1 0 0
// 1 1 1 0 0 0 0 0 1 1 1 1 0 1 0
// 1 1 1 1 1 1 1 1 1 0 0 0 0 1 0
// 1 1 1 1 1 1 1 0 0 0 0 0 0 0 1
// 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0

// Flipping random cell to 0
// Flip Source: 8 2
// 1 0 0 1 0 0 0 0 1 0 0 0 0 0 0
// 0 0 0 1 0 0 0 0 1 0 0 0 0 0 0
// 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0
// 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0
// 0 0 1 1 0 0 0 0 0 1 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0
// 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0
// 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0
// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1
// 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0