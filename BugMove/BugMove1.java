package BugMove;
import java.util.Random;

public class BugMove1 {
    public static void main(String[] args) {

        int n = 8;
        int m = 8;

        int Array[][] = new int[n][m];

        Random rd = new Random();

        for ( int i = 0; i < Array.length; i++)
        {
            for ( int j = 0; j < Array[i].length; j++)
            {
                Array[i][j] = 0;
            }
        }

        int x = n / 2;
        int y = m / 2;
        int nonce = 0;

        while (true)
        {
            int check = 0;
            Array[y][x]++;
            if ( x == 0 || y == 0 || x == n - 1 || y == m - 1 ) {
                if (x == 0) {
                    int mcorner = rd.nextInt(2);
                    x += mcorner;
                }
                if (y == 0) {
                    int mcorner = rd.nextInt(2);
                    y += mcorner;
                }
                if (x == n - 1) {
                    int pcorner = rd.nextInt(2) - 1;
                    x += pcorner;
                }
                if (y == m - 1 ) {
                    int pcorner = rd.nextInt(2) - 1;
                    y += pcorner;
                }
            } else {
                int xnext = rd.nextInt(3) - 1;
                int ynext = rd.nextInt(3) - 1;
                x += xnext;
                y += ynext;
            }

            for ( int i = 0; i < Array.length; i++) {
                for ( int j = 0; j < Array[i].length; j++) {
                    if(Array[i][j] == 0) {
                        System.out.println("left locate: " + i + "-" + j);
                        check++;
                    }
                }
            }

//            for (int[] ints : Array) {
//                for (int anInt : ints) {
//                    if (anInt == 0) check++;
//                }
//            }

            System.out.println("left point: " + check);

            if ( check == 0 ) break;
            nonce++;
        }
        System.out.println("total try: " + nonce);
    }
}