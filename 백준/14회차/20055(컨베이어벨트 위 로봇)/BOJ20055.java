import java.io.*;
import java.util.*;
public class BOJ20055 {
    static int K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int step = 0;
        int[] con = new int[2*N];
        boolean[] robot = new boolean[2*N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < con.length ; i++){
            con[i] = Integer.parseInt(st.nextToken());
            if(con[i] == 0) K--;
        }

        while(true){
            step++;
            step1(con, robot, N-1);
            if(K<=0) break;
            step2(con, robot);
            if(K<=0) break;
            step3(con, robot);
            if(K <= 0) break;
        }

        System.out.println(step);
    }

    static void step1(int[] con, boolean[] robot, int Quit){
        int tmpC = con[con.length-1];

        if(robot[Quit]) robot[Quit] = false;

        for(int i = con.length-1 ; i > 0 ; i--){
            con[i] = con[i-1];
            robot[i] = robot[i-1];
        }
        con[0] = tmpC;
        robot[0] = false;

        if(robot[Quit]) robot[Quit] = false;
    }

    static void step2(int[] con, boolean[] robot){

        for(int i = robot.length - 1 ; i> 0 ; i--){
            if(i == robot.length-1){
                if(robot[i] && !robot[0] && con[0] != 0){
                    robot[0] = true;
                    robot[i] = false;
                    con[0]--;
                    if(con[0] == 0) K--;
                }
            }else{
                if(robot[i] && !robot[i+1] && con[i+1] != 0){
                    robot[i+1] = true;
                    robot[i] = false;
                    con[i+1]--;
                    if(con[i+1] == 0) K--;
                }
            }
        }
    }

    static void step3(int[] con, boolean[] robot){
        if(!robot[0] && con[0]!=0){
            robot[0] = true;
            con[0]--;
            if(con[0] == 0) K--;
        }
    }
}