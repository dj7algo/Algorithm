import java.io.*;

import java.util.*;
public class Main {
    static int n;
    static int map[][];
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getD1D2();
        System.out.println(ans);
    }
    public static void getD1D2(){
        // d1~d2 구하기
        for(int i=1 ;i<n; i++){
            for(int j=1; j<n; j++){
                // d1,d2
                getXY(i,j);
            }
        }
    }
    public static void getXY(int d1, int d2){
        // 기준점 x,y 구하기
        for(int i=1; i<=n; i++){
            // x조건  1<=x < x+d1+d2 <=N
            if(i+d1+d2>n) break;

            for(int j=1; j<=n; j++){
                // y 조건 1<= y-d1 < y < y+d2<=N

                if (1 > j-d1) continue;
                if(j+d2 >n) continue;

                solve(d1,d2,i,j);

            }
        }

    }
    public static void solve(int d1, int d2, int x, int y){


        int tmp[][] = new int[n+1][n+1];
        // 경계선 1 (x,y), (x+1,y-1) (x+d1,y-d1)

        int jj = y;
        for(int i=x; i<=x+d1; i++){
            tmp[i][jj--] = 5;
        }
        // 경계선2 (x,y) (x+1,y+1) (x+d2, y+d2)
        jj = y;
        for(int i=x; i<=x+d2; i++){
            tmp[i][jj++] = 5;
        }

        // 경계선3 (x+d1, y-d1)  (x+d1+1, y-d1+1) (x+d1+d2, y-d1+d2)
        jj = y-d1;
        for(int i=x+d1; i<=x+d1+d2; i++){
            tmp[i][jj++] = 5;
        }
        // 경계선 4 (x+d2, y+d2) (x+d2+1, y+d2-1)  (x+d2+d1, y+d2-d1)
        jj = y+d2;
        for(int i=x+d2; i<=x+d2+d1; i++){
            tmp[i][jj--] = 5;
        }

        // 1번 선거구~ 4번 선거구 나누기

        // 1번 선거구  1<=r <x+d1 , 1<=c<=y
        for(int i=1; i<x+d1; i++){
            for(int j=1; j<=y; j++){
                if(tmp[i][j] ==5) break;
                tmp[i][j] = 1;
            }
        }
        // 2번선거구   1<=r<=x+d2 , y<c<=N
        for(int i=1; i<=x+d2; i++){
            for(int j=n; j>=y+1; j--){
                if(tmp[i][j]==5) break;
                tmp[i][j] = 2;
            }
        }

        // 3번선거구 x+d1 <=r <=N , 1<=c<y-d1+d2
        for(int i=x+d1; i<=n; i++){
            for(int j=1; j<y-d1+d2; j++){
                if(tmp[i][j]==5) break;
                tmp[i][j] = 3;
            }
        }

        // 4번선거구  x+d2<r<=N,  y-d1+d2<=c<=N
        for(int i=x+d2+1; i<=n; i++){
            for(int j=n; j>=y-d1+d2; j--) {
                if(tmp[i][j]==5) break;
                tmp[i][j] = 4;
            }
        }



        // 경계 안에 있는 공간
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(tmp[i][j]==0) tmp[i][j] = 5;
            }
        }

        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        boolean five = false;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(tmp[i][j]==1) one = true;
                if(tmp[i][j]==2) two = true;
                if(tmp[i][j]==3) three = true;
                if(tmp[i][j]==4) four = true;
                if(tmp[i][j]==5) five = true;
            }
        }

        if(!one || !two || !three || !four || !five) return;

        boolean visited[][] = new boolean[n+1][n+1];

        max = 0;
        min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(!visited[i][j]) bfs(i,j,visited,tmp);
            }
        }

        ans = Math.min(ans,max-min);

    }
    public static void bfs(int x, int y, boolean visited[][], int tmp[][]){
        visited[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        int num = tmp[x][y];
        int sum = 0;
        while(!q.isEmpty()){
            Node a = q.poll();
            sum+=map[a.x][a.y];
            for(int i=0; i<4; i++){
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];
                if(isRange(nx,ny) && !visited[nx][ny] && tmp[nx][ny] == num){
                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny));
                }
            }
        }
        max = Math.max(max,sum);
        min = Math.min(min,sum);

    }
    public static void print(int tmp[][]){
        System.out.println(">>>>>>>>>>>");
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isRange(int x, int y){
        if(x>=1 && y>=1 && x<=n && y<=n) return true;
        return false;
    }
}
class Node{
    int x,y;
    Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}