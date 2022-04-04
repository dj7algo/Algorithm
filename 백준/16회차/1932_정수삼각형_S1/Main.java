import java.util.*;


import java.io.*;
public class Main {

	public static void main(String [] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		long dp[][] = new long[n+1][n+1];
		int arr[][] = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = arr[1][1];
		long max = 0;
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				dp[i][j]= Math.max(dp[i-1][j], dp[i-1][j-1]) + arr[i][j]; 
				max = Math.max(max, dp[i][j]);
			}
		}
		
		

		
		System.out.println(max);
		
		
	}
}
