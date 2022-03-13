import java.io.*;
import java.util.*;
public class Main {
    int map[][] = new int[9][9];

    static int dx [] = {0,0,-1,1,1,1,-1,-1};
    static int dy [] = {1,-1,0,0,1,-1,1,-1};
    static Node king = new Node();
    static Node rock = new Node();

    // 0 1 2 3 4   5 6   7
    // R L B T RT LT RB LB
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        String a = st.nextToken();  // 왕 위치
        String b = st.nextToken();  //  돌 위치
        int n = Integer.parseInt(st.nextToken());

        // 입력으로 A1 A2 이런식으로 들어오는데 일반적인 배열 좌표계때메 반대로 구하기
        king.x = a.charAt(1)-'0';
        king.y = a.charAt(0)-'A'+1;

        rock.x = b.charAt(1)-'0';
        rock.y = b.charAt(0)-'A'+1;

        for(int i=0; i<n; i++){
            String str = br.readLine();
            int x = king.x;
            int y = king.y;
            if(str.equals("R")){
                x+=dx[0];
                y+=dy[0];
                move(x,y,0);
            }
            if(str.equals("L")){
                x+=dx[1];
                y+=dy[1];
                move(x,y,1);
            }
            if(str.equals("B")){
                x+=dx[2];
                y+=dy[2];
                move(x,y,2);
            }
            if(str.equals("T")){
                x+=dx[3];
                y+=dy[3];
                move(x,y,3);
            }
            if(str.equals("RT")){
                x+=dx[4];
                y+=dy[4];
                move(x,y,4);
            }
            if(str.equals("LT")){
                x+=dx[5];
                y+=dy[5];
                move(x,y,5);
            }
            if(str.equals("RB")){
                x+=dx[6];
                y+=dy[6];
                move(x,y,6);
            }
            if(str.equals("LB")){
                x+=dx[7];
                y+=dy[7];
                move(x,y,7);
            }
        }
        char tmp = (char)(king.y+'A'-1);
        String king_ans = Character.toString(tmp)+king.x;


         tmp = (char)(rock.y+'A'-1);
        String rock_ans = Character.toString(tmp)+rock.x;

        System.out.println(king_ans);
        System.out.println(rock_ans);
    }
    public static void move(int x, int y, int dir){
        if(!isRange(x,y)) return;   // 왕이 맵 밖으로 이동한경우

        if(x==rock.x && y== rock.y){
            int tmp_x = rock.x+dx[dir];
            int tmp_y = rock.y+dy[dir];

            if(!isRange(tmp_x,tmp_y)) return;   // 돌이 맵 밖으로 나간경우
            rock.x = tmp_x;
            rock.y = tmp_y;
        }

        king.x=x;
        king.y=y;
    }
    public static void print(){
        System.out.println("king "+king.x + " "+king.y);
        System.out.println("rock "+rock.x + " "+rock.y);
    }
    public static boolean isRange(int x, int y){
        if(x>=1 && y>=1 && x<=8 && y<=8) return true;
        return false;
    }
}
class Node{
    int x,y;

}