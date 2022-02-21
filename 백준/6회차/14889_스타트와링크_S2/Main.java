import java.util.*;
import java.io.*;

class Main{
	static int n;
	static int arr[][];
	static int tmp[];
	static int min = Integer.MAX_VALUE;
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		tmp = new int[n];	
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(min);
	}
	public static void dfs(int level ,int now) {
		if(level == n/2) {
			
			boolean visited [] = new boolean[n];
			for(int i=0; i<level; i++) {
				visited[tmp[i]] = true;
			}
			int sum1 = 0;
			int sum2 = 0;
			ArrayList<Integer>list = new ArrayList<>();
			ArrayList<Integer>list2 = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				if(visited[i]) list.add(i);
				else list2.add(i);
			}
			
			
			for(int i=0; i<list.size(); i++) {
				for(int j=0; j<list.size(); j++) {
					if(i==j) continue;
					
					int left = list.get(i);
					int right = list.get(j);
					
					sum1+=arr[left][right];
					
				}
			}
			
			for(int i=0; i<list2.size(); i++) {
				for(int j=0; j<list2.size(); j++) {
					if(i==j) continue;
					
					int left = list2.get(i);
					int right = list2.get(j);
					
					sum2+=arr[left][right];
					
				}
			}
			min = Math.min(min, Math.abs(sum1-sum2));
			return ;
		}
		
		for(int i=now; i<n; i++) {
			tmp[level] = i;
			dfs(level+1,i+1);
		}
	}
}