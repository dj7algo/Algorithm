import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,t;
    static int min = Integer.MAX_VALUE;
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static int map[][];
    static boolean visited[][][][];
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1][m+1][n+1][m+1];
        map = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

        if(min > t){
            System.out.println("Fail");
        }
        else{
            System.out.println(min);
        }
    }
    public static void bfs(){
        Queue<Node> q = new LinkedList<>();

        visited[1][1][1][1] = true;
        q.add(new Node(1,1,0,false));

        while(!q.isEmpty()){
            Node a = q.poll();

            if(a.x ==n && a.y ==m){
                min = Math.min(min,a.time);
            }
            for(int i=0; i<4; i++){
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];

                if(isRange(nx,ny) && !visited[nx][ny][a.x][a.y]){
                    if(map[nx][ny] ==0){
                        q.add(new Node(nx,ny,a.time+1,a.sword));
                        visited[nx][ny][a.x][a.y] = true;
                    }
                    if(map[nx][ny] ==1 && a.sword){
                        q.add(new Node(nx,ny,a.time+1,a.sword));
                        visited[nx][ny][a.x][a.y] = true;
                    }
                    if(map[nx][ny] ==2){
                        q.add(new Node(nx,ny,a.time+1,true));
                        visited[nx][ny][a.x][a.y] = true;
                    }
                }
            }
        }
    }
    public static boolean isRange(int x, int y){
        if(x>=1 && y>=1 && x<=n && y<=m) return  true;
        return false;
    }
}
class Node{
    int x,y,time;
    boolean sword;
    public Node(int x, int y, int time, boolean sword) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.sword = sword;
    }
}