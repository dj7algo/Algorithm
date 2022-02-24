import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
	
	
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			boolean arr[][] = new boolean[4][14];
			
			for(int i=0; i<4; i++) {
				Arrays.fill(arr[i], true);
			}
			
			String str = br.readLine();
			boolean flag = true;
			 for(int i=0; i<str.length(); i+=3) {
				char type = str.charAt(i);
				int num = 0;
				
				char num1 = str.charAt(i+1);
				char num2 = str.charAt(i+2);
				num+=num1-'0';
				num*=10;
				num+=num2-'0';

				flag = true;
				if(type =='S') {
					if(!arr[0][num]) flag =false;
					arr[0][num] = false;
				}
				else if(type =='D') {
					if(!arr[1][num]) flag =false;
					arr[1][num]=false;
				}
				else if(type =='H') {
					if(!arr[2][num]) flag =false;
					arr[2][num] =false;
				}
				else {
					if(!arr[3][num]) flag =false;
					arr[3][num] = false;
				}
				if(!flag) {
					sb.append("#"+tc+" ERROR"+"\n");
					break;
				}
			}
			 if(flag) {
					sb.append("#"+tc+" ");
					for(int i=0; i<4; i++) {

						int cnt = 0;
						for(int j=1; j<=13; j++) {
							if(arr[i][j]) cnt++;
						}
						sb.append(cnt+" ");
					}
					sb.append("\n");
			 }

			
		}
		System.out.println(sb);
	}

}
