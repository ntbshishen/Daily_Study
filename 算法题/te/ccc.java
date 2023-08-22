package te;

import java.util.Arrays;

class ccc{
     public String longestPalindrome(String s) {
            char[] ss=s.toCharArray();
            int max=0;
            int[][] x=new int[s.length()][s.length()];
            for(int i=0;i<s.length();i++){
                int left=i,right=i;
                while(left>=0&&right<s.length()){

                   char m=s.charAt(i);
                    //System.out.println(right+":"+left);
                    if(ss[left]!=ss[right]){
                        //int[][]
                        break;
                    }
                    if(max<right-left+1){
                      //  System.out.println(right+"::"+left);
                        x[left][right]=right-left+1;
                       // System.out.println(x[left][right]);
                        max=right-left+1;
                      ///   System.out.println(max);
                    }
                    left--;
                    right++;
                }
            }
            for(int i=0;i<s.length()-1;i++){
                String temp=s.substring(i, i+2);
                if(temp.charAt(0)==temp.charAt(1)){
                    //System.out.println(i);
                    int left=i;
                    int right=i+1;
                   
                    while(left>=0&&right<s.length()){
                   // x[left][right]=right-left+1;
                    if(ss[left]!=ss[right]){
                        //int[][]
                        break;
                    }
                    if(max<right-left+1){
                       System.out.println(right+":"+left);
                        x[left][right]=right-left+1;
                        max=right-left+1;
                    }
                    left--;
                    right++;
                 }
                  
                }
            }
            String re=null;
            for(int i=0;i<s.length();i++){
                for(int j=i;j<s.length();j++){
                    if(x[i][j]==max){
                            System.out.println(i+":::"+j);
                            re=s.substring(i, j+1);
                            break;
                    }
                }
            }

            return re;
    }
    public int myAtoi(String s) {
        int len=s.length();
        int sord=0;
        int sum=0;
        for(int i=0;i<len;i++){
          if(s.charAt(i)!=' '){
            if(s.charAt(i)=='-'){
                  sord=1;
            }
            else{
                if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                  if((Math.pow(2,31)-1)/sum<10){
                    return Integer.MAX_VALUE;
                }
               
                    sum=sum*10+(s.charAt(i)-'0');
                
            }
            }
          }
        }
        if(sord==1){
            sum=-sum;
        }
        return sum;
    }
    public int halveArray(int[] nums) {
        int re=0;
        double[] num1=Arrays.stream(nums).mapToDouble(Double::valueOf).toArray();
        Arrays.sort(num1);
        double sum=Arrays.stream(num1).sum();
        double temp=sum;
        while(temp>sum/2.0){
            temp=temp-num1[num1.length-1]/2.0;
            num1[num1.length-1]=num1[num1.length-1]/2.0;
            Arrays.sort(num1);
            re++;
        }
        return re;
        
    }

}