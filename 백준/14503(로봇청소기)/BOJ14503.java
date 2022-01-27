import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;



public class BOJ14503 {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int robot_i = Integer.parseInt(st.nextToken());
        int robot_j = Integer.parseInt(st.nextToken());
        int robot_d = Integer.parseInt(st.nextToken());


        List<CleanSite> not_clean = new ArrayList<>();
        for(int i = 0 ; i < room.length ; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0 ; j < room[i].length ; j++){
                room[i][j] = (int)line[2*j] - '0';
                if(room[i][j] == 0){
                    not_clean.add(new CleanSite(i, j));
                }
            }
        }
        br.close();

        int clean = 0;


        boolean is_pos = true;

        while(is_pos){
            System.out.println("check" + robot_i + " " + robot_j);
            if((room[robot_i][robot_j] == 0) && (not_clean.contains(new CleanSite(robot_i, robot_j)))) {
                System.out.println("cleaning");
                System.out.println("[" + robot_i + ", " + robot_j + "]");
                not_clean.remove(not_clean.indexOf(new CleanSite(robot_i, robot_j)));
                System.out.println(not_clean.contains(new CleanSite(robot_i, robot_j)));
                clean++;

                for(CleanSite s : not_clean){
                    System.out.print("[" + s.getX() + ", " + s.getY() + "]\t");
                }
            }
            System.out.println();

            //현재 방향의 왼쪽방향으로 회전하면서 확인
            boolean flag = false;
            int d = robot_d;
            for(int i = 0 ; i < 4 ; i++) {
                System.out.println("subcheck" + i);
                d = d == 0 ? 3 : d - 1;
                int ni = robot_i + di[d];
                int nj = robot_j + dj[d];
                System.out.println("현재 방향 : " + d + "| " + ni + ", " + nj);
                //인덱스 나가는지 확인
                if (ni >= 0 && ni <= room.length && nj >= 0 && nj <= room[0].length) {
                    if (not_clean.contains(new CleanSite(ni, nj))) {
                        System.out.println("not clean " + ni + ", " + nj);
                        robot_i = ni;
                        robot_j = nj;
                        robot_d = d;
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag){
                System.out.println("all clean or wall");
                d = (robot_d + 2) % 4;
                int ni = robot_i + di[d];
                int nj = robot_j + dj[d];
                if(ni > 0 && ni < room.length && nj > 0 && nj < room[0].length){
                    if(room[ni][nj] == 0) {
                        System.out.println("후진 : 현재 - " + robot_i + ", " + robot_j + " | 후진 : - " + ni + ", " + nj);
                        robot_i = ni;
                        robot_j = nj;
                    }else{
                        System.out.println("backward is wall, finish clean");
                        is_pos = false;
                    }
                }else{
                    System.out.println("backward is wall, finish clean");
                    is_pos = false;
                }
            }
        }
        System.out.println(clean);
//        StringBuilder sb = new StringBuilder(clean);
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
    }
}

class CleanSite{
    private int x;
    private int y;

    public CleanSite(int x, int y){
        setX(x);
        setY(y);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CleanSite cleanSite = (CleanSite) o;
        return x == cleanSite.x && y == cleanSite.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}