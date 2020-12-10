package MatrixOperation.Matrix2dArray2;

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

        public Array sum(Array A, Array B) {

            for ( int i = 0; i < n * m; i++) Arr[i] = 0;

            for ( int i = 0; i < n * m; i++) this.Arr[i] = A.Arr[i] + B.Arr[i];

            return this;
        }

        public Array sub(Array A, Array B) {

            for ( int i = 0; i < n * m; i++) Arr[i] = 0;

            for ( int i = 0; i < n * m; i++) this.Arr[i] = A.Arr[i] = B.Arr[i];
            
            return this;
        }

        public Array mul(Array A, Array B) {

            for ( int i = 0; i < A.n * B.m; i++) Arr[i] = 0;

            for ( int i = 0; i < A.n; i++)
                for (int j = 0; j < B.m; j++)
                    for (int k = 0; k < A.m; k++) Arr[B.m * i + j] += A.Arr[A.m * i + k] * B.Arr[j + B.m * k];

            return this;
        }
    }

    public static void main(String[] args) {

        Array A = new Array(2, 3);
//        Array B = new Array(2, 3);
        Array C = new Array(3,2);
//        Array sumAB = new Array(2, 3);
//        Array subAB = new Array(2, 3);
        Array mulAC = new Array(2,2);

        A.view();
//        B.view();
        C.view();
//        sumAB.sum(A,B).view();
//        subAB.sub(A,B).view();
        mulAC.mul(A,C).view();
    }
}
