import java.io.*;
import java.util.*;
public class Main {

    static int n;
    static char map[][];
    static int dx[] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(isRange(nx,ny) && map[i][j]!=map[nx][ny]){
                        char tmp = map[i][j];
                        map[i][j] = map[nx][ny];
                        map[nx][ny] = tmp;
                        ans = Math.max(ans,getCnt());

                        map[nx][ny] = map[i][j];
                        map[i][j] = tmp;
                    }
                }
            }
        }
        System.out.println(ans);
    }
    public static int getCnt(){
        int cnt = 0;
        int tmp = 1;
        for(int i=0; i<n; i++){
            tmp = 1;
            char color = map[i][0]; // 기준 컬러
            for(int j=1; j<n; j++){
                if(color == map[i][j]){
                    tmp++;
                }

                else{
                    // 다른색깔 나왔을 경우 여태까지 먹었던 사탕의 개수 최댓값과 비교
                    cnt = Math.max(cnt,tmp);
                    // 색깔, 갯수 초기화
                    tmp = 1;
                    color = map[i][j];
                }
            }
            cnt = Math.max(cnt,tmp);    // 마지막 열까지 같은 색상인경우 비교가 안되는 케이스 있으니 비교과정 넣어주기
        }


        for(int i=0; i<n; i++){     // 열
            tmp = 1;
            char color = map[0][i]; // 기준 컬러
            for(int j=1; j<n; j++){
                if(color == map[j][i]){
                    tmp++;
                }

                else{
                    // 다른색깔 나왔을 경우 여태까지 먹었던 사탕의 개수 최댓값과 비교
                    cnt = Math.max(cnt,tmp);
                    // 색깔, 갯수 초기화
                    tmp = 1;
                    color = map[j][i];
                }
            }
            cnt = Math.max(cnt,tmp);    // 마지막 열까지 같은 색상인경우 비교가 안되는 케이스 있으니 비교과정 넣어주기
        }


        return cnt;
    }
    public static boolean isRange(int x, int y){
        if(x>=0 && y>=0 && x<n && y<n) return true;
        return false;
    }
}
