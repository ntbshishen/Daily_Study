package te;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class c {
 


 

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //x表示进位
            int x=0;
            
            int sum=l1.val+l2.val;
            if(sum>10){
                x=1;
                sum=sum%10;
            }
            ListNode re=new ListNode(sum,null);  
            ListNode te=re;
            l1=l1.next;
            l2=l2.next;
            while(l1!=null&&l2!=null){
                int s=l1.val+l2.val+x;
                if(s>=10){
                    x=1;
                    s=s%10;
                }
                else{
                    x=0;
                }
                ListNode temp=new ListNode(s,null);
                while(te.next!=null){
                    te=te.next;
                }
                te.next=temp;
                l1=l1.next;
                l2=l2.next;
                
            }
        
            while(l1!=null){
                
                int s=l1.val+x;
                if(s>=10){
                    x=1;
                    s=s%10;
                }else{
                    x=0;
                }
                ListNode temp=new ListNode(s,null);
               // ListNode te=re;
                while(te.next!=null){
                    te=te.next;
                }
                te.next=temp;
               l1=l1.next;
            }
            while(l2!=null){
               
                int s=l2.val+x;
                if(s>=10){
                    x=1;
                    s=s%10;
                }else{
                    x=0;
                }
                ListNode temp=new ListNode(s,null);
               // ListNode te=re;
                while(te.next!=null){
                    te=te.next;
                }
                te.next=temp;
                l2=l2.next;
            }
            if(x==1){
                ListNode e=new ListNode(1);
                 while(te.next!=null){
                    te=te.next;
                }
                te.next=e;
            }
            
            return re;
    }

    
}
