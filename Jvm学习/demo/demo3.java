import java.io.IOException;
import java.nio.ByteBuffer;

public class demo3 {
    static int _1Gb=1024*1024*1024;
    public static void main(String[] args) throws IOException{
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(_1Gb);
        System.out.println("分配完毕。。");
        System.in.read();
        System.out.println("开始释放。。");
        byteBuffer=null;
        System.gc();
        System.in.read();
    }

    
}
