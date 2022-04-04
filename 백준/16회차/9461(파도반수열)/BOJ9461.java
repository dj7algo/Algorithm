import java.io.*;
import java.util.*;
public class BOJ9461 {
    static long[] dp = new long[101];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        for(int tc = 1 ; tc <= T ; tc++){
            int N = Integer.parseInt(br.readLine());
            for(int i = 2 ; i <= N ; i++){
                if(i==2) dp[i] = 1;
                if(dp[i]==-1) dp[i] = dp[i-2] + dp[i-3];
            }
            System.out.println(dp[N]);
        }
    }

}