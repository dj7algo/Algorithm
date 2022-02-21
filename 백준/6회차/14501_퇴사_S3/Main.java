import java.util.*;
import java.io.*;

class Main{
	static int n;
	static Node arr[];
	static int dp[];
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		n = Integer.parseInt(br.readLine());
		
		arr = new Node[n+1];
		dp = new int[n+2];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node(t,p);
		}

		int max = 0;
		
		for(int i=1; i<=n; i++) {
			Node a = arr[i];
			// 현재 일에서 상담을 진행 가능한 경우
			if(i + a.time <= n+1) {
				// 현재일 + 상담일의 최댓값 갱신
				dp[i+a.time] = Math.max(dp[i+a.time], dp[i]+a.pay);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			
			
			
			
		}
		
		
		System.out.println(dp[n+1]);
		
	}
}
class Node{
	int time,pay;

	public Node(int time, int pay) {
		super();
		this.time = time;
		this.pay = pay;
	}
	
}