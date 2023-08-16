import java.util.Scanner;

//  설탕 배달
//  https://www.acmicpc.net/problem/2839
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = 5001;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.min(dp[i], dp[i - 3] + 1);
        }

        for (int i = 5; i <= N; i++) {
            dp[i] = Math.min(dp[i], dp[i - 5] + 1);
        }

        if (dp[N] >= 5001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}