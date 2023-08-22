package te;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int x=map.get(nums[i]);
                x++;
                map.replace(nums[i], x);
            }
            else {
                map.put(nums[i],1);
            }
        }
        System.out.print(map);
        for(int key:map.keySet()){
            if(map.get(key)>k){
                return -1;
            }
        }

        return 0;
    }
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            int count=upper+lower;
            int sum=0;
            for(int i=0;i<colsum.length;i++){
                sum+=colsum[i];
            }
            if(sum!=count){
                return new ArrayList<List<Integer>>();
            }
            List<Integer> list1=new ArrayList<>();
            List<Integer> list2=new ArrayList<>();
            int sum1=0;
            int sum2=0;
             for(int i=0;i<colsum.length;i++){
                if(colsum[i]==0||colsum[i]==1){
                    list1.add(0);
                    list2.add(0);
                }
                else if(colsum[i]==2){
                    list1.add(1);
                    sum1++;
                    list2.add(1);
                    sum2++;
                }
            }
            for(int i=0;i<colsum.length;i++){
                if(colsum[i]==1){
                    if(upper-sum1>0){
                        list1.set(i, 1);
                        sum1++;
                    }
                    else if(lower-sum2>0){
                        list2.set(i, 1);
                        sum2++;
                        
                    }
                }

            }           
             List<List<Integer>> res = new ArrayList<List<Integer>>();
            res.add(list1);
            res.add(list2);
           
                return res;
            
    }
    public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            map.put(i,numbers[i]);
        }
        for (Integer key:map.keySet()) {
           // System.out.println("key: " + key + " value: " + hashMap.get(key));
           if(map.containsValue(target-map.get(key))){
                LinkedList<Integer> keys=findKey(map, target-map.get(key));
                result[0]=key+1;
                System.out.println(result[0]);
                for(int i=0;i<keys.size();i++){
                    if(keys.get(i)!=key){
                        result[1]=keys.get(i)+1;
                        break;
                    }
                }
                break;
           }
        }
        return result;
        

    }

    public LinkedList<Integer> findKey(Map map, Integer value){
	//创建用于存储Key的链表
	LinkedList<Integer> keys = new LinkedList<>();
	//通过遍历的方法来查找
	Iterator iterator = map.keySet().iterator();
	while(iterator.hasNext()){
		 Integer key = (Integer)iterator.next();
		if(value.equals(map.get(key))){
			keys.add(key);
		}
	}
	return keys;
}
public String addStrings(String num1, String num2) {
    String result="";
    int len1=num1.length();
    int len2=num2.length();
    int i=len1-1,j=len2-1;
    int x=0;
    while(i>=0||j>=0){
         
        if(i>=0&&j>=0){
           int re=(num1.charAt(i)-'0'+num2.charAt(j)-'0'+x)%10;
           x=(num1.charAt(i)-'0'+num2.charAt(j)-'0'+x)/10;
           result=re+result;
            i--;
            j--;
        }
        else{
            if(i>=0){
            int re=(num1.charAt(i)-'0'+x)%10;
             x=(num1.charAt(i)-'0'+x)/10;
           result=re+result;
                i--;
            }
            else{
              int re=(num2.charAt(j)-'0'+x)%10;
              x=(num2.charAt(j)-'0'+x)/10;
              result=re+result;
                j--;
            }
        }

    }
    return result;

}
public int[] minInterval(int[][] intervals, int[] queries) {
    int[] result=new int[queries.length];
    for(int i=0;i<result.length;i++){
        result[i]=-1;
    }
    HashMap<int[],Integer> map=new HashMap<>();
    for(int i=0;i<intervals.length;i++){
        map.put(new int[]{intervals[i][0],intervals[i][1]}, intervals[i][1]-intervals[i][0]+1);
    }
    List<Map.Entry<int[],Integer>> list=new ArrayList<Map.Entry<int[],Integer>>(map.entrySet());
    list.sort(new Comparator<Map.Entry<int[],Integer>>() {
        @Override
        public int compare(Entry<int[], Integer> o1, Entry<int[], Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());  
        }
    });
    for (int i = 0; i < list.size(); i++) {
        int[] temp=list.get(i).getKey();
        System.out.println(temp[0] +"-"+temp[1]+ ": " + list.get(i).getValue());
    }      

    for(int i=0;i<queries.length;i++){
        for (int j = 0; j < list.size(); j++) {
            int[] temp=list.get(j).getKey();
            if(queries[i]>=temp[0]&&queries[i]<=temp[1]){
                result[i]=list.get(j).getValue();
                break;
            }
        }      
    }
    return result;

}
public static int maxDistToClosest(int[] seats) {
    int left=0;
    int right=0;
    int max=0;
    for(int i=0;i<seats.length;i++){
        if(seats[i]==0){
            left=i;
            right=i;
            do{
                if(left==0&&right<seats.length){
                    right++;
                }
                else if(right==seats.length-1&&left>0){
                    left--;
                }
                else{
                    right++;
                    left--;
                }
                System.out.println(left+" : "+i+" : "+right);
            }while(seats[left]==0&&seats[right]==0);
            if(seats[left]==0){
                max=Math.max(max,right-i);
            }
            else if(seats[right]==0){
                max=Math.max(max,i-left);
            }
            else{
                max=Math.max(max,Math.min(right-i,i-left));
            }
        }
    }
    return max;
}
    
}
