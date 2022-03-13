import java.io.*;
import java.util.*;
public class Main {
    static int dx [] = {-1,0,1,0};
    static int dy[] = {0,1,0,-1};
    static char order[];
    static char map[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        order = new char[n];
        String str = br.readLine();

        int cnt = 0;
        for(int i=0; i<n; i++){
            order[i] = str.charAt(i);
        }
        int x = 50;     // 왜? 명령어의 최대길이는 50,  즉 F연산을 50번하면 앞으로 50칸 갈 수 있다
        int y = 50;     // 이에 따라 현재 위치를 50,50으로 잡고 맵을 100,100으로 한 다음 출력시 잘라주면 된다.

        map = new char[101][101];
        for(int i=0; i<101; i++){
            Arrays.fill(map[i],'#');
        }
        map[50][50] = '.';  // 출발지점
        int dir = 2;    // 남쪽방향

        for(int i=0; i< order.length; i++){
            char op = order[i];

            if(op=='F'){
                x+=dx[dir];
                y+=dy[dir];
                map[x][y] = '.';
            }
            if(op=='R'){
                dir++;
                if(dir==4) dir=0;
            }
            if(op=='L'){
                dir--;
                if(dir==-1) dir = 3;
            }

        }

        int left = Integer.MAX_VALUE;
        int right = 0;
        int up = Integer.MAX_VALUE;
        int down = 0;
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                if(map[i][j]=='.'){
                    left = Math.min(left,j);
                    right = Math.max(right,j);
                    up = Math.min(up,i);
                    down = Math.max(down,i);
                }
            }
        }

        for(int i=up; i<=down; i++){
            for(int j=left; j<=right; j++){
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }

    }
}
