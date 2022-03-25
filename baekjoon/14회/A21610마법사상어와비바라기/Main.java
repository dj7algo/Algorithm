package A21610마법사상어와비바라기;

import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = {0,-1,-1,-1,0,1,1,1};
  static int[] dy = {-1,-1,0,1,1,1,0,-1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken()); // 격자 크기
    int M = Integer.parseInt(st.nextToken()); // 이동 횟수

    boolean visit[][] = new boolean[N][N]; // 방문처리
    int[][] map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[][] mapCopy = new int[N][N];
    for(int a=0;a<map.length;a++){
      System.arraycopy(map, 0, mapCopy, 0, map[0].length);
    }

    Queue<Pos> cloude = new LinkedList<>();
    cloude.add(new Pos(N-1,1));
    cloude.add(new Pos(N-1,2));
    cloude.add(new Pos(N,1));
    cloude.add(new Pos(N,2));

    for(int i=0;i<M;i++){
      st = new StringTokenizer(br.readLine(), " ");
      int dir = Integer.parseInt(st.nextToken())-1;
      int s = Integer.parseInt(st.nextToken());
      // 1. 비 구름 이동
      for(int j=0;j<cloude.size();j++){ // 구름 수 만큼 반복
        Pos pos = cloude.poll();
        int nx = pos.x, ny = pos.y;
        for(int a=0;a<s;a++){ // 이동 거리 만큼 반복
          nx += dx[dir];
          ny += dy[dir];
          if(nx<0) nx +=N;
          else if (nx >= N) nx -= N;
          if(ny<0) ny +=N;
          else if(ny>=N) ny-=N;
        }
        // 2. 비가 내리고
        visit[nx][ny]=true;
        mapCopy[nx][ny]++;
        // 4방탐색(대각선으로)
        int count=0;
        for(int d=1;d<=8;d+=2){ 
          int nnx = nx+dx[d];
          int nny = ny+dy[d];
          if(nnx<0 || nnx>=N || nny<0 || nny>=N) continue;
          if(map[nnx][nny]>0) count++;
        }
        mapCopy[nx][ny]+=count;
      }
      for (int k = 0; k < N; k++) { 
        for (int l = 0; l < N; l++) {
          if(mapCopy[k][l]>=2&& !visit[k][l]){
            mapCopy[k][l]-=2;
            cloude.add(new Pos(k,l));
          }
        }
      }
      for (int a = 0; a < map.length; a++) {
        System.arraycopy(mapCopy, 0, map, 0, map[a].length);
      }
    }
    int result = 0;
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++) result+=map[i][j];
    }
    System.out.println(result);
  }
}

class Pos {
  int x,y;
  Pos(int x,int y){
    this.x=x;
    this.y=y;
  }
}
