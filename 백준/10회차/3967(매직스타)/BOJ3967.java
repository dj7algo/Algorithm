import java.io.*;
import java.util.*;
public class Main {
    static char[] line;
    static boolean[] alphabet;
    static boolean isDone;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len= 0;
        int idx = 0;
        line = new char[12];
        alphabet = new boolean[12];
        isDone = false;
        for (int i = 0; i < 5; i++) {
            String l = br.readLine();
            for (int j = 0; j < l.length(); j++) {
                if(l.charAt(j) != '.'){
                    line[len++] = l.charAt(j);
                    if(0 <= (int)l.charAt(j) - 'A' && (int)l.charAt(j) - 'A' < 12) {
                        alphabet[(int) l.charAt(j) - 'A'] = true;
                        idx++;
                    }
                }
            }
        }
        dfs(0);
        br.close();
    }

    static void dfs(int idx) {
        if (isDone) return;
        if (idx == 12) {
            if (check()) {
                StringBuilder sb = new StringBuilder();
                sb.append("....").append(line[0]).append("....\n")
                        .append(".").append(line[1]).append(".").append(line[2]).append(".").append(line[3]).append(".").append(line[4]).append(".\n")
                        .append("..").append(line[5]).append("...").append(line[6]).append("..\n")
                        .append(".").append(line[7]).append(".").append(line[8]).append(".").append(line[9]).append(".").append(line[10]).append(".\n")
                        .append("....").append(line[11]).append("....");
                System.out.println(sb);
                isDone = true;
            }
            return;
        }


        if(line[idx] != 'x') dfs(idx+1);
        else{
            for(int i = 0 ; i < 12 ; i++){
                if(alphabet[i]) continue;
                alphabet[i] = true;
                line[idx] = (char) (i + 'A');
                dfs(idx+1);
                alphabet[i] = false;
                line[idx] = 'x';
            }
        }
    }

    static boolean check() {
        if((line[0]-'A') + (line[2] - 'A') + (line[5] - 'A')+(line[7] - 'A') + 4 != 26) return false;
        if((line[1]-'A') + (line[2] - 'A') + (line[3] - 'A')+(line[4] - 'A') + 4 != 26) return false;
        if((line[0]-'A') + (line[3] - 'A') + (line[6] - 'A')+(line[10] - 'A') + 4 != 26) return false;
        if((line[1]-'A') + (line[5] - 'A') + (line[8] - 'A')+(line[11] - 'A') + 4 != 26) return false;
        if((line[4]-'A') + (line[6] - 'A') + (line[9] - 'A')+(line[11] - 'A') + 4 != 26) return false;
        if((line[7]-'A') + (line[8] - 'A') + (line[9] - 'A')+(line[10] - 'A') + 4 != 26) return false;
        return true;
    }


}

