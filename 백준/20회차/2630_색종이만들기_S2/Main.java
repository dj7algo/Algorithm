import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int map[][];
    static boolean visited[][];
    static int area[][];
    static int num = 0;
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static int zero = 0 ;
    static int one = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        area = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1,1,n,n,n);

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(!visited[i][j]){
                    if(map[i][j]==0) zero++;
                    if(map[i][j]==1) one++;
                    bfs(i,j);
                }
            }
        }



        System.out.println(zero);
        System.out.println(one);
    }
    public static void bfs(int x, int y){
        visited[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        int std = area[x][y];
        q.add(new Node(x,y));


        while(!q.isEmpty()){
            Node a = q.poll();

            for(int i=0; i<4; i++){
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];

                if(isRange(nx,ny) && !visited[nx][ny] && area[nx][ny]==std){
                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny));
                }
            }
        }

    }
    public static void dfs(int x1, int y1, int x2, int y2, int divide){


        boolean flag = true;
        int color = map[x1][y1];
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(map[i][j]!=color) flag = false;
            }
        }

        if(flag){
            for(int i=x1; i<=x2; i++){
                for(int j=y1; j<=y2; j++){
                    area[i][j] = num;
                }
            }
            num++;
        }
        else{

            int nx1 = x1;
            int ny1  = y1;

            int nx2 = x1+divide/2-1;
            int ny2 = y1+divide/2-1;

            dfs(nx1,ny1,nx2,ny2,divide/2);

            nx1 = x1;
            ny1 = y1+divide/2;

            nx2 = nx1+divide/2-1;
            ny2 = ny1+divide/2-1;

            dfs(nx1,ny1,nx2,ny2,divide/2);

            nx1 = x1+divide/2;
            ny1 = y1;
            nx2 = nx1+divide/2-1;
            ny2 = ny1+divide/2-1;

            dfs(nx1,ny1,nx2,ny2,divide/2);

            nx1 = x1+divide/2;
            ny1 = y1+divide/2;

            nx2 = x2;
            ny2 = y2;

            dfs(nx1,ny1,nx2,ny2,divide/2);
        }
    }
    public static boolean isRange(int x, int y){
        if(x>=1 && y>=1 && x<=n && y<=n )return  true;
        return  false;
    }
}
class Node{
    int x,y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}