package a0303;
import java.util.*;
import java.io.*;

/*
visit배열 하나 만들고 
map<integer, list> 하나 만들어서 연결된곳 관리하면서 visit처리된 수 
세면 될듯? 
 */

public class 백준2606바이러스 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] visit = new int[num+1];
		
		int[][] arr = new int[num+1][num+1];
		int size = sc.nextInt();
		
		for(int i=0; i<size; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			arr[from][to] = 1;
			arr[to][from] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visit[1] = 1;
		
		while(!q.isEmpty()) {
			int nownum = q.poll();
			
			for(int j=1; j<=num; j++) {
				if(arr[nownum][j]==1 && visit[j]==0) {
					visit[j] = 1;
					q.add(j);
				}
			}
			
		}
		
		int cnt = -1;
		for(int i=1; i<=num; i++) {
			if(visit[i]==1)cnt++;
		}
	//	System.out.println(Arrays.toString(visit));
		
		System.out.println(cnt);
		
	}

}
