import java.util.*;

public class A2635수이어가기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int count=0;
        
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=N;i>=N/2;i--){
           ArrayList<Integer> list = new ArrayList<>();
            list.add(N);

            int start=N;
            int next=i;
            while(start>=0){

                if(next>=0) list.add(next);
                int temp=start;
                start = next;
                next=temp-start; // 앞앞 값 - 앞 값
            }
            if(count<list.size()){
                count=list.size();
                result=list;
            }
            
        }
        System.out.println(count);
        for(Integer a : result) System.out.print(a+" ");
        scan.close();
    }
}

/* 
https://yongku.tistory.com/entry/백준-알고리즘-백준-2635번-수-이어가기-자바Java
*/
