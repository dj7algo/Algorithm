package A3967매직스타;

import java.io.*;
import java.util.*;

public class A3967매직스타 {
    static int[][] check = { { 0, 2, 5, 7 }, { 0, 3, 6, 10 }, { 7, 8, 9, 10 }, { 1, 2, 3, 4 }, { 1, 5, 8, 11 }, { 4, 6, 9, 11 } };
    static int[][] pos ={{0,4},{1,1},{1,3},{1,5},{1,7},{2,2},{2,6},{3,1},{3,3},{3,5},{3,7},{4,4}};
    static char[][] map = new char[5][10];
    static int[] star = new int[12];            // 별 모양 위에서부터 아래로 순서대로 저장
    static boolean[] visit = new boolean[12];   // A~L 방문처리
    static boolean answer;
    static ArrayList<Integer> change = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) map[i] = br.readLine().toCharArray();
        for(int i=0;i<12;i++) star[i] = map[pos[i][0]][pos[i][1]]; // 별모양 위치 순서대로 star에 저장
        
        for (int i = 0; i < 12; i++) {
            star[i] = (star[i] == 120) ? -1 : star[i] - 'A';        // ASCII코드 120이 'x' , 'x'이면 -1 아니면 알파벳을 숫자로 저장
            if (star[i] != -1) visit[star[i]] = true;               // 이미 알파벳이 있는 부분은 방문처리
            else change.add(i);                                     // 'x'이면 해당 부분은 바꿔줘야된다는 의미로 위치 저장
        }

        dfs(0);

        for(int i=0;i<12;i++) map[pos[i][0]][pos[i][1]]=(char) (star[i] + 'A');
        
        // System.out.println(Arrays.toString(star));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void dfs(int idx) {
        if (idx == change.size()) { // 'x'를 다 바꿔 줬으면
            if (Success()) answer = true;
            return;
        }

        for (int i = 0; i < 12; i++) {
            if (visit[i]) continue;
            star[change.get(idx)] = i;
            visit[i] = true;
            dfs(idx + 1);
            visit[i] = false;
            if (answer) return;
        }
    }

    private static boolean Success() {
        for (int i = 0; i < 6; i++) {
            int temp = 0;
            for (int j = 0; j < 4; j++) {
                temp += star[check[i][j]];
            }
            if (temp != 22) return false; // 0~11로 계산하였으므로 합이 22가 되어야 함.
        }
        return true;
    }
}
