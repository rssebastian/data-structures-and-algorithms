import java.util.Random;

public class Maze {
    private Node[][] maze;
    protected Node entrance;
    protected Node exit;

    Maze(int numRows, int numCols) {
        int idNum = 0;
        maze = new Node[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Node point = new Node();
                point.id = idNum;
                if (row == 0)
                    point.up = false;
                if (row == numRows - 1)
                    point.down = false;
                if (col == 0)
                    point.left = false;
                if (col == numCols - 1)
                    point.right = false;
                maze[row][col] = point;
                idNum++;
            }
        }
        entrance = maze[0][0];
        exit = maze[numRows - 1][numCols - 1];
    }

    // public void printMaze() {
    // for (int row = 0; row < maze.length; row++) {
    // for (int col = 0; col < maze[row].length; col++) {
    // System.out.print(maze[row][col].id + " ");
    // }
    // System.out.println();
    // }
    // }

    public static void main(String[] args) {
        int rows = 15;
        int columns = 15;
        Maze maze = new Maze(rows, columns);
        // maze.printMaze();
        WeightedQuickUnionUF UF = new WeightedQuickUnionUF(rows * columns);
        while (!UF.connected(maze.entrance.id, maze.exit.id)) {
            int randRow = (int) Math.floor(Math.random() * rows);
            int randCol = (int) Math.floor(Math.random() * columns);
            Node point1 = maze.maze[randRow][randCol];

            switch ((int) Math.floor(Math.random() * 4)) {
                // Connect up
                case 0:
                    if (point1.up) {
                        Node point2 = maze.maze[randRow - 1][randCol];
                        if (UF.connected(point1.id, point2.id))
                            continue;
                        UF.union(point1.id, point2.id);

                        System.out.println(point1.id + " " + point2.id);
                    }
                    break;
                // Connect right
                case 1:
                    if (point1.right) {
                        Node point2 = maze.maze[randRow][randCol + 1];
                        if (UF.connected(point1.id, point2.id))
                            continue;
                        UF.union(point1.id, point2.id);

                        System.out.println(point1.id + " " + point2.id);
                    }
                    break;
                // Connect down
                case 2:
                    if (point1.down) {
                        Node point2 = maze.maze[randRow + 1][randCol];
                        if (UF.connected(point1.id, point2.id))
                            continue;
                        UF.union(point1.id, point2.id);

                        System.out.println(point1.id + " " + point2.id);
                    }
                    break;
                // Connect right
                case 3:
                    if (point1.left) {
                        Node point2 = maze.maze[randRow][randCol - 1];
                        if (UF.connected(point1.id, point2.id))
                            continue;
                        UF.union(point1.id, point2.id);

                        System.out.println(point1.id + " " + point2.id);
                    }
                    break;
                default:
            }
        }
        System.out.println("Maze Completed!");
    }

    private class Node {
        private int id;
        private boolean up = true;
        private boolean right = true;
        private boolean down = true;
        private boolean left = true;
    }
}

// TEST CASE OUTPUT
// 136 151
// 56 57
// 67 82
// 147 146
// 104 89
// 4 5
// 90 75
// 174 189
// 199 198
// 77 76
// 65 64
// 126 141
// 204 189
// 115 116
// 219 204
// 192 207
// 11 26
// 221 220
// 69 84
// 168 169
// 203 204
// 105 120
// 90 91
// 65 80
// 45 60
// 25 24
// 200 201
// 46 31
// 63 48
// 214 199
// 177 176
// 9 10
// 153 138
// 104 103
// 30 45
// 65 66
// 99 98
// 169 154
// 116 101
// 87 86
// 98 113
// 86 71
// 114 99
// 125 124
// 29 14
// 172 157
// 54 53
// 139 154
// 97 98
// 213 214
// 31 32
// 191 206
// 147 148
// 187 172
// 117 116
// 41 40
// 150 165
// 118 117
// 91 92
// 21 22
// 29 44
// 197 198
// 35 50
// 79 80
// 6 7
// 88 73
// 95 110
// 188 187
// 107 122
// 223 224
// 144 129
// 106 107
// 20 19
// 123 108
// 67 68
// 24 9
// 82 97
// 180 195
// 70 85
// 32 47
// 208 193
// 28 27
// 25 26
// 34 49
// 34 19
// 147 132
// 155 140
// 17 18
// 43 58
// 171 186
// 136 137
// 15 30
// 66 67
// 68 69
// 92 77
// 208 207
// 63 64
// 212 197
// 145 144
// 104 119
// 192 191
// 94 95
// 160 175
// 55 54
// 160 145
// 191 190
// 86 101
// 72 87
// 212 211
// 221 206
// 44 59
// 148 163
// 0 15
// 18 33
// 92 93
// 81 66
// 97 112
// 180 165
// 216 201
// 178 163
// 181 166
// 6 21
// 41 42
// 13 28
// 118 103
// 209 224
// 4 3
// 202 201
// 115 114
// 156 155
// 202 217
// 61 46
// 221 222
// 40 25
// 17 2
// 185 170
// 128 129
// 179 178
// 124 109
// 161 146
// 135 136
// 143 144
// 93 94
// 102 101
// 196 197
// 41 56
// 55 40
// 173 172
// 70 69
// 55 70
// 62 77
// 219 220
// 47 62
// 175 190
// 183 184
// 74 89
// 195 210
// 182 197
// 33 34
// 152 153
// 132 117
// 140 125
// 193 194
// 35 36
// 193 178
// 215 216
// 184 169
// 127 142
// 20 5
// 31 30
// Maze Completed!