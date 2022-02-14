package week4;
import java.util.*;
import java.io.*;
public class 직사각형네게의어쩌고 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean [][] arr = new boolean[101][101];
		int count = 0;
		for (int tc = 1 ; tc <= 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for( int i = x1 ; i < x2 ; i++) {
				for(int j = y1 ;j < y2; j++) {
					if (!arr[i][j]) {
						arr[i][j] = true;
						count++;
					}

				}
			}
		}
		System.out.println(count);
		
	}
}
