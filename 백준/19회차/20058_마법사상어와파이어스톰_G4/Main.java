import java.io.*;

import java.util.*;
public class Main {
    static int n,q,l;
    static int map[][];
    static int copyMap[][];
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static boolean visited[][];
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        n = (int) Math.pow(2,n);

        map = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<q;i ++){
            copyMap = new int[n][n];
            l = Integer.parseInt(st.nextToken());
            l = (int) Math.pow(2,l);
            for(int j=0; j<n; j+=l){
                for(int k=0; k<n; k+=l){
                    rotate(j,k);
                }
            }
            copy();
            melt();
        }

        int total = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                total +=map[i][j];
            }
        }
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && map[i][j]!=0){
                    bfs(i,j);
                }
            }
        }
        System.out.println(total);
        System.out.println(max);

    }
    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x,y));

        int cnt = 0;

        while(!q.isEmpty()){
            Node a = q.poll();
            cnt++;
            for(int i=0; i<4; i++){
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];

                if(isRange(nx,ny) && !visited[nx][ny] && map[nx][ny]!=0){
                    q.add(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
        max = Math.max(max,cnt);
    }
    public static void melt(){

        ArrayList<Node>list = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==0) continue;
                int cnt =0;
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(!isRange(nx,ny)) continue;

                    if(map[nx][ny]!=0) cnt++;
                }

                if(cnt<3){
                    list.add(new Node(i,j));
                }
            }
        }


        for(Node a: list){
            map[a.x][a.y]--;
        }

    }
    public static void copy(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = copyMap[i][j];
            }
        }
    }
    public static void rotate(int x, int y){

        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                copyMap[i+x][j+y] = map[x+l-j-1][i+y];
            }
        }

    }
    public static boolean isRange(int x, int y){
        if(x>=0 && y>=0 && x<n && y<n) return  true;
        return  false;
    }
    public static void print(int[][] map){
        System.out.println(">>>>>>>>>>>>");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
class Node{
    int x,y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}