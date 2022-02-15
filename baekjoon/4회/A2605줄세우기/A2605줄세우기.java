import java.util.*;

public class A2605줄세우기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int N = scan.nextInt();
        for(int i=0;i<N;i++){
            int idx = scan.nextInt();
            list.add(list.size()-idx,i+1);
        }

        for(Integer i : list) System.out.print(i+" ");
        scan.close();
    }
}