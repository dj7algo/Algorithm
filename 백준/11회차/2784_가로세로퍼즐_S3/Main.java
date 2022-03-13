import java.io.*;

import java.util.*;
public class Main {
    static ArrayList<String>list = new ArrayList<>();
    static String [] arr = new String[6];
    static String [] tmp = new String[3];
    static boolean visited [] = new boolean[6];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        for(int i=0; i<6; i++){
            arr[i] = br.readLine();
            list.add(arr[i]);
        }

        dfs(0);
        System.out.println(0);
    }
    public static void dfs(int level){
        if(level ==3){
            boolean garo[] = new boolean[3];
            boolean sero[] = new boolean[3];
            int cnt = 0;
            for(String key : list){


                // 가로방향 먼저 검색

                for(int i=0 ;i<3; i++){
                    if(key.equals(tmp[i]) && !garo[i]){
                        cnt++;
                        garo[i] = true;
                        break;
                    }

                    StringBuilder sb = new StringBuilder();
                    sb.append(tmp[0].charAt(i));
                    sb.append(tmp[1].charAt(i));
                    sb.append(tmp[2].charAt(i));

                    if(sb.toString().equals(key) && !sero[i]){
                        cnt++;
                        sero[i] = true;
                        break;
                    }

                }

            }
            if(cnt == list.size()){
                for(int i=0; i<3; i++){
                    System.out.println(tmp[i]);
                }
                System.exit(0);
            }
            return;
        }

        for(int i=0; i<6; i++){
            if (visited[i]) return;
            tmp[level] = arr[i];
            dfs(level+1);
        }
    }
}
