package A14501퇴사;

import java.io.*;
import java.util.*;
// DP(Dynamic Programing) 문제
public class A14501퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 일자
        int[] T =new int[N];    // 상담기간
        int[] P = new int[N];   // 금액
        int[] dp = new int[N+1];    // 금액의 합
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }
       // 뒤에서
        for (int i = N-1; i >= 0; i--) {
            int next = i + T[i];
            if (next > N) { // 일할 수 있는 날짜를 넘어가는 경우
                dp[i] = dp[i + 1];
            } else {    // 돈을 더 많이 버는 경우를 게산
                dp[i] = Math.max(dp[i + 1], dp[next] + P[i]);
            }
        }
        System.out.println(dp[0]);
        
        // 앞에서
        // for(int i=0;i<N;i++) {
		// 	int temp = i +T[i];
		// 	if(temp<=N) {
		// 		dp[temp] = Math.max(dp[temp], dp[i]+P[i]); 
		// 	}
		// 	//해당 날짜에 일할 수 없다면, 이전까지 일한 최대 수당을 넣어주어야 한다.
		// 	dp[i+1] = Math.max(dp[i+1], dp[i]); 
		// }
		// System.out.print(dp[N]);
    }
}
