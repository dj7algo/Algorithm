package A2579계단오르기;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int dan = Integer.parseInt(br.readLine());
    int[] jumsu = new int[dan + 1];
    for (int i = 1; i <= dan; i++) {
      jumsu[i] = Integer.parseInt(br.readLine());
    }
    
    int[] dp = new int[dan + 1];
    dp[1] = jumsu[1];

    for (int i = 2; i <= dan; i++) {
      if (i == 2) {
        dp[2] = jumsu[1] + jumsu[2];
      } else if (i == 3) {
        dp[3] = Math.max(jumsu[1], jumsu[2]) + jumsu[3];
      } else {
        dp[i] = Math.max(dp[i - 3] + jumsu[i - 1], dp[i - 2]) + jumsu[i];
      }
    }

    System.out.println(dp[dan]);
  }
}
