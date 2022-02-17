import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[7][2];
		for (int tc = 1 ; tc <= N; tc++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			arr[grade][gender]++;
		}
		int result = 0;
		for (int g = 1; g <= 6; g++) {
			int girl = arr[g][0] / K ; //여자수 / 방최대인원
			if (arr[g][0] % K != 0){
				girl++;
			}
			int boy = arr[g][1] / K ; //남자수 / 방최대인원
			if (arr[g][1] % K != 0) {
				boy++;
			}

			result += girl + boy;
		}
		System.out.println(result);
		br.close();
	}
}
