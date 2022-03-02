import java.util.*;
import java.io.*;

class Main{
	static int m,n;
	static char map[][];
	static char white [][] = {{'W','B','W','B','W','B','W','B'}, {'B','W','B','W','B','W','B','W'}};
	static char black [][] = {{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'}};
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st  =new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new char[m][n];
		
		for(int i=0; i<m; i++) {
			 String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(isRange(i+7, j+7)) {
					int cnt = changeColor('W', i, j);
					cnt = Math.min(cnt, changeColor('B', i, j));
					min = Math.min(min, cnt);
				}
				
			}
		}
		System.out.println(min);
	}
	public static boolean isRange(int x, int y) {
		if(x<m && y<n) return true;
		return false;
	}
	public static int changeColor(char start_color, int x, int y) {
		int cnt = 0;
		
		if(start_color =='W') {
			
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					if(i%2==0) {	// 짝수라인 W B W B W B W B 
						if(map[x+i][y+j] != white[0][j]) cnt++;
					}
					else {			// 홀수라인 B W B W B W B W
						if(map[x+i][y+j] != white[1][j]) cnt++;
					}
				}
			}
			return cnt;
		}
		
		else {
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					
					if(i%2==0) {	// 짝수라인 B W B W B W B W
						if(map[x+i][y+j] != white[1][j]) cnt++;
					}
					else {			// 홀수라인 W B W B W B W B 
						if(map[x+i][y+j] != white[0][j]) cnt++;
					}
					
				}
			}
			return cnt;
		}
		
	}
}
