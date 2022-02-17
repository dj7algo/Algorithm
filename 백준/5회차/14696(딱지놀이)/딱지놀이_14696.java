import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1 ; tc <= T; tc++) {
			//라운드 1, 2, 3, 4, 5
			int A[] = new int[5]; //딱지 1, 2, 3, 4
			int B[] = new int[5]; //딱지 1, 2, 3, 4
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //A의 개수
			for (int i = 1 ; i <= N; i++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //B의 개수
			for (int i = 1 ; i <= N; i++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			if (A[4] > B[4]) {
				sb.append("A").append("\n");
			}else if (A[4] < B[4]) {
				sb.append("B").append("\n");
			}else {
				if (A[3] > B[3]) {
					sb.append("A").append("\n");
				}else if (A[3] < B[3]) {
					sb.append("B").append("\n");
				}else {
					if (A[2] > B[2]) {
						sb.append("A").append("\n");
					}else if (A[2] < B[2]) {
						sb.append("B").append("\n");
					}else {
						if (A[1] > B[1]) {
							sb.append("A").append("\n");
						}else if (A[1] < B[1]) {
							sb.append("B").append("\n");
						}else {
							sb.append("D").append("\n");
						}
					}
				}
			}
		}
		System.out.print(sb.toString());
		br.close();
	}
}
