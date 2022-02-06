package tomyself;


import java.io.*;
import java.util.*;
public class Main {
		static int arr[] = new int[7];
		static int smallPeople[] = new int[9];
		
		// 조합 시간복잡도 2^n
		// 즉 2^9
		
		public static void main(String[] args) throws Exception {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			smallPeople[i] = Integer.parseInt(br.readLine());
		}
		
		dfs(0,0,0);
	}
	public static void dfs(int level, int sum, int now) {
		if(level==7) {
			
			if(sum==100) {
				Arrays.sort(arr);
				for(int i=0; i<7; i++) {
					System.out.println(arr[i]);
				}
				System.exit(0);
			}
			return ;
		}
		
		
		for(int i=now; i<9; i++) {
			arr[level] = smallPeople[i];
			dfs(level+1,sum+smallPeople[i],i+1);
		}
		
	}
 }
