package banasu0723.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class b_250911 {
    // 4949번 균형잡힌 세상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String line = br.readLine();

            if(line.equals(".")){
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for(char c : line.toCharArray()){
                if(c == '(' || c == '[') {
                    stack.push(c);
                } else if(c == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        isBalanced = false;
                        break;
                    }
                    stack.pop();
                } else if(c == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        isBalanced = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty()){
                isBalanced = false;
            }

            sb.append(isBalanced ? "yes\n" : "no\n");
        }

        System.out.println(sb);


    }
}