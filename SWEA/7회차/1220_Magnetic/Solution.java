import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {

	
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for(int tc=1; tc<=10; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			int map [][] = new int [n][n];
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int ans = 0;
			
			for(int j=0; j<n; j++) {
				boolean red = false;		// 아래로 떨어짐
				boolean blue = false;		// 위로 떨어짐
				for(int i=0; i<n; i++) {
					int num = map[i][j];
					if(num==1) {
						// N극 성질 가지는 자성체
						red = true;
					}
					if(num ==2) {
						// S극 성질 가지는 자성체
						if(red)  ans++;
						red = false;
					}
				}
			}
			
			sb.append("#"+tc+" "+ans+"\n");
		}

		System.out.println(sb);
	}

}
