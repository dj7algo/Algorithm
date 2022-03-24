import java.io.*;

import java.util.*;
public class Main {
    static int n,k;
    static int [] belt;
    static int hp[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[n*2+1];
        hp = new int[n*2+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n*2; i++){
            hp[i] = Integer.parseInt(st.nextToken());
        }

        int step = 1;
        while (true){
            // 벨트가 각 칸위에 있는 로봇과 한칸 회전

            int tmp_belt [] = new int[n*2+1];
            int tmp_hp [] = new int[n*2+1];

            tmp_belt[1]  = belt[n*2];
            tmp_hp[1] = hp[n*2];

            for(int i=2; i<= n*2; i++){
                tmp_belt[i] = belt[i-1];
                tmp_hp[i] = hp[i-1];
            }

            for(int i=1; i<=n*2; i++){
                belt[i] = tmp_belt[i];
                hp[i] = tmp_hp[i];
            }

            belt[n] = 0;

            // 2. 가장 먼저 벨트위에 올라간 로봇부터 한칸 이동
            // N번째 자리에서 로봇들이 무조건 다 떨어지고 1번째 자리에서부터 로봇이 올라가고, 한칸씩 움직이므로
            // N번째부터 1번째 순서대로 반복문을 타면 가장 먼저 벨트위에 올라간 로봇부터 움직이기 가능

            for(int i=n-1; i>=1; i--){
                if(belt[i]==0) continue;    // 해당칸에 로봇이 없는 경우
                if( i+1 == n ){
                    if(hp[i+1] !=0){
                        if(belt[i] ==1){
                            belt[i] = 0;
                            hp[i+1]--;
                        }
                    }
                }
                else if(hp[i+1] != 0 && belt[i+1] == 0){
                    belt[i+1] = 1;
                    belt[i] = 0;
                    hp[i+1]--;
                }
            }

            // 3 올리는 위치에 내구도가 0이 아니면 로봇을 올린다
            if(hp[1] !=0){
                hp[1]--;
                belt[1] = 1;
            }

            // 4. 내구도가 0인칸이 k개 이상이면 종료
            int cnt = 0;
            for(int i=1; i<=n*2; i++){
                if(hp[i] ==0 )cnt++;
            }

            if(cnt>=k){
                System.out.println(step);
                return;
            }
            step++;
        }
    }
}
