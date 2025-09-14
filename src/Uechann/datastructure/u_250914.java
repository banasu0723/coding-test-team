package Uechann.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 문제 1966
여러분도 알다시피 여러분의 프린터 기기는 여러분이 인쇄하고자 하는 문서를 인쇄 명령을 받은 ‘순서대로’, 즉 먼저 요청된 것을 먼저 인쇄한다.
 여러 개의 문서가 쌓인다면 Queue 자료구조에 쌓여서 FIFO - First In First Out - 에 따라 인쇄가 되게 된다. 
 하지만 상근이는 새로운 프린터기 내부 소프트웨어를 개발하였는데, 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.

    1. 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
    2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 
    이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄를 한다.
    예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.

여러분이 할 일은, 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다. 
예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.

입력
첫 줄에 테스트케이스의 수가 주어진다. 각 테스트케이스는 두 줄로 이루어져 있다.

테스트케이스의 첫 번째 줄에는 문서의 개수 N(1 ≤ N ≤ 100)과, 
몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)이 주어진다. 
이때 맨 왼쪽은 0번째라고 하자. 두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다. 
중요도는 1 이상 9 이하의 정수이고, 중요도가 같은 문서가 여러 개 있을 수도 있다.

출력
각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력한다.

예제 입력 1 
3           테스트 케이스의 수
1 0         문서의 개수N, 궁금한 문서가 큐에서 몇번째 놓였는지 나타내는 정수M
5           N개의 문서의 중요도 차례대로
4 2
1 2 3 4
6 0
1 1 9 1 1 1
예제 출력 1 
1
2
5
 */

public class u_250914 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();

        int caseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCount; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // (Key, Value) (인덱스, 우선순위) 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                q.add(new AbstractMap.SimpleEntry<>(j, Integer.parseInt(st.nextToken())));
            }

            int count = 0;
            while (!q.isEmpty()) {
                Map.Entry<Integer, Integer> front = q.poll();

                // 우선순위가 더 큰값이 있으면 큐에 다시 add
                boolean flag = q.stream()
                        .anyMatch(n -> n.getValue() > front.getValue());

                if (flag)
                    q.add(front);
                else {
                    count++;

                    // 출력된 요소의 Key가 M이면 sb에 추가 후 break
                    if (front.getKey() == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
            q.clear();
        }
        System.out.println(sb);
    }
}
