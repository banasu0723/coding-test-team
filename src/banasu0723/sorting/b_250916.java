package banasu0723.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_250916 {
    //11399번 ATM
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n];
        int total = 0;
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);

        for(int t : time){
            total += t; // 현재 사람까지 기다린 시간
            result += total; // 모든 사람이 기다린 시간의 총합
        }

        sb.append(result);
        System.out.println(sb);
    }
}