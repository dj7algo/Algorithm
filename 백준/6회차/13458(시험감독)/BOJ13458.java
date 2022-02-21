import java.io.*;
import java.util.*;
public class BOJ13458 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rooms = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            rooms[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long supervisor = 0;

        for(int i = 0 ; i < N ; i++){
            supervisor++;
            if(rooms[i] < B) continue;
            rooms[i] -= B;
            if(rooms[i] % C != 0) supervisor++;
            supervisor += rooms[i] / C;
        }

        System.out.println(supervisor);
        br.close();
    }
}