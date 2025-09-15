package banasu0723.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_250915 {
    // 수 정렬하기 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int num;

        for(int i = 0; i < N; i++){
            num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        Arrays.sort(arr);

        for(int number : arr){
            sb.append(number).append("\n");
        }

        System.out.println(sb);
    }
}