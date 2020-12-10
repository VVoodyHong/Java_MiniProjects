package MatrixOperation.Matrix1dArray2;

import java.util.Random;

public class MatrixOper {

    public static class Array {
        int n, m;
        Random rd = new Random();

        int[][] Arr;
        int[][] retMul;

        public Array(int x, int y) {
            n = x;
            m = y;
            Arr = new int[n][m];

            for ( int i = 0; i < n; i++)
                for ( int j = 0; j < m; j++)
                    Arr[i][j] = rd.nextInt(5);
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

            for ( int i = 0; i < n; i++)
                for ( int j = 0; j < m; j++) Arr[i][j] += Other[i][j];

            return this;
        }

        public Array sub(int [][] Other) {

            for ( int i = 0; i < n; i++)
                for ( int j = 0; j < m; j++) Arr[i][j] -= Other[i][j];

            return this;
        }

        public Array mul(int [][] Other) {

            retMul = new int[n][Other[0].length];

            for ( int i = 0; i < n; i++)
                for (int j = 0; j < Other[0].length; j++)
                    for (int k = 0; k < m; k++) retMul[i][j] += Arr[i][k] * Other[k][j];

            Arr = retMul;
            return this;
        }
    }

    public static void main(String[] args) {

        Array A = new Array(2, 3);
        Array B = new Array(2, 3);
        Array C = new Array(3, 2);

        A.view();
        System.out.println();

        B.view();
        System.out.println();

        C.view();
        System.out.println();

        A.sum(B.Arr()).view();
        System.out.println();

        B.sub(A.Arr()).view();
        System.out.println();

        A.mul(C.Arr()).view();
        System.out.println();
    }
}
