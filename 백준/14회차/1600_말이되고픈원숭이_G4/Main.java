import java.io.*;

import java.util.*;
public class Main {
    static int dx [] ={0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static int ddx [] = {-2,-2,-1,-1,1,1,2,2};
    static int ddy [] = {-1,1,-2,2,-2,2,-1,1};
    static int h,w,k;
    static int map[][];
    static boolean visited[][][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());    // 능력 횟수
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        visited = new boolean[h][w][k+1];
        map = new int[h][w];

        for(int i=0; i<h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }
    static boolean isRange(int x, int y){
        if(x>=0 && y>=0 && x<h && y<w) return true;
        return false;
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0,0,0,0));

        while (!q.isEmpty()){
            Node a= q.poll();

            if(a.x == h-1 && a.y == w-1){
                System.out.println(a.cnt);
                System.exit(0);
            }
            for(int i=0; i<4; i++){
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];

                if(isRange(nx,ny) && map[nx][ny] ==0 && !visited[nx][ny][a.skill]) {
                    q.add(new Node(nx, ny, a.cnt + 1, a.skill));
                    visited[nx][ny][a.skill] = true;
                }
            }

            if(a.skill<k){
                for(int i=0; i<8; i++){
                    int nx = a.x+ddx[i];
                    int ny = a.y+ddy[i];

                    if(isRange(nx,ny) && map[nx][ny] ==0 && !visited[nx][ny][a.skill+1]){
                        visited[nx][ny][a.skill+1] = true;
                        q.add(new Node(nx,ny,a.cnt+1,a.skill+1));
                    }
                }
            }

        }
        System.out.println(-1);
    }
}
class Node {
    int x,y,cnt,skill;

    public Node(int x, int y, int cnt, int skill) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.skill = skill;
    }
}