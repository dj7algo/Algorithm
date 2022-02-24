import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
	
	
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for(int tc=1; tc<=10; tc++) {
			
			int r = Integer.parseInt(br.readLine());
			
			boolean building [][] = new boolean[r+1][256];
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=1; i<=r; i++) {
				int h = Integer.parseInt(st.nextToken());
				
				for(int j=1; j<=h; j++) {
					building[i][j] = true;
				}
			}
			
			int cnt = 0;
			for(int i=1; i<=r; i++) {
				if(!building[i][1]) continue;	// 빌딩이 없는 칸
				
				for(int j=1; j<=255; j++) {
					if(!building[i][j]) break;		// 건물 높이 끝
					
					// 맨 왼쪽 2칸, 오른쪽 2칸 안지어지므로 인덱스 예외처리 안해도됨

					if(building[i-1][j]) continue;
					if(building[i-2][j]) continue;
					if(building[i+1][j]) continue;
					if(building[i+2][j]) continue;
					cnt++;
				}
			}
			sb.append("#"+tc+" "+cnt+"\n");
			
		}
		System.out.println(sb);
	}

}
