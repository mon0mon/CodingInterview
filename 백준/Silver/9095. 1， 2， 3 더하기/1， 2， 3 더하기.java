import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//  1, 2, 3 더하기
//  https://www.acmicpc.net/problem/9095
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] dp = new int[n+1];

            dp[1] = 1;
            if (n >= 2) dp[2] = 2;
            if (n >= 3) dp[3] = 4;

            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
    }
}