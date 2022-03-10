import java.io.*;
import java.util.*;
public class Main {

    static int n,m,h;
    static int map[][][];
    static int dx [] = {0,0,1,-1,0,0};
    static int dy [] = {1,-1,0,0,0,0};
    static int dh [] = {0,0,0,0,1,-1};
    static boolean visited[][][];
    static int max = 0;
    static ArrayList<Node>list = new ArrayList<>();
    static Queue<Node>q = new LinkedList<>();
    public static void main(String[] args)  throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[n][m][h];
        visited = new boolean[n][m][h];
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());

                for(int k=0; k<m; k++){
                    map[j][k][i] = Integer.parseInt(st.nextToken());
                    if(map[j][k][i]==1){
                        q.add(new Node(j,k,i,0));
                    }
                }
            }
        }
        if(q.size() ==0){
            System.out.println(-1);
            System.exit(0);
        }
        bfs();

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[j][k][i]==0){
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(max);
    }
    public static void bfs(){

        int before_day = 0;
        while(!q.isEmpty()){
            Node a = q.poll();
            max = Math.max(max,a.day);
            if(a.day != before_day){
                before_day = a.day;
                flush();
            }

            visited[a.x][a.y][a.h] = true;
            for(int i=0; i<6; i++){
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];
                int nh = a.h+dh[i];

                if(isRange(nx,ny,nh) && !visited[nx][ny][nh] && map[nx][ny][nh]==0){
                    list.add(new Node(nx,ny,nh,a.day+1));
                    visited[nx][ny][nh] = true;
                    q.add(new Node(nx,ny,nh, a.day+1));
                }
            }
        }


    }
    public static void flush(){
        for(int i=0; i<list.size(); i++){
            Node a = list.get(i);
            map[a.x][a.y][a.h] = 1;
        }
        list.clear();
    }
    public static boolean isRange(int x, int y, int k){
        if(x>=0 && y>=0 && x<n && y<m && k>=0 && k<h) return true;
        return false;
    }
}
class Node{
    int x,y,h,day;

    public Node(int x, int y, int h, int day) {
        this.x = x;
        this.y=y;
        this.h=h;
        this.day = day;
    }
}