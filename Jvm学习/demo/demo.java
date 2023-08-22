
public class demo{
    public static void main(String[] args) {
        String x="ab";
        String s="a"+"b";//javac在编译器之间的优化，在编译期间，结果确定为“ab”
        String s3=new String("a")+new String("b");
        String s2=s.intern();
        System.out.println("s2?=x"+": "+(s2==x));
        System.out.println("s?=x"+": "+(s==x));
        System.out.println("s3?=x"+": "+(s3==x));

    }
}