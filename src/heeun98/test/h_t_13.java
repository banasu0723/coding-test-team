package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class h_t_13 {

    static int[][] gr;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        gr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                gr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        partition(0, 0, n);
        System.out.println(white);
        System.out.println(blue);

    }


    public static void partition(int row, int col, int size) {



        if (colorCheck(row, col, size)) {
            if (gr[row][col] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        int newSize = size / 2;

        partition(row , col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);


    }

    public static boolean colorCheck(int row, int col, int size) {

        int color = gr[row][col];


        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (gr[i][j] != color) return false;
            }
        }
        return true;


    }
}
