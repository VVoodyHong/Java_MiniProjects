package BugMove;

import java.util.Random;

public class BugMove2 {
    public static void main(String[] args) {

        int n = 10;
        int m = 10;
        int Array[][] = new int[n+2][m+2];
        Random rd = new Random();

        for ( int i = 1; i <= n; i++) {
            for ( int j = 1; j <= m; j++) {
                Array[i][j] = 0;
            }
        }

        for ( int i = 0; i < n + 2; i++) {
            Array[0][i] = -1;
            Array[n-1][i] = -1;
            Array[i][0] = -1;
            Array[i][n-1] = -1;
        }

        int x = (n + 2) / 2;
        int y = (m + 2) / 2;
        int nonce = 0;

        while (true) {
            nonce++;
            int check = 0;
            Array[y][x]++;

            int tempx = x;
            int tempy = y;
            int xnext = rd.nextInt(3) - 1;
            int ynext = rd.nextInt(3) - 1;
            x += xnext;
            y += ynext;

            if ( Array[y][x] == -1 ) {
                x = tempx;
                y = tempy;
                continue;
            }

            for ( int i = 0; i < n; i++) {
                for ( int j = 0; j < m; j++) {
                    if(Array[i][j] == 0) {
                        System.out.println("left locate: " + i + "-" + j);
                        check++;
                    }
                }
            }

            System.out.println("left point: " + check);

            if ( check == 0 ) break;
        }
        System.out.println("total try: " + nonce);
    }
}
