package EightQueens;

class MyStack {

    int size;
    int top;
    Pointer[] stackArray;

    MyStack() {
        size = 8;
        top = 0;
        stackArray = new Pointer[size];
    }

    public boolean IsEmpty() { return (top == 0); }

    public boolean IsFull() { return (size == top); }
    
    public void Push(Pointer x) {
        if ( IsFull() ) {
            System.out.println("Stack is full.");
            return;
        }
        stackArray[top] = x;
        top++;
    }
    
    public void Pop() {
        if ( IsEmpty() ) {
            System.out.println("Stack is empty.");
            return;
        }
        stackArray[top - 1] = null;
        top--;
    }
}

class Pointer {

    int row;
    int col;

    Pointer(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class EightQueens {

    public static void solutionQueens(MyStack queens) {

        int i = 0;
        int[][] chessBoard = new int[8][8];

        Pointer[] queen = queens.stackArray;
        chessBoard[queen[0].row][queen[0].col] = 1;

        int back = -1;
        
        while(!queens.IsFull()) {
            
            i++;
            if ( back == -1 ) {

                for ( int j = 0; j < 8; j++ ) {
                    if (checkQueen(i, j, chessBoard)) {
                        Pointer nextQueen = new Pointer(i, j);
                        queens.Push(nextQueen);
                        chessBoard[queen[i].row][queen[i].col] = 1;
                        break;
                        
                    }
                    if ( j == 7 ) {
                        i--;
                        back = queen[i].col;
                        chessBoard[queen[i].row][queen[i].col] = 0;
                        if ( back == 7) {
                            i--;
                            back = queen[i].col;
                            chessBoard[queen[i].row][queen[i].col] = 0;
                            queens.Pop();
                        }
                        queens.Pop();
                        i--;
                    }
                } 
            }
            else { 
                for ( int j = back + 1; j < 8; j++ ) {
                    if (checkQueen(i, j, chessBoard)) {
                        Pointer nextQueen = new Pointer(i, j);
                        queens.Push(nextQueen);
                        chessBoard[queen[i].row][queen[i].col] = 1;
                        back = -1;
                        break;
                        
                    }
                    if ( j == 7 ) {
                        i--;
                        back = queen[i].col;
                        chessBoard[queen[i].row][queen[i].col] = 0;
                        if ( back == 7) {
                            i--;
                            back = queen[i].col;
                            chessBoard[queen[i].row][queen[i].col] = 0;
                            queens.Pop();
                        }
                        queens.Pop();
                        i--;
                    }
                } 
            }
        }
    }

    public static boolean slope(int i, int j, int row, int col) {

        double result = (col - j) / (double)(row - i);

        if ( Math.abs(result) == 1)  return true;
        else return false; 
    }

    public static boolean checkQueen(int row, int col, int[][] Board) {
        
        for ( int i = 0; i < row; i++) {
            for ( int j = 0; j < 8; j++) {
                if ( Board[i][j] != 0  ) {
                    if ( j == col || slope(i, j, row, col)) { return false; }
                }
            }
        }
        return true;
    }
    public static void showBoard(MyStack queens) {

        String[][] chessBoard = new String[8][8];

        for ( int i = 0; i < 8; i++ ) {
            for ( int j = 0; j < 8; j++ ) {
                chessBoard[i][j] = "--";
            }
        }

        for ( int i = 0; i < queens.stackArray.length; i++ ) {chessBoard[queens.stackArray[i].row][queens.stackArray[i].col] = "♔ "; }

        System.out.println();
        System.out.println("    a    b    c    d    e    f    g    h");
        for ( int i = 0; i < 8; i++ ) {
            System.out.print((8 - i) + ":  ");
            for ( int j = 0; j < 8; j++ ) { System.out.print(chessBoard[i][j] + "   "); }
            System.out.print(":" + (8 - i));
            System.out.println();  
        }
        System.out.println("    a    b    c    d    e    f    g    h");
        System.out.println();
    }

    public static void showAll(MyStack[] S, Pointer[] Q) {

        for ( int i = 0; i < 8; i++ ) S[i] = new MyStack();
        for ( int i = 0; i < 8; i++ ) Q[i] = new Pointer(0, i);
        for ( int i = 0; i < 8; i++ ) S[i].Push(Q[i]);
        for ( int i = 0; i < 8; i++ ) solutionQueens(S[i]);
        for ( int i = 0; i < 8; i++ ) showBoard(S[i]);
    }

    public static void main(String[] args) {
        
        MyStack[] caseStack = new MyStack[8];
        Pointer[] queenCase = new Pointer[8];

        showAll(caseStack, queenCase);
    }

}