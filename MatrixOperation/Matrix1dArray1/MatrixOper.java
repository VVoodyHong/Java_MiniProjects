package MatrixOperation.Matrix1dArray1;

import java.util.Random;

public class MatrixOper {

    public static class Array {
        int n = 4;
        int m = 4;
        Random rd = new Random();

        int[][] Arr = new int[n][m];

        public Array() {
            for ( int i = 0; i < n; i++)
            {
                for ( int j = 0; j < m; j++) {
                    Arr[i][j] = rd.nextInt(5);
                }
            }
        }

        public int[][] Arr() {
            return Arr;
        }

        public void view() {
            for (int[] i : this.Arr)
            {
                for (int j : i) {
                    if (j < 0)  System.out.print(j + " ");
                    else        System.out.print(" " + j + " ");
                }
                System.out.println();
            }
        }

        public Array sum(int [][] Other) {

            for ( int i = 0; i < n; i++) {
                for ( int j = 0; j < m; j++) this.Arr[i][j] += Other[i][j];
            }
            return this;
        }

        public Array sub(int [][] Other) {

            for ( int i = 0; i < n; i++) {
                for ( int j = 0; j < m; j++) this.Arr[i][j] -= Other[i][j];
            }
            return this;
        }
    }

    public static void main(String[] args) {

        Array A = new Array();
        Array B = new Array();

        A.view();
        System.out.println();

        B.view();
        System.out.println();
        
        A.sum(B.Arr()).view();
        System.out.println();

        A.sub(B.Arr()).view();
        System.out.println();

        A.sub(B.Arr()).view();
    }
}
