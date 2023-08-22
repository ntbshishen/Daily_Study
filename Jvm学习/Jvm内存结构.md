# Jvm内存结构
## Jvm二进制字节码
组成
- 类的基本信息，常量池，类方法定义，包括了虚拟机指令
- Java源码->javac->翻译为jvm指令->解释器->机器码->cpu
## 程序计数器
**定义**
- 记住下一条jvm指令的执行地址
- 物理上是由寄存器实现的
**特征**
- 线程私有 (java多线程) 每一线程拥有自己的程序计数器
- 不会存在内存溢出(实现时，不用考虑溢出)
## 虚拟机栈
### 定义
- 栈 - 数据结构
- 一个线程运行需要的内存空间
- 栈帧 - 每个方法运行时需要的内存 - 参数，局部变量，返回地址
- 每执行一个方法，生成一个栈帧，压入栈空间
- 活动栈帧，对应当前正在执行的那个方法
**Eample**
```java
public class Demo{
    /*
    调用method时，产生一个栈帧
    */
    public static void main(String[] args){
        method1();
    }
    private static void method1(){
        methods(1,2);
    }
    private static int method2(int a,int b){
        int c= a + b;
        return c;
    }
}
```
### 问题
1. 垃圾回收不涉及占内存
   - 每个方法执行完后，都会被弹出栈，不需要回收，回收只是针对于堆内存
2. 栈内存越大越好吗？
   - -Xss size 指定jvm栈大小
   - 栈越大，能分配的线程越小
   - 方法内的局部变量是线程安全的，局部变量不是线程共享的。每个线程调用方法时，都会生成一个栈帧，分配一个变量。
### 栈内存溢出
- 栈帧过多导致内存溢出(递归函数往往会导致栈溢出)
### 线程运行诊断
- cpu占用过多
    - ps命令 H -eo pid-进程号 tid-线程号 %cpu占用率
    - grep 筛选 +进程号
    - jstack + 进程id
      - 输出的是16进制的线程编号
- 程序运行很长时间没有结果
  - 原因：线程死锁
## 本地方法栈
定义：native method 不是由java代码编写的方法，由c，c++编写的方法，java调用这些方法。
- 例如 object中的clone()，wait()
## 堆
- 通过new关键字，创建对象都会使用堆内存
特点
- 他是线程共享的
- 有垃圾回收机制
- 变量引用地址存在栈里，但是这个地址指向的对象的内容是在堆内存中的
### 堆内存溢出(OutofMemoryError)
### 堆内存诊断
- jps工具
    - 查看当前系统中有哪些java进程
- jmap工具
    - 查看堆内存占用情况
- jconsole工具
    - 图形界面，多功能的检测工具，可以连续检测
案例
- 垃圾回收后，内存占用依旧很高
## 方法区
### 定义
- 所有线程共享的，它存贮了和类有关的东西，逻辑上是heap的一部分，具体实现方式可以不一样
### 方法区溢出
- 使用的计算机内存。-XX MaxMetaspaceSize 设置元空间大小
- ClassLoader 用来加载类的二进制字节码
  - defineClass()执行类加载
- ClassWriter 生成类的二进制字节码
  - visit(版本号，public，类名，包名，类的父类，接口类)
  - toByteArray() 返回二进制字节码

**场景**
- spring
- Mybatis
动态生成类
### 运行时常量池
- 常量池，就是一张表，虚拟机指令根据这张常量表找到要执行的类名，方法名，参数类型，字面量
- 运行常量池，每个.class文件中的常量池都会放在运行时常量池中
### StringTable 
数据结构上是哈希表，存的是字符串常量
- 常量池中的信息被加载到运行时常量池中时，还没有成为java字符串对象
- ldc #2会把a符号变为“a”字符串对象
```java
    String s1="a";
    String s2="b";
    String s3="ab";
    String s4=s1+s2;//new StringBuilder().append("a").append("b").toString() new String("ab")
    String s5="a"+"b";//javac在编译器之间的优化
    //在编译期间，结果确定为“ab”
    System.out.println(s3==s4)//false
    System.out.println(s3==s5)//true
```
- 常量池中的字符串仅是符号，第一次用到时才变成对象
- 利用串池机制，来避免重复创建字符串对象
- 字符串变量的拼接原理是StringBuilder
- 字符串常量拼接的原理是编译器优化
- 可以使用intern方法，主动将串池中话没有的字符串对象放入串池

**位置**
- 在堆中，更容易触发垃圾回收机制

**StringTable垃圾回收**
- java对象中的类名，方法名都是以字符串存在内存中的。
- 字符串为什么要入池？减少字符串对象的内存占用
## 直接内存
**定义**
- 属于操作系统内存
- 用于NIO操作，用于数据缓冲区
<!--Todo 了解NIO-->
- 分配回收成本较高，单独写性能高
- 不受JVM内存回收管理
- dircetMemory 系统和java都可以访问该内存
### 直接内存释放原理
```java 
    /*
     * DirectByteBuffer类源码
     *
    */
    DirectByteBuffer(int cap) {                   // package-private

        super(-1, 0, cap, cap);
        boolean pa = VM.isDirectMemoryPageAligned();
        int ps = Bits.pageSize();
        long size = Math.max(1L, (long)cap + (pa ? ps : 0));
        Bits.reserveMemory(size, cap);

        long base = 0;
        try {
            base = UNSAFE.allocateMemory(size);
        } catch (OutOfMemoryError x) {
            Bits.unreserveMemory(size, cap);
            throw x;
        }
        UNSAFE.setMemory(base, size, (byte) 0);
        if (pa && (base % ps != 0)) {
            // Round up to page boundary
            address = base + ps - (base & (ps - 1));
        } else {
            address = base;
        }
        //clean 虚引用对象？
        //TODO:
        cleaner = Cleaner.create(this, new Deallocator(base, size, cap));
        att = null;

    }
```
<!--了解一下unsafe类-->
