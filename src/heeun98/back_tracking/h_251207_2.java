package heeun98.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_251207_2 {

    static int[][] pos;
    static ArrayList<int[]> chicken = new ArrayList<>();
    static boolean[][] visit;
    static int removeCount;
    static int n;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0 , 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        pos = new int[n][n];
        visit = new boolean[n][n];
        int chickenCount = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);
            for (int j = 0; j < n; j++) {
                pos[i][j] = Integer.parseInt(st.nextToken());
                if (pos[i][j] == 2) {
                    chickenCount++;
                    chicken.add(new int[]{i, j});
                }
            }
        }


        removeCount = chickenCount - m;

        dfs(0,0);

        System.out.println(result);

    }

    static void dfs(int idx, int count) {
        if (count == removeCount) {

            ArrayList<int[]> chickened = new ArrayList<>();
            for (int[] a : chicken) {
                if (pos[a[0]][a[1]] == 2) {
                    chickened.add(a);
                }
            }
           result = Math.min(result, calculateMinDistance(chickened));
        }

        for (int i = idx; i < chicken.size(); i++) {
            int r = chicken.get(i)[0];
            int c = chicken.get(i)[1];


            pos[r][c] = 0;
            dfs(i + 1,count + 1);
            pos[r][c] = 2;

        }

    }


    static int calculateMinDistance(List<int[]> contain) {

        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int min = Integer.MAX_VALUE;
                if (pos[i][j] == 1) {

                    int distance;
                    for (int[] pos : contain) {

                        distance = Math.abs(pos[0] - i) + Math.abs(pos[1] - j);
                        min = Math.min(distance, min);

                    }
                    total += min;
                }
            }
        }
        return total;
    }
}
