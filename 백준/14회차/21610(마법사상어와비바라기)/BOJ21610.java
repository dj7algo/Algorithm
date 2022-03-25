import java.io.*;
import java.util.*;
public class BOJ21610 {

    static class Cloud implements Cloneable{
        int i;
        int j;
        Cloud(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] di = {-1, -1, 1, 1};
        int[] dj = {-1, 1, 1, -1};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] sky = new int[N+1][N+1];
        ArrayList<Cloud> clouds = new ArrayList<>();
        clouds.add(new Cloud(N, 1));
        clouds.add(new Cloud(N, 2));
        clouds.add(new Cloud(N-1, 1));
        clouds.add(new Cloud(N-1, 2));

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++){
                sky[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            move(clouds, d, s, N);
            for(int j = 0 ; j < clouds.size() ;j++){
                sky[clouds.get(j).i][clouds.get(j).j]++;
            }
            for(int j = 0 ; j < clouds.size() ; j++) {
                int curI = clouds.get(j).i;
                int curJ = clouds.get(j).j;
                int count = 0;
                for(int k = 0 ; k < 4 ; k++){
                    int ni = curI + di[k];
                    int nj = curJ + dj[k];
                    if(1 <= ni && ni <= N && 1 <= nj && nj <= N && sky[ni][nj]!=0){
                        sky[curI][curJ]++;
                    }
                }
                sky[curI][curJ] += count;
            }
            clouds = makeClouds(sky, clouds, N);
        }

        int sum = 0;

        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ;j <= N ; j++){
                sum += sky[i][j];
            }
        }

        System.out.println(sum);
    }

    static void move(ArrayList<Cloud> cloud, int d, int s, int N){
        for(int i = 0 ; i < cloud.size() ; i++){
            if(s >= N) s = s % N;
            if(d==1) cloud.get(i).j = moveJL(cloud.get(i).j, s, N);
            if(d==2){ cloud.get(i).j=moveJL(cloud.get(i).j, s, N); cloud.get(i).i=moveIU(cloud.get(i).i, s, N); }
            if(d==3){ cloud.get(i).i=moveIU(cloud.get(i).i, s, N); }
            if(d==4){ cloud.get(i).i=moveIU(cloud.get(i).i, s, N); cloud.get(i).j=moveJR(cloud.get(i).j, s, N); }
            if(d==5){ cloud.get(i).j=moveJR(cloud.get(i).j, s, N);}
            if(d==6){ cloud.get(i).i=moveID(cloud.get(i).i, s, N); cloud.get(i).j=moveJR(cloud.get(i).j, s, N);}
            if(d==7){ cloud.get(i).i=moveID(cloud.get(i).i, s, N);}
            if(d==8){ cloud.get(i).i=moveID(cloud.get(i).i, s, N); cloud.get(i).j=moveJL(cloud.get(i).j, s, N);}
        }

    }

    static int moveIU(int i, int s, int N){
        if(i - s <= 0) return N + (i - s);
        return i - s;
    }
    static int moveID(int i, int s, int N){
        if(i + s > N) return (i + s) % N;
        return i+s;
    }
    static int moveJL(int j, int s, int N){
        if(j - s <= 0) return N + (j - s);
        return j - s;
    }
    static int moveJR(int j, int s, int N){
        if(j + s > N) return (j + s) % N;
        return j+s;
    }

    static ArrayList<Cloud> makeClouds(int[][] sky, ArrayList<Cloud> clouds, int N){
        ArrayList<Cloud> news = new ArrayList<>();
        for(int i = 1 ; i <= N ; i++){
            out: for(int j = 1 ; j <= N ; j++){
                for(int k = 0 ; k < clouds.size() ; k++){
                    if(clouds.get(k).i == i && clouds.get(k).j == j) continue out;
                }
                if(sky[i][j] >= 2){
                    news.add(new Cloud(i, j));
                    sky[i][j] -= 2;
                }
            }
        }
        return news;
    }
}