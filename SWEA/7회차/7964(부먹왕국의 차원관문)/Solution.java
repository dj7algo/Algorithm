import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int city = Integer.parseInt(st.nextToken()); //도시의 수
			int distance = Integer.parseInt(st.nextToken()); //거리
			String line = br.readLine();
			String[] ct = line.split(" ");
			int curX = 0;
			int door = 0;
			//1. 현재 자리에 차원관문 넣기
			//2. 범위내 차원관문이있으면, 그 관문으로 이동하고, 없으면이동
			//3. 차원관문 범위가 도시를 넘어서면, 거기서 종료.
			while (curX < city) {
				//현재자리에 차원관문 넣기. 만약 이미 넣어져있으면 안넣기
				if (!ct[curX].equals("1")) {
					door++;
				}
				boolean find = false;
				for (int i = curX+1 ; (i < curX+distance) && (i < city); i++) {
					if (ct[i].equals("1")) {
						find = true;
						curX = i;
						break;
					}
				}
				if (!find) {
					curX = curX+distance;
				}
			}
			sb.append(door).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
