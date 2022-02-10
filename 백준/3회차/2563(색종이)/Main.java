import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		//100개의 배열 생성. 인덱스 맞추려고 101로 생성함.
		int[][] arr = new int[101][101];
		int count = 0;
		for(int tc = 1; tc <= T ; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 색종이 하나씩 10X10으로 색칠함. 근데 이미 색칠되어있으면, 그냥 넘어감.
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken());
			for (int i = x ; i < x+10; i++) {
				for(int j = y; j < y+10; j++) {
					if (arr[i][j] == 0) {
						arr[i][j] = 1;
						count++;
					}
				}
			}
		}
		System.out.println(count); //색칠된 총 개수 출력
	}
}
