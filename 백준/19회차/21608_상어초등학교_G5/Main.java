import java.io.*;

import java.util.*;
public class Main {
    static int n;
    static int map[][];
    static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static HashMap<Integer,ArrayList<Integer>> hashMap = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        for(int i=1; i<=n*n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            ArrayList<Integer>likeList = new ArrayList<>();

            for(int j=0; j<4; j++){
                likeList.add(Integer.parseInt(st.nextToken()));
            }
            hashMap.put(num,likeList);      // 각 사람별 좋아하는 친구 저장
            solve(num,likeList);
        }

        int ans = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                int num = map[i][j];
                int cnt = 0;
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(!isRange(nx,ny)) continue;

                    ArrayList<Integer> likeList = hashMap.get(num);
                    if(likeFriends(map[nx][ny],likeList)) cnt++;
                }
                if(cnt==1) ans+=1;
                if(cnt==2) ans+=10;
                if(cnt==3)ans+=100;
                if(cnt==4) ans+=1000;

            }
        }
        System.out.println(ans);
    }
    public static void solve(int num,ArrayList<Integer>likeList){
        ArrayList<Node>tmp = new ArrayList<>();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j]!=0) continue;  // 이미 기존에 차있는 자리 스킵

                int likeCnt = 0;        // 좋아하는 친구의 개수
                int empty = 0;          // 빈칸 개수
                for(int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(!isRange(nx,ny)) continue;;

                    if(likeFriends(map[nx][ny],likeList)){
                        likeCnt++;
                    }
                    if(map[nx][ny]==0) empty++;
                }
                tmp.add(new Node(i,j,likeCnt,empty));
            }
        }

        Collections.sort(tmp);

        Node a = tmp.get(0);
        map[a.x][a.y] = num;

    }
    public static boolean likeFriends(int num,ArrayList<Integer>likeList){
        for(int i=0; i<likeList.size(); i++){
            if(num == likeList.get(i)) return  true;
        }
        return  false;
    }
    public static boolean isRange(int x, int y){
        if(x>=1 && y>=1 && x<=n && y<=n) return true;
        return false;
    }
}
class Node implements  Comparable<Node>{
    int x,y,like,empty;

    public Node(int x, int y, int like, int empty) {
        this.x = x;
        this.y = y;
        this.like = like;
        this.empty = empty;
    }

    @Override
    public int compareTo(Node o) {
        if(this.like == o.like){
            if(this.empty == o.empty){
                if(this.x==o.x){
                    return this.y-o.y;
                }
                return this.x-o.x;
            }
            return o.empty - this.empty;
        }
        return o.like - this.like;
    }
}