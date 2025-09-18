package banasu0723.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_250918_2 {
    // 11650번 좌표 정렬하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        // 음수( < 0 ) 반환 → a가 b보다 앞에 옴
        // 0 반환 → 순서 유지
        // 양수( > 0 ) 반환 → b가 a보다 앞에 옴
        Arrays.sort(points, (a,b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }else{
                return a[0] - b[0];
            }
        });

        for(int i = 0; i < N; i++){
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }

        System.out.println(sb);

    }
}
