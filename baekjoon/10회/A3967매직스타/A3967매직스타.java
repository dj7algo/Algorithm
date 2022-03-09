package A3967매직스타;

import java.io.*;
import java.util.*;

/*
1. 바깥에 조그만 삼각형 세개 숫자의 합은 반대편 조그만 삼각형 숫자의 합과 같다.
2. 두 개의 큰 삼각형의 세개의 꼭지점 숫자의 합은 항상 같다.
3. 다이아몬드의 4개 꼭지점 숫자의 합은 모두 26이다.
4. 여섯 개의 꼭지점에 있는 숫자의 합은 항상 짝수이다.
5. 여섯 개의 꼭지점이 모두 짝수이거나 홀수인 경우는 없다.
*/

public class A3967매직스타 {
    static int[][] check = { { 0, 2, 5, 7 }, { 0, 3, 6, 10 }, { 7, 8, 9, 10 }, { 1, 2, 3, 4 }, { 1, 5, 8, 11 }, { 4, 6, 9, 11 } };
    static char[][] map = new char[5][10];
    static int[] star = new int[12];
    static boolean[] visit = new boolean[26];
    static boolean answer;
    static ArrayList<Integer> change = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) map[i] = br.readLine().toCharArray();
        star[0] = map[0][4];
        star[1] = map[1][1];
        star[2] = map[1][3];
        star[3] = map[1][5];
        star[4] = map[1][7];
        star[5] = map[2][2];
        star[6] = map[2][6];
        star[7] = map[3][1];
        star[8] = map[3][3];
        star[9] = map[3][5];
        star[10] = map[3][7];
        star[11] = map[4][4];
        for (int i = 0; i < 12; i++) {
            star[i] = (star[i] == 120) ? -1 : star[i] - 'A';
            if(star[i]!=-1) visit[star[i]]=true;
            else change.add(i);
        }

        dfs(0);

        map[0][4]= (char) (star[0]+'A');
        map[1][1]= (char) (star[1]+'A');
        map[1][3]= (char) (star[2]+'A');
        map[1][5]= (char) (star[3]+'A');
        map[1][7]= (char) (star[4]+'A');
        map[2][2]= (char) (star[5]+'A');
        map[2][6]= (char) (star[6]+'A');
        map[3][1]= (char) (star[7]+'A');
        map[3][3]= (char) (star[8]+'A');
        map[3][5]= (char) (star[9]+'A');
        map[3][7]= (char) (star[10]+'A');
        map[4][4] = (char) (star[11] + 'A');

        //System.out.println(Arrays.toString(star));
        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void dfs(int idx) {
        if(answer) return;
        if(idx==change.size()){
            if(Success()) answer =true;
            return;
        }

        for(int i=0;i<12;i++){
            if(visit[i]) continue;
            star[change.get(idx)]=i;
            visit[i]=true;
            dfs(idx+1);
            visit[i]=false;
            if(answer) return;
        }
    }

    private static boolean Success(){
        for(int i=0;i<6;i++){
            int temp=0;
            for(int j=0;j<4;j++){
                temp += star[check[i][j]];
            }
            if(temp!=22) return false; // 0~11로 계산하였으므로 합이 22가 되어야 함.
        }
        return true;

    }
}
