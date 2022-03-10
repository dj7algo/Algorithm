package a0306;
import java.util.*;

/*
 엘리베이터로 이동할수있는지 없는지 어떻게 판단??
 
 visit[]배열로 이미 방문한곳이면 return 해주면될듯 
 
 
 */
public class 백준5014스타트링크_첫풀이 {

	static int[] visit = new int[1000001];
	
	static int all;
	static int from;
	static int to;
	static int up;
	static int down;
	static int mincnt = Integer.MAX_VALUE;
	static int checkcnt = 0;
	
	static void findmin(int now, int cnt) {
		checkcnt++;
		
		if(now == to) {
			mincnt = Math.min(mincnt, cnt);
			//System.out.println(cnt);
			return;
		}
		System.out.println(now);
		
		if(now<1 || all<now ||visit[now]==1)return;
		if(cnt>mincnt)return;
		visit[now] = 1;
		
		findmin(now+up, cnt+1);
		findmin(now-down, cnt+1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		all = sc.nextInt();
		from = sc.nextInt();
		to = sc.nextInt();
		up = sc.nextInt();
		down = sc.nextInt();
		
		findmin(from, 0);
		System.out.println("checkcnt:"+checkcnt);
		
		if(mincnt==Integer.MAX_VALUE)System.out.println("use the stairs");
		else System.out.println(mincnt);
	}

}