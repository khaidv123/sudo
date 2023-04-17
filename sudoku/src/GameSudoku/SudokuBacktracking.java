package GameSudoku;

public class SudokuBacktracking implements SolveSudokuStrategy {

    private static int cnt = 1;

    @Override
    public  boolean solveSudoku(int[][] grid,int row, int col, int N){
        int r = -1;
        int c = -1;
        boolean isEmpty = true;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (grid[i][j] == 0)
                {
                    r = i;
                    c = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty)
        {
            return true;
        }

        for (int num = 1; num <= N; num++)
        {
            if (isSafe(grid, r, c, num))
            {
                System.out.println("Step " + cnt);
                cnt++;
                System.out.println("________________________________________");

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++)
                        System.out.print(grid[i][j] + " ");
                    System.out.println();
                }

                grid[r][c] = num;
                if (solveSudoku(grid,row,col,N))
                {
                    return true;
                }
                else
                {

                    grid[r][c] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num)
    {

        for (int d = 0; d < board.length; d++)
        {

            if (board[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++)
        {

            if (board[r][col] == num)
            {
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == num)
                {
                    return false;
                }
            }
        }

        return true;
    }

}
