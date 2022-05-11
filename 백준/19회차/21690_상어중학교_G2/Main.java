import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int map[][];
    static boolean visited[][];
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static int ans = 0;
    static final int BLANK = -2;
    static final int RAINBOW = 0;
    static final int BLACK = -1;
    static boolean flag = false;
    static ArrayList<Node>list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int [n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            list.clear();
            flag = false;
            visited = new boolean[n][n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    rainbowSetting();
                    if(!visited[i][j] && map[i][j]>=1) {
                        bfs(i,j,map[i][j]);
                    }
                }
            }
            if(!flag) break;

            Collections.sort(list);
            Node a = list.get(0);
            ArrayList<Node>tmp = bfs2(a.x, a.y, map[a.x][a.y]);
            remove(tmp);
            gravity();
            rotate();
            gravity();
        }
        System.out.println(ans);
    }
    public static void print() {
        System.out.println(">>>>>>>>");
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void remove(ArrayList<Node>tmp) {

        for(Node a :tmp) {
            map[a.x][a.y] = BLANK;
        }
        ans+= (tmp.size()*tmp.size());
    }
    public static ArrayList<Node> bfs2(int x, int y, int num) {
        ArrayList<Node>tmp = new ArrayList<>();
        boolean visited2 [][] = new boolean[n][n];
        tmp.add(new Node(x, y));

        Queue<Node>q = new LinkedList<Node>();
        q.add(new Node(x, y));
        visited2[x][y] = true;

        while(!q.isEmpty()) {
            Node a = q.poll();

            for(int i=0; i<4; i++) {
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];

                if(isRange(nx, ny) && !visited2[nx][ny]) {
                    if(map[nx][ny] == num) {
                        visited2[nx][ny] = true;
                        q.add(new Node(nx, ny));
                        tmp.add(new Node(nx, ny));
                    }
                    if(map[nx][ny] == RAINBOW) {
                        visited2[nx][ny] = true;
                        q.add(new Node(nx, ny));
                        tmp.add(new Node(nx, ny));
                    }
                }
            }
        }
        return tmp;
    }
    public static void rotate() {
        int copy_map[][] = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                copy_map[i][j] = map[j][n-i-1];
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = copy_map[i][j];
            }
        }
    }
    public static void gravity() {
        for(int j=0; j<n; j++) {
            for(int i=n-2; i>=0; i--) {
                if(map[i][j]!=BLACK && map[i][j]!=BLANK) {
                    int nx = i+1;

                    while(nx<n) {
                        if(map[nx][j]!=BLANK) break;
                        nx++;
                    }
                    nx--;
                    if(nx ==i) continue;
                    map[nx][j] = map[i][j];
                    map[i][j] = BLANK;


                }
            }
        }
    }
    public static void bfs(int x, int y, int num) {
        Queue<Node>q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x, y));
        int size = 1;
        int rainbowCnt = 0;


        while(!q.isEmpty()) {
            Node a = q.poll();

            for(int i=0; i<4; i++) {
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];

                if(isRange(nx, ny) && !visited[nx][ny]) {
                    if(map[nx][ny]==RAINBOW) {
                        rainbowCnt++;
                        size++;
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                    if(map[nx][ny] == num) {
                        size++;
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        if(size<2) return;
        flag = true;
        list.add(new Node(x, y, rainbowCnt, size));
    }
    public static void rainbowSetting() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == RAINBOW) visited[i][j] = false;
            }
        }
    }
    public static boolean isRange(int x, int y) {
        if(x>=0 && y>=0 && x<n && y<n) return true;
        return false;
    }
}
class Node implements Comparable<Node>{
    int x,y,rainbowCnt,size;

    public Node(int x, int y) {
        this.x=x;
        this.y=y;
    }
    public Node(int x, int y, int rainbowCnt, int size) {
        this.x = x;
        this.y = y;
        this.rainbowCnt = rainbowCnt;
        this.size = size;
    }
    @Override
    public int compareTo(Node o) {
        if(this.size == o.size) {
            if(this.rainbowCnt == o.rainbowCnt) {
                if(this.x==o.x) {
                    return o.y-this.y;
                }
                return o.x-this.x;
            }
            return o.rainbowCnt - this.rainbowCnt;
        }
        return o.size - this.size;
    }

}