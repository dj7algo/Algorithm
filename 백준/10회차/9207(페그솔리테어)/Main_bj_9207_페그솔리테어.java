import java.util.*;
import java.io.*;
public class Main_bj_9207_페그솔리테어 {
	
	static int[] di = {0,-1,0,1}; // 좌 상 우 하
	static int[] dj = {-1,0,1,0};
	static int max;
	static void pinmove(char[][] arr, int count, int x , int y ) {
		// 이동시키고, 이동시킨 배열상태로 다시 검사하는식으로 끝날때까지 반복
		for (int i = x ; i < 5; i++) {
			for (int j = y ; j < 9; j++) {
				if (arr[i][j] == 'o') {
					for (int a = 0 ;  a< 4; a++) {
						char[][] newarr = new char[5][9];
						for (int k = 0 ; k < 5 ; k++) {
							newarr[k] = Arrays.copyOf(arr[k], 9);
						}
						int ni = i + di[a];
						int nj = j + dj[a];
						if (ni >= 0 && ni < 5 && nj >= 0 && nj < 9 && arr[ni][nj] == 'o') {
							int ni2 = i + di[a]*2;
							int nj2 = j + dj[a]*2;
							if (ni2 >= 0 && ni2 < 5 && nj2 >= 0 && nj2 < 9 && arr[ni2][nj2] == '.') {
									newarr[i][j] = '.';
									newarr[ni2][nj2] = 'o';
									newarr[ni][nj] = '.';
									pinmove(newarr, count+1, 0, 0);
							}
						}
					}
				}
			}
		}
		max = Math.max(max, count);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// 머이런 문제가 다
		// 1. # (벽)
		// 2. . (이동가능구간)
		// 3. o (핀)
		// 5X9 char 배열
		// 핀은 사방탐색중에 핀이 있어야 뛰어 넘어서 제거할 수 있고, 뛰어 넘은자리에도 핀이 없어야 뛰어넘을 수 있음.		
		for (int tc = 1; tc <= T ; tc++) {
			char[][] arr = new char[5][9];
			// 0. 배열담기
			int pin = 0;
			for (int i = 0 ; i < 5; i++) {
				String line = br.readLine();
				for (int j = 0 ; j < 9 ; j++) {
					arr[i][j] = line.charAt(j);
					if (arr[i][j] == 'o') {
						pin++;
					}
				}
			}
			max = Integer.MIN_VALUE;
			pinmove(arr,0,0,0);
			System.out.println(pin-max + " " + max);
			br.readLine(); //공백제거
			// 탐색하면서 o를 찾는다. 
			// o를 찾았을 때, 상하좌우 탐색 후 이동할 수 있는지 확인한다.
			// 이동할 수 있는 구간이 있으면, 처리 후에 다음 o를 찾으러 간다. 그러나 다른곳으로 이동할 수 있으니 경우의수를 둔다.
			
		}
		
		br.close();
	}
}
