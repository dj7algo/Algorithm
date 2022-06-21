import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int min = Integer.MAX_VALUE;
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static char map[][];
    static boolean human_visited[][];
    static boolean fire_visited[][];
    static int fire_time[][];
    static Queue<Node>fireQ = new LinkedList<>();
    static Queue<Node>humanQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n+1][m+1];
        human_visited = new boolean[n+1][m+1];
        fire_visited = new boolean[n+1][m+1];
        fire_time = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            Arrays.fill(fire_time[i],Integer.MAX_VALUE);
        }



        for(int i=1; i<=n; i++){
            String str = br.readLine();
            for(int j=1; j<=m; j++){
                map[i][j] = str.charAt(j-1);
                if(map[i][j]=='F'){
                    fire_visited[i][j] = true;
                    fireQ.add(new Node(i,j,0));
                }
                if(map[i][j]=='J') {
                    human_visited[i][j] =true;
                    humanQ.add(new Node(i,j,0));
                }
            }
        }
        fire_bfs();
        human_bfs();
        if(min == Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(min+1);
        }

    }
    public static void human_bfs(){


        while(!humanQ.isEmpty()){
            Node a = humanQ.poll();
            for(int i=0; i<4; i++){
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];

                if(!isRange(nx,ny)){
                    min = Math.min(min,a.time);
                }


                if(isRange(nx,ny) && map[nx][ny]!='#' &&!human_visited[nx][ny] && a.time+1<fire_time[nx][ny]){
                    human_visited[nx][ny] = true;

                    humanQ.add(new Node(nx,ny,a.time+1));
                }

            }
        }
    }
    public static void fire_bfs(){
        while(!fireQ.isEmpty()){
            Node a = fireQ.poll();
            fire_time[a.x][a.y] = a.time;
            for(int i=0; i<4; i++){
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];

                if (isRange(nx, ny) && !fire_visited[nx][ny] && map[nx][ny] != '#') {
                    fire_visited[nx][ny] = true;
                    fireQ.add(new Node(nx,ny,a.time+1));
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
    public Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}