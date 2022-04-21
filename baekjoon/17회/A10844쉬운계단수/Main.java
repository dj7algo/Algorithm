package A10844쉬운계단수;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int r = 1000000000;
    int N = scan.nextInt(); // 자리수
    long[][] dp = new long[N + 1][10];

    Arrays.fill(dp[1], 1L);
    dp[1][0] = 0L;

    // 두 번째 자릿수부터 N까지 탐색
    for (int i = 2; i <= N; i++) {

      // i번째 자릿수의 자릿값들을 탐색 (0~9)
      for (int j = 0; j < 10; j++) {

        // j=0, 즉 자릿값이 0이라면 이전 자릿수의 첫번째 자릿수만 가능
        if (j == 0) {
          dp[i][0] = dp[i - 1][1] % r;
        }
        // j=9라면 이전 자릿수는 8만 가능
        else if (j == 9) {
          dp[i][9] = dp[i - 1][8] % r;
        }
        // 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨
        else {
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % r;
        }
      }
    }

    long result = 0;

    // 각 자릿값마다의 경우의 수를 모두 더해준다.
    for (int i = 0; i < 10; i++) {
      result += dp[N][i];
    }

    System.out.println(result % r);
  }

}