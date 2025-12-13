package heeun98.brute_force;


public class h_251213 {


    public static void main(String[] args) {

        boolean[] visit = new boolean[10001];


        for (int i = 1; i <= 10000; i++) {

            int sum = i + sum(i);
            if (sum > 10000) continue;
            visit[sum] = true;
        }


        for (int i = 1; i <= 10000; i++) {
            if (!visit[i]) System.out.println(i);
        }


    }

    private static int sum(int num) {

        int sum = 0;
        while (num > 0) {

            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
