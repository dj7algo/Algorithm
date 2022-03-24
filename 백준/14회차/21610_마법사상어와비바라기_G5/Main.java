import java.io.*;

import java.util.*;
public class Main {
    static int n,m;
    static int map[][];
    static int dx [] ={0,0,-1,-1,-1,0,1,1,1};
    static int dy [] = {0,-1,-1,0,1,1,1,0,-1};
    static int dir [];
    static int move[];
    static boolean visited[][];
    static ArrayList<Node>list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        dir = new int[m];
        move = new int[m];
        visited = new boolean[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int di = Integer.parseInt(st.nextToken());
            int si= Integer.parseInt(st.nextToken());
            dir[i] = di;
            move[i] = si;
        }

        list.add(new Node(n,1));
        list.add(new Node(n,2));
        list.add(new Node(n-1,1));
        list.add(new Node(n-1,2));

        int idx = 0;
        while (m-->0){
            visited = new boolean[n+1][n+1];
            ArrayList<Node> tmp = new ArrayList<>();    // 이동한 구름의 좌표를 담을 배열
            // 1. 모든 구름이 이동한다
            int move_cnt = move[idx];
            int d = dir[idx];
            idx++;

            for(int i=0; i<list.size(); i++){
                Node a = list.get(i);
                int nx = a.x;
                int ny = a.y;
                for(int j=0; j<move_cnt; j++){     // 정해진 칸 만큼 이동
                    nx+=dx[d];
                    ny+=dy[d];

                    // 범위에 벗어날시 연결시켜줌
                    if(nx == 0) nx = n;
                    if(ny == 0) ny = n;
                    if(nx==n+1) nx = 1;
                    if(ny == n+1) ny = 1;
                }
                visited[nx][ny] = true; // 구름이 생김
                tmp.add(new Node(nx,ny));
            }
            // 구름이 있는 칸의 물의 양 1 증가
            for(Node a : tmp){
                map[a.x][a.y]++;
            }



            // 물이 증가한 칸에서 물복사 버그 시전
            // 대각선 방향 2.4.6.8

            for(Node a : tmp){
                int cnt = 0;
                for(int i=2; i<=8; i+=2){
                    int nx = a.x+dx[i];
                    int ny = a.y+dy[i];

                    if(isRange(nx,ny) && map[nx][ny]>0){
                        cnt++;
                    }
                }
                map[a.x][a.y]+=cnt;

            }

            list.clear();

            // 물의 양이 2 이상인 칸에 구름이 생김
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(map[i][j]>=2 && !visited[i][j]){
                        list.add(new Node(i,j));
                        map[i][j]-=2;
                    }
                }
            }
        }
        int sum = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                sum+=map[i][j];
            }
        }
        System.out.println(sum);
    }
    public static boolean isRange(int x, int y){
        if(x>=1 && y>=1 && x<=n && y<=n) return true;
        return false;
    }
}
class Node{
    int x,y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}