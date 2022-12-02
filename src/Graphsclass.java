import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Graphsclass {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int N=scan.nextInt();
        int M=scan.nextInt();
        int[][] data = new int[N][M];
        for(int row = 0; row< data.length; row++){
            for(int col = 0 ;col< data[row].length; col++){
                data[row][col] = scan.nextInt();
            }
        }
        System.out.println(numIslands(data));
    }


    public static int numIslands(int[][] body) {
        int numIslands = 0;

        for (int i = 0; i < body.length; i++) {
            for (int j = 0; j < body[0].length; j++) {
                if (body[i][j] == 1) {
                    numIslands++;
                    checkNeighbours(i, j, body);
                }
            }
        }
        return numIslands;
    }



    private static void checkNeighbours(int row, int col, int[][] body) {

        if (row < 0 || row >= body.length || col < 0 || col >= body[0].length || body[row][col] == 0)
            return;

        body[row][col] = 0;
        // north
        checkNeighbours(row - 1, col, body);
        // south
        checkNeighbours(row + 1, col, body);
        // east
        checkNeighbours(row, col + 1, body);
        // west
        checkNeighbours(row, col - 1, body);

        // d1
        checkNeighbours(row - 1, col-1, body);
        // d2
        checkNeighbours(row - 1, col+1, body);
        // d3
        checkNeighbours(row+1, col - 1, body);
        // d4
        checkNeighbours(row+1, col + 1, body);

    }
}