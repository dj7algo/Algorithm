import java.io.*;
import java.util.*;
public class Main {

    static int n;
    static char map[][];
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static int min;
    static int cnt;
    public static void main(String[] args)  throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            min = Integer.MAX_VALUE;
            cnt = Integer.MAX_VALUE;
            map = new char[5][9];
            for(int j=0; j<5; j++){
                String str = br.readLine();
                for(int k=0; k<9; k++){
                    map[j][k] = str.charAt(k);
                }
            }


            dfs(0);
            System.out.println(cnt+" "+min);
            br.readLine();
        }
    }
    public static void dfs(int level){

        int tmp_cnt = getCnt();

        if(cnt > tmp_cnt){
            cnt = tmp_cnt;
            min = level;
        }


        for(int i=0; i<5; i++){
            for(int j=0; j<9; j++){
                if(map[i][j] =='o'){
                    for(int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];

                        if(isRange(nx,ny) && map[nx][ny]=='o'){
                            int nnx = nx+dx[k];
                            int nny = ny+dy[k];

                            if(isRange(nnx,nny) && map[nnx][nny]=='.'){
                                map[i][j] = '.';
                                map[nx][ny] = '.';
                                map[nnx][nny] = 'o';
                                dfs(level+1);
                                map[i][j]= 'o';
                                map[nx][ny] = 'o';
                                map[nnx][nny] = '.';
                            }
                        }
                    }
                }
            }
        }


    }
    public static int getCnt(){
        int cnt = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<9; j++){
                if(map[i][j] =='o') cnt++;
            }
        }
        return cnt;
    }
    public static boolean isRange(int x, int y){
        if(x>=0 && y>=0 && x<5 && y<9) return true;
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