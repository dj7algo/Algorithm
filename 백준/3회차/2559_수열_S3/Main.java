import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		/*
		 *풀이 아이디어
		 *누적합을 구한뒤 뺀다
		 * 
		 */
		
		
		int n,k;
		String [] input = br.readLine().split(" ");
		
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		
		int dp [] = new int[n+1];	// 누적합 담을 배열
		int arr[] = new int[n+1];	// 데이터 담을 배열
		input = br.readLine().split(" ");
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(input[i-1]);
		}
		
		dp[1] = arr[1];
		
		for(int i=2 ;i<n; i++) {
			dp[i] = arr[i]+dp[i-1];
		}
		
		int max = dp[k];
		for(int i=k+1; i<=n; i++) {
			max = Math.max(max, dp[i]-dp[i-k]);
		}
		
		System.out.println(max);
	}
 }
