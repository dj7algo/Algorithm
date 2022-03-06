import java.io.*;

// https://congsoony.tistory.com/112?category=954270
public class A1331나이트투어 {
    static int moveX[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int moveY[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static String str[];
    static boolean visit[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = new String[37];
        for (int i = 0; i < 36; i++) {
            str[i] = br.readLine();
        }
        str[36] = str[0]; // 마지막칸이 시작점으로 다시 되돌아 와야함.
        int index = 0;
        visit = new boolean[6][6];
        boolean check = true;
        while (index < 36) {
            String current = str[index];
            String next = str[index + 1];

            char current_x = current.charAt(0);
            char current_y = current.charAt(1);

            visit[current_y - '0' - 1][current_x - 'A'] = true;

            char next_x = next.charAt(0);
            char next_y = next.charAt(1);

            int diff_x = Math.abs(current_x - next_x);
            int diff_y = Math.abs(current_y - next_y);
            boolean isTrue = false;
            for (int d = 0; d < 8; d++) {
                if (moveX[d] == diff_x && moveY[d] == diff_y) {
                    isTrue = true;
                    break;
                }
            }
            if (!isTrue) {
                check = false;
                System.out.println("Invalid");
                return;
            }
            if (visit[next_y - '0' - 1][next_x - 'A']) { // 이미 방문한 곳이라면
                if (index != 35) { // 마지막 방문 칸은 시작점으로 같음
                    check = false;
                    System.out.println("Invalid");
                    return;
                }
            }
            index++;
        }
        if (check)
            System.out.println("Valid");
    }
}