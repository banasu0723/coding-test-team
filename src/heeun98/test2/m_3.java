package heeun98.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.*;
import java.util.*;

public class m_3 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] gr = new int[n][5];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for (int j = 0; j < 5; j++) {
                gr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] student = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                for (int k = 0; k < 5; k++) {

                    if (gr[i][k] == gr[j][k]) {
                        student[i]++;
                        student[j]++;
                        break;
                    }
                }
            }
        }

        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < student.length; i++) {
            if (max < student[i]) {
                max = student[i];
                answer = i + 1;
            }
        }

        System.out.println(answer);
    }
}
