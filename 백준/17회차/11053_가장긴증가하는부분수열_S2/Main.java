import java.io.*;
import java.util.*;
public class Main {
	static int dp[];
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n];
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		dp[0] = 1;
		
		
		for(int i=1; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
