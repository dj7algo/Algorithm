import java.util.*;
import java.io.*;
public class Main {
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t  = Integer.parseInt(br.readLine());

		while(t-- >0) {
			String [] input = br.readLine().split(" ");
			StringBuilder sb = new StringBuilder();
			int h = Integer.parseInt(input[0]);
			int w = Integer.parseInt(input[1]);
			int n = Integer.parseInt(input[2]);
			
		
//			int cnt = 1;
//			loop: for(int i=1; i<=w; i++) {
//				for(int j=1; j<=h; j++) {	
//					if(cnt ==n) {
//						sb.append(j);
//						if(i<10) {
//							sb.append(0);
//							sb.append(i);
//						}
//						else {
//							sb.append(i);
//						}
//						break loop;
//					}
//					
//					cnt++;
//				}
//			}
			
			int row = n%h;
			int col = n/h;
			
			if(row == 0) {
				row = h;
			}
			else {
				col++;
			}
			
			sb.append(row);
			if(col < 10) sb.append(0);
			sb.append(col);
			System.out.println(sb);
		}
	}
}
