package A20055컨베이어벨트위의로봇;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    // ==== 입력 ====
    int N = Integer.parseInt(st.nextToken()); // 컨베이어 길이
    int K = Integer.parseInt(st.nextToken()); // 내구도 0의 개수가 K개 이상이면 종료
    int[] con = new int[2 * N + 1]; // 컨베이어 칸 내구도
    boolean[] robot = new boolean[N+1]; // 해당 위치 로봇 존재 유무

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= N * 2; i++) con[i] = Integer.parseInt(st.nextToken());

    // ==== 구현 ====
    int dan = 1; // 단계수
    loop: while (true) {
      // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
      // ① 내구도 회전
      int tmp = con[2 * N];
      for (int i = 2 * N; i > 1; i--) {
        con[i] = con[i - 1];
      }
      con[1] = tmp;
      // ② 로봇 회전
      for(int i=N;i>1;i--) {
        robot[i]=robot[i-1];
      }
      robot[1] = false; // 항상 처음 올라오는 벨트는 로봇이 존재X
      robot[N] = false; // 내리는 위치이면 로봇 내림

      // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
      //    - 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.      
      for (int i = N; i > 1; i--) {
        // 내 위치에 로봇이 없고 내 뒤에 로봇이 존재하는데 내구도가 1이상이면
        if(!robot[i] && robot[i - 1] && con[i]>=1){ 
          robot[i]=true;
          robot[i-1]=false;
          con[i]--;
        }
      }

      // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.  
      if(con[1]!=0) {
        robot[1]=true;
        con[1]--;
      }


      // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
      int count=0;
      for(int i=1;i<=N*2;i++) {
        if(con[i]==0) {
          if(++count >= K) {
            break loop;
          }
        }
      }
      
      // 출력
      // System.out.println("* "+dan + "단");
      // System.out.print("   내구도 : [ ");
      // for (int i = 1; i <= N * 2; i++) {
      //   System.out.print(con[i]);
      //   if (i < N * 2) System.out.print(", ");
      // }
      // System.out.println(" ]");
      // System.out.print("로봇 위치 : [ ");
      // for (int i = 1; i <=N ; i++) {
      //   System.out.print(robot[i]?1:0);
      //   if (i < N) System.out.print(", ");
      // }
      // System.out.println(" ]");
      // System.out.println("========================================");

      dan++;
    }

    System.out.print(dan);
  }
}
