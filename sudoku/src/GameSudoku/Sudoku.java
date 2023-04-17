package GameSudoku;

import java.io.*;

public class Sudoku {
    private static int N = 9;
    private int[][] grid;
    private SolveSudokuStrategy Strategy;

    public Sudoku(int[][] grid){
        this.grid = grid;
    }

    public int[][] getGrid(){
        return this.grid;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int[] row : grid) {
            for (int col : row) {
                sb.append(col).append(" ");
            }
            sb.append("\n");
        }
        String x = new String(sb);
        return x;
    }

    /*
    public void InOut() throws IOException {
        BufferedInputStream bufferin = null;
        BufferedOutputStream bufferout = null;

        try {
            InputStream inputStream = new FileInputStream("input.txt");
            OutputStream outputStream = new FileOutputStream("output.txt");

            bufferin = new BufferedInputStream(inputStream);
            bufferout = new BufferedOutputStream(outputStream);

            int c;
            while((c = bufferin.read()) != -1){
                bufferout.write(c);
            }

        }finally {
            if(bufferin != null)
                bufferin.close();
            if(bufferout != null)
                bufferout.close();
        }
    }
    */

    public boolean solve(){
        //SudokuNaiveApproach naive = new SudokuNaiveApproach();
        SudokuBacktracking back = new SudokuBacktracking();
        if(back.solveSudoku(this.grid,0,0,this.N))
            return true;
        else
            return false;
    }


}
