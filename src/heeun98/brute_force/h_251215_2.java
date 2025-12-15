package heeun98.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class h_251215_2 {

    static int n;
    static int m;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            char[] charArray = input.toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = charArray[j];
            }
        }

        makeChess(board);


        System.out.println(result);
    }

    private static void makeChess(char[][] board) {

        for (int sr = 0; sr <= n - 8; sr++) {
            for (int sc = 0; sc <= m - 8; sc++) {
                result = Math.min(result, check(board, sr, sc));
            }
        }


    }

    private static int check(char[][] board, int sr, int sc) {

        int wStart = 0;
        int bStart = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char current = board[sr + i][sc + j];

                char expectedW = (i + j) % 2 == 0 ? 'W' : 'B';
                char expectedB = (i + j) % 2 == 0 ? 'B' : 'W';

                if (current != expectedW) wStart++;
                if (current != expectedB) bStart++;
            }
        }


        return Math.min(wStart, bStart);
    }


}
