import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class BOJ13300 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        int[][] students = new int[2][7];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            students[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
        }

        for(int i = 0 ; i < students.length ; i++){
            for(int j = 0 ; j < students[i].length ; j++){
                count += students[i][j] / K;
                if(students[i][j] % K != 0) count++;
            }
        }
        System.out.println(count);
    }
}
