package heeun98.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class h_t_12 {

    static int[][] gr;
    static List<int[]> bin;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gr = new int[9][9];
        bin = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                gr[i][j] = num;
                if (num == 0) bin.add(new int[]{i, j});
            }
        }

        dfs(0);

    }

    static void dfs(int v) {
        if (v == bin.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(gr[i][j] + " ");
                }
                System.out.println();
            }
            flag = true;
            return;
        }

        int row = bin.get(v)[0];
        int col = bin.get(v)[1];

        for (int j = 1; j <= 9; j++) {
            if (!posible(row, col, j)) continue;
            gr[row][col] = j;
            dfs(v + 1);
            if (flag) return;
            gr[row][col] = 0;
        }

    }

    static boolean posible(int row, int col, int value) {

        if (!checkRow(row, value)) return false;
        if (!checkCol(col, value)) return false;

        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;

        if (!checkSquare(value, startRow, startCol)) return false;

        return true;

    }

    private static boolean checkSquare(int value, int startRow, int startCol) {
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (gr[i][j] == value) return false;
            }
        }
        return true;
    }

    private static boolean checkCol(int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (gr[i][col] == value) return false;
        }
        return true;
    }

    private static boolean checkRow(int row, int value) {
        for (int i = 0; i < 9; i++) {
            if (gr[row][i] == value) return false;
        }
        return true;
    }


}
