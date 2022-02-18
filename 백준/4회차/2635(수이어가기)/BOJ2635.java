import java.io.*;
import java.util.*;
public class BOJ2635 {
    static int arr[];
    static ArrayList<Integer> tmp;
    static int max_count, count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[0];
        int N = Integer.parseInt(br.readLine());
        for(int i = N ; i > 0 ; i--){
            tmp = new ArrayList<>();
            tmp.add(N);
            tmp.add(i);
            makearr(i, N);
            if(max_count < tmp.size()) {
                max_count = tmp.size();
                arr = new int[max_count];
                for(int j = 0 ; j < arr.length ; j++){
                    arr[j] = tmp.get(j).intValue();
                }
            }
        }
        System.out.println(max_count);
        for(int n : arr)
            System.out.print(n + " ");
    }

    static void makearr(int cnt, int before){
        if(before - cnt < 0) return;

        int res = before - cnt;
        tmp.add(res);
        makearr(res, cnt);
    }
}
