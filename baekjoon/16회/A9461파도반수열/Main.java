package A9461파도반수열;

import java.io.*;

/* 
p(1)...P(10) = {1,1,1,2,2,3,4,5,7,9}
=> p(N) = P(N-3)+P(N-2)
*/
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb =new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int tc = 0; tc < T; tc++) {
      int N = Integer.parseInt(br.readLine());
      long[] dp = new long[N + 1];

      if (N <= 3) {
        sb.append(1+"\n");
        continue;
      }
      dp[1] = 1;
      dp[2] = 1;
      dp[3] = 1;
      for (int i = 4; i <= N; i++) {
        dp[i] = dp[i - 3] + dp[i - 2];
      }

      sb.append(dp[N]+"\n");
    }
    System.out.print(sb.toString().trim());
  }
}
