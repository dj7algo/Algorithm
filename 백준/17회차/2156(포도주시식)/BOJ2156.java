import java.io.*;
import java.util.*;
public class BOJ2156 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N+1];
        int[] dp = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = wines[0];
        dp[1] = wines[1];
        int max = 0;
        for(int i = 2 ; i <= N ; i++){
            int tmp = wines[i]+wines[i-1];
            if(i>=3) {
                tmp += dp[i-3];
                tmp = Math.max(tmp, wines[i]+dp[i-3]);
            }
            tmp = Math.max(tmp, wines[i]+dp[i-2]);
            dp[i] = Math.max(dp[i-1], tmp);
        }

        System.out.println(dp[N]);
    }
}
