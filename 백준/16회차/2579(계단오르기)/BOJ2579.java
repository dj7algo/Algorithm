import java.io.*;
import java.util.*;
public class BOJ2579 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] step = new int[N+1];
        int[] dp = new int[N+1];

        for(int i =1 ; i <= N ; i++){
            step[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = step[0];
        dp[1] = step[1];

        if(N >= 2){
            dp[2] = step[1]+step[2];
        }


        for(int i = 3 ; i <= N ; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3]+step[i-1])+step[i];
        }
        System.out.println(dp[N]);
    }
}