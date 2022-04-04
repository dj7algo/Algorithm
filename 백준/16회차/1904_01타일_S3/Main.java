import java.util.*;
import java.io.*;
public class Main {

	static int n;
	public static void main(String [] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		int dp [] = new int[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[n]%15746);
	}
}
