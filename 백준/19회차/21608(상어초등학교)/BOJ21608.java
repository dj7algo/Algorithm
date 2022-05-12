import java.io.*;
import java.util.*;

public class BOJ21609 {
    static int[][] blocks;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int N;

    static class Block {
        int r, c;

        Block(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Group {
        int size;
        int[] base;
        int rainbow;
        List<Block> block;

        Group(int r, int c) {
            this.size = 1;
            if (blocks[r][c] > 0) {
                this.base = new int[]{r, c};
                this.rainbow = 0;
            } else {
                this.base = new int[]{N, N};
                this.rainbow = 1;
            }
            this.block = new LinkedList<>();
            this.block.add(new Block(r, c));
        }

        void add(int r, int c) {
            this.size++;
            block.add(new Block(r, c));
            if (blocks[r][c] == 0) rainbow++;
            else check(r, c);
        }

        void check(int r, int c) {
            if (this.base[0] > r) this.base = new int[]{r, c};
            else if (this.base[0] == r && this.base[1] > c) this.base = new int[]{r, c};
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int score = 0;

        blocks = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            PriorityQueue<Group> g = new PriorityQueue<>(new Comparator<Group>() {
                @Override
                public int compare(Group o1, Group o2) {
                    if(o1.size == o2.size){
                        if(o1.rainbow == o2.rainbow){
                            if(o1.base[0] == o2.base[0]){
                                return o2.base[1] - o1.base[1];
                            }
                            return o2.base[0] - o1.base[0];
                        }
                        return o2.rainbow - o1.rainbow;
                    }
                    return o2.size - o1.size;
                }
            });
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (blocks[i][j] < 0) continue;
                    boolean[][] visited = new boolean[N][N];
                    Group tmp = new Group(i, j);
                    int base = blocks[i][j];
                    Queue<Block> q = new LinkedList<>();
                    visited[i][j] = true;
                    q.add(new Block(i, j));
                    while (!q.isEmpty()) {
                        Block cur = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int ni = cur.r + di[d];
                            int nj = cur.c + dj[d];
                            if (0 <= ni && ni < N && 0 <= nj && nj < N && blocks[ni][nj] >= 0 && !visited[ni][nj]) {
                                if ((base != 0 && blocks[ni][nj] != 0 && blocks[ni][nj] != base)) continue;
                                if(base == 0 && blocks[ni][nj] != 0) base = blocks[ni][nj];
                                q.add(new Block(ni, nj));
                                tmp.add(ni, nj);
                                visited[ni][nj] = true;

                            }
                        }
                    }
                    if(tmp.size >= 2 && tmp.size-tmp.rainbow >= 1) {
                        g.add(tmp);
                    }
                }
            }
            if(g.size() == 0) break;

            Group tmp = g.poll();
            score += (tmp.size * tmp.size);
            remove(tmp);
            gravity();
            rotation();
            gravity();
        }
        System.out.println(score);
    }

    static void remove(Group g){
        List<Block> b = g.block;
        for(int i = 0 ; i < b.size() ; i++){
            blocks[b.get(i).r][b.get(i).c] = -2;
        }
    }

    static void gravity(){
        for(int j = 0 ; j < N ; j++){
            int base = N-1;
            for(int i = N-1; i >= 0 ; i-- ){
                if(blocks[i][j]==-1 || (blocks[i][j] >= 0 && base == i)) {
                    base = i - 1;
                }
                else if(blocks[i][j] >= 0 && base > i) {
                    blocks[base][j] = blocks[i][j];
                    blocks[i][j] = -2;
                    base = base - 1;
                }
            }
        }
    }

    static void rotation(){
        int[][] tmp = new int[N][N];
        for(int i = 0 ; i < N ;i++){
            for(int j = 0 ; j < N ;j++){
                tmp[i][j] = blocks[j][N-i-1];
            }
        }
        blocks = tmp;
    }
}
