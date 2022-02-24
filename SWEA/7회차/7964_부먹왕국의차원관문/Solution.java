import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
	
	
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	// 왕국 도시수
			int d = Integer.parseInt(st.nextToken());	// 이동 제한 거리
			
			boolean gate[] = new boolean[n+1];
			st = new StringTokenizer(br.readLine());	// 차관 정보
			
			for(int i=1; i<=n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				
				if(tmp==1) gate[i] =true;
			}
			int cnt = 0;
			int depth = 0;
			for(int i=n; i>=1; i--) {
				if(i==1) {
					if(!gate[i]) cnt++;
					break;
				}
				
				// 마지막엔 무조건 게이트 있어야됨
				if(i==n) {
					if(gate[i]) continue;
					else {
						gate[i] = true;
						cnt++;
					}
						
				}
				
				
				if(gate[i]) depth = 0;
				else {
					depth++;
					if(depth ==d) {
						gate[i] = true;
						cnt++;
						depth=0;
					}
				}
				
			}
			sb.append("#"+tc+" "+cnt+"\n");
		}
		System.out.println(sb);
	}

}
