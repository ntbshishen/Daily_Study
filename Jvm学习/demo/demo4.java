import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class demo4 {
    public static void main(String[] args) {
        soft();
    }
    public static void soft(){
        List<SoftReference<Byte[]>> list=new ArrayList<>();
        // 引用队列
        ReferenceQueue<Byte[]> queue=new ReferenceQueue<>();
        for(int i=0;i<5;i++){
            SoftReference<Byte[]> ref=new SoftReference<Byte[]>(new Byte[4*1024*1024],queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());

        }
        System.out.println("循环结束： "+list.size());
   
        for(SoftReference<Byte[]> ref:list){
            System.out.println(ref.get());
        }
    }
}
