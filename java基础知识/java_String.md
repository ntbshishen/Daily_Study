# java中String new和直接赋值的区别
- 对于字符串：其对象的引用都是存储在栈中的，如果是编译期已经创建好(直接用双引号定义的)的就存储在常量池中，如果是运行期（new出来的）才能确定的就存储在堆中。对于equals相等的字符串，在常量池中永远只有一份，在堆中有多份。

**例如**
- String str1="ABC"； 和String str2 = new String("ABC"); 
- String str1="ABC" 可能创建一个对象或者不创建对象，如果"ABC"这个字符串在java String池里不存在，会在java String池创建这个一个String对象("ABC").如果已经存在，str1直接reference to 这个String池里的对象。
- String str2 = new String("ABC") 至少创建一个对象，也可能两个。因为用到new 关键字，会在heap创建一个 str2 的String 对象，它的value 是 "ABC".同时，如果"ABC"这个字符串在java String池里不存在，会在java String池创建这个一个String对象("ABC").
1. String s = new String(“xyz”); 产生几个对象？
    - 一个或两个。如果常量池中原来没有 ”xyz”, 就是两个。如果原来的常量池中存在“xyz”时，就是一个。
    - 对于基础类型的变量和常量：变量和引用存储在栈中，常量存储在常量池中。
