package te;
import java.util.HashMap;
import java.util.Map;

public class cc {

     public int lengthOfLongestSubstring(String s) {
        Map<String,Integer> map=new HashMap<String,Integer>();
        int x=0;
        if(s.equals("")){
            return 1;
        }
        for(int i=0;i<s.length()-1;i++){
            map.put(s.substring(i, i+1),i);
           // System.out.print(s.substring(i, i+1));
           // System.out.print(map.get(s.substring(i, i+1)));
            for(int j=i+1;j<s.length();j++){
               // System.out.print(s.substring(j, j+1));
                if(map.containsKey(s.substring(j, j+1))){
                   // System.out.print(j-i+" ");
                    if(x<j-i)
                        x=j-i;
                    map.clear();
                    break;
                }
                else if(j==s.length()-1){
                   // System.out.print(j+1);
                    if(x<j-i)
                        x=j-i;
                    map.clear();
                    break;
                }
                map.put(s.substring(j, j+1), j);
            }
           // map.clear();
        }
        return x;
            
    }
}
