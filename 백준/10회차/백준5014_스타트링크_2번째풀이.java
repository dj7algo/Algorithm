package a0306;

import java.util.*;

public class 백준5014_스타트링크_2번째풀이 {

	static int[] visit = new int[1000001];
	
	static int all;
	static int from;
	static int to;
	static int up;
	static int down;
	static int mincnt = Integer.MAX_VALUE;
	static int checkcnt = 0;
	
	static void bfs(int from, int cnt) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {from, 0});
		
		while(!q.isEmpty()) {
			
			int[] now = q.poll();
			int nowwhere = now[0]; 	int nowcnt = now[1];
			
			if(nowwhere == to) {
				mincnt = nowcnt;
				return;
			}
			
			if(nowwhere+up<=all && visit[nowwhere+up]==0) {
				visit[nowwhere+up] = 1;
				q.add(new int[] {nowwhere+up, nowcnt+1});
			}
			
			if(nowwhere-down>=1 && visit[nowwhere-down]==0) {
				visit[nowwhere-down] = 1;
				q.add(new int[] {nowwhere-down, nowcnt+1});
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		all = sc.nextInt();
		from = sc.nextInt();
		to = sc.nextInt();
		up = sc.nextInt();
		down = sc.nextInt();
		
		bfs(from, 0);
		if(mincnt==Integer.MAX_VALUE)System.out.println("use the stairs");
		else System.out.println(mincnt);
	}

}
