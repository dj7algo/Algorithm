import java.io.*;
import java.util.*;
public class BOJ11053 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        dp[1] = 1;

        int max = 1;
        for(int i = 2 ; i <= N ; i++){
            if(arr[i] > arr[i-1]) {
                dp[i] = dp[i-1]+1;
                for(int j = i-2 ; j>=0 ; j--){
                    if(arr[i] > arr[j]){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
            }
            else{
                for(int j = i-1 ; j >= 0 ; j--) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
