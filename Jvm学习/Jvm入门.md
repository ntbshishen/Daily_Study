# Jvm入门
## 什么是JVM
### 定义
- java Virtual Machine - java 程序的运行环境(java 二进制字节码的运行环境)
### 好处
- 一次编写，到处运行  **屏蔽了底层机器码**
- 自动内存管理，垃圾回收功能
- 数组下标越界检查
- 多态
### 比较
|名称|组成|
|-|-|
|JavaEE|JDK+应用服务器+IDE工具|
|JavaSE|JDK+IDE工具|
|JDK|JVM+基础类库+编译工具|
|JRE|JVM+基础类库|
|JVM|JVM|
- 编译工具->编译器，例如javac
## 学习JVM有什么用
- 理解底层的实现原理
- 中高级程序员必备技能
## 常见的JVM
- JVM是一个规范，可以自己实现jvm
## 学习路线
- java Class->ClassLoader
  - JVM内存结构
    - Method Area 方法区
    - Heap 堆
    - JVM Stacks 虚拟机栈
    - PC Register 程序计数器 ->本地方法接口->执行引擎  **本地方法接口调用操作系统方法**
    - Native Method Stacks 本地方法栈->本地方法接口->执行引擎 
  - 执行引擎
    - Interperter 解释器 **逐行解释代码**
    - JIT Compiler 即时编译器
    - GC 垃圾回收  
