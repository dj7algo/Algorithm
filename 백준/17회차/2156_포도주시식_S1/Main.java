import java.io.*;
import java.util.*;
public class Main {
	static int dp[];
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = arr[1];
		if(n==1) {
			System.out.println(dp[1]);
			System.exit(0);
		}
		
		dp[2] = dp[1] + arr[2];
		
		for(int i=3; i<=n; i++) {
			dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], Math.max(dp[i-1], dp[i-2]+arr[i]));
		
		}
		
		System.out.println(dp[n]);
	}
}
