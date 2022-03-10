import java.io.*;
import java.util.*;
public class BOJ9207 {
    static int N,pinResult,moveResult;
    static char[][] map;
    //상하좌우
    static int[] dx= {-1,1,0,0};
    static int[] dy= {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int t=0; t<N; t++) {
            map = new char[5][9];
            pinResult = moveResult = 0;
            int pin = 0;
            for(int i=0; i<5; i++) {
                String temp = br.readLine();
                for(int j=0; j<9; j++) {
                    map[i][j] = temp.charAt(j);
                    if(map[i][j]=='o') pin++;
                }
            }
            pinResult = pin;

            for(int i=0; i<5; i++) {
                for(int j=0; j<9; j++) {
                    if(map[i][j]=='o') dfs(i,j,pin,0);//현재위치와 pin,move
                }
            }
            br.readLine();
            //print();

            System.out.println(pinResult+" "+moveResult);
        }


    }
    private static void dfs(int x, int y, int pin, int m) {
        //기저조건
        if(pin<=pinResult) {
            pinResult = pin;
            moveResult = m;
        }

        //4방탐색
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(isValid(nx,ny) && map[nx][ny] == 'o') {
                int nx2 = nx + dx[d];
                int ny2 = ny + dy[d];
                if(isValid(nx2,ny2) && map[nx2][ny2]=='.') {//빈칸일때만 가능
                    map[x][y] = '.';//현재위치 빈칸
                    map[nx][ny] = '.';//인접한 칸도 빈칸
                    map[nx2][ny2] = 'o';//이동한칸 표시

                    for(int i=0; i<5; i++) {
                        for(int j=0; j<9; j++) {
                            if(map[i][j]=='o') dfs(i,j,pin-1,m+1);
                        }
                    }

                    //복구
                    map[x][y] = 'o';//현재위치 복구
                    map[nx][ny] = 'o';//인접한 칸 복구
                    map[nx2][ny2] = '.';//이동한칸 복구
                }
            }


        }

    }

    private static boolean isValid(int nx, int ny) {//map안에 있는지 확인
        return nx>=0 && nx<5 && ny>=0 && ny<9;
    }

    private static void print() {
        for(int i=0; i<5; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }
}