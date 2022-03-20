package a0320;

import java.util.*;
import java.io.*;

/*
 while문 안에서 매 좌표마다 visit 아니면 bfs를 돌린다 
 bfs안에서는 사방탐색을 돌려서 범위를 벗어나는 수가 있는지 탐색
 있으면 list에도 넣고 큐에도 넣어서 체크 
 한 집단마다 -> list 1개 
 
 -> 집단이 여러개일수있으므로 2차원 리스트로 관리 
 
 
 */



public class 백준16234인구이동 {
	
	static ArrayList<ArrayList<int[]>> alllist;
	static ArrayList<int[]> tmplist;
	static int[][] arr;
	static int[][] visit;
	static int size ;
	static int low ;
	static int high ;
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};
	
	static void bfs(int i, int j) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		
		tmplist = new ArrayList<>();
		tmplist.add(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowi = now[0];	int nowj = now[1];
			
			for(int d=0; d<4; d++) {
				int ni = nowi+di[d];
				int nj = nowj+dj[d];
				
				if(check(ni, nj)) {
					int gap = Math.abs(arr[nowi][nowj]-arr[ni][nj]);
					if(visit[ni][nj]==0 && gap>=low &&gap<=high) {
						visit[ni][nj] = 1;
						q.add(new int[] {ni, nj});
						tmplist.add(new int[] {ni, nj});
					}
				}
			}
		}
		
	}
	
	static boolean check(int i, int j) {
		if(0<=i&&i<size && 0<=j&&j<size)return true;
		return false;
	}
	
	static boolean canvisit(int i, int j) {		//주변에 연합조건 만족하는게 있는지 체크 
		
		for(int d=0; d<4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			
			if(check(ni,nj)) {
				int gap = Math.abs(arr[ni][nj]-arr[i][j]);
				if(gap>=low && gap<=high)return true;
			}
		}
		return false;
	}
	
	static void allcheck() {
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(visit[i][j]==0 && canvisit(i,j)) {
					visit[i][j] = 1;
					bfs(i,j);		//방문한적 없고 근처에 연합조건 만족하는곳이 있으면 bfs 
					alllist.add(tmplist);
				}
			}
		}
	}
	
	static void print() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void move() {
		
		for(int i=0; i<alllist.size(); i++) {
			int sum = 0;
			int cnt = 0;
			
			for(int j=0; j<alllist.get(i).size(); j++) {
				int[] now = alllist.get(i).get(j);
				sum+=arr[now[0]][now[1]];
				cnt++;
			}
			//System.out.println("sum:" +sum +"cnt:"+cnt);
			int avg = sum/cnt;
			
			for(int j=0; j<alllist.get(i).size(); j++) {
				int[] now = alllist.get(i).get(j);
				arr[now[0]][now[1]] = avg;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
	
		size = Integer.parseInt(ST.nextToken());
		low = Integer.parseInt(ST.nextToken());
		high = Integer.parseInt(ST.nextToken());
		
		arr = new int[size][size];
		
		for(int i=0; i<size; i++) {
			ST = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++) {
				arr[i][j] = Integer.parseInt(ST.nextToken());
			}
		}
		
		int time = 0;
		
		while(true) {
			alllist = new ArrayList<>();		//한턴에 모든 집단을 담을 2차원 리스트 초기화
			visit = new int[size][size];		//visit 초기화
			allcheck();							//한턴에 다 개방한 상태
			//print();
			if(alllist.size()==0)break;
			//System.out.println("time:"+time);
			time++;
			move();								//한턴에 일어날 인구이동
			//print();
		}
		
		System.out.println(time);
	}
}
