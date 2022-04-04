import java.util.*;
import java.io.*;
public class Main {

	public static void main(String [] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		long dp [] = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for(int j=4; j<=100; j++) {
			dp[j]= dp[j-3]+dp[j-2]; 
		}
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
