import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static double percent[];
    static boolean visited[][];
    static double ans = 0;
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        percent = new double[4];

        for(int i=0; i<4; i++){
            percent[i] = Double.parseDouble(st.nextToken())*0.01;
        }

        visited = new boolean[30][30];
        visited[15][15] = true;
        dfs(15,15,1,0);
        System.out.println(ans);

    }
    public static void dfs(int x, int y, double sum, int cnt){
        if(cnt ==n){
            ans+=sum;
            return ;
        }

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(isRange(nx,ny) && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx,ny,sum*percent[i], cnt+1);
                visited[nx][ny] = false;
            }
        }


    }
    public static boolean isRange(int x, int y){
        if(x>=1 && y>=1 && x<=29 && y<=29) return true;
        return false;
    }
}
// 14 13 12 11 10
// 9 8 7 6 5
// 4 3 2 1