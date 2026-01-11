package heeun98.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class h_14 {

    static int[][] gr;
    static Position[] result;
    static List<Position> pizza;
    static List<Position> house;
    static int n;
    static int m;
    static int distance = Integer.MAX_VALUE;
    static int answer = Integer.MAX_VALUE;
    static int count =0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        gr = new int[n][n];
        result = new Position[m];

        pizza = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                gr[i][j] = Integer.parseInt(st.nextToken());
                if (gr[i][j] == 2) {
                    pizza.add(new Position(i, j));
                }
                if (gr[i][j] == 1) {
                    house.add(new Position(i, j));
                }
            }
        }

        dfs(0, 0);
        System.out.println(answer);

    }

    static void dfs(int idx, int v) {
        if (v == m) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                Position hP = house.get(i);
                distance = Integer.MAX_VALUE;
                for (int j = 0; j < result.length; j++) {
                    Position pP = result[j];
                    distance = Math.min(distance, Math.abs(pP.r - hP.r) + Math.abs(pP.c - hP.c));
                }
                sum += distance;
            }
            answer = Math.min(sum, answer);
            return;
        }

        for (int i = idx; i < pizza.size(); i++) {
            result[v] = pizza.get(i);
            dfs(i + 1, v + 1);
        }


    }

    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public String toString() {
            return r +"," + c;
        }
    }




}
