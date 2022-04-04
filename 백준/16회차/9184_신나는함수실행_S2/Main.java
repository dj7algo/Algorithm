import java.util.*;

import javax.print.attribute.standard.DateTimeAtProcessing;

import java.io.*;
public class Main {
	static int dp[][][];
	public static void main(String [] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp = new int[51][51][51];
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==-1 && b==-1 && c==-1) return;
			int result = w(a, b, c);
			System.out.println("w("+a+", "+b+", "+c+") = "+result);
		}
		
		
	}
	public static int w(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0) return 1;
		if(dp[a][b][c]!=0) return dp[a][b][c];
		
		
		else if(a>20 || b>20 || c>20) {
			return  w(20, 20, 20);
		}
		
		else if(a<b && b<c) {
			dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		else {
			dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1)-w(a-1, b-1, c-1)    ;
		}
		
		
		return dp[a][b][c];
	}
}
