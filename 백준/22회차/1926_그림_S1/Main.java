import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int max = 0;
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static int map[][];
    static boolean visited[][];
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1][m+1];
        map = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(!visited[i][j] && map[i][j]==1){
                    cnt++;
                    bfs(i,j);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);

    }
    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();

        visited[x][y] = true;
        int cnt = 1;
        q.add(new Node(x,y));

        while(!q.isEmpty()){
            Node a = q.poll();

            for(int i=0; i<4; i++){
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];

                if(isRange(nx,ny) && map[nx][ny]==1 && !visited[nx][ny]){
                    cnt++;
                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny));
                }
            }
        }
        max = Math.max(max,cnt);
    }
    public static boolean isRange(int x, int y){
        if(x>=1 && y>=1 && x<=n && y<=m) return  true;
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