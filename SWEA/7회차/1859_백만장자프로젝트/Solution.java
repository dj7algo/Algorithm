import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {

	
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int arr[] = new int[n];
			int max_idx = 0;	// 최대 가격 판매날
			int max = 0;
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());	
			}
			
			long ans = 0;

			
			int left = 0;
			while(left < n-1) {
				max = 0;
				for(int i=max_idx; i<n; i++) {
					if(arr[i] > max) {
						max = arr[i];
						max_idx = i;
					}	
				}
				
				for(int i=left; i<max_idx; i++) {
					ans+=max-arr[i];
				}
				left = max_idx+1;
				max_idx++;
			}
			
			
			sb.append("#"+tc+" "+ans+"\n");
		}

		System.out.println(sb);
	}

}
