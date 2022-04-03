package A1904공일타일;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    if(N<2) {
      System.out.print(1);
      System.exit(0);
    }
    int[] dp = new int[N];

    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < N; i++) {
      dp[i] = (dp[i - 1] + dp[i-2])%15746;
    }
    System.out.print(dp[N-1]);
  }
}
