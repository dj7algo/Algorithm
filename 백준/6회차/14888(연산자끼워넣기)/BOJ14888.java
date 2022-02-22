import java.util.*;
import java.io.*;
public class BOJ14888 {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] operation;
    static int[] number;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        number = new int[N];
        operation = new int[N-1];
        int size_o = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 4 ; i++){
            int t = Integer.parseInt(st.nextToken());
            char o = 0;
            if(i==0) o = 1;
            else if(i==1) o = 2;
            else if(i==2) o = 3;
            else if(i==3) o = 4;
            for(int j = 0 ; j < t ; j++){
                operation[size_o++] = o;
            }
        }
        Arrays.sort(operation);
        do{
            calculate();
        }while(perm());

        System.out.println(max);
        System.out.println(min);
    }


    static boolean perm(){
        int i = operation.length - 1;
        while(i>0 && operation[i-1] >= operation[i]) --i;

        if(i==0) return false;

        int j = operation.length - 1;
        while(operation[i-1] >= operation[j]) --j;

        swap(i-1, j);

        int k = operation.length - 1;
        while(i < k){
            swap(i++, k--);
        }

        return true;
    }

    static void swap(int i, int j){
        int tmp = operation[i];
        operation[i] = operation[j];
        operation[j] = tmp;
    }

    static void calculate(){
        int result = number[0];
        for(int i = 1 ; i < number.length ; i++){
            if(operation[i-1] == 1) result += number[i];
            else if(operation[i-1] == 2) result -= number[i];
            else if(operation[i-1] == 3) result *= number[i];
            else if(operation[i-1] == 4) result /= number[i];
        }

        max = Math.max(max, result);
        min = Math.min(min, result);

    }
}