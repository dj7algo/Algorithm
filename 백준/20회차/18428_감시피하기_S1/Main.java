import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char map[][];
    static int arr[];
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static ArrayList<Node>teacher = new ArrayList<>();
    static ArrayList<Node>list = new ArrayList<>();
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n+1][n+1];
        arr = new int [3];
        for(int i=1; i<=n; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j]=='X') list.add(new Node(i,j));
                if(map[i][j]=='T') teacher.add(new Node(i,j));
            }
        }

        // X인것만 조합으로 구하기
        dfs(0,0);
        System.out.println("NO");
    }
    public static void dfs(int level, int now){
        if(level == 3){
            isPossible();
            return;
        }

        for(int i=now; i<list.size(); i++){
            arr[level] = i;
            dfs(level+1,i+1);
        }
    }
    public static void isPossible(){

        for(int i=0; i<3; i++){
            Node a = list.get(arr[i]);
            map[a.x][a.y] = 'O';
        }
        boolean flag = true;
        for(Node a : teacher){

            for(int i=0; i<4; i++){
                int nx = a.x;
                int ny = a.y;

                while(isRange(nx,ny)){
                    if(map[nx][ny]=='O') break;
                    if(map[nx][ny]=='S'){
                        flag = false;
                        break;
                    }
                    nx+=dx[i];
                    ny+=dy[i];
                }
            }
        }
        if(flag){
            System.out.println("YES");
            System.exit(0);
        }
        for(int i=0; i<3; i++){
            Node a = list.get(arr[i]);
            map[a.x][a.y] = 'X';
        }
    }
    public static boolean isRange(int x, int y){
        if(x>=1 && y>=1 && x<=n && y<=n) return  true;
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
