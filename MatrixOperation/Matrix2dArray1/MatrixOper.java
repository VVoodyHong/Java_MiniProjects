package MatrixOperation.Matrix2dArray1;

import java.util.Random;

public class MatrixOper {

    public static class Array {
        private final int n;
        private final int m;
        Random rd = new Random();

        int[] Arr;

        public Array(int x, int y) {
            n = x;
            m = y;
            Arr = new int[n * m];

            for ( int i = 0; i < n * m; i++) Arr[i] = rd.nextInt(5);
        }

        public void view() {
            for ( int i = 0; i < n * m; i++) {
                if ( i != 0 && i % m == 0) System.out.println();
                System.out.print(Arr[i] + " ");
            }
            System.out.println();
            System.out.println();
        }

        public Array sum(Array Other) {

            for ( int i = 0; i < n * m; i++) Arr[i] += Other.Arr[i];
            return this;
        }

        public Array sub(Array Other) {

            for ( int i = 0; i < n * m; i++) Arr[i] -= Other.Arr[i];
            return this;
        }

        public Array mul(Array A, Array B) {

            for ( int i = 0; i < n * m; i++) Arr[i] = 0;

            for ( int i = 0; i < A.n; i++)
                for (int j = 0; j < B.m; j++)
                    for (int k = 0; k < A.m; k++) Arr[B.m * i + j] += A.Arr[A.m * i + k] * B.Arr[j + B.m * k];
            return this;
        }
    }

    public static void main(String[] args) {

        Array A = new Array(3, 5);
        Array B = new Array(3, 5);
        Array C = new Array(2, 3);
        Array D = new Array( 3, 2);
        Array E = new Array(2, 2);

        A.view();
        B.view();
        A.sum(B).view();
        C.view();
        D.view();
        E.mul(C, D).view();
    }
}