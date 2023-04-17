package GameSudoku;

import java.io.IOException;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 7, 4, 5, 2, 0, 6, 3, 0, 9 } };

        Sudoku su = new Sudoku(grid);
        if(su.solve()){
            System.out.println(su.toString());
        }
        else
            System.out.println("khong giai duoc");

    }

}
