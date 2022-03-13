package week11;
import java.util.*;
import java.io.*;
public class Main_bj_2784_가로세로퍼즐 {
	
	static int N = 6;
	static int R = 3;
	static boolean[] visited = new boolean[6];
	static List<String> input;
	static String[] result = new String[3];
	static boolean find = false;
	static void perm(int count) {
		if (count == R ) {
			List<String> temp = new ArrayList<>();
			for (int i = 0 ; i < 6; i++) {
				temp.add(input.get(i));
			}
			for (int i = 0 ; i < 3; i++) {
				char[] sero = {result[0].charAt(i),result[1].charAt(i),result[2].charAt(i)};
				String serostr= String.valueOf(sero);
				temp.remove(new String(result[i]));
				temp.remove(new String(serostr));
			}//3개 지우고, 세로로도 잘라본다.
			if (temp.size() == 0 && !find) { //다 잘라질때만 결과출력
				for (int i = 0 ; i < 3 ; i++) {
					System.out.println(result[i]);
				}
				find = true;
			}	
			return;
		}
		for (int i = 0 ; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			result[count] = input.get(i);
			perm(count+1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = new ArrayList<String>();
		for (int i = 0 ; i < 6; i++) {
			input.add(br.readLine());
		}
		perm(0);
		if (!find) {
			System.out.println(0);
		}
		br.close();
	}
}
