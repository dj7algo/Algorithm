import java.io.*;
import java.util.*;
/**
 * A2563색종이
 */
public class A2563색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boolean[][] paper = new Boolean[100][100];
        for(int i =0;i<100;i++){
            Arrays.fill(paper[i],false);    // 배열 한번에 특정값으로 초기화.
        }

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 색종이 범위(x~x+10 , y~y+10)에 true 저장
            for (int i = y; i < y + 10; i++) {  
                for (int j = x; j < x + 10; j++) {
                    if (paper[i][j] == true) continue;
                    paper[i][j] = true;
                }
            }
        }
        // paper[100][100]내에 true 개수 = 넓이
        int count=0;
        for (int i =0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(paper[i][j]==true) count++;
            }
        }
        System.out.println(count);
    }
}