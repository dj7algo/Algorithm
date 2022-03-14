package BaekJoon;
import java.io.*;
import java.util.*;
public class BOJ2784 {
    static boolean[] visited;
    static List<String> word;
    static List<List<String>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = new ArrayList<>(6);
        visited = new boolean[6];
        String[] strs = new String[6];

        for(int i =0 ; i < strs.length ; i++){
            word.add(br.readLine());
        }

        perm(new int[3], 0, 3);

        if(list.isEmpty()) System.out.println(0);
        else{
            for(int i = 0 ; i < 3; i++){
                System.out.println(list.get(0).get(i));
            }
        }

    }

    static void perm(int[] ans, int cnt, int R){

        if(cnt == R){
            List<String> temp = new ArrayList<>(3);
            List<String> copy = new ArrayList<>(6);
            copy.addAll(word);

            for(int i = 0 ; i < 3 ; i++) {
                temp.add(word.get(ans[i]));
                copy.remove(word.get(ans[i]));
            }

            for(int i =0 ; i < 3 ; i++){
                String tempStr = "" + temp.get(0).charAt(i) + temp.get(1).charAt(i) + temp.get(2).charAt(i);
                if(copy.contains(tempStr)) copy.remove(tempStr);
                else return;
            }
            list.add(temp);
            return;
        }

        for(int i =0 ; i < 6 ;i++){
            if(!visited[i]){
                visited[i] = true;
                ans[cnt] = i;
                perm(ans, cnt+1, R);
                visited[i] = false;
            }
        }
    }
}
