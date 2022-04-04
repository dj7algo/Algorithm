import java.io.*;
import java.util.*;

//"00"타일과 "1"타일로 N길이의 타일 만들기
//f(1) : 1 - 1 ("1"타일만 가능)
//f(2) : 2 - 00, 11 ("00"타일 한번 사용 / "1"타일 두개 이어붙이기)
//f(3) : 3
//       001 100 - (00 사용한 경우)
//       111     - (00 사용하지 않은 경우)
//f(4) : 5
//       0000           - (00 2개 사용한 경우)
//       0011 1001 1100 - (00 1개 사용한 경우)
//       1111           - (00 0개 사용한 경우)
//f(5) : 8
//       10000 00100 00001         - (00 2개 사용한 경우)
//       11001 10011 00111 11100   - (00 1개 사용한 경우)
//       11111                     - (00 0개 사용한 경우)
// 점화식
// f(n) = f(n-1) + f(n-2)

public class BOJ1904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2 ; i <= N ; i++){
            if(i==2) dp[i] = i;
            else{
                dp[i] = (dp[i-1]+dp[i-2])%15746;
            }
        }

        System.out.println(dp[N]);

    }
}