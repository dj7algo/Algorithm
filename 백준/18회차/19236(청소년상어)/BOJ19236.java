import java.io.*;
import java.util.*;

public class BOJ19236 {
    static class Fish {
        int x, y, dir;
        boolean isEaten;

        Fish(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            isEaten = false;
        }

        void eaten() {
            this.isEaten = true;
        }
    }

    static class Shark {
        int x, y, dir;

        Shark() {
            this.x = -1;
            this.y = -1;
            this.dir = -1;
        }

        void eat(Fish fish) {
            this.x = fish.x;
            this.y = fish.y;
            this.dir = fish.dir;
        }
    }

    static int max = Integer.MIN_VALUE;
    static Fish[] fishes;
    static int[] fishidx;
    static Shark s;
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fishes = new Fish[16 + 1];
        fishidx = new int[16];
        s = new Shark();

        int target = 0;
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                int idx = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                if (i == 0 && j == 0) target = idx;
                fishes[idx] = new Fish(i, j, dir);
                fishidx[4 * i + j] = idx;
            }
        }

        eating(target, 0);

        System.out.println(max);

    }

    static void eating(int target, int sum) {

        sum = sum + target;
        s.eat(fishes[target]);
        fishes[target].eaten();
        fishidx[fishes[target].x*4+fishes[target].y] = 0;
        moveFish();

        int[] result = checkMove();
        if (result == null) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) break;
            //Fish[] backup = Arrays.copyOf(fishes, 17);
            Fish[] backup = new Fish[17];
            for(int j = 1 ; j < 17 ; j++){
                backup[j] = new Fish(fishes[j].x, fishes[j].y, fishes[j].dir);
                backup[j].isEaten = fishes[j].isEaten;
            }
            Shark backupS = s;
            int[] backupI = Arrays.copyOf(fishidx, 16);
            eating(result[i], sum);
            s = backupS;
            fishes = backup;
            fishidx = backupI;
        }
    }

    static void moveFish() {
        for (int i = 1; i <= 16; i++) {
            if (fishes[i].isEaten) {
                continue;

            }
            int count = 0;
            int dir = fishes[i].dir;
            while (count < 8) {
                int ni = fishes[i].x + di[dir];
                int nj = fishes[i].y + dj[dir];
                if ((s.x == ni && s.y == nj) || (ni < 0 || 4 <= ni || nj < 0 || 4 <= nj)) {
                    count++;
                    dir = (dir + 1) % 8;
                } else {
                    //int idx = fishidx[ni * 4 + nj];
                    int idx = ni * 4 + nj;
                    if(fishidx[idx]==0){
                        fishidx[fishes[i].x*4+fishes[i].y] =0;
                    }else{
                        int idxf = fishidx[idx];
                        fishes[idxf].x = fishes[i].x;
                        fishes[idxf].y = fishes[i].y;
                        fishidx[fishes[i].x * 4 + fishes[i].y] = idxf;
                    }
                    fishes[i].x = ni;
                    fishes[i].y = nj;
                    fishes[i].dir = dir;
                    fishidx[4 * ni + nj] = i;
                    break;
                }
            }
        }

        /*for(int i = 1 ; i <= 16 ; i++){
            if(fishes[i].isEaten)
                fishidx[fishes[i].x*4 + fishes[i].y] = 0;
        }*/
    }

    static int[] checkMove() {
        int idx = 1;
        int[] result = new int[4];
        int resultidx = 0;
        while (true) {
            int ni = s.x + (idx * di[s.dir]);
            int nj = s.y + (idx * dj[s.dir]);
            if (0 <= ni && ni < 4 && 0 <= nj && nj < 4) {
                if (fishidx[4 * ni + nj] != 0 && !fishes[fishidx[4 * ni + nj]].isEaten)
                    result[resultidx++] = fishidx[4 * ni + nj];
                idx++;
            } else {
                break;
            }
        }

        if (resultidx == 0) return null;

        return result;
    }


}
