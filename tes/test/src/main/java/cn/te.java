package cn;

public class te {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass=Class.forName("cn.d");
        System.out.println(aClass.getClassLoader());
    }
}
