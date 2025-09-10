package banasu0723.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_250910 {
    // 11866 요세푸스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        // 1부터 n 까지 원형 구조 큐에 집어넣기
        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }

        sb.append("<");

        while(!queue.isEmpty()){
            // k-1 번 앞에서 뒤로 위동
            for(int i = 0; i < k - 1; i++){
                queue.offer(queue.poll());
            }

            // k번째 사람 제거
            sb.append(queue.poll());

            // 마지막이 아니면 쉼표 추가
            if(!queue.isEmpty()){
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
