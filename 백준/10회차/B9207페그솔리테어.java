package a0306;

import java.util.*;
import java.io.*;

/*
처음으로 떠오르는 방법 -> 별다른 규칙성은 없는것 같음 -> 완전탐색
-> + 배열을 파라미터로 넘겨주면서 계속 확인해야할듯?
-> why? 핀이 뛰어넘을수있는 곳이 여러개일수있으므로
 
 
 */

public class B9207페그솔리테어 {

	public static boolean check(int i, int j) {		//범위 안전성 검사
		if(0<=i&&i<5 && 0<=j&&j<9)return true;
		return false;
	}
	
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0, 1, 0, -1};				//사방탐색용 
	
	static int movemin = Integer.MAX_VALUE;
	static int remainmin = Integer.MAX_VALUE;
	
	public static void findmin(char[][] arr, int remain, int move) {		//dfs 완탐 함수
		
	//	System.out.println("dir:"+dir);
	//	System.out.println("iidx:" + iidx+" jidx:"+jidx +" ni:"+(iidx+di[dir])+" nj:"+(jidx+dj[dir]));
		
		if(remain < remainmin) {
			remainmin = remain; 
			movemin = move;
		}else if(remain == remainmin) {
			movemin = Math.min(movemin, move);
		}
		
		//print(arr);
		//System.out.println();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<9; j++) {
				if(arr[i][j] == 'o') {			//핀 발견했을때
					
					for(int d=0; d<4; d++) {
						int ni = i+di[d];
						int nj = j+dj[d];
						int nni = ni+di[d];
						int nnj = nj+dj[d];
						
						if(check(ni, nj) && check(nni, nnj) && arr[ni][nj]=='o' && arr[nni][nnj] == '.') {
							
							arr[i][j] = '.';		//원래있던자리
							arr[ni][nj] = '.';		//없어질 인접핀
							arr[nni][nnj] = 'o';	//이동한 원래핀자리
							findmin(arr, remain-1, move+1);
							
							arr[i][j] = 'o';
							arr[ni][nj] = 'o';
							arr[nni][nnj] = '.';
						}
					}
				}
			}
		}
	}
	
	public static void print(char[][] arr) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		char[][] arr = new char[5][9];
		
		for(int t=1; t<=tc; t++) {					//tc별 입력받기
			
			int cnt = 0;							//입력될 핀의 갯수 
			
			for(int i=0; i<5; i++) {
				String tmp = br.readLine();
				for(int j=0; j<9; j++) {
					arr[i][j] = tmp.charAt(j);
					if(arr[i][j] == 'o')cnt++;
				}
			}
			
			movemin = 0;
			remainmin = cnt;			//tc마다 초기화
							
			findmin(arr, cnt, 0);
			
		
			//System.out.println();
			if(remainmin==Integer.MAX_VALUE)System.out.println(0+" "+0);
			else System.out.println(remainmin+" "+movemin);
			br.readLine();
		}
		
		
	}

}
