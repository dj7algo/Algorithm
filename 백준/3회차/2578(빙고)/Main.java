import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] bingo = new int[5][5];
		boolean find = false;
		//1. 빙고넣기
		for (int i = 0 ; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//2. 하나씩 읽기
		for (int i = 0 ; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				//3. num에 해당하는 줄 찾아서 -1 할당하기
				
				for(int x = 0 ;  x < 5; x++) {
					for (int y = 0 ; y < 5; y++) {
						if (num == bingo[x][y]) {
							bingo[x][y] = -1;
						}// -1할당하고 가로줄 세로줄 탐색
					}
				}
				//4. 할당끝났으면, 전체 조회해서 3줄이상인지 찾기
				//4-1. 가로줄,세로줄
				int totalnum = 0;
				for (int x = 0 ; x < 5; x++) {
					int rcount = 0;
					int ccount = 0;
					for (int y = 0 ; y < 5; y++) {
						if (bingo[x][y] == -1) {
							rcount++;
						}
						if (bingo[y][x] == -1) {
							ccount++;
						}
					}
					if (rcount == 5) totalnum++;
					if (ccount == 5) totalnum++;
				}
				//4-2. 대각선 /
				int dcount = bingo[2][2] == -1 ? 1 : 0;
				for (int x = 1; x <= 2; x++) {
					int ni = 2 - x;
					int nj = 2 + x;
					if (bingo[ni][nj] == -1) dcount++;
					ni = 2 + x;
					nj = 2 - x;
					if (bingo[ni][nj] == -1) dcount++;
				}
				if (dcount == 5) totalnum++;
				//4-3 대각선 \
				dcount = bingo[2][2] == -1 ? 1 : 0;
				for (int x = 1; x <= 2; x++) {
					int ni = 2 - x;
					int nj = 2 - x;
					if (bingo[ni][nj] == -1) dcount++;
					ni = 2 + x;
					nj = 2 + x;
					if (bingo[ni][nj] == -1) dcount++;
				}
				if (dcount == 5) totalnum++;
				//4-3. 대각선 \
				if (totalnum >= 3) {
					find = true;
					System.out.println((i*5) + (j+1));
					break;
				}
			}
			if (find) break;
		}
		br.close();
	}
}
