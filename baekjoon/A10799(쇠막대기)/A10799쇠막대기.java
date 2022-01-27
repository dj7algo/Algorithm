import java.io.*;

public class A10799쇠막대기 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String str =br.readLine();

       str=str.replace("()", "*");

       int count = 0, sum = 0;  // count 쇠막대기 수
        for(int i=0;i<str.length();i++){
            char c= str.charAt(i);
            if(c=='(') count++;
            else {
                if (c == ')'){
                    count--;
                    sum++;
                }
                else if (c == '*')
                    sum += count;
            }
        }
        System.out.println(sum);
    }
}
