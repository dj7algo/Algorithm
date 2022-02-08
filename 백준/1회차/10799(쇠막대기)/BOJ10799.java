import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        br.close();

        Stack<Character> sc = new Stack<>();
        int size = 0;

        for(int i = 0 ; i < line.length() ; i++){
            if(line.charAt(i) == '('){
                sc.push(line.charAt(i));
            }else{
                sc.pop();
                char before = line.charAt(i-1);
                if(before == '('){
                    size += sc.size();
                }else{
                    size += 1;
                }

            }
        }
        System.out.println(size);


    }
}
