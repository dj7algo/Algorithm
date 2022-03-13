package week11;
import java.util.*;
import java.io.*;
public class Main_bj_1347_미로만들기 {
	static int getDirection(int dir, boolean rotation) {
		if (rotation) {
			return dir + 1 == 4 ? 0 : dir+1;
		}else {
			return dir -1 == -1 ? 3 : dir-1;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[100][100];
		String line = br.readLine();
		int startX = 49;
		int startY = 49;
		map[startX][startY] = true;
		int[] di = {0,-1,0,1}; //좌 상 우 하
		int[] dj = {-1,0,1,0};
		int dir = 3;
		for (int i = 0 ;i < N ;i++) {
			char cmd = line.charAt(i);
			if (cmd == 'L') {
				dir = getDirection(dir, false);
			}else if (cmd == 'R') {
				dir = getDirection(dir,true);
			}else {
				startX = startX + di[dir];
				startY = startY + dj[dir];
				map[startX][startY] = true;
			}
		}
		
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		for (int i = 0 ;i < 100; i++) {
			for (int j = 0 ; j < 100 ; j++) {
				if(map[i][j]) {
					minX = Math.min(minX, i);
					minY = Math.min(minY, j);
					maxX = Math.max(maxX, i);
					maxY = Math.max(maxY, j);
				}
			}
		}
		int R = maxX-minX+1;
		int C = maxY-minY+1;
		for (int i = 0 ; i < R ; i++) {
			for (int j = 0 ; j < C ; j++) {
				if (map[minX+i][minY+j]) {
					System.out.print(".");
				}else {
					System.out.print("#");
				}
			}
			System.out.println();
		}

		
		
		br.close();
	}
}
