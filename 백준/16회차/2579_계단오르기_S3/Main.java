import java.util.*;


import java.io.*;
public class Main {

	public static void main(String [] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		long dp[][] = new long[301][2];		// 계단의 최대 갯수 = 300개
		int arr[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//dp[n][0]  1칸으로 올라온 경우
		//dp[n][1]  2칸으로 올라온 경우
		
		dp[1][0] = arr[1];
		dp[2][0] = arr[1]+arr[2];
		dp[2][1] = arr[2];
		
		long max = 0;
		for(int i=3; i<=n; i++) {
			dp[i][0] = dp[i-1][1] + arr[i];
			dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) +arr[i];
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}
		
		System.out.println(max);
	}
}
