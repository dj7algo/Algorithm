package week13;
import java.util.*;
import java.io.*;

public class Main_bj_13901_로봇 {
	static int[] di = {0,-1,1,0,0}; // 위, 아래, 왼 , 오른쪽
	static int[] dj = {0,0,0,-1,1};
	static int R;
	static int C;
	static boolean dircheck_4(int[] dirarr, int[][] map, int X, int Y) {
		for (int i = 0 ; i < 4; i++) {
			int ni = X + di[dirarr[i]];
			int nj = Y + dj[dirarr[i]];
			if (ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] == 0) {
				return true;
			}
		}
		return false;
		
	}
	public static void main(String[] args) throws Exception{
		//1. 로봇은, 사용자가 지정한 방향을 일직선으로 움직인다.
		//2. 이동중, 벽이나 방문한지역, 장애물을 만날경우, 로봇은 사용자가 지정한 다음방향으로 움직인다.
		//3. 사용자가 지정한 다음방향이 없다면, 맨 처음방향으로 돌아가서 위의 과정을 반복한다.
		//4. 로봇이 움직일 수 없을 경우 동작을 멈춘다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R  = Integer.parseInt(st.nextToken()); //row
		C  = Integer.parseInt(st.nextToken()); //col
		int O = Integer.parseInt(br.readLine()); //장애물 개수
		//이동가능 0 장애물 -1 방문함 1
		int[][] arr = new int[R][C];
		for (int i = 0 ; i < O ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = -1; 
		}
		st = new StringTokenizer(br.readLine(), " ");
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		arr[startX][startY] = 1;

		st = new StringTokenizer(br.readLine(), " ");
		int[] dirarr = new int[4];
		for (int i = 0 ; i < 4; i++) {
			dirarr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		while(dircheck_4(dirarr, arr, startX, startY)) { //3,4번동작
			for (int i = 0 ; i < 4; i++) { //2번동작
				int dir = dirarr[i];
				int ni = startX + di[dir];
				int nj = startY + dj[dir];
				while (ni >= 0 && ni < R && nj >= 0 && nj < C && arr[ni][nj] == 0) { //1번동작
					startX = ni;
					startY = nj;
					arr[startX][startY] = 1;
					ni = startX + di[dir];
					nj = startY + dj[dir];
				}
			}
		}
		
		System.out.println(startX + " " + startY);
		
		
		
		br.close();
	}
}
