package a0313;
import java.util.*;
import java.io.*;

/*
 전형적인 사방탐색 문제 
 
 다음으로 못가는 경우 -> 방문했던곳, 장애물, 벽 
 */

public class 백준13901로봇 {

	static int sero ;
	static int garo ;
	static int[][] visit;
	static int[][] arr;
	
	static boolean check(int i, int j) {
		if(0<=i&&i<sero && 0<=j&&j<garo)return true;
		return false;
	}
	
	static int di[] = new int[4];
	static int dj[] = new int[4];
	static int dir = 0;
	
	static int nowi = 0;	static int nowj = 0;
	static int ni = 0; 		static int nj = 0;
	
	static void move() {
		
		while(true) {
			visit[nowi][nowj] = 1;
			int cnt = 0;
			//System.out.println("nowi:"+nowi+" "+" nowj:"+nowj);
			while(true) {
				ni = nowi+di[dir];
				nj = nowj+dj[dir];
				//System.out.println("ni:"+ni+" "+" nj:"+nj);
				if(check(ni,nj) && visit[ni][nj]==0 && arr[ni][nj]!=-1) {
					//System.out.println(ni+" "+nj);
					break;
				}
				//System.out.println(ni+" "+nj);
				dir = (dir+1)%4;
				cnt++;
				
				if(cnt==4) {
					System.out.println(nowi+" "+nowj);
					return;
				}
				
			}
			//System.out.println(1);
			nowi = ni; nowj = nj;
		}
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer ST = new StringTokenizer(br.readLine());
		sero = Integer.parseInt(ST.nextToken());
		garo = Integer.parseInt(ST.nextToken());
		
		arr = new int[sero][garo];
		visit = new int[sero][garo];
		
		int xnum = Integer.parseInt(br.readLine());
		
		for(int i=0; i<xnum; i++) {
			ST = new StringTokenizer(br.readLine());
			int xi = Integer.parseInt(ST.nextToken());
			int xj = Integer.parseInt(ST.nextToken());
			
			arr[xi][xj] = -1;
		}
		
		ST = new StringTokenizer(br.readLine());
		nowi = Integer.parseInt(ST.nextToken());
		nowj = Integer.parseInt(ST.nextToken());
		
		int d = 0;
		
		ST = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			int nowdir = Integer.parseInt(ST.nextToken());
			
			if(nowdir == 1) {
				di[d] = -1;	dj[d] = 0;
			}else if(nowdir == 2) {
				di[d] = 1;	dj[d] = 0;
			}else if(nowdir == 3) {
				di[d] = 0;	dj[d] = -1;
			}else if(nowdir == 4) {
				di[d] = 0;	dj[d] = 1;
			}
			d++;
		}
//		System.out.println(Arrays.toString(di));
//		System.out.println(Arrays.toString(dj));
		
		//for(int[] tmp: arr)System.out.println(Arrays.toString(tmp));
		//System.out.println(nowi+" " +nowj);
		
		move();
		
	}

}
