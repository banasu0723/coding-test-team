package banasu0723.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 10828 스택
public class b_250902 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령의 수
        Stack<Integer> stack = new Stack<Integer>(); // Stack 객체 생성
        StringBuilder sb = new StringBuilder(); // 출력 성능 향상

        for (int i = 0; i < N; i++) {

            // 입력을 받고 공백 기준으로 문자열 나눠주기
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            // 명령 확인
            switch (S) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
            }
        }

        // 출력
        System.out.println(sb);

    }
}
