package GameSudoku;

public class SudokuNaiveApproach implements SolveSudokuStrategy{
    private static int cnt = 1;
    public boolean solveSudoku(int grid[][], int row,
                               int col,int N)
    {

        if (row == N - 1 && col == N)
            return true;

        if (col == N) {
            row++;
            col = 0;
        }

        if (grid[row][col] != 0)
            return solveSudoku(grid, row, col + 1,N);

        for (int num = 1; num < 10; num++) {

            if (isSafe(grid, row, col, num)) {

                grid[row][col] = num;

                System.out.println("Step " + cnt);
                cnt++;
                System.out.println("________________________________________");

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++)
                        System.out.print(grid[i][j] + " ");
                    System.out.println();
                }



                if (solveSudoku(grid, row, col + 1,N))
                    return true;
            }

            grid[row][col] = 0;
        }
        return false;
    }

    static boolean isSafe(int[][] grid, int row, int col,
                          int num)
    {

        for (int x = 0; x <= 8; x++)
            if (grid[row][x] == num)
                return false;

        for (int x = 0; x <= 8; x++)
            if (grid[x][col] == num)
                return false;

        int startRow = row - row % 3, startCol
                = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == num)
                    return false;

        return true;
    }

}
