import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	ArrayList<Integer>list = new ArrayList<>();
    	ArrayList<Integer>ans = new ArrayList<>();
    	int max = 0;
    	for(int i=n/2; i<=n; i++) {
    		list.clear();
    		list.add(n);
    		list.add(i);
    		int idx = 0;
    		while(true) {
    			int tmp = list.get(idx)-list.get(idx+1);
    			if(tmp<0) break;
    			list.add(tmp);
    			idx++;
    		}
    		
    		
    		
    		if(max < list.size()) {
    			max = list.size();
    			ans.clear();
    			for(int a : list) {
    				ans.add(a);
    			}
    		}
    	}
    	System.out.println(max);
    	for(int i=0; i<ans.size(); i++) {
    		System.out.print(ans.get(i)+" ");
    	}
    }
}
