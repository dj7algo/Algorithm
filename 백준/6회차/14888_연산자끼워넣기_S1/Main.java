import java.util.*;
import java.io.*;

class Main{
	static int n;
	static int op[];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE; 
	static int num[];
	static int tmp_op[];
	static char arr[];
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());	// 수의 개수
		num = new int[n];
		op = new int[4];
		arr = new char[n-1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		tmp_op = Arrays.copyOf(op, op.length);
		dfs(0);
		System.out.println(max);
		System.out.println(min);
	}
	public static void dfs(int level) {
		if(level == n-1) {
			
			
			int tmp = num[0];
			for(int i=0; i<n-1; i++) {
				
				if(arr[i] =='+') {
					tmp+=num[i+1];
				}
				
				if(arr[i] =='-') {
					tmp-=num[i+1];
				}
				
				if(arr[i] =='x') {
					tmp*=num[i+1];
				}
				
				if(arr[i] =='%') {
					tmp/=num[i+1];
				}
			}
			min = Math.min(min, tmp);
			max = Math.max(max, tmp);
			
			return ;
		}
		
		for(int i=0; i<4; i++) {
			if(tmp_op[i] != 0) {
				if(i==0) arr[level] = '+';
				if(i==1) arr[level] = '-';
				if(i==2) arr[level] = 'x';
				if(i==3) arr[level] = '%';
				
				tmp_op[i]--;
				dfs(level+1);
				tmp_op[i]++;
			}
		}
		
	}
}
