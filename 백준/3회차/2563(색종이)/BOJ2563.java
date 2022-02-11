import java.io.*;
import java.util.*;
public class BOJ2563 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] drawing = new boolean[100][100];
        int count = 0;

        for(int n = 0 ; n < N ; n++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i = x ; i < x+10 ; i++){
                for(int j = y ; j < y+10 ; j++){
                    if(!drawing[i][j]){
                        drawing[i][j] = true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

    }
}
