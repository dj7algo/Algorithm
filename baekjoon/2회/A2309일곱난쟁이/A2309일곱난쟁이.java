package h2;

import java.util.*;

public class A2309일곱난쟁이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = 9; // 난쟁이 수
        List<Integer> cm = new ArrayList<Integer>();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            cm.add(sc.nextInt());
            sum += cm.get(i);
        }
        sum -= 100; // 두 명의 가짜 난쟁이 키의 합

        int copySum = sum;
        for (int i = 1; i < N; i++) {
           copySum -= cm.get(i);
           if(cm.indexOf(copySum)!=-1){
               cm.remove(i);
               cm.remove(cm.indexOf(copySum));
               break;
           }
           copySum=sum;
        }
        cm.sort(null);
       
        for(Integer i :cm) System.out.println(i);
        
        sc.close();
    }
}
