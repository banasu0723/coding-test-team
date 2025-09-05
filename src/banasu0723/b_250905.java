package banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b_250905 {
    // 2164번 카드2
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        // 1 부터 N 까지 큐에 넣기
        for(int i = 1; i <= N; i++){
            queue.add(i);
        }

        while(queue.size() > 1){
            queue.poll(); // 맨 위 버리기
            queue.add(queue.poll()); // 맨 위 카드 꺼내서 맨 뒤로
        }

        System.out.println(queue.poll()); // 마지막 남은 카드

    }
}
