package week11;

import java.util.*;
import java.io.*;

public class Main_bj_1063_킹 {
	static int[] didj(String line) {
		if (line.equals("R")) {
			return new int[] {0, 1};
		}else if (line.equals("L")) {
			return new int[] {0, -1};
		}else if (line.equals("B")) {
			return new int[] {1, 0};
		}else if (line.equals("T")) {
			return new int[] {-1, 0};
		}else if (line.equals("RT")) {
			return new int[] {-1, 1};
		}else if (line.equals("LT")) {
			return new int[] {-1, -1};
		}else if (line.equals("RB")) {
			return new int[] {1, 1};
		}else {
			return new int[] {1, -1};
		}
	}
	static int[] getPosition(String line) {
		int y = line.charAt(0) - 'A';
		int x = 8-(line.charAt(1) - '0');
		return new int[] {x,y};
	}
	public static void main(String[] args) throws Exception{
		//8방탐색
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[][] map = new int[8][8]; //king 2 stone 1 pan 0
		int[] king = getPosition(st.nextToken());
		int[] stone = getPosition(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int kingX = king[0]; 
		int kingY = king[1];
		int stoneX = stone[0];
		int stoneY = stone[1];
		map[kingX][kingY] = 2;
		map[stoneX][stoneY] = 1;
		for (int i = 0 ; i < N; i++) {
			String cmd = br.readLine();
			int[] dir = didj(cmd);
			int ni = kingX + dir[0];
			int nj = kingY + dir[1];
			if (ni >= 0 && ni < 8 && nj >= 0 && nj < 8) {
				if (map[ni][nj] == 1) { //다음장소에 돌이 있을때 돌과같이 움직임
					int sni = stoneX + dir[0];
					int snj = stoneY + dir[1];
					if (sni >= 0 && sni < 8 && snj >= 0 && snj < 8) { //돌의 move가 유효할때만 움직임
						map[stoneX][stoneY] = 0;
						map[kingX][kingY] = 0;
						stoneX = sni;
						stoneY = snj;
						kingX = ni;
						kingY = nj;
						map[stoneX][stoneY] = 1;
						map[kingX][kingY] = 2;
					}
					
				}else { //돌없으면 그냥 감
					map[kingX][kingY] = 0;
					kingX = ni;
					kingY = nj;
					map[kingX][kingY] = 2;
				}
			}
		}
		System.out.println((char)(kingY + 'A') + "" + (int)(8-kingX) ); //King위치 출력
		System.out.println((char)(stoneY + 'A') + "" + (int)(8-stoneX)); //돌위치 출력
		br.close();
	}
}
