package te;
import java.beans.Transient;
import java.util.List;
import te.matrix;
import te.util.TreeNode;
import te.c;
class test{
 
 public static void main(String args[]){
         int[][] matrix=new int[][]{
                       {1,3},
                       {2,6},
                       {8,10},
                       {15,18}
                       
         };
        /*c c1=new c();
         ListNode C=new ListNode(5);
         ListNode C1=new ListNode(2);
         ListNode C2=new ListNode(4);
         ListNode C3=new ListNode(6);
         ListNode C4=new ListNode(4);
         C1.next=C2;
         C1.next.next=new ListNode(3);
         C.next=C3;
         C.next.next=C4;
         ListNode x=c1.addTwoNumbers(C, C1);
        
         while(x!=null){
            System.out.print(x.val+" ");
            x=x.next;
         }*/
         //matrix matrix2=new matrix();
        // List<Integer> re=matrix2.spiralOrder(matrix);
        // cc cc=new cc();
        // ccc ccc=new ccc();
         TreeNode root=new TreeNode(3);
         TreeNode node1Node=new TreeNode(1);
         TreeNode node2Node=new TreeNode(3);
         TreeNode node3Node=new TreeNode(4);
         TreeNode node4Node=new TreeNode(1);
         TreeNode node5Node=new TreeNode(5);
         root.left=node1Node;
         node1Node.left=node2Node;
         root.right=node3Node;
         node3Node.left=node4Node;
         node3Node.right=node5Node;    
        // Solution.goodNodes(root); 
         Solution.merge(matrix)   ; 
        // System.out.println("");
    }

  
}