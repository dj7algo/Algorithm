package week8;
import java.util.*;
import java.io.*;
public class Main_bj_1018_체스판 {
	static int min;
	static int find(boolean[][] arr, int x, int y, boolean color) {
		int count = 0;
		for (int i = 0 ; i < 8; i++) {
			boolean standard = (i % 2 == 0 ? color: !color);
			for(int j = 0 ; j < 8; j++) {
				int ni = x+ i;
				int nj = y+ j;
				if (j %2 == 0) {
					if (arr[ni][nj] != standard) count++;
				}else {
					if (arr[ni][nj] == standard) count++;
				}
				if (count > min) { // BACK TRACKING
					return count;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean[][] board = new boolean[R][C]; //white=> true Black => false
		min = Integer.MAX_VALUE;
		//1. 배열 담기
		for (int i = 0 ; i < R ; i++) {
			String line = br.readLine();
			for (int j = 0 ; j < C ; j++) {
				board[i][j] = (line.charAt(j)=='W' ? true : false) ;
			}
		}
		//2-1. 검사하기
		for (int i = 0 ; i <= R-8; i++) {
			for (int j = 0 ; j <= C-8; j++) {
				min = Math.min(min, find(board,i,j,false));
				min = Math.min(min, find(board,i,j,true));
//				System.out.println("black : "+i + "," + j + " : " + find(board,i,j,false));//black
//				System.out.println("white : "+i + "," + j + " : " + find(board,i,j,true)); //white
			}
		}
		System.out.println(min);

		br.close();
	}
}
