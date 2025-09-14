package banasu0723.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_250914 {
    // 1966번 프린터 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서 개수
            int m = Integer.parseInt(st.nextToken()); // 찾을 문서 위치

            st = new StringTokenizer(br.readLine());
            Queue<int[]> queue = new LinkedList<>();
            for (int j= 0; j < n; j++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.add(new int[]{j, importance}); // [문서 위치, 중요도]
            }

            int printCount = 0;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                boolean hasHigher = false;

                // 뒤에 더 중요한 문서가 있는지 확인
                for (int[] doc : queue) {
                    if (doc[1] > now[1]) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    queue.add(now); // 뒤로 보내기
                } else {
                    printCount++;
                    if (now[0] == m) { // 내가 찾는 문서라면
                        sb.append(printCount).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
