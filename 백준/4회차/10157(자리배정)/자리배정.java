package week4;
import java.util.*;
import java.io.*;
public class 자리배정 {
	static boolean[][] checked;
	static int N;
	static int row;
	static int col;
	static int count = 1;
	static boolean find = false;
	static int[] di = {-1,0,1,0};//북동남서
	static int[] dj = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(br.readLine());
		checked = new boolean[row][col];
		int curX = row-1; 
		int curY = 0;
		checked[curX][curY] = true;
		int dir = 0;//북쪽부터 시작
		while(count < N && count < (row*col)) { // 인덱스 벗어나면 방향전환!
			int ni = curX + di[dir];
			int nj = curY + dj[dir];
			if (ni >= 0 && ni < row && nj >= 0 && nj < col && !checked[ni][nj]) {
				checked[ni][nj] = true;
				count++;
				curX = ni;
				curY = nj;
				if (count == N) {
					find = true;
					break;
				}
			}else {
				dir = (dir + 1) % 4;
			}
			
			
		}
		
		if (N == 1) {
			System.out.println("1 1");
		}else {
			if(!find) {
				System.out.println(0);
			}else {
				System.out.println((curY+1) + " " + (row-curX) );
			}
		}
		
	}
}
