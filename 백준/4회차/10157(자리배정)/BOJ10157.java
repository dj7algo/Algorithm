import java.io.*;
import java.util.*;
public class BOJ10157 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int R = Integer.parseInt(br.readLine());

        int[][] seat = new int[M+1][N+1];
        int[] di = {1, 0, -1, 0};
        int[] dj = {0, 1, 0, -1};

        int i = 1;
        int j = 1;
        int startI = 1;
        int endI = M;
        int startJ = 1;
        int endJ = N;
        int count = 1;
        int d = 0;

        seat[i][j] = count++;

        if (R > N*M) {
            System.out.println(0);
            return;
        }

        while(count <= R){
            int ni = i + di[d];
            int nj = j + dj[d];

            if(startI <= ni && ni <= endI && startJ <= nj && nj <= endJ){
                i = ni;
                j = nj;
                seat[i][j] = count++;
                if(d == 0 && i == endI){
                    d += 1;
                    startJ++;
                }else if(d == 1 && j == endJ){
                    d+=1;
                    endI--;
                }else if(d==2 && i == startI){
                    d+=1;
                    endJ--;
                }else if(d==3 && j == startJ){
                    d = 0;
                    startI++;
                }
            }
        }

        System.out.println(j + " " + i);
    }
}
