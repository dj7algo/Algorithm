import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T ; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> box = new LinkedList<Integer>(); //담아둘 박스
			for (int i = 0 ; i < N; i++) {
				box.add(Integer.parseInt(st.nextToken()));
			}
			// 1. 최대값을 찾아 최대값기준 왼쪽을 전부 팔아버린다.
			// 2. 계산끝난애들은 다 뺴버린다.
			// 3. 반복한다.
			long sum = 0;
			while(!box.isEmpty()) {
				int max= 0;
				int maxIdx = 0;
				//1. 최대값 찾기
				long before = System.currentTimeMillis();
				max = Collections.max(box);
				maxIdx = box.indexOf(max);
				long after = System.currentTimeMillis();
				//2. 최대값기준 왼쪽 다 잘라내기 + 마지막최대값도 짤라내서 넣기
				for (int i = 0 ; i <= maxIdx; i++) {
					sum += (max-box.remove(0));
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
