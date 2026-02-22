package heeun98.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class m_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int currentRow = 3;
        int currentCol = 3;
        int[][] gr = new int[3][3];

        int[] numbers = new int[10];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                gr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while (true) {

            if (currentRow >= currentCol) {

                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        int idx = gr[i][j];
                        numbers[idx]++;
                    }
                }
            }


        }

    }

    public class Pair {
        private int num;
        private int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
