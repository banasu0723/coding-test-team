package banasu0723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_250908 {
    // 1874번 스택 수열
    // + = push(1부터 n까지 오름차순으로 스택에 넣을 수 있음), - = pop (스택에서 꺼내기)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Boolean possible = true;

        int n = Integer.parseInt(br.readLine()); // 수열 길이
        int num = 1; // 스택에 오름차순으로 넣을 숫자


        for(int i = 0; i < n; i++){

            int answer = Integer.parseInt(br.readLine()); // 수열의 수

            // 입력받은 수열의 수가 나올 떄까지 push
            while(num <= answer){
                stack.push(num);
                sb.append("+\n");
                num++;
            }

            if(!stack.isEmpty() && stack.peek() == answer){
                stack.pop();
                sb.append("-\n");
            } else{
                possible = false;
                break;
            }
        }

        if(possible){
            System.out.println(sb);
        } else{
            System.out.println("NO");
        }
    }
}