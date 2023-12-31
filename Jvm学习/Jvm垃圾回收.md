# Jvm垃圾回收
## 1. 如何判断对象可以回收
### 1.1 引用计数法
- 类互相引用不可回收
### 1.2 可达性分析算法
- 扫描堆中的对象，看是否能够沿着GC Root对象为起点的引用链找到该对象，找不到，则可回收。工具(MAT)分析堆内存
### 1.3 四种引用
1. 强引用   -   实线:
   - 沿着GC的引用链，找到的对象是不可回收的
2. 软引用   -   虚线
   -  当垃圾回收，且内存不够时，就可以把软引用引用的对象回收掉
3. 弱引用   -   虚线
   - 当没有强引用直接引用的，不管内存够不够，都被回收掉 
4. 虚引用   -   虚线
5. 终结器引用   -   虚线
   - 重写finallize()不推荐使用 
## 2.垃圾回收算法
### 2.1 标记删除
- 第一步：标记可以删除的区域
- 第二步：清除，不会删除区域内的字节，而是记录起始和结束位置的内存地址
- 缺点：不会对清除区域做处理，导致内存碎片
### 2.2标记处理
- 第一步：同标记删除
- 第二部：整理，整理内存碎片
### 2.3复制算法
- 第一步：标记
- 第二部：复制，新开辟一块空间把之前的对象复制进来
## 3.分代回收机制
**新生代**
- 回收更加频繁
1. 伊甸园：占满后，进行一次 Minor GC 垃圾回收，使用复制算法，将幸存的对象复制到幸存区TO中，然后交换
幸存区From和To
2. minor gc 会引发Stop the world，暂停用户的所有线程
3. 对象寿命超过阈值时，会晋升老年代，最大寿命15(4bit)
**老年代**
- 回收频率更低
1. 当老年代空间不足，会先尝试触发minor gc，如果空间仍不足，那么触发full gc，他的stop时间更长
## 4.垃圾回收器
- 并发运行，允许用户进程和垃圾回收同时进行
- 并发运行，多个垃圾回收线程并行，用户进程被暂停
### 4.1 串行
- 单线程
- 堆内存较小，适合个人电脑
### 4.2 吞吐量优先
- 多线程
- 堆内存较大，多核cpu
- 让单位时间内,STW的时间最短 0.2 0.2=0.4 次数少
### 4.3 响应时间优先
- 多线程
- 堆内存较大，多核cpu
- 尽可能让单词的STW的时间最短 0.1 0.1 0.1 0.1 0.1=0.5 单次时间短
### 4.4 G1-垃圾回收器
- 使用场景
  - 同时注重吞吐量和低延迟，默认暂停时间200ms
  - 超大堆内存，会将堆划分为多个大小相等的Region
  - 整体上是标记 
#### 4.4.1 G1垃圾回收阶段
<!-- TODO GC调优-->
