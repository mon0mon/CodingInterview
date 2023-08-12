import java.io.IOException;

public class Solution {
    private final int MOD = 1_000_000_007;
    private int[] dx = {1, 0};
    private int[] dy = {0, 1};
    private int height;
    private int width;

    // public static void main(String[] args) {
    //     System.out.println(new Pg42898_등굣길().solution(4, 3, new int[][]{{2, 2}}));
    // }

    public int solution(int m, int n, int[][] puddles) {
        height = n + 1;
        width = m + 1;
        int[][] dp = new int[height][width];

        // 웅덩이 표시
        for (int i = 0; i < puddles.length; i++) {
            int y = puddles[i][1];
            int x = puddles[i][0];
            dp[y][x] = -1;
        }

        dp[1][1] = 1; // 시작 위치

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }

                // 왼쪽에서 오는 경우와 위쪽에서 오는 경우의 경로 합산
                if (i - 1 >= 1 && dp[i - 1][j] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                }
                if (j - 1 >= 1 && dp[i][j - 1] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        return dp[n][m];
    }
}