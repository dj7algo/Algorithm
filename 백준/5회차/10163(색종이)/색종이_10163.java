import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//색종이개수
		int[] paper = new int[N+1];
		int[][] draw = new int[1001][1001];
		for (int tc = 1 ; tc <= N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for(int i = x ; i < x+w; i++) {
				for (int j = y ; j < y+h ; j++) {
					if (draw[i][j] == 0) { //안그려져있으면 그리고 종이넓이를 더한다.
						draw[i][j] = tc;
						paper[tc]++;
					}else { //그려져있으면, 지우고 다시그리고 이전에 그렸던애를 지운다. 
						paper[ draw[i][j] ]--; //이전애 지우기
						draw[i][j] = tc; //내꺼 그리기
						paper[tc]++; //내꺼넓이 추가
					}
				}
			}
		}
		for(int i = 1 ; i <= N; i++) {
			sb.append(paper[i]).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
