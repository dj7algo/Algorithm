import java.io.*;

import java.util.*;
public class Main {

    static boolean alpha[] = new boolean[26];
    static char[] word;
    static int n,k;
    static int max = 0;
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 무조건 포함해야 되는 알파벳 a , n , t, i, c
        alpha['a'-'a'] = true;
        alpha['n'-'a'] = true;
        alpha['t'-'a'] = true;
        alpha['i'-'a'] = true;
        alpha['c'-'a'] = true;

        for (int i=0; i<n; i++){
            list.add(br.readLine());
        }

        if(k<5){
            System.out.println(0);
            System.exit(0);
        }
        word = new char[k-5];

        dfs(0,0);

        System.out.println(max);
    }
    public static void dfs(int level, int now){
        if(level == k-5){
            int cnt = getCnt();
            max = Math.max(max,cnt);

            return;
        }


        for(int i=now; i<26; i++){

            if(alpha[i]) continue;  // a , n , t , c,  i 는 기본으로 갖고가니 pass

            int tmp = i+'a';
            char ch = (char) tmp;
            word[level] = ch;
            dfs(level+1, i+1);
        }
    }
    public static int getCnt(){
        boolean tmp_alpha[] = new boolean[26];

        tmp_alpha['a'-'a'] = true;
        tmp_alpha['n'-'a'] = true;
        tmp_alpha['t'-'a'] = true;
        tmp_alpha['i'-'a'] = true;
        tmp_alpha['c'-'a'] = true;

        for(int i=0; i<word.length; i++){
            tmp_alpha[word[i]-'a'] = true;
        }

        int cnt = 0;
        for(int i=0; i<list.size(); i++){
            boolean flag = true;
            String str = list.get(i);

            for(int j=0; j<str.length(); j++){
                if(!tmp_alpha[str.charAt(j)-'a']){
                    flag = false;
                }
            }
            if(flag) cnt++;
        }

        return cnt;
    }
}
