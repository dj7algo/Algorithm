import java.io.*;
import java.util.*;

public class BOJ2605 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> student = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            student.add(Integer.parseInt(st.nextToken()), i);
        }

        for(int i = N-1 ; i >= 0 ; i--){
            System.out.print(student.get(i) + " ");
        }
    }
}
