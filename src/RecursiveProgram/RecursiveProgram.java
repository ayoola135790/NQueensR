package RecursiveProgram;

/**
* @author emmanuel_ogunleye
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RecursiveProgram {
    public static boolean isSafe(char[][] board, int row, int col){
    int n = board.length;
    for (int i = 0; i < col; i++){
        if (board[row][i] == 'Q'){
            return false;
    }
 }


//Checking for upper diagonal on left side
    for (int i = row, j = col; i >= 0 && j>= 0; i--, j--){
    if (board[i][j] == 'Q'){
    return false;
    }
}
    //Checking for lower diagonal on left side
    for (int i = row, j = col; i < n && j>= 0; i++, j--){
        if (board[i][j] == 'Q'){
        return false;
        }
    }

    return true;
    }
    
public static void solveNQueens(int n, int col, char[][] board, List<List<String>> solutions){
        if(col == n){
        //Add board configuration to solutions
        List <String> solution = new ArrayList <>();
        for (char [] row : board){
        solution.add(new String(row));
        }
        solutions.add(solution);
        return;
    }

    for(int i = 0; i < n; i++){
            if(isSafe(board, i , col)){
            board[i][col] = 'Q';
            solveNQueens(n, col + 1, board, solutions);
            board[i][col] = '.';
            }
    }
        }
    public static void main(String[] args){
    int n = 8;
    char[][] board = new char[n][n];

    for(int i = 0; i < n; i++){
        for(int j = 0; j<n; j++){
        board[i][j] = '.';
    }
}

List <List<String>> solutions = new ArrayList<>();
    solveNQueens(n, 0, board, solutions);
    Comparator<List<String>> listComparator = Comparator.comparing(list-> String.join("",
    list));
    Collections.sort(solutions, listComparator);
    for(List<String> solution : solutions){
        for(String row : solution){
            System.out.print(row);
            }
            System.out.println();
        }
    }   
}
