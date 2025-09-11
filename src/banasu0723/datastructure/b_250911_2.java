package banasu0723.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_250911_2 {
    // 10815번 숫자카드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Boolean isExisted = false;

        int n = Integer.parseInt(br.readLine());
        int[] cards= new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            if(Arrays.binarySearch(cards, num) >= 0){
                sb.append(1).append(" ");
            } else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);


    }
}