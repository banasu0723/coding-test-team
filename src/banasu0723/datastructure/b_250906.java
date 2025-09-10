package banasu0723.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b_250906 {
    // 10845번 큐
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push":
                    // 큐 뒤에 x 추가
                    int x = Integer.parseInt(st.nextToken());
                    queue.addLast(x);
                    break;

                case "pop":
                    // 큐가 비어있으면 -1 아니면 맨 앞 수 제거+출력
                    sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append("\n");
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    // 비어있으면 1 아니면 0
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "front":
                    // 비어있으면 -1 아니면 맨앞 확인
                    sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
                    break;

                case "back":
                    // 비어있으면 -1 아니면 맨뒤 확인
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");



            }
        }
        System.out.println(sb);

    }
}